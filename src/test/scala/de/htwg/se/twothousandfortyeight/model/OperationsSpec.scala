package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Operations, Tile}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class OperationsSpec extends AnyWordSpec with Matchers {
  "A Move" when {
    "used" should {
      "have a addTile method" in {
        val tiles = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.isFull(tiles) should be(false)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.addTile(tiles).length should be(16)
        Operations.isFull(tiles) should be(true)
      }
      "have a compareLines method" in {
        val tiles1 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())
        val tiles2 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(2))
        val tiles3 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE * 2).map(_ => new Tile(2))
        val tiles4 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(4))
        Operations.compareLines(tiles1, tiles1) should be(true)
        Operations.compareLines(tiles1, tiles2) should be(false)
        Operations.compareLines(tiles1, tiles3) should be(false)
        Operations.compareLines(tiles1, tiles4) should be(false)
        Operations.compareLines(tiles2, tiles1) should be(false)
        Operations.compareLines(tiles2, tiles2) should be(true)
        Operations.compareLines(tiles2, tiles3) should be(false)
        Operations.compareLines(tiles2, tiles4) should be(false)
        Operations.compareLines(tiles3, tiles1) should be(false)
        Operations.compareLines(tiles3, tiles2) should be(false)
        Operations.compareLines(tiles3, tiles3) should be(true)
        Operations.compareLines(tiles3, tiles4) should be(false)
        Operations.compareLines(tiles4, tiles1) should be(false)
        Operations.compareLines(tiles4, tiles2) should be(false)
        Operations.compareLines(tiles4, tiles3) should be(false)
        Operations.compareLines(tiles4, tiles4) should be(true)
      }
      "have a getPositionOfTile method" in {
        Operations.getPositionOfTile(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile()), 2, 2) should be(new Tile())
      }
      "have a canBeMoved method" in {
        Operations.canBeMoved(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())) should be(true)
        Operations.canBeMoved(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(4))) should be(true)
      }
      "have a isFull method" in {
        Operations.isFull(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())) should be(false)
        Operations.isFull(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(4))) should be(true)
      }
    }
  }
}
