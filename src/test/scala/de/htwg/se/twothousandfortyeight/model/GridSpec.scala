package de.htwg.se.twothousandfortyeight.model

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
  "A Grid" when {
    "new" should {
      var grid = new Grid
      var grid2 = new Grid
      "have a initial tiles" in {
        grid.tiles should be(new Array[Tile](16))
      }
      "have a isFull method" in {
        grid.resetGrid
        grid.isFull should be(false)
      }
      "have a getAvailableSpace method" in {
        grid.resetGrid
        grid.getAvailableSpace.toString should be("[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]")
      }
      "have a compareLines method case a true result" in {
        var line1 = grid.tiles
        var line2 = grid.tiles
        grid.compareLines(line1, line2) should be(true)
      }
      "have a compareLines method case a false result" in {
        grid2.resetGrid
        var line1 = grid.tiles
        var line3 = grid2.tiles
        grid.compareLines(line1, line3) should be(false)
      }
      "have a getLine method " in {
        grid2.getLine(0).length.toString should be("4")
      }
      "have a positionOfTile method " in {
        grid.positionOfTile(2, 3).value should be(0)
      }
      "have a isTileMoveable method " in {
        grid.isTileMoveable should be(true)
      }
    }
  }
}
