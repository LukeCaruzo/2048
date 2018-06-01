package de.htwg.se.twothousandfortyeight.util

import java.awt.Color

import de.htwg.se.twothousandfortyeight.model.Tile

object Utils {
  def processKey(key1: Int, key2: Char): String = {
    if (key1 == 87 || key2 == 'w') {
      return "up"
    } else if (key1 == 65 || key2 == 'a') {
      return "left"
    } else if (key1 == 83 || key2 == 's') {
      return "down"
    } else if (key1 == 68 || key2 == 'd') {
      return "right"
    } else if (key1 == 84 || key2 == 't') {
      return "exit"
    } else if (key1 == 82 || key2 == 'r') {
      return "reset"
    } else {
      return ""
    }
  }

  def getBackGroundColor(tile: Tile): Color = {
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
