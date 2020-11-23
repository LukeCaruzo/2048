package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl.MoveActor
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers


class MoveActorSpec extends AnyWordSpec with Matchers {
  "A MoveActor" when {
    "new" should {
      val moveActor = new MoveActor("testActor")

      "have a printTui method" in {
        moveActor.printTui.length should be(65)
      }
      "have a printWin method" in {
        moveActor.printWin.length should be(74)
      }
      "have a printLose method" in {
        moveActor.printLose.length should be(75)
      }
      "have a printHelp method" in {
        moveActor.printHelp.length should be(222)
      }
    }
  }
}
