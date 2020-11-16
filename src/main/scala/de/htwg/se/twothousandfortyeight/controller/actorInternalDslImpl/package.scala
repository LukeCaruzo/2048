package de.htwg.se.twothousandfortyeight.controller

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.util.Timeout

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

package object actorInternalDslImpl {
  implicit val timeout = Timeout(5 seconds)
  implicit val system = ActorSystem("system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val w = "w"
  val a = "a"
  val s = "s"
  val d = "d"
  val q = "q"
  val r = "r"
  val z = "z"
  val u = "u"
  val t = "t"
  val h = "h"
}
