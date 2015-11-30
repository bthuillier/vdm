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
import play.api.libs.json.Json

object PostLoader {

  def parseString(str: String): Option[VDMPost] =
    Json.parse(str).validate[VDMPost].asOpt

  /**
   * Load the file where the VDM post are saved
   * and return all the posts save
  **/
  def load(file: String)(implicit system: ActorSystem, materializer: ActorMaterializer): List[VDMPost] = {
    import akka.stream.io.Implicits._
    val r = Source.synchronousFile(new File(s"target/$file")).
      via(Framing.delimiter(ByteString(System.lineSeparator), maximumFrameLength = 1024, allowTruncation = true)).
      map(_.utf8String).
      map(parseString(_)).runWith(Sink.fold(List.empty[Option[VDMPost]])((x, y) => y :: x)).map(_.flatten)
    Await.result(r, 100 seconds)


  }

}
