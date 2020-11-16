package de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl

case class Move(seq: String*) {
  val moveActor = new MoveActor
  seq.foreach(e => moveActor.move(e))
  sys.exit
}