package de.htwg.se.twothousandfortyeight.model

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
      "have a canBeMoved method" in {
        grid.canBeMoved should be(true)
      }
      "have a addTile method" in {
        grid.addTile(0.3, 0.7) should be()
        grid.addTile(0.1, 0.9) should be()
        grid.addTile(0.6, 0.5) should be()
        grid.addTile(0.9, 0.3) should be()
        grid.tiles should be(Array(new Tile(0), new Tile(4), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(2), new Tile(0)))
      }
      "have a rotate method which is called with 90" in {
        grid.rotate(90) should be(Array(new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(4), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0)))
      }
      "have a rotate method which is called with 180" in {
        grid.rotate(180) should be(Array(new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(4), new Tile(0)))
      }
      "have a rotate method which is called with 270" in {
        grid.rotate(270) should be(Array(new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(4), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0)))
      }
      "have a toString method" in {
        grid.toString should be("(0)(4)(0)(0)\n(2)(2)(0)(0)\n(0)(0)(2)(2)\n(0)(0)(2)(0)")
      }
    }
  }
}