package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.TurnResult.{HELP, LOSE, TURN_FINISHED, WIN}
import de.htwg.se.twothousandfortyeight.controller.{TurnResult, TurnTrait}
import de.htwg.se.twothousandfortyeight.util.Utils

class Tui(turn: TurnTrait) {
  println(Utils.help)
  printTui

  while (true) {
    try {
      val scanner = new java.util.Scanner(System.in)
      val line = scanner.nextLine
      if (!line.isEmpty) {
        Utils.processAction(turn, processInput(line)) match {
          case TURN_FINISHED => printTui
          case WIN => printWin
          case LOSE => printLose
          case HELP => printHelp
        }
      }
    } catch {
      case _: NoSuchElementException => println("running: tui") // fix for docker
    }
  }

  def processInput(line: String): String = {
    line.charAt(0).toLower match {
      case 'a' => "left"
      case 'd' => "right"
      case 's' => "down"
      case 'w' => "up"
      case 'q' => "undo"
      case 'r' => "reset"
      case 'z' => "save"
      case 'u' => "load"
      case 't' => "exit"
      case 'h' => "help"
      case _ => "blank"
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

  def printHelp: Unit = {
    println(Utils.help)
    println
  }
}
