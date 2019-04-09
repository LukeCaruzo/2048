package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Move.{getSingleLine, mergeSingleLine, moveSingleLine}
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Move, Score, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MoveSpec extends WordSpec with Matchers {
  "A Move" when {
    "new" should {
      "have a addTile method" in {
        Move.addTile(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())).length should be(16)
      }
      "have a left method" in {
        Move.left(new Game).grid.length should be(16)
      }
      "have a right method" in {
        Move.right(new Game).grid.length should be(16)
      }
      "have a up method" in {
        Move.up(new Game).grid.length should be(16)
      }
      "have a down method" in {
        Move.down(new Game).grid.length should be(16)
      }
      "have a compareLines method" in {
        val tiles1 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())
        val tiles2 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(2))
        val tiles3 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE * 2).map(_ => new Tile(2))
        val tiles4 = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(4))
        Move.compareLines(tiles1, tiles1) should be(true)
        Move.compareLines(tiles1, tiles2) should be(false)
        Move.compareLines(tiles1, tiles3) should be(false)
        Move.compareLines(tiles1, tiles4) should be(false)
        Move.compareLines(tiles2, tiles1) should be(false)
        Move.compareLines(tiles2, tiles2) should be(true)
        Move.compareLines(tiles2, tiles3) should be(false)
        Move.compareLines(tiles2, tiles4) should be(false)
        Move.compareLines(tiles3, tiles1) should be(false)
        Move.compareLines(tiles3, tiles2) should be(false)
        Move.compareLines(tiles3, tiles3) should be(true)
        Move.compareLines(tiles3, tiles4) should be(false)
        Move.compareLines(tiles4, tiles1) should be(false)
        Move.compareLines(tiles4, tiles2) should be(false)
        Move.compareLines(tiles4, tiles3) should be(false)
        Move.compareLines(tiles4, tiles4) should be(true)
      }
      "have a mergeSingleLine, moveSingleLine and getSingleLine method" in {
        mergeSingleLine(moveSingleLine(new Game(getSingleLine(new Game, 0).grid, new Score))).grid.length should be(4)
      }
      "have a getPositionOfTile method" in {
        Move.getPositionOfTile(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile()), 2, 2) should be(new Tile())
      }
      "have a canBeMoved method" in {
        Move.canBeMoved(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())) should be(true)
        Move.canBeMoved(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(4))) should be(true)
      }
      "have a isFull method" in {
        Move.isFull(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile())) should be(false)
        Move.isFull(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile(4))) should be(true)
      }
    }
  }
}
