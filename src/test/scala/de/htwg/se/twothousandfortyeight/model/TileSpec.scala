package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Tile
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class TileSpec extends AnyWordSpec with Matchers {
  "A Tile" when {
    "new" should {
      var tile = new Tile(16)
      var tileEmpty = new Tile()
      "have a value" in {
        tile.value should be(16)
      }
      "have a nice String representation" in {
        tile.toString should be("16")
      }
      "have check if it is empty" in {
        tile.isEmpty should be(false)
        tileEmpty.isEmpty should be(true)
      }
    }
  }
}
