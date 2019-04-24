package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller._
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn

import scala.swing.{Publisher, Reactor}

class Tui extends Reactor with Publisher {
  val turn = new Turn(this)

  listenTo(turn)

  reactions += {
    case _: TurnMade => printTui
    case _: GameWon => printWin
    case _: GameLost => printLose
  }

  println("Hello. Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println()
  println(turn.game.toString)
  println("Your Score: " + turn.game.score.toString)
  println()
  while (true) {
    val scanner = new java.util.Scanner(System.in)
    val line = scanner.nextLine()
    if (!line.isEmpty) {
      publishKey(line.charAt(0))
    }
  }

  def printTui(): Unit = {
    println(turn.game.toString)
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

  def publishKey(key: Char): Unit = {
    key match {
      case 'a' =>
        publish(new Left)
      case 'd' =>
        publish(new Right)
      case 's' =>
        publish(new Down)
      case 'w' =>
        publish(new Up)
      case 'q' =>
        publish(new Undo)
      case 'r' =>
        publish(new Reset)
      case 'z' =>
        publish(new Save)
      case 'u' =>
        publish(new Load)
      case 't' =>
        publish(new Exit)
      case _ =>
        publish(new Blank)
    }
  }
}
