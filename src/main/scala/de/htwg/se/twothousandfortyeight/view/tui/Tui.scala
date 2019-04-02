package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.{TurnMade, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.util.Utils

import scala.swing.Reactor

class Tui(game: GameTrait, turn: TurnTrait) extends Reactor {
  listenTo(turn)

  reactions += {
    case event: TurnMade => printTui
  }

  println("Hello. Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println()
  println(game.status.grid.toString)
  println("Your Score: " + game.status.score.toString)
  println()
  while (true) {
    val scanner = new java.util.Scanner(System.in)
    turn.makeTurn(game, Utils.processKey(scanner.nextLine().charAt(0)), Math.random(), Math.random())
  }

  def printTui(): Unit = {
    if (game.status.win) {
      println("You won!")
    } else if (game.status.lose) {
      println("You lost!")
    } else {
      println(game.status.grid.toString)
      println("Your Score: " + game.status.score.toString)
      println()
    }
  }
}
