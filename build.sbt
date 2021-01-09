lazy val root = project
  .in(file("."))
  .settings(
    name := "2048SE",
    organization := "de.htwg.se",
    version := "0.0.1",

    scalaVersion := "3.0.0-M3"
  )

import org.scoverage.coveralls.Imports.CoverallsKeys._

coverallsToken := Some("SauHm93KXQlTBivHSKxpSqJdeytSHUPcb")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.3" % "test"

libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.5"

libraryDependencies += ("net.codingwell" %% "scala-guice" % "4.2.11").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.play" %% "play-json" % "2.9.1").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.akka" %% "akka-actor" % "2.5.23").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.akka" %% "akka-testkit" % "2.5.23" % Test).withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.akka" %% "akka-http" % "10.2.1").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.akka" %% "akka-http-testkit" % "10.2.1" % Test).withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.akka" %% "akka-stream" % "2.6.10").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.akka" %% "akka-stream-testkit" % "2.6.10" % Test).withDottyCompat(scalaVersion.value)

libraryDependencies += ("org.scalaj" % "scalaj-http_2.11" % "2.3.0").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.typesafe.slick" %% "slick" % "3.3.3").withDottyCompat(scalaVersion.value)

libraryDependencies += ("ch.qos.logback" % "logback-classic" % "1.1.2").withDottyCompat(scalaVersion.value)

libraryDependencies += ("com.h2database" % "h2" % "1.4.187").withDottyCompat(scalaVersion.value)

libraryDependencies += ("org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1").withDottyCompat(scalaVersion.value)

libraryDependencies += ("org.scoverage" %% "scalac-scoverage-plugin" % "1.4.0").withDottyCompat(scalaVersion.value)
