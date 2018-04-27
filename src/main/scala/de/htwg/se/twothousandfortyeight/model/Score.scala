package de.htwg.se.twothousandfortyeight.model

case class Score(var score: Int = 0) {
  def resetScore(): Unit = {
    score = 0
  }
}
