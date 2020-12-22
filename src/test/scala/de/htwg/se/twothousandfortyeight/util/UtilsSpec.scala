package de.htwg.se.twothousandfortyeight.util

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class UtilsSpec extends AnyWordSpec with Matchers {
  "A Util" when {
    "used" should {
      "have a processAction method" in {
        val turn = new Turn

        Utils.processAction(turn, "left") should be(0)
        Utils.processAction(turn, "right") should be(0)
        Utils.processAction(turn, "down") should be(0)
        Utils.processAction(turn, "up") should be(0)
        Utils.processAction(turn, "undo") should be(0)
        Utils.processAction(turn, "reset") should be(0)
        Utils.processAction(turn, "save") should be(0)
        Utils.processAction(turn, "load") should be(0)
        Utils.processAction(turn, "help") should be(3)
        Utils.processAction(turn, "blank") should be(0)
      }
      "have a help method" in {
        val newline = "\n"
        val sb = new StringBuilder

        sb.append("----------------HELP----------------" + newline)
        sb.append("| W - up    | Q - undo | R - reset |" + newline)
        sb.append("| A - left  | Z - save | T - exit  |" + newline)
        sb.append("| S - down  | U - load |           |" + newline)
        sb.append("| D - right |          |           |" + newline)
        sb.append("------------------------------------" + newline)

        Utils.help should be(sb.toString)
      }
    }
  }
}
