package de.htwg.se.twothousandfortyeight.controller

import java.util

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.{Grid, Score, Tile}

object Turn {
  def left(grid: Grid, score: Score, random1: Double, random2: Double): Unit = {
    var needsATile = false

    for (i <- 0 to 3) {
      val singleLine = grid.getSingleLine(i)
      val movedLine = moveSingleLine(singleLine)
      val mergedLine = mergeSingleLine(score, movedLine)
      grid.setSingleLine(i, mergedLine)

      if (!needsATile && !compareLines(singleLine, mergedLine)) {
        needsATile = true
      }
    }

    if (needsATile) {
      grid.addTile(random1, random2)
    }
  }

  def right(grid: Grid, score: Score, random1: Double, random2: Double): Unit = {
    grid.tiles = grid.rotate(180)
    left(grid, score, random1, random2)
    grid.tiles = grid.rotate(180)
  }

  def up(grid: Grid, score: Score, random1: Double, random2: Double): Unit = {
    grid.tiles = grid.rotate(270)
    left(grid, score, random1, random2)
    grid.tiles = grid.rotate(90)
  }

  def down(grid: Grid, score: Score, random1: Double, random2: Double): Unit = {
    grid.tiles = grid.rotate(90)
    left(grid, score, random1, random2)
    grid.tiles = grid.rotate(270)
  }

  def moveSingleLine(oldLine: Array[Tile]): Array[Tile] = {
    val helperList = new util.LinkedList[Tile]
    for (i <- 0 to 3) {
      if (!oldLine(i).isEmpty) {
        helperList.addLast(oldLine(i))
      }
    }

    if (helperList.size() == 0) {
      return oldLine
    } else {
      val newLine = new Array[Tile](4)

      while (helperList.size != 4) {
        helperList.add(new Tile())
      }

      for (i <- 0 to 3) {
        newLine(i) = helperList.removeFirst()
      }

      return newLine
    }
  }

  def mergeSingleLine(score: Score, oldLine: Array[Tile]): Array[Tile] = {
    val helperList = new util.LinkedList[Tile]

    var i = 0
    while (i < 4 && !oldLine(i).isEmpty) {
      var oldValue = oldLine(i).value
      if (i < 3 && oldLine(i).value == oldLine(i + 1).value) {
        oldValue *= 2
        score.value += oldValue

        if (oldValue == 2048) {
          TwoThousandFortyEight.win = true
        }

        i = i + 1
      }

      helperList.add(new Tile(oldValue))
      i = i + 1
    }

    if (helperList.size() == 0) {
      return oldLine
    } else {
      while (helperList.size != 4) {
        helperList.add(new Tile())
      }

      return helperList.toArray(new Array[Tile](4))
    }
  }

  def compareLines(line1: Array[Tile], line2: Array[Tile]): Boolean = {
    if (line1 == line2) {
      return true
    } else if (line1.length != line2.length) {
      return false
    }

    for (i <- 0 until line1.length) {
      if (line1(i).value != line2(i).value) {
        return false
      }
    }

    return true
  }

  def makeTurn(key: String, random1: Double, random2: Double): Unit = {
    if (!TwoThousandFortyEight.grid.canBeMoved) {
      TwoThousandFortyEight.lose = true
    }

    if (!TwoThousandFortyEight.win && !TwoThousandFortyEight.lose) {
      if (key == "a") {
        left(TwoThousandFortyEight.grid, TwoThousandFortyEight.score, random1, random2)
      } else if (key == "d") {
        right(TwoThousandFortyEight.grid, TwoThousandFortyEight.score, random1, random2)
      } else if (key == "s") {
        down(TwoThousandFortyEight.grid, TwoThousandFortyEight.score, random1, random2)
      } else if (key == "w") {
        up(TwoThousandFortyEight.grid, TwoThousandFortyEight.score, random1, random2)
      }
    }

    if (!TwoThousandFortyEight.win && !TwoThousandFortyEight.grid.canBeMoved) {
      TwoThousandFortyEight.lose = true
    }
  }
}
