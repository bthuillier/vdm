package com.bthuillier.vdm

import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server._
import akka.http.scaladsl.model._
import StatusCodes._
import org.joda.time.DateTime
import akka.http.scaladsl.unmarshalling.Unmarshaller

trait VDMRouting {

  implicit val dateTimeStringUnmarshaller: Unmarshaller[String, DateTime] =
  Unmarshaller.strict[String, DateTime] { string ⇒
    try DateTime.parse(string)
    catch {
      case t: Throwable ⇒
        throw if (string.isEmpty) Unmarshaller.NoContentException else new IllegalArgumentException(s"'$string' is not a valid DateTime value", t)
    }
  }

  def filterAuthor: Directive1[Option[VDMPost => Boolean]] = parameter('author.?) map {
    author => author.map(PostService.authorFilter)
  }

  def filterFromTo: Directive1[Option[VDMPost => Boolean]] = (parameter('from.as[DateTime].?) & parameter('to.as[DateTime].?)).tflatMap {
    case (Some(from), Some(to)) => provide(Some(PostService.dateFilter(from, to)))
    case (None, None) => provide(None)
    case _ => reject
  }

  def filters = (filterAuthor & filterFromTo).tmap {
    case (a, ft) => List(a, ft).flatten
  }

  def postRoute(postService: PostService) = pathPrefix("api" / "posts") {
    pathEnd {
      filters { filters =>
        complete(postService.filterBy(filters).toString)
      }
    } ~
    path(LongNumber) { id =>
      complete { postService.findPostById(id) match {
          case Some(post) => post.toString
          case None => NotFound
        }
      }
    }
  }

}
