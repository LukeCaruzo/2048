name := "2048SE"
organization := "de.htwg.se"
version := "0.0.1"
scalaVersion := "2.12.12"

import org.scoverage.coveralls.Imports.CoverallsKeys._

coverallsToken := Some("SauHm93KXQlTBivHSKxpSqJdeytSHUPcb")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"

libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.5"

libraryDependencies += "net.codingwell" %% "scala-guice" % "4.2.11"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.1"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.5.23"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.5.23" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.1"

libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % "10.2.1" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.10"

libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.10" % Test

libraryDependencies += "org.scalaj" % "scalaj-http_2.11" % "2.3.0"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

libraryDependencies += "com.h2database" % "h2" % "1.4.187"

libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1"

libraryDependencies += "org.scoverage" %% "scalac-scoverage-plugin" % "1.4.0"

libraryDependencies += "org.apache.kafka" %% "kafka" % "2.6.0"

/*libraryDependencies += "org.apache.spark" % "spark-core_2.12" % "3.0.1"

libraryDependencies += "org.apache.spark" % "spark-streaming_2.12" % "3.0.1" % "provided"

libraryDependencies += "org.apache.spark" % "spark-streaming-kafka-0-10_2.12" % "3.0.1"

libraryDependencies += "org.apache.spark" % "spark-sql_2.12" % "3.0.1"*/