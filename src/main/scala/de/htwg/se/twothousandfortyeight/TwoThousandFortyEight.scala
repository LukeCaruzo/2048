package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.Player
import de.htwg.se.twothousandfortyeight.model.Tile

object TwoThousandFortyEight {
  def main(args: Array[String]): Unit = {
    val student = Player("Lucas/Bilal")
    println("Hello, " + student.name)

    val tile = Tile(0, 0)
    println(tile.isNotEmpty)
    println(tile.toString)
    tile.updateValue(64)
    println(tile.isNotEmpty)
    println(tile.toString)
  }
}
