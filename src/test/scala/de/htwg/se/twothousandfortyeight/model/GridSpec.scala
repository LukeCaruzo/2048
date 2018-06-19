package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.gameBaseImpl.{Grid, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
  "A Grid" when {
    "new" should {
      val grid = new Grid(0.3, 0.5, 0.7, 0.2)
      "have a initial tiles" in {
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
      }
      "have a isFull method" in {
        grid.isFull should be(false)
      }
      "have a getAvailableSpace method" in {
        grid.getAvailableSpace should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
      }
      "have a getSingleLine method which is called with 0" in {
        grid.getSingleLine(0) should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
      }
      "have a getSingleLine method which is called with 1" in {
        grid.getSingleLine(1) should be(Array(new Tile(2), new Tile(0), new Tile(0), new Tile(0)))
      }
      "have a getSingleLine method which is called with 2" in {
        grid.getSingleLine(2) should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(2)))
      }
      "have a getSingleLine method which is called with 3" in {
        grid.getSingleLine(3) should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
      }
      "have a getPositionOfTile method" in {
        grid.getPositionOfTile(2, 3).value should be(0)
      }
      "have a addTile method" in {
        grid.addTile(0.3, 0.7) should be()
        grid.addTile(0.1, 0.9) should be()
        grid.addTile(0.6, 0.5) should be()
        grid.addTile(0.9, 0.3) should be()
        grid.tiles should be(Array(new Tile(0), new Tile(4), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(2), new Tile(0)))
      }
      "have a rotate method which is called with 90" in {
        grid.rotate(90)
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(4), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0)))
        grid.rotate(270)
      }
      "have a rotate method which is called with 180" in {
        grid.rotate(180)
        grid.tiles should be(Array(new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(4), new Tile(0)))
        grid.rotate(180)
      }
      "have a rotate method which is called with 270" in {
        grid.rotate(270)
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(4), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0)))
        grid.rotate(90)
      }
      "have a toString method" in {
        grid.toString should be("(0)(4)(0)(0)\n(2)(2)(0)(0)\n(0)(0)(2)(2)\n(0)(0)(2)(0)")
      }
      "have a canBeMoved method which returns true" in {
        grid.canBeMoved should be(true)
      }
      "have a canBeMoved method which returns true when full" in {
        grid.tiles = Array(new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        grid.canBeMoved should be(true)
      }
      "have a canBeMoved method which returns false when full" in {
        grid.tiles = Array(new Tile(2), new Tile(4), new Tile(8), new Tile(16), new Tile(32), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        grid.canBeMoved should be(false)
      }
      "have a addTile method and there is no empty space" in {
        grid.tiles = Array(new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        grid.addTile(0.2, 0.3) should be()
      }
      "have a setSingleLine method" in {
        grid.setSingleLine(1, Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0))) should be()
      }
    }
  }
}