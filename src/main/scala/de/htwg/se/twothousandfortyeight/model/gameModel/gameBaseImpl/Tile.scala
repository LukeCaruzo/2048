package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

import de.htwg.se.twothousandfortyeight.model.gameModel.TileTrait

case class Tile(value: Int = 0) extends TileTrait {
  def isEmpty: Boolean = value == 0

  override def toString: String = value.toString
}
