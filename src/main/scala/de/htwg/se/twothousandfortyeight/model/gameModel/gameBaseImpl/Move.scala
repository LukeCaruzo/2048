package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

import java.util.{ArrayList, LinkedList}

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight

object Move {
  def addTile(tiles: Array[Tile]): Array[Tile] = {
    val emptyIndices = new ArrayList[Int]
    for (i <- 0 until tiles.size) {
      if (tiles(i).isEmpty) {
        emptyIndices.add(i)
      }
    }

    if (!emptyIndices.isEmpty) {
      val emptyTileValue = if (Math.random() < 0.9) 2 else 4
      tiles(emptyIndices.get((Math.random() * emptyIndices.size()).asInstanceOf[Int] % emptyIndices.size())) = new Tile(emptyTileValue)
    }

    return tiles
  }

  def left(game: Game): Game = {
    var needsATile = false
    var gameNew = new Game
    val scoreOld = game.score.value

    var score = 0
    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      val singleLine = getSingleLine(game, i)
      val mergedLine = mergeSingleLine(moveSingleLine(new Game(singleLine.grid, new Score)))

      System.arraycopy(mergedLine.grid, 0, game.grid, i * TwoThousandFortyEight.FIELD_SIZE, TwoThousandFortyEight.FIELD_SIZE)

      score = score + mergedLine.score.value

      if (!needsATile && !compareLines(singleLine.grid, mergedLine.grid)) {
        needsATile = true
      }
    }

    gameNew = new Game(game.grid, new Score(score + scoreOld))

    if (needsATile) {
      gameNew = new Game(addTile(gameNew.grid), gameNew.score)
    }

    return gameNew
  }

  def right(game: Game): Game = {
    return Rotate.rotate(left(Rotate.rotate(game, 180)), 180)
  }

  def up(game: Game): Game = {
    return Rotate.rotate(left(Rotate.rotate(game, 270)), 90)
  }

  def down(game: Game): Game = {
    return Rotate.rotate(left(Rotate.rotate(game,90)), 270)
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

  def moveSingleLine(game: Game): Game = {
    val oldLine = game.grid
    val helperList = new LinkedList[Tile]
    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      if (!oldLine(i).isEmpty) {
        helperList.addLast(oldLine(i))
      }
    }

    if (helperList.size() == 0) {
      return new Game(oldLine, game.score)
    } else {
      val newLine = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE)

      while (helperList.size != TwoThousandFortyEight.FIELD_SIZE) {
        helperList.add(new Tile())
      }

      for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        newLine(i) = helperList.removeFirst()
      }

      return new Game(newLine, game.score)
    }
  }

  def mergeSingleLine(game: Game): Game = {
    val oldLine = game.grid
    val helperList = new LinkedList[Tile]
    var scoreNew = game.score

    var i = 0
    while (i < TwoThousandFortyEight.FIELD_SIZE && !oldLine(i).isEmpty) {
      var oldValue = oldLine(i).value
      if (i < (TwoThousandFortyEight.FIELD_SIZE - 1) && oldLine(i).value == oldLine(i + 1).value) {
        oldValue *= 2
        //println(game.score.value + " + " + oldValue)
        scoreNew = new Score(game.score.value + oldValue)

        i = i + 1
      }

      helperList.add(new Tile(oldValue))
      i = i + 1
    }

    if (helperList.size() == 0) {
      return new Game(oldLine, scoreNew)
    } else {
      while (helperList.size != TwoThousandFortyEight.FIELD_SIZE) {
        helperList.add(new Tile())
      }

      return new Game(helperList.toArray(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE)), scoreNew)
    }
  }

  def getSingleLine(game: Game, index: Int): Game = {
    val singleLine = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE)

    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      singleLine(i) = getPositionOfTile(game.grid, i, index)
    }

    return new Game(singleLine, game.score)
  }



  def getPositionOfTile(tiles: Array[Tile], x: Int, y: Int): Tile = {
    return tiles(x + y * TwoThousandFortyEight.FIELD_SIZE)
  }

  def canBeMoved(tiles: Array[Tile]): Boolean = {
    if (!isFull(tiles)) {
      return true
    }

    for (x <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      for (y <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        val tile = getPositionOfTile(tiles, x, y)
        if ((x < (TwoThousandFortyEight.FIELD_SIZE - 1) && tile.value == getPositionOfTile(tiles, x + 1, y).value) ||
          ((y < (TwoThousandFortyEight.FIELD_SIZE - 1)) && tile.value == getPositionOfTile(tiles, x, y + 1).value)) {
          return true
        }
      }
    }

    return false
  }

  def isFull(tiles: Array[Tile]): Boolean = {
    tiles.foreach(tile => if (tile.isEmpty) return false)

    return true
  }

}
