package de.htwg.se.twothousandfortyeight.controller

import org.scalatest.wordspec.AnyWordSpec

class TurnSpec extends AnyWordSpec {
  /*"A Turn" when {
    "new" should {
      val turn = new Turn

      "have a turnLeft method" in {
        turn.turnLeft should be(0)
      }
      "have a turnRight method" in {
        turn.turnRight should be(0)
      }
      "have a turnDown method" in {
        turn.turnDown should be(0)
      }
      "have a turnUp method" in {
        turn.turnUp should be(0)
      }
      "have a turnUndo method" in {
        turn.turnUndo should be(0)
      }
      "have a turnReset method" in {
        turn.turnReset should be(0)
      }
      "have a turnSave method" in {
        turn.turnSave should be(0)
      }
      "have a turnLoad method" in {
        turn.turnLoad should be(0)
      }
      "have a evaluate method" in {
        turn.evaluate should be(0)
      }
      "have a way to win" in {
        val winArray = Array[Tile](new Tile(2), new Tile(1024), new Tile(1024),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(2),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2))
        turn.game = new Game(winArray)
        turn.turnRight should be(1)
        turn.evaluate should be(1)
      }
      "have a way to lose" in {
        val loseArray = Array[Tile](
          new Tile(2), new Tile(4), new Tile(8), new Tile(16),
          new Tile(16), new Tile(8), new Tile(4), new Tile(2),
          new Tile(32), new Tile(64), new Tile(128), new Tile(256),
          new Tile(256), new Tile(128), new Tile(64), new Tile(32))
        turn.game = new Game(loseArray)
        turn.turnRight should be(2)
        turn.evaluate should be(2)
      }
    }
  }*/
}
