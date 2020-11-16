package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Tile
import org.scalatest.wordspec.AnyWordSpec

class TileSpec extends AnyWordSpec {
  "A Tile" when {
    "new" should {
      val tile = Tile(16)
      "have a value" in {
        tile.value === 16
      }
      "have a nice String representation" in {
        tile.toString.equals("16")
      }
      "have check if it is empty" in {
        !tile.isEmpty
        Tile().isEmpty
      }
    }
  }
}
