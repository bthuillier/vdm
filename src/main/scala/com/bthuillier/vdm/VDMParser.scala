package com.bthuillier.vdm

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer
import akka.http.scaladsl.model._
import scala.concurrent.duration._
import org.jsoup.Jsoup
import org.jsoup.nodes._
import org.jsoup.select._
import scala.collection.JavaConversions._
import org.joda.time.{ DateTime => JDateTime}
import scala.concurrent.Future
import java.io.File
import akka.util.ByteString
import play.api.libs.json.Json


object VDMParser extends App {
  implicit val system = ActorSystem("vdm-client-system")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher

  def parseDocument(document: Document) = {
    val posts: List[Element] = document.select(".article").toList
    posts.map { post =>
      parseElement(post)
    }
  }

  def parseElement(element: Element) = {
    val id = element.id()
    val text = element.select("p").first().select("a").toList.map(_.text).mkString
    val (date, author) = authorAndDate(element.select(".right_part p:eq(1)").text.split("-", 3).toList)
    VDMPost(id.toInt, text, author, date)
  }

  def authorAndDate(strs: List[String]): (JDateTime, String) = strs match {
    case date :: _ :: author :: _ =>
      PostService.dateTimeFormatter.parseDateTime(date.substring(3, 21)) -> author.substring(5).toList.takeWhile(_ != ' ').mkString
  }

  def load = {
    val http = Http(system)
    val queries = Range(0, 17).map { r => s"http://www.viedemerde.fr/?page=$r"} .map { uri =>
      http.singleRequest(HttpRequest(uri = uri)).flatMap { r =>
        r.entity.toStrict(100 seconds).map { entity =>
          parseDocument(Jsoup.parse(entity.data.decodeString("utf-8")))
        }

      }
    }

    Future.sequence(queries).map(_.flatten).
      map(posts => posts.map(p => Json.stringify(Json.toJson(p)) + "\n"))

  }

  val result = load

  import akka.stream.io.Implicits._
  import akka.stream.scaladsl._
  val source = Source(result).map(x => ByteString(x.mkString, "UTF-8"))

  source.runWith(Sink.synchronousFile(new File("target/posts.base"))).onComplete(_ ⇒ system.shutdown())

}
