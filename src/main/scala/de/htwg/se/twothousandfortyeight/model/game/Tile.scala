package de.htwg.se.twothousandfortyeight.model.game

import de.htwg.se.twothousandfortyeight.model.TileTrait


case class Tile(var value: Int = 0) extends TileTrait {
  def isEmpty: Boolean = value == 0

  override def toString: String = "(" + value.toString + ")"
}
