package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Functions, Game}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FunctionsSpec extends WordSpec with Matchers {
  "A Functions" when {
    "new" should {
      "have a reset method" in {
        Functions.reset.score.value should be(0)
        Functions.reset.grid.length should be(TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE)
      }
      "have a toString method" in {
        Functions.toString(new Game).length should be(51)
      }
    }
  }
}
