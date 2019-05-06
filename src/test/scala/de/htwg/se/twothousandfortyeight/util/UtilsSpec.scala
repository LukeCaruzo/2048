package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Tile
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

import scala.swing.Color

@RunWith(classOf[JUnitRunner])
class UtilsSpec extends WordSpec with Matchers {
  "A Util" when {
    "used" should {
      "have a processKey method" in {
        val turn = new Turn

        Utils.processKey(turn, 'a') should be(0)
        Utils.processKey(turn, 'd') should be(0)
        Utils.processKey(turn, 's') should be(0)
        Utils.processKey(turn, 'w') should be(0)
        Utils.processKey(turn, 'q') should be(0)
        Utils.processKey(turn, 'r') should be(0)
        Utils.processKey(turn, 'z') should be(0)
        Utils.processKey(turn, 'u') should be(0)
        Utils.processKey(turn, ' ') should be(0)
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
