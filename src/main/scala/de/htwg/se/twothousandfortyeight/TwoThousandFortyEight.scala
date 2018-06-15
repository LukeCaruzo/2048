package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model._
import de.htwg.se.twothousandfortyeight.view.gui.GraphicalUserInterface
import de.htwg.se.twothousandfortyeight.view.tui.TextUserInterface

object TwoThousandFortyEight {
  val FIELD_SIZE = 4 // Tests are configured for 4

  def main(args: Array[String]): Unit = {
    val student = new Player("Lucas/Bilal")
    val game = new Game

    new GraphicalUserInterface(student, game)
    new TextUserInterface(student, game)
  }
}
