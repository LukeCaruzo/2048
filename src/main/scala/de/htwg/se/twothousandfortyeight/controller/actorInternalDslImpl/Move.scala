package de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl

case class Move(seq: String*) {
  seq.foreach(e => MoveActor.move(e))
  sys.exit
}