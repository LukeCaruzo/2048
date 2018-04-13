package de.htwg.se.twothousandfortyeight.model

case class Grid() {
  var grid: Array[Array[Tile]] = Array.ofDim(4, 4)
  for (i <- 0 to 3) {
    for (j <- 0 to 3) {
      grid(i)(j) = Tile(0)
    }
  }

  def insert(x: Int, y: Int, tile: Tile) {
    grid(x)(y) = tile
  }

  override def toString: String = grid.map(_.mkString(" ")).mkString("\n")
}
