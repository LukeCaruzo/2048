package de.htwg.se.twothousandfortyeight.model

case class Grid() {
  var grid: Array[Tile] = Array.fill[Tile](16)(new Tile(0))

  override def toString: String = grid.toString
}
