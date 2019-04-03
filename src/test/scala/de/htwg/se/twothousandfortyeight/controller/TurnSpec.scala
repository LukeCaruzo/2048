package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Functions, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  /*"A Turn" when {
    "used" should {
      val turn = new Turn
      turn.game.grid = new Grid(0.3, 0.5, 0.7, 0.2)
      "have a makeTurn method" in {
        turn.makeTurn("up", 0.4, 0.7)
        turn.makeTurn("down", 0.4, 0.7)
        turn.makeTurn("left", 0.4, 0.7)
        turn.makeTurn("right", 0.4, 0.7)
        turn.game.grid.tiles = Array(new Tile(2), new Tile(4), new Tile(8), new Tile(16), new Tile(32), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        turn.makeTurn("left", 0.4, 0.7)
        //game.lose should be(true)
        turn.makeTurn("reset", 0.5, 0.5)
        //game.lose should be(false)
        turn.makeTurn("save", 0.5, 0.5)
        turn.makeTurn("load", 0.5, 0.5)
        turn.makeTurn("undo", 0.5, 0.5)
      }
      "have a left method with no need for tile" in {
        turn.game.reset
        turn.game.grid.tiles = Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0))
        turn.game.left(0.5, 0.3)
        turn.game.grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
        turn.game.score.value should be(0)
      }
      "have a mergeSingleLine method with win" in {
        turn.game.grid.tiles = Array(new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024))
        turn.game.mergeSingleLine(turn.game.grid.getSingleLine(1)) should be(Array(new Tile(2048), new Tile(2048), new Tile(0), new Tile(0)))
        //game.win should be(true)
      }
    }
  }*/
}
