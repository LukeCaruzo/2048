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

libraryDependencies += "com.google.code.gson" % "gson" % "2.8.5"

libraryDependencies += ("org.scalaj" % "scalaj-http_2.11" % "2.3.0").withDottyCompat(scalaVersion.value)

libraryDependencies += ("org.scoverage" %% "scalac-scoverage-plugin" % "1.4.0").withDottyCompat(scalaVersion.value)
