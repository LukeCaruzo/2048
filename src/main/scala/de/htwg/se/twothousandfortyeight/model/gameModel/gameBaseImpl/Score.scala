package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

case class Score(val value: Int = 0) {
  override def toString: String = value.toString
}
