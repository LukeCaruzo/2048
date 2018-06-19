package de.htwg.se.twothousandfortyeight.model.gameBaseImpl

case class Score(var value: Int = 0) {
  override def toString: String = value.toString
}
