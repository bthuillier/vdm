
lazy val root = (project in file(".")).
  settings(
    name := "vdm",
    version := "1.0",
    scalaVersion := "2.11.6",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.4.0",
      "com.typesafe.akka" %% "akka-http-core-experimental" % "2.0-M1",
      "com.typesafe.akka" %% "akka-http-experimental" % "2.0-M1",
      "joda-time" % "joda-time" % "2.9.1",
      "org.scalatest" %% "scalatest" % "2.2.4" % "test",
      "org.jsoup" % "jsoup" % "1.8.3",
      "com.typesafe.akka" %% "akka-http-testkit-experimental" % "2.0-M1" % "test"
    )

  )
