package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Score, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameSpec extends WordSpec with Matchers {
  "A Game" when {
    "new" should {
      val game = new Game
      "have a reset method" in {
        game.reset.score.value should be(0)
        game.reset.grid.length should be(TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE)
      }
      "have a rotate method" in {
        game.rotate.grid should not be (game.grid)
        game.rotate.rotate.grid should not be (game.grid)
        game.rotate.rotate.rotate.grid should not be (game.grid)
        game.rotate.rotate.rotate.rotate.grid should be(game.grid)
      }
      "have a left method" in {
        game.left.grid.length should be(16)
      }
      "have a right method" in {
        game.right.grid.length should be(16)
      }
      "have a up method" in {
        game.up.grid.length should be(16)
      }
      "have a down method" in {
        game.down.grid.length should be(16)
      }
      "have a mergeSingleLine, moveSingleLine and getSingleLine method" in {
        game.getSingleLine(0).moveSingleLine.mergeSingleLine.grid.length should be(4)
      }
      "have a toString method" in {
        game.toString.length should be(51)
      }
    }
  }
}
