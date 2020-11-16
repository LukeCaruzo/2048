package de.htwg.se.twothousandfortyeight.controller.actorBaseImpl

case class Move(seq: String*) {
  seq.foreach(e => Player.play(e))
}