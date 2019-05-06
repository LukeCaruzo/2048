package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.TileTrait

import scala.swing.Color

object Utils {
  def processKey(turn: TurnTrait, key: Char): Int = {
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

  @deprecated
  def getBackGroundColor(tile: TileTrait): Color = {
    tile.value match {
      case 2 =>
        return new Color(0xfff835)
      case 4 =>
        return new Color(0xaed100)
      case 8 =>
        return new Color(0x7dd100)
      case 16 =>
        return new Color(0x50d100)
      case 32 =>
        return new Color(0x00d1a0)
      case 64 =>
        return new Color(0x005ad1)
      case 128 =>
        return new Color(0x4c00d1)
      case 256 =>
        return new Color(0xb500d1)
      case 512 =>
        return new Color(0xd10099)
      case 1024 =>
        return new Color(0xd1005e)
      case 2048 =>
        return new Color(0xd10000)
      case _ =>
        return new Color(0x707070)
    }
  }
}
