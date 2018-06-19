package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.game.Tile

@RunWith(classOf[JUnitRunner])
class TileSpec extends WordSpec with Matchers {
  "A Tile" when {
    "new" should {
      var tile = new Tile(16)
      var tileEmpty = new Tile()
      "have a value" in {
        tile.value should be(16)
      }
      "have a nice String representation" in {
        tile.toString should be("(16)")
      }
      "have check if it is empty" in {
        tile.isEmpty should be(false)
        tileEmpty.isEmpty should be(true)
      }
    }
  }
}
