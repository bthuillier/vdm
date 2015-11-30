package com.bthuillier.vdm

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.http.scaladsl.model._
import StatusCodes._
import org.joda.time.DateTime
import akka.http.scaladsl.unmarshalling.Unmarshaller
import de.heikoseeberger.akkahttpplayjson.PlayJsonSupport

trait VDMRouting extends PlayJsonSupport {

  implicit val dateTimeStringUnmarshaller: Unmarshaller[String, DateTime] =
  Unmarshaller.strict[String, DateTime] { string ⇒
    try DateTime.parse(string)
    catch {
      case t: Throwable ⇒
        throw if (string.isEmpty)
          Unmarshaller.NoContentException
        else
          new IllegalArgumentException(s"'$string' is not a valid DateTime value", t)
    }
  }

  def authorFilterDirective: Directive1[Option[VDMPost => Boolean]] = parameter('author.?) map {
    author => author.map(PostService.authorFilter)
  }

  def fromToFilterDirective: Directive1[Option[VDMPost => Boolean]] = (parameter('from.as[DateTime].?) & parameter('to.as[DateTime].?)).tflatMap {
    case (Some(from), Some(to)) => provide(Some(PostService.dateFilter(from, to)))
    case (None, None) => provide(None)
    case _ => reject
  }

  def filters = (authorFilterDirective & fromToFilterDirective).tmap {
    case (a, ft) => List(a, ft).flatten
  }

  def postRoute(postService: PostService) = pathPrefix("api" / "posts") {
    pathEnd {
      filters { filters =>
        complete(postService.filterBy(filters))
      }
    } ~
    path(LongNumber) { id =>
      complete { postService.findPostById(id) match {
          case Some(post) => PostResponse(post)
          case None => NotFound
        }
      }
    }
  }

}
