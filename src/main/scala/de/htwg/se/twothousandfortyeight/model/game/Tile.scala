package de.htwg.se.twothousandfortyeight.model.game

case class Tile(var value: Int = 0) {
  def isEmpty: Boolean = value == 0

  override def toString: String = "(" + value.toString + ")"
}
