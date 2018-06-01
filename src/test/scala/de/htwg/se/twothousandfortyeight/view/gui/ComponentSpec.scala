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
        component.processKey("87") should be("up")
        component.processKey("83") should be("down")
        component.processKey("68") should be("right")
        component.processKey("65") should be("left")
        component.processKey("27") should be("exit")
        component.processKey("72474") should be("")
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
      }
    }
  }
}
