package de.htwg.se.twothousandfortyeight.controller

import org.scalatest.wordspec.AnyWordSpec
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Tile}

class TurnSpec extends AnyWordSpec {
  val turn = new Turn

  "A turn" should {
    "have a turnLeft method" in {
      assert(turn.turnLeft === 0)
    }
  }

  "A Turn" when {
    "new" should {
      val turn = new Turn

      "have a turnLeft method" in {
        turn.turnLeft === 0
      }
      "have a turnRight method" in {
        turn.turnRight === 0
      }
      "have a turnDown method" in {
        turn.turnDown === 0
      }
      "have a turnUp method" in {
        turn.turnUp === 0
      }
      "have a turnUndo method" in {
        turn.turnUndo === 0
      }
      "have a turnReset method" in {
        turn.turnReset === 0
      }
      "have a turnSave method" in {
        turn.turnSave === 0
      }
      "have a turnLoad method" in {
        turn.turnLoad === 0
      }
      "have a evaluate method" in {
        turn.evaluate === 0
      }
      "have a way to win" in {
        val winArray = Array[Tile](new Tile(2), new Tile(1024), new Tile(1024),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(2),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2))
        turn.game = new Game(winArray)
        turn.turnRight === 1
        turn.evaluate === 1
      }
      "have a way to lose" in {
        val loseArray = Array[Tile](
          new Tile(2), new Tile(4), new Tile(8), new Tile(16),
          new Tile(16), new Tile(8), new Tile(4), new Tile(2),
          new Tile(32), new Tile(64), new Tile(128), new Tile(256),
          new Tile(256), new Tile(128), new Tile(64), new Tile(32))
        turn.game = new Game(loseArray)
        turn.turnRight === 2
        turn.evaluate === 2
      }
    }
  }
}
