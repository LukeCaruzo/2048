package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Score
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ScoreSpec extends AnyWordSpec with Matchers {
  "Score" when {
    "new" should {
      val score = new Score(100)
      "have a initial value" in {
        score.value should be(100)
      }
      "have a nice String representation" in {
        score.toString should be("100")
      }
    }
  }
}
