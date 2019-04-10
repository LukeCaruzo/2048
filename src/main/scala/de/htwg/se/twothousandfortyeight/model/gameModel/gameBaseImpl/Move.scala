package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

import java.util.ArrayList

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight

object Move {
  def addTile(tiles: Array[Tile]): Array[Tile] = {
    val newTiles = tiles
    val emptyIndices = new ArrayList[Int]

    for (i <- newTiles.indices) {
      if (newTiles(i).isEmpty) {
        emptyIndices.add(i)
      }
    }

    if (!emptyIndices.isEmpty) {
      val emptyTileValue = if (Math.random() < 0.9) 2 else 4
      newTiles(emptyIndices.get((Math.random() * emptyIndices.size()).asInstanceOf[Int] % emptyIndices.size())) = new Tile(emptyTileValue)
    }

    return newTiles
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
