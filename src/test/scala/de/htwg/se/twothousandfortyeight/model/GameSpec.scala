package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.scalatest._
import org.scalatest.matchers.should.Matchers

class GameSpec extends wordspec.AnyWordSpec with Matchers {
  "A Game" when {
    "new" should {
      val game = new Game
      "have a reset method" in {
        game.reset.score.value shouldBe 0
        game.reset.grid.length shouldBe TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE
      }
      "have a rotate method" in {
        !game.rotate.grid.equals(game.grid)
        !game.rotate.rotate.grid.equals(game.grid)
        !game.rotate.rotate.rotate.grid.equals(game.grid)
        game.rotate.rotate.rotate.rotate.grid.equals(game.grid)
      }
      "have a left method" in {
        game.left.grid.length shouldBe 16
      }
      "have a right method" in {
        game.right.grid.length shouldBe 16
      }
      "have a up method" in {
        game.up.grid.length shouldBe 16
      }
      "have a down method" in {
        game.down.grid.length shouldBe 16
      }
      "have a mergeSingleLine, moveSingleLine and getSingleLine method" in {
        game.getSingleLine(0).moveSingleLine.mergeSingleLine.grid.length shouldBe 4
      }
      "have a toString method" in {
        game.toString.length shouldBe 54
      }
    }
  }
}
