package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.Player
import de.htwg.se.twothousandfortyeight.model.Grid
import de.htwg.se.twothousandfortyeight.model.Tile

object TwoThousandFortyEight {
  var win = false
  var lose = false
  var score = 0
  var tiles = new Array[Tile](4 * 4)

  def resetAll(): Unit = {
    score = 0
    win = false
    lose = false
    tiles = new Array[Tile](4 * 4)(new Tile)

    // Initialize with 2 tiles
    // addTile
    // addTile
  }

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
    println(grid.toString)
  }
}
