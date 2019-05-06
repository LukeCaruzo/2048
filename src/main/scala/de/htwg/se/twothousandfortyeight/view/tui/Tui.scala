package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.util.Utils

class Tui(turn: TurnTrait) {
  println("Hello. Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println
  printTui

  while (true) {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine
    if (!line.isEmpty) {
      Utils.processKey(turn, line.charAt(0)) match {
        case 0 => printTui
        case 1 => printWin
        case 2 => printLose
      }
    }
  }

  def printTui: Unit = {
    println(turn.game.toString)
    println("Your Score: " + turn.game.score.toString)
    println
  }

  def printWin: Unit = {
    printTui
    println("You won!")
    sys.exit
  }

  def printLose: Unit = {
    printTui
    println("You lost!")
    sys.exit
  }
}
