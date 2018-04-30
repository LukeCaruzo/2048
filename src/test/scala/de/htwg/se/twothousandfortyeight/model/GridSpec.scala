package de.htwg.se.twothousandfortyeight.model

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GridSpec extends WordSpec with Matchers {
  "A Grid" when {
    "new" should {
      var grid = new Grid()
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
    }
  }
}
