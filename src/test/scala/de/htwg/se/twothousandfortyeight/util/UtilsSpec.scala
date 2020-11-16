package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Tile
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.swing.Color

class UtilsSpec extends AnyWordSpec with Matchers {
  "A Util" when {
    "used" should {
      "have a processAction method" in {
        val turn = new Turn

        Utils.processAction(turn, "left") should be(0)
        Utils.processAction(turn, "right") should be(0)
        Utils.processAction(turn, "down") should be(0)
        Utils.processAction(turn, "up") should be(0)
        Utils.processAction(turn, "undo") should be(0)
        Utils.processAction(turn, "reset") should be(0)
        Utils.processAction(turn, "save") should be(0)
        Utils.processAction(turn, "load") should be(0)
        Utils.processAction(turn, "help") should be(3)
        Utils.processAction(turn, "blank") should be(0)
      }
      "have a help method" in {
        val newline = System.getProperty("line.separator")
        val sb = new StringBuilder

        sb.append("----------------HELP----------------" + newline)
        sb.append("| W - up    | Q - undo | R - reset |" + newline)
        sb.append("| A - left  | Z - save | T - exit  |" + newline)
        sb.append("| S - down  | U - load |           |" + newline)
        sb.append("| D - right |          |           |" + newline)
        sb.append("------------------------------------" + newline)

        Utils.help should be(sb.toString)
      }
      "have a getBackgroundColor method" in {
        val tile2 = new Tile(2)
        Utils.getBackGroundColor(tile2) should be(new Color(0xfff835))
        val tile4 = new Tile(4)
        Utils.getBackGroundColor(tile4) should be(new Color(0xaed100))
        val tile8 = new Tile(8)
        Utils.getBackGroundColor(tile8) should be(new Color(0x7dd100))
        val tile16 = new Tile(16)
        Utils.getBackGroundColor(tile16) should be(new Color(0x50d100))
        val tile32 = new Tile(32)
        Utils.getBackGroundColor(tile32) should be(new Color(0x00d1a0))
        val tile64 = new Tile(64)
        Utils.getBackGroundColor(tile64) should be(new Color(0x005ad1))
        val tile128 = new Tile(128)
        Utils.getBackGroundColor(tile128) should be(new Color(0x4c00d1))
        val tile256 = new Tile(256)
        Utils.getBackGroundColor(tile256) should be(new Color(0xb500d1))
        val tile512 = new Tile(512)
        Utils.getBackGroundColor(tile512) should be(new Color(0xd10099))
        val tile1024 = new Tile(1024)
        Utils.getBackGroundColor(tile1024) should be(new Color(0xd1005e))
        val tile2048 = new Tile(2048)
        Utils.getBackGroundColor(tile2048) should be(new Color(0xd10000))
        val tile0 = new Tile(0)
        Utils.getBackGroundColor(tile0) should be(new Color(0x707070))
      }
    }
  }
}
