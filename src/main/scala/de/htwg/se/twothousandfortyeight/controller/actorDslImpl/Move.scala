package de.htwg.se.twothousandfortyeight.controller.actorDslImpl

case class Move(seq: String*) {
  seq.foreach(e => Player.play(e))
}
