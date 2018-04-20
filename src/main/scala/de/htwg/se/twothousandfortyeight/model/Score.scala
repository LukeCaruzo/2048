package de.htwg.se.twothousandfortyeight.model

class Score(cscore: Int = 0) {
  var score: Int = cscore

  override def toString: String = score.toString
}
