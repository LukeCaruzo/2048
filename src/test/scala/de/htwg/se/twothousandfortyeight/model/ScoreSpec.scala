package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Score
import org.scalatest.wordspec.AnyWordSpec

class ScoreSpec extends AnyWordSpec {
  "Score" when {
    "new" should {
      val score = Score(100)
      "have a initial value" in {
        score.value === 100
      }
      "have a nice String representation" in {
        score.toString.equals("100")
      }
    }
  }
}
