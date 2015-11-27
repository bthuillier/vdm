package com.bthuillier.vdm

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

object VDM extends App with VDMRouting {
  implicit val system = ActorSystem("vdm-system")
  implicit val materializer = ActorMaterializer()
  implicit val ec = system.dispatcher
  val posts = PostLoader.load("posts.csv")
  val service = new ConcretePostService(posts)

  val route = postRoute(service)

  val bindingFuture = Http().bindAndHandle(route, "localhost", 8080)

  println(s"Server online at http://localhost:8080/\nPress RETURN to stop...")
  Console.readLine() // for the future transformations
  bindingFuture
    .flatMap(_.unbind()) // trigger unbinding from the port
    .onComplete(_ ⇒ system.shutdown()) // and shutdown when done
}
