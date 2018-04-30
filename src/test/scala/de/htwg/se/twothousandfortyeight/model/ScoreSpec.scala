package de.htwg.se.twothousandfortyeight.model

import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScoreSpec extends WordSpec with Matchers {
  "Score" when {
    "new" should {
      var score = new Score(100)
      "have a initial value" in {
        score.value should be(100)
      }
      "reset" in {
        score.resetScore()
        score.value should be(0)
      }
    }
  }
}
