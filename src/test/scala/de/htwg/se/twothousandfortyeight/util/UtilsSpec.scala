package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.TurnResult.{HELP, TURN_FINISHED}
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class UtilsSpec extends AnyWordSpec with Matchers {
  "A Util" when {
    "used" should {
      "have a processAction method" in {
        val turn = new Turn

        Utils.processAction(turn, "left") should be(TURN_FINISHED)
        Utils.processAction(turn, "right") should be(TURN_FINISHED)
        Utils.processAction(turn, "down") should be(TURN_FINISHED)
        Utils.processAction(turn, "up") should be(TURN_FINISHED)
        Utils.processAction(turn, "undo") should be(TURN_FINISHED)
        Utils.processAction(turn, "reset") should be(TURN_FINISHED)
        Utils.processAction(turn, "save") should be(TURN_FINISHED)
        Utils.processAction(turn, "load") should be(TURN_FINISHED)
        Utils.processAction(turn, "help") should be(HELP)
        Utils.processAction(turn, "blank") should be(TURN_FINISHED)
      }
      "have a help method" in {
        val help =
          """----------------HELP----------------
            || W - up    | Q - undo | R - reset |
            || A - left  | Z - save | T - exit  |
            || S - down  | U - load |           |
            || D - right |          |           |
            |------------------------------------
            |"""
            .stripMargin

        Utils.help should be(help)
      }
    }
  }
}
