package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.Grid
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  "A Grid" when {
    "new" should {
      val grid = new Grid(0.3, 0.5, 0.7, 0.2)
      // TODO: Continue Tests
    }
}
