package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.{GameLost, GameWon, TurnMade, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.util.Utils

import scala.swing.Reactor

class Tui(turn: TurnTrait) extends Reactor {
  listenTo(turn)

  reactions += {
    case event: TurnMade => printTui
    case event: GameWon => printWin
    case event: GameLost => printLose
  }

  println("Hello. Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println()
  println(turn.game.grid.toString)
  println("Your Score: " + turn.game.score.toString)
  println()
  while (true) {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine()
    if(!line.isEmpty) {
      turn.makeTurn(Utils.processKey(line.charAt(0)), Math.random(), Math.random())
    }
  }

  def printTui(): Unit = {
    println(turn.game.grid.toString)
    println("Your Score: " + turn.game.score.toString)
    println()
  }

  def printWin(): Unit = {
    printTui()
    println("You won!")
    sys.exit()
  }

  def printLose(): Unit = {
    printTui()
    println("You lost!")
    sys.exit()
  }
}
