package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.TileTrait

import scala.swing.Color

object Utils {
  def processAction(turn: TurnTrait, action: String): Int = {
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
  }

  def help: String = {
    val newline = "\n"
    val sb = new StringBuilder

    sb.append("----------------HELP----------------" + newline)
    sb.append("| W - up    | Q - undo | R - reset |" + newline)
    sb.append("| A - left  | Z - save | T - exit  |" + newline)
    sb.append("| S - down  | U - load |           |" + newline)
    sb.append("| D - right |          |           |" + newline)
    sb.append("------------------------------------" + newline)

    return sb.toString
  }

  @deprecated
  def getBackGroundColor(tile: TileTrait): Color = {
    tile.value match {
      case 2 => return new Color(0xfff835)
      case 4 => return new Color(0xaed100)
      case 8 => return new Color(0x7dd100)
      case 16 => return new Color(0x50d100)
      case 32 => return new Color(0x00d1a0)
      case 64 => return new Color(0x005ad1)
      case 128 => return new Color(0x4c00d1)
      case 256 => return new Color(0xb500d1)
      case 512 => return new Color(0xd10099)
      case 1024 => return new Color(0xd1005e)
      case 2048 => return new Color(0xd10000)
      case _ => return new Color(0x707070)
    }
  }
}
