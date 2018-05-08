package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.{Grid, Player, Score}
import de.htwg.se.twothousandfortyeight.view.TextUserInterface

object TwoThousandFortyEight {
  var win = false
  var lose = false
  var score = new Score
  var grid = new Grid

  def main(args: Array[String]): Unit = {
    val student = new Player("Lucas/Bilal")

    new TextUserInterface(student)
  }
}
