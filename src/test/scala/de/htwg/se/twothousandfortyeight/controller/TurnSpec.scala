package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  "A Turn" when {
    "used" should {
      val turn = new Turn

      "have a makeTurn method" in {
        turn.makeTurn('w')
        turn.makeTurn('s')
        turn.makeTurn('a')
        turn.makeTurn('d')
        turn.makeTurn('r')
        turn.makeTurn('z')
        turn.makeTurn('u')
        turn.makeTurn('q')

        val winArray = Array[Tile](new Tile(2), new Tile(1024), new Tile(1024), new Tile(2), new Tile(2), new Tile(2), new Tile(2), new Tile(2),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2),
          new Tile(2), new Tile(2), new Tile(2), new Tile(2))
        turn.game = new Game(winArray)
        turn.makeTurn('d')

        val loseArray = Array[Tile](
          new Tile(2), new Tile(4), new Tile(8), new Tile(16),
          new Tile(16), new Tile(8), new Tile(4), new Tile(2),
          new Tile(32), new Tile(64), new Tile(128), new Tile(256),
          new Tile(256), new Tile(128), new Tile(64), new Tile(32))
        turn.game = new Game(loseArray)
        turn.makeTurn('d')
      }
    }
  }
}
