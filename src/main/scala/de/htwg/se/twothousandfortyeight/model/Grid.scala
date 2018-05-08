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
    val list = getAvailableSpace
    if (!getAvailableSpace.isEmpty) {
      val index = (random1 * list.size).asInstanceOf[Int] % list.size
      val emptyTile = list(index)
      emptyTile.value = if (random2 < 0.9) 2 else 4
    }
  }

  def getAvailableSpace(): Array[Tile] = {
    val list = new util.ArrayList[Tile](16)
    for (t <- this.tiles) {
      if (t.isEmpty) {
        list.add(t)
      }
    }

    val array = new Array[Tile](list.size)
    for (i <- 0 until list.size) {
      array(i) = list.get(i)
    }

    return array
  }

  def isFull: Boolean = getAvailableSpace.size == 0

  def getPositionOfTile(x: Int, y: Int): Tile = tiles(x + y * 4)

  def canBeMoved: Boolean = {
    if (!isFull) {
      return true
    }

    for (x <- 0 to 3) {
      for (y <- 0 to 3) {
        var tile = getPositionOfTile(x, y)
        if ((x < 3 && tile.value == getPositionOfTile(x + 1, y).value) || ((y < 3) && tile.value == getPositionOfTile(x, y + 1).value)) {
          return true
        }
      }
    }

    return false
  }

  def rotate(angle: Int): Array[Tile] = {
    val newTiles = new Array[Tile](16)
    var offsetX = 3
    var offsetY = 3

    if (angle == 90) {
      offsetY = 0
    } else if (angle == 270) {
      offsetX = 0
    }

    val rad = Math.toRadians(angle)
    val cos = Math.cos(rad).toInt
    val sin = Math.sin(rad).toInt

    for (x <- 0 to 3) {
      for (y <- 0 to 3) {
        val newX = (x * cos) - (y * sin) + offsetX
        val newY = (x * sin) + (y * cos) + offsetY
        newTiles(newX + newY * 4) = getPositionOfTile(x, y)
      }
    }

    return newTiles
  }

  def getSingleLine(index: Int): Array[Tile] = {
    val result = new Array[Tile](4)

    for (i <- 0 to 3) {
      result(i) = getPositionOfTile(i, index)
    }

    return result
  }

  def setSingleLine(index: Int, re: Array[Tile]): Unit = {
    System.arraycopy(re, 0, tiles, index * 4, 4)
  }

  override def toString: String = {
    val s = new StringBuilder

    for (i <- 0 to 3) {
      val tiles = getSingleLine(i)
      for (j <- 0 to 3) {
        s.append(tiles(j))
      }

      if (i != 3) {
        s.append(System.getProperty("line.separator"))
      }
    }

    return s.toString
  }
}
