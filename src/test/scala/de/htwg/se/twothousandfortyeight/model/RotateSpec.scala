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
        Rotate.rotate(new Game, 90).get.grid.length should be(16)
        Rotate.rotate(new Game, 180).get.grid.length should be(16)
        Rotate.rotate(new Game, 270).get.grid.length should be(16)

        Rotate.rotate(new Game, 100) should be(None)
      }
    }
  }
}
