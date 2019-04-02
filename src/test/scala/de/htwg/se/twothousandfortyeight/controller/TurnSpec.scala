package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Grid, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  "A Turn" when {
    "used" should {
      val game = new Game
      val turn = new Turn
      game.status.grid = new Grid(0.3, 0.5, 0.7, 0.2)
      "have a makeTurn method" in {
        turn.makeTurn(game, "up", 0.4, 0.7)
        turn.makeTurn(game, "down", 0.4, 0.7)
        turn.makeTurn(game, "left", 0.4, 0.7)
        turn.makeTurn(game, "right", 0.4, 0.7)
        game.status.grid.tiles = Array(new Tile(2), new Tile(4), new Tile(8), new Tile(16), new Tile(32), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        turn.makeTurn(game, "left", 0.4, 0.7)
        game.status.lose should be(true)
        turn.makeTurn(game, "reset", 0.5, 0.5)
        game.status.lose should be(false)
        turn.makeTurn(game, "save", 0.5, 0.5)
        turn.makeTurn(game, "load", 0.5, 0.5)
        turn.makeTurn(game, "undo", 0.5, 0.5)
      }
      "have a left method with no need for tile" in {
        game.reset
        game.status.grid.tiles = Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0))
        game.left(0.5, 0.3)
        game.status.grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
        game.status.score.value should be(0)
      }
      "have a mergeSingleLine method with win" in {
        game.status.grid.tiles = Array(new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024))
        game.mergeSingleLine(game.status.grid.getSingleLine(1)) should be(Array(new Tile(2048), new Tile(2048), new Tile(0), new Tile(0)))
        game.status.win should be(true)
      }
    }
  }
}
