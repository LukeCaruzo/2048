package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.controller.TurnResult.{LOSE, TURN_FINISHED, WIN}
import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Tile}
import org.scalatest.matchers.should.Matchers

class TurnSpec extends AnyWordSpec with Matchers {
  "A Turn" when {
    "new" should {
      val turn = new Turn

      "have a turnLeft method" in {
        turn.turnLeft should be(TURN_FINISHED)
      }
      "have a turnRight method" in {
        turn.turnRight should be(TURN_FINISHED)
      }
      "have a turnDown method" in {
        turn.turnDown should be(TURN_FINISHED)
      }
      "have a turnUp method" in {
        turn.turnUp should be(TURN_FINISHED)
      }
      "have a turnUndo method" in {
        turn.turnUndo should be(TURN_FINISHED)
      }
      "have a turnReset method" in {
        turn.turnReset should be(TURN_FINISHED)
      }
      "have a turnSave method" in {
        turn.turnSave should be(TURN_FINISHED)
      }
      "have a turnLoad method" in {
        turn.turnLoad should be(TURN_FINISHED)
      }
      "have a evaluate method" in {
        turn.evaluate should be(TURN_FINISHED)
      }
      "have a way to win" in {
        val winArray = Array[Tile](
          Tile(2), Tile(1024), Tile(1024),Tile(2),
          Tile(2), Tile(2), Tile(2), Tile(2),
          Tile(2), Tile(2), Tile(2), Tile(2),
          Tile(2), Tile(2), Tile(2), Tile(2))
        turn.game = Game(winArray)
        turn.turnRight should be(WIN)
        turn.evaluate should be(WIN)
      }
      "have a way to lose" in {
        val loseArray = Array[Tile](
          Tile(2), Tile(4), Tile(8), Tile(16),
          Tile(16), Tile(8), Tile(4), Tile(2),
          Tile(32), Tile(64), Tile(128), Tile(256),
          Tile(256), Tile(128), Tile(64), Tile(32))
        turn.game = Game(loseArray)
        turn.turnRight should be(LOSE)
        turn.evaluate should be(LOSE)
      }
    }
  }
}
