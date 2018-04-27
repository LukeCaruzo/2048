package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.{Grid, Player, Score}

object TwoThousandFortyEight {
  var win = false
  var lose = false
  var score = new Score
  var grid = new Grid

  def resetAll(): Unit = {
    score.resetScore
    win = false
    lose = false
    grid.resetGrid
  }

  def main(args: Array[String]): Unit = {
    val student = Player("Lucas/Bilal")
    println("Hello, " + student.name)
  }
}
