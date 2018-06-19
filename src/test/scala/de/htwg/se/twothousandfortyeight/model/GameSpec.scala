package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.game.Game
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class GameSpec extends WordSpec with Matchers {
  "A Game" when {
    "new" should {
      val game = new Game
      "have initial values" in {
        game.win should be(false)
        game.lose should be(false)
      }
      "have a reset method" in {
        game.win = true
        game.win should be(true)
        game.reset
        game.win should be(false)
      }
      "have a save method" in {
        game.win = true
        game.win should be(true)
        game.save("test.2048")
      }
      "have a load method" in {
        game.win = false
        game.win should be(false)
        game.load("test.2048")
      }
    }
  }
}
