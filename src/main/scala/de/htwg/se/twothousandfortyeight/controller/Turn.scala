package de.htwg.se.twothousandfortyeight.controller

import java.util

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.{Game, Tile}

object Turn {
  def left(game: Game, random1: Double, random2: Double): Unit = {
    var needsATile = false

    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      val singleLine = game.grid.getSingleLine(i)
      val movedLine = moveSingleLine(singleLine)
      val mergedLine = mergeSingleLine(game, movedLine)
      game.grid.setSingleLine(i, mergedLine)

      if (!needsATile && !compareLines(singleLine, mergedLine)) {
        needsATile = true
      }
    }

    if (needsATile) {
      game.grid.addTile(random1, random2)
    }
  }

  def right(game: Game, random1: Double, random2: Double): Unit = {
    game.grid.rotate(180)
    left(game, random1, random2)
    game.grid.rotate(180)
  }

  def up(game: Game, random1: Double, random2: Double): Unit = {
    game.grid.rotate(270)
    left(game, random1, random2)
    game.grid.rotate(90)
  }

  def down(game: Game, random1: Double, random2: Double): Unit = {
    game.grid.rotate(90)
    left(game, random1, random2)
    game.grid.rotate(270)
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

  def mergeSingleLine(game: Game, oldLine: Array[Tile]): Array[Tile] = {
    val helperList = new util.LinkedList[Tile]

    var i = 0
    while (i < TwoThousandFortyEight.FIELD_SIZE && !oldLine(i).isEmpty) {
      var oldValue = oldLine(i).value
      if (i < (TwoThousandFortyEight.FIELD_SIZE - 1) && oldLine(i).value == oldLine(i + 1).value) {
        oldValue *= 2
        game.score.value += oldValue

        if (oldValue == 2048) {
          game.win = true
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

  def makeTurn(game: Game, key: String, random1: Double, random2: Double): Unit = {
    runSpecialMove(game, key)

    if (!game.grid.canBeMoved) {
      game.lose = true
    }

    if (!game.win && !game.lose) {
      runMove(game, key, random1, random2)
    }

    if (!game.win && !game.grid.canBeMoved) {
      game.lose = true
    }
  }

  def runSpecialMove(game: Game, key: String): Unit = {
    key match {
      case "undo" =>
        game.load("undo.2048")
      case "reset" =>
        game.reset
      case "save" =>
        game.save("save.2048")
      case "load" =>
        game.load("save.2048")
      case "exit" =>
        sys.exit()
      case _ =>
        game.save("undo.2048")
    }
  }

  def runMove(game: Game, key: String, random1: Double, random2: Double): Unit = {
    key match {
      case "left" =>
        left(game, random1, random2)
      case "right" =>
        right(game, random1, random2)
      case "down" =>
        down(game, random1, random2)
      case "up" =>
        up(game, random1, random2)
      case _ =>
    }
  }
}
