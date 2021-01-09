package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.TileTrait

object Utils:
  def processAction(turn: TurnTrait, action: String): Int =
    action match {
      case "left" => turn.turnLeft
      case "right" => turn.turnRight
      case "down" => turn.turnDown
      case "up" => turn.turnUp
      case "undo" => turn.turnUndo
      case "reset" => turn.turnReset
      case "save" => turn.turnSave
      case "load" => turn.turnLoad
      case "exit" => turn.turnExit
      case "help" => return 3
      case _ => turn.evaluate
    }

  def help: String =
    """----------------HELP----------------
      || W - up    | Q - undo | R - reset |
      || A - left  | Z - save | T - exit  |
      || S - down  | U - load |           |
      || D - right |          |           |
      |------------------------------------
      |""".stripMargin
