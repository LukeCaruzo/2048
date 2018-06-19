package de.htwg.se.twothousandfortyeight.model.game

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
import java.util

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.GameTrait

class Game extends GameTrait {
  var win = false
  var lose = false
  var score = new Score
  var grid = new Grid

  def reset: Unit = {
    win = false
    lose = false
    score = new Score
    grid = new Grid
  }

  def save(filename: String): Unit = {
    val oos = new ObjectOutputStream(new FileOutputStream(filename))
    oos.writeObject(this)
    oos.close
  }

  def load(filename: String): Unit = {
    val ois = new ObjectInputStream(new FileInputStream(filename))
    val game = ois.readObject.asInstanceOf[Game]

    this.win = game.win
    this.lose = game.lose
    this.score = game.score
    this.grid = game.grid

    ois.close
  }

  def left(random1: Double, random2: Double): Unit = {
    var needsATile = false

    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      val singleLine = this.grid.getSingleLine(i)
      val movedLine = moveSingleLine(singleLine)
      val mergedLine = mergeSingleLine(movedLine)
      this.grid.setSingleLine(i, mergedLine)

      if (!needsATile && !compareLines(singleLine, mergedLine)) {
        needsATile = true
      }
    }

    if (needsATile) {
      this.grid.addTile(random1, random2)
    }
  }

  def right(random1: Double, random2: Double): Unit = {
    this.grid.rotate(180)
    left(random1, random2)
    this.grid.rotate(180)
  }

  def up(random1: Double, random2: Double): Unit = {
    this.grid.rotate(270)
    left(random1, random2)
    this.grid.rotate(90)
  }

  def down(random1: Double, random2: Double): Unit = {
    this.grid.rotate(90)
    left(random1, random2)
    this.grid.rotate(270)
  }

  def moveSingleLine(oldLine: Array[Tile]): Array[Tile] = {
    val helperList = new util.LinkedList[Tile]
    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      if (!oldLine(i).isEmpty) {
        helperList.addLast(oldLine(i))
      }
    }

    if (helperList.size() == 0) {
      return oldLine
    } else {
      val newLine = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE)

      while (helperList.size != TwoThousandFortyEight.FIELD_SIZE) {
        helperList.add(new Tile())
      }

      for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        newLine(i) = helperList.removeFirst()
      }

      return newLine
    }
  }

  def mergeSingleLine(oldLine: Array[Tile]): Array[Tile] = {
    val helperList = new util.LinkedList[Tile]

    var i = 0
    while (i < TwoThousandFortyEight.FIELD_SIZE && !oldLine(i).isEmpty) {
      var oldValue = oldLine(i).value
      if (i < (TwoThousandFortyEight.FIELD_SIZE - 1) && oldLine(i).value == oldLine(i + 1).value) {
        oldValue *= 2
        this.score.value += oldValue

        if (oldValue == 2048) {
          this.win = true
        }

        i = i + 1
      }

      helperList.add(new Tile(oldValue))
      i = i + 1
    }

    if (helperList.size() == 0) {
      return oldLine
    } else {
      while (helperList.size != TwoThousandFortyEight.FIELD_SIZE) {
        helperList.add(new Tile())
      }

      return helperList.toArray(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE))
    }
  }

  def compareLines(line1: Array[Tile], line2: Array[Tile]): Boolean = {
    if (line1 == line2) {
      return true
    } else if (line1.length != line2.length) {
      return false
    }

    for (i <- line1.indices) {
      if (line1(i).value != line2(i).value) {
        return false
      }
    }

    return true
  }
}
