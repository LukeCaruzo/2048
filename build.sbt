name := "2048SE"
organization := "de.htwg.se"
version := "0.0.1"
scalaVersion := "2.13.3"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.2" % "test"

libraryDependencies += "junit" % "junit" % "4.8.1" % "test"

libraryDependencies += "org.scala-lang.modules" % "scala-swing_2.13" % "2.1.1"

libraryDependencies += "com.google.inject" % "guice" % "4.1.0"

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.5"

libraryDependencies += "net.codingwell" %% "scala-guice" % "4.2.11"

libraryDependencies += "org.scala-lang.modules" % "scala-xml_2.13" % "1.3.0"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.1"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.10"

libraryDependencies += "com.typesafe.akka" %% "akka-testkit" % "2.6.10" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.1"

libraryDependencies += "com.typesafe.akka" %% "akka-http-testkit" % "10.2.1" % Test

libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.10"

libraryDependencies += "com.typesafe.akka" %% "akka-stream-testkit" % "2.6.10" % Test

libraryDependencies += "org.scalaj" % "scalaj-http_2.11" % "2.3.0"

libraryDependencies += "com.typesafe.slick" %% "slick" % "3.3.3"

libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.1.2"

libraryDependencies += "com.h2database" % "h2" % "1.4.187"

libraryDependencies += "org.mongodb.scala" %% "mongo-scala-driver" % "4.1.1"
