package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import de.htwg.se.twothousandfortyeight.view.tui.Tui

object TwoThousandFortyEight {
  val FIELD_SIZE = 4 // Tests are configured for 4

  def main(args: Array[String]): Unit = {
    val game = new Game
    val turn = new Turn

    new Tui(game, turn)
  }
}
