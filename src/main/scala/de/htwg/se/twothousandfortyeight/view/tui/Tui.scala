package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.TurnTrait

class Tui(turn: TurnTrait) {
  println("Hello. Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println
  println(turn.game.toString)
  println("Your Score: " + turn.game.score.toString)
  println
  while (true) {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine
    if (!line.isEmpty) {
      publishKey(line.charAt(0)) match {
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

  def publishKey(key: Char): Int = {
    key match {
      case 'a' =>
        turn.turnLeft
      case 'd' =>
        turn.turnRight
      case 's' =>
        turn.turnDown
      case 'w' =>
        turn.turnUp
      case 'q' =>
        turn.turnUndo
      case 'r' =>
        turn.turnReset
      case 'z' =>
        turn.turnSave
      case 'u' =>
        turn.turnLoad
      case 't' =>
        turn.turnExit
      case _ =>
        turn.evaluate
    }
  }
}
