package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.{Grid, Player, Score}
import de.htwg.se.twothousandfortyeight.view.gui.GraphicalUserInterface

object TwoThousandFortyEight {
  val FIELD_SIZE = 4
  var win = false
  var lose = false
  var score = new Score
  var grid = new Grid

  def main(args: Array[String]): Unit = {
    val student = new Player("Lucas/Bilal")

    //new TextUserInterface(student)
    new GraphicalUserInterface(student)
  }
}
