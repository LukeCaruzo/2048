package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.game.Score

@RunWith(classOf[JUnitRunner])
class ScoreSpec extends WordSpec with Matchers {
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
