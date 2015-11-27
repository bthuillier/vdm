package com.bthuillier.vdm


import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.io.Framing
import akka.stream.scaladsl._
import akka.stream.stage.{ Context, StatefulStage, SyncDirective }
import akka.util.ByteString
import scala.util.Try
import org.joda.time.DateTime
import java.io.File
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object PostLoader {

  def parseString(str: String): Option[VDMPost] = str.split(",").toList match {
    case id :: content :: author :: date :: Nil =>
      Try(
        VDMPost(id.toLong, content, author, PostService.dateTimeFormatter.parseDateTime(date))
      ).toOption
    case _ =>
      None
  }

  def load(file: String)(implicit system: ActorSystem, materializer: ActorMaterializer): List[VDMPost] = {
    import akka.stream.io.Implicits._ // add file sources to Source object or use explicitly: SynchronousFileSource(f)
    val r = Source.synchronousFile(new File(s"target/$file")).
      via(Framing.delimiter(ByteString(System.lineSeparator), maximumFrameLength = 512, allowTruncation = true)).
      map(_.utf8String).
      map(parseString(_)).runWith(Sink.head).map(_.toList)
    Await.result(r, 100 seconds)


  }

}
