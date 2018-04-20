package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.Player
import de.htwg.se.twothousandfortyeight.model.Grid

object TwoThousandFortyEight {
  var win = false
  var lose = false
  var score = 0
  var grid = new Grid

  def resetAll(): Unit = {
    score = 0
    win = false
    lose = false
    grid.resetGrid
  }

  def main(args: Array[String]): Unit = {
    val student = Player("Lucas/Bilal")
    println("Hello, " + student.name)
  }
}
