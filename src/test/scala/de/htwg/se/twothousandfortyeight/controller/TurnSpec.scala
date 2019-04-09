package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  "A Turn" when {
    "used" should {
      val turn = new Turn

      "have a makeTurn method" in {
        turn.makeTurn("up")
        turn.makeTurn("down")
        turn.makeTurn("left")
        turn.makeTurn("right")
        turn.makeTurn("reset")
        turn.makeTurn("save")
        turn.makeTurn("load")
        turn.makeTurn("undo")
      }
    }
  }
}
