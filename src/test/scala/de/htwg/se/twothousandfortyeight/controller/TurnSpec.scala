package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.{Grid, Score, Tile}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class TurnSpec extends WordSpec with Matchers {
  "A Turn" when {
    "used" should {
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
      "have a compareLines method" in {
        Turn.compareLines(grid.getSingleLine(1), grid.getSingleLine(1)) should be(true)
        Turn.compareLines(grid.getSingleLine(1), grid.getSingleLine(2)) should be(false)
        Turn.compareLines(grid.getSingleLine(1), Array(new Tile(2), new Tile(4), new Tile(0))) should be(false)
      }
      "have a makeTurn method" in {
        Turn.makeTurn("up", 0.4, 0.7)
        Turn.makeTurn("down", 0.4, 0.7)
        Turn.makeTurn("left", 0.4, 0.7)
        Turn.makeTurn("right", 0.4, 0.7)
        TwoThousandFortyEight.grid.tiles = Array(new Tile(2), new Tile(4), new Tile(8), new Tile(16), new Tile(32), new Tile(64), new Tile(128), new Tile(256), new Tile(512), new Tile(1024), new Tile(2048), new Tile(4096), new Tile(64), new Tile(32), new Tile(16), new Tile(1024))
        Turn.makeTurn("left", 0.4, 0.7)
        TwoThousandFortyEight.lose should be(true)
      }
      "have a left method with no need for tile" in {
        grid.tiles = Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0))
        Turn.left(grid, score, 0.5, 0.3)
        grid.tiles should be(Array(new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(2), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0), new Tile(0)))
        score.value should be(4)
      }
      "have a mergeSingleLine method with win" in {
        grid.tiles = Array(new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024), new Tile(1024))
        Turn.mergeSingleLine(score, grid.getSingleLine(1)) should be(Array(new Tile(2048), new Tile(2048), new Tile(0), new Tile(0)))
        TwoThousandFortyEight.win should be(true)
      }
    }
  }
}
