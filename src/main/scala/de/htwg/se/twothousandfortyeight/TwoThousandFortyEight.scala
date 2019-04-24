package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.{Reactor, Turn}
import de.htwg.se.twothousandfortyeight.view.tui.Tui

object TwoThousandFortyEight {
  val FIELD_SIZE = 4 // Tests are configured for 4

  def main(args: Array[String]): Unit = {
    val turn = new Turn
    val reactor = new Reactor(turn)

    new Tui(turn, reactor)
  }
}
