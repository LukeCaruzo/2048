package de.htwg.se.twothousandfortyeight.model

import java.util

case class Grid(random1: Double = Math.random(), random2: Double = Math.random(), random3: Double = Math.random(), random4: Double = Math.random()) {
  var tiles = new Array[Tile](16)
  for (i <- 0 until tiles.length) {
    tiles(i) = new Tile()
  }
  addTile(random1, random2)
  addTile(random3, random4)

  def addTile(random1: Double, random2: Double): Unit = {
    val availableSpace = getAvailableSpace
    if (!availableSpace.isEmpty) {
      val emptyTile = availableSpace((random1 * availableSpace.length).asInstanceOf[Int] % availableSpace.length)
      emptyTile.value = if (random2 < 0.9) 2 else 4
    }
  }

  def getAvailableSpace(): Array[Tile] = {
    val tilesList = new util.ArrayList[Tile](16)
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

  def isFull: Boolean = getAvailableSpace.size == 0

  def getPositionOfTile(x: Int, y: Int): Tile = tiles(x + y * 4)

  def canBeMoved: Boolean = {
    if (!isFull) {
      return true
    }

    for (x <- 0 to 3) {
      for (y <- 0 to 3) {
        val tile = getPositionOfTile(x, y)
        if ((x < 3 && tile.value == getPositionOfTile(x + 1, y).value) || ((y < 3) && tile.value == getPositionOfTile(x, y + 1).value)) {
          return true
        }
      }
    }

    return false
  }

  def rotate(angle: Int): Array[Tile] = {
    val newTiles = new Array[Tile](16)
    var oX = 3
    var oY = 3

    if (angle == 90) {
      oY = 0
    } else if (angle == 270) {
      oX = 0
    }

    val radians = Math.toRadians(angle)
    val cos = Math.cos(radians).toInt
    val sin = Math.sin(radians).toInt

    for (x <- 0 to 3) {
      for (y <- 0 to 3) {
        val nX = (x * cos) - (y * sin) + oX
        val nY = (x * sin) + (y * cos) + oY
        newTiles(nX + nY * 4) = getPositionOfTile(x, y)
      }
    }

    return newTiles
  }

  def getSingleLine(index: Int): Array[Tile] = {
    val singleLine = new Array[Tile](4)

    for (i <- 0 to 3) {
      singleLine(i) = getPositionOfTile(i, index)
    }

    return singleLine
  }

  def setSingleLine(index: Int, re: Array[Tile]): Unit = {
    System.arraycopy(re, 0, tiles, index * 4, 4)
  }

  override def toString: String = {
    val sb = new StringBuilder

    for (i <- 0 to 3) {
      val tiles = getSingleLine(i)
      for (j <- 0 to 3) {
        sb.append(tiles(j))
      }

      if (i != 3) {
        sb.append(System.getProperty("line.separator"))
      }
    }

    return sb.toString
  }
}
