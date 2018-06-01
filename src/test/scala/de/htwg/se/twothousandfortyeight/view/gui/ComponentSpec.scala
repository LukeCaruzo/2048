package de.htwg.se.twothousandfortyeight.view.gui

import java.awt.Color

import de.htwg.se.twothousandfortyeight.model.Tile
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ComponentSpec extends WordSpec with Matchers {
  "A Component" when {
    "new" should {
      val component = new Component
      "have a processKey method" in {
        component.processKey(87, 'w') should be("up")
        component.processKey(83, 's') should be("down")
        component.processKey(68, 'd') should be("right")
        component.processKey(65, 'a') should be("left")
        component.processKey(27, ' ') should be("exit")
        component.processKey(32, ' ') should be("")
      }
      "have a getForegroundColor method" in {
        val tile = new Tile(2)
        component.getForegroundColor(tile) should be(new Color(0xededed))
      }
      "have a getBackgroundColor method" in {
        val tile2 = new Tile(2)
        component.getBackGroundColor(tile2) should be(new Color(0xc6d100))
        val tile4 = new Tile(4)
        component.getBackGroundColor(tile4) should be(new Color(0xaed100))
        val tile8 = new Tile(8)
        component.getBackGroundColor(tile8) should be(new Color(0x7dd100))
        val tile16 = new Tile(16)
        component.getBackGroundColor(tile16) should be(new Color(0x50d100))
        val tile32 = new Tile(32)
        component.getBackGroundColor(tile32) should be(new Color(0x00d1a0))
        val tile64 = new Tile(64)
        component.getBackGroundColor(tile64) should be(new Color(0x005ad1))
        val tile128 = new Tile(128)
        component.getBackGroundColor(tile128) should be(new Color(0x4c00d1))
        val tile256 = new Tile(256)
        component.getBackGroundColor(tile256) should be(new Color(0xb500d1))
        val tile512 = new Tile(512)
        component.getBackGroundColor(tile512) should be(new Color(0xd10099))
        val tile1024 = new Tile(1024)
        component.getBackGroundColor(tile1024) should be(new Color(0xd1005e))
        val tile2048 = new Tile(2048)
        component.getBackGroundColor(tile2048) should be(new Color(0xd10000))
        val tile0 = new Tile(0)
        component.getBackGroundColor(tile0) should be(new Color(0x707070))



      }
    }
  }
}
