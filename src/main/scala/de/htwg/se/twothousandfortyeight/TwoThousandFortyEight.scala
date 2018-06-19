package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import de.htwg.se.twothousandfortyeight.view.UserInterface

object TwoThousandFortyEight {
  val FIELD_SIZE = 4 // Tests are configured for 4

  def main(args: Array[String]): Unit = {
    val student = "Lucas/Bilal"
    val game = new Game

    new UserInterface(student, game)
  }
}
