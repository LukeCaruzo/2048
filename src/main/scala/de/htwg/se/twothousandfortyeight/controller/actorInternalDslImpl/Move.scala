package de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl

case class Move(seq: String*) {
  seq.foreach(e => Player.play(e))
  sys.exit
}