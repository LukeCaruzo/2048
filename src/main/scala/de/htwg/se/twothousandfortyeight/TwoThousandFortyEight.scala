package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.view.rest.Rest
import de.htwg.se.twothousandfortyeight.view.tui.Tui


object TwoThousandFortyEight {
  val FIELD_SIZE = 4 // Tests and Slick are configured for 4

  def main(args: Array[String]): Unit = {
    val turn = new Turn

    new Rest(turn)
    new Tui(turn)
  }
}
