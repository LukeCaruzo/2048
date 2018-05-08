package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.{Grid, Score, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  "A Grid" when {
    "new" should {
      val grid = new Grid(0.3, 0.5, 0.7, 0.2)
      val score = new Score
      "have a left method" in {
        Turn.left(grid, score, 0.5, 0.3)
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
        score.value should be(0)
      }
      "have a right method" in {
        Turn.right(grid, score, 0.2, 0.9)
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(4), new Tile(0), new Tile(4), new Tile(0), new Tile(0)))
        score.value should be(4)
      }
      "have a down method" in {
        Turn.down(grid, score, 0.7, 0.4)
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(4), new Tile(0), new Tile(4)))
        score.value should be(4)
      }
      "have a up method" in {
        Turn.up(grid, score, 0.8, 0.1)
        grid.tiles should be(Array(new Tile(0), new Tile(4), new Tile(2), new Tile(2), new Tile(2), new Tile(0), new Tile(0), new Tile(4), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
        score.value should be(4)
      }
      "have a moveSingleLine method" in {
        Turn.moveSingleLine(grid.getSingleLine(1)) should be(Array(new Tile(2), new Tile(4), new Tile(0), new Tile(0)))
      }
      "have a mergeSingleLine method" in {
        Turn.mergeSingleLine(score, grid.getSingleLine(1)) should be(Array(new Tile(2), new Tile(0), new Tile(0), new Tile(0)))
      }
    }
  }
}
