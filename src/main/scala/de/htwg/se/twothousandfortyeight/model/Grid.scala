package de.htwg.se.twothousandfortyeight.model

import java.util

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight

case class Grid(random1: Double = Math.random(), random2: Double = Math.random(), random3: Double = Math.random(), random4: Double = Math.random()) {
  var tiles = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE)
  for (i <- tiles.indices) {
    tiles(i) = new Tile()
  }
  addTile(random1, random2)
  addTile(random3, random4)

  def addTile(random1: Double, random2: Double): Unit = {
    val availableSpace = getAvailableSpace()
    if (!availableSpace.isEmpty) {
      val emptyTile = availableSpace((random1 * availableSpace.length).asInstanceOf[Int] % availableSpace.length)
      emptyTile.value = if (random2 < 0.9) 2 else 4
    }
  }

  def getAvailableSpace(): Array[Tile] = {
    val tilesList = new util.ArrayList[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE)
    for (tile <- this.tiles) {
      if (tile.isEmpty) {
        tilesList.add(tile)
      }
    }

    val tilesArray = new Array[Tile](tilesList.size)
    for (i <- 0 until tilesList.size) {
      tilesArray(i) = tilesList.get(i)
    }

    return tilesArray
  }

  def isFull: Boolean = getAvailableSpace().length == 0

  def getPositionOfTile(x: Int, y: Int): Tile = tiles(x + y * TwoThousandFortyEight.FIELD_SIZE)

  def canBeMoved: Boolean = {
    if (!isFull) {
      return true
    }

    for (x <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      for (y <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        val tile = getPositionOfTile(x, y)
        if ((x < (TwoThousandFortyEight.FIELD_SIZE - 1) && tile.value == getPositionOfTile(x + 1, y).value) || ((y < (TwoThousandFortyEight.FIELD_SIZE - 1)) && tile.value == getPositionOfTile(x, y + 1).value)) {
          return true
        }
      }
    }

    return false
  }

  def rotate(angle: Int): Unit = {
    val newTiles = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE)
    var oX = TwoThousandFortyEight.FIELD_SIZE - 1
    var oY = TwoThousandFortyEight.FIELD_SIZE - 1

    if (angle == 90) {
      oY = 0
    } else if (angle == 270) {
      oX = 0
    }

    val radians = Math.toRadians(angle)
    val cos = Math.cos(radians).toInt
    val sin = Math.sin(radians).toInt

    for (x <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      for (y <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        val nX = (x * cos) - (y * sin) + oX
        val nY = (x * sin) + (y * cos) + oY
        newTiles(nX + nY * TwoThousandFortyEight.FIELD_SIZE) = getPositionOfTile(x, y)
      }
    }


    this.tiles = newTiles
  }

  def getSingleLine(index: Int): Array[Tile] = {
    val singleLine = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE)

    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      singleLine(i) = getPositionOfTile(i, index)
    }

    return singleLine
  }

  def setSingleLine(index: Int, re: Array[Tile]): Unit = {
    System.arraycopy(re, 0, tiles, index * TwoThousandFortyEight.FIELD_SIZE, TwoThousandFortyEight.FIELD_SIZE)
  }

  override def toString: String = {
    val sb = new StringBuilder

    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      val tiles = getSingleLine(i)
      for (j <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        sb.append(tiles(j))
      }

      if (i != (TwoThousandFortyEight.FIELD_SIZE - 1)) {
        sb.append(System.getProperty("line.separator"))
      }
    }

    return sb.toString
  }
}
