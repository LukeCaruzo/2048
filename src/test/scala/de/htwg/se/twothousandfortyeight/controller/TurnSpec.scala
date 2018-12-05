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
      game.grid = new Grid(0.3, 0.5, 0.7, 0.2)
      "have a makeTurn method" in {
        Turn.makeTurn(game, "up", 0.4, 0.7)
        Turn.makeTurn(game, "down", 0.4, 0.7)
        Turn.makeTurn(game, "left", 0.4, 0.7)
        Turn.makeTurn(game, "right", 0.4, 0.7)
        game.grid.tiles = Array(new Tile(2), new Tile(4), new Tile(8), new Tile(16), new Tile(32), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        Turn.makeTurn(game, "left", 0.4, 0.7)
        game.lose should be(true)
        Turn.makeTurn(game, "reset", 0.5, 0.5)
        game.lose should be(false)
        Turn.makeTurn(game, "save", 0.5, 0.5)
        Turn.makeTurn(game, "load", 0.5, 0.5)
        Turn.makeTurn(game, "undo", 0.5, 0.5)
      }
      "have a left method with no need for tile" in {
        game.reset
        game.grid.tiles = Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0))
        game.left(0.5, 0.3)
        game.grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
        game.score.value should be(0)
      }
      "have a mergeSingleLine method with win" in {
        game.grid.tiles = Array(new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024))
        game.mergeSingleLine(game.grid.getSingleLine(1)) should be(Array(new Tile(2048), new Tile(2048), new Tile(0), new Tile(0)))
        game.win should be(true)
      }
    }
  }
}
