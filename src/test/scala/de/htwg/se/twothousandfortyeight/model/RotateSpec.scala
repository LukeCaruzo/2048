package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Rotate}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class RotateSpec extends WordSpec with Matchers {
  "A Rotate" when {
    "new" should {
      "have a rotate method" in {
        val game = new Game
        Rotate.rotate(game).grid should not be (game.grid)
        Rotate.rotate(Rotate.rotate(game)).grid should not be (game.grid)
        Rotate.rotate(Rotate.rotate(Rotate.rotate(game))).grid should not be (game.grid)
        Rotate.rotate(Rotate.rotate(Rotate.rotate(Rotate.rotate(game)))).grid should be(game.grid)
      }
    }
  }
}
