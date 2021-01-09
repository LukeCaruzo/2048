package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.util.Utils

class Tui(turn: TurnTrait):
  println(Utils.help)
  printTui

  while (true)
    try
      val scanner = new java.util.Scanner(System.in)
      val line = scanner.nextLine
      if (!line.isEmpty)
        Utils.processAction(turn, processInput(line)) match
          case 0 => printTui
          case 1 => printWin
          case 2 => printLose
          case 3 => printHelp
    catch
      case _: NoSuchElementException => println("running: tui") // fix for docker
    

  def processInput(line: String): String =
    line.charAt(0) match
      case 'a' => return "left"
      case 'd' => return "right"
      case 's' => return "down"
      case 'w' => return "up"
      case 'q' => return "undo"
      case 'r' => return "reset"
      case 'z' => return "save"
      case 'u' => return "load"
      case 't' => return "exit"
      case 'h' => return "help"
      case _ => return "blank"

  def printTui: Unit =
    println(turn.game.toString)
    println("Your Score: " + turn.game.score.toString)
    println

  def printWin: Unit =
    printTui
    println("You won!")
    sys.exit

  def printLose: Unit =
    printTui
    println("You lost!")
    sys.exit

  def printHelp: Unit =
    println(Utils.help)
    println
