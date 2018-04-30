package de.htwg.se.twothousandfortyeight.model

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScoreSpec extends WordSpec with Matchers {
  "Score" when {
    "new" should {
      var score = new Score()
      "have a initial value" in {
        score.score should be(0)
      }
      score.resetScore()
      "should reset" in {
        score.score should be(0)
      }
    }
  }
}
