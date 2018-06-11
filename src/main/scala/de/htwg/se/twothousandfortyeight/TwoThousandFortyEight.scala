package de.htwg.se.twothousandfortyeight

import java.util.Scanner

import de.htwg.se.twothousandfortyeight.model.{Grid, Player, Score}
import de.htwg.se.twothousandfortyeight.view.gui.GraphicalUserInterface
//import de.htwg.se.twothousandfortyeight.view.tui.TextUserInterface

object TwoThousandFortyEight {
  var FIELD_SIZE = 9 // Tests are configured for 4
  var win = false
  var lose = false
  var score = new Score
  var grid = new Grid

  def main(args: Array[String]): Unit = {
    println("Enter your name: ")
    val student = new Player(new Scanner(System.in).next())

    //new TextUserInterface(student)
    new GraphicalUserInterface(student)
  }
}
