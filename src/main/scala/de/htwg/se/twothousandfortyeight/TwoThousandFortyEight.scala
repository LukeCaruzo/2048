package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.Player
import de.htwg.se.twothousandfortyeight.model.Grid
import de.htwg.se.twothousandfortyeight.model.Tile


object TwoThousandFortyEight {
  def main(args: Array[String]): Unit = {
    val student = Player("Lucas/Bilal")
    println("Hello, " + student.name)

    val tile = Tile()
    println(tile.isEmpty)
    println(tile.toString)

    tile.value = 64
    println(tile.isNotEmpty)
    println(tile.toString)

    val grid = Grid()
    grid.insert(1, 2, new Tile(64))
    println(grid.toString)
  }
}
