package de.htwg.se.twothousandfortyeight.model

import java.util

case class Grid() {
  var tiles = new Array[Tile](16)

  def addTile(): Unit = {
    val list = getAvailableSpace
    if (!getAvailableSpace.isEmpty) {
      var emptyTile = list.get((Math.random * list.size).asInstanceOf[Int] % list.size)
      emptyTile.value = if (Math.random < 0.5) 2 else 4
    }
  }

  def getAvailableSpace: util.ArrayList[Tile] = {
    val list = new util.ArrayList[Tile](16)
    for (t <- tiles) {
      if (t.isEmpty) {
        list.add(t)
      }
    }
    return list
  }

  def isFull = getAvailableSpace.size == 0

  def positionOfTile(x: Int, y: Int): Tile = {
    return tiles(x + y * 4)
  }

  def resetGrid {
    tiles = new Array[Tile](16)
    for (i <- 0 until tiles.length) {
      tiles(i) = new Tile()
    }
    addTile
    addTile
  }

  def isTileMoveable: Boolean = {
    if (!isFull) {
      return true
    }

    for (x <- 0 to 3) {
      for (y <- 0 to 3) {
        var tile = positionOfTile(x, y)
        if ((x < 3 && (tile.value == positionOfTile(x + 1, y).value)) || ((y < 3) && (tile.value == positionOfTile(x, y + 1).value))) {
          return true
        }
      }
    }

    return false
  }

  def compareLines(line1: Array[Tile], line2: Array[Tile]): Boolean = {
    if (line1 == line2) {
      return true
    } else if (line1.length != line2.length) {
      return false
    }

    for (i <- 0 to line1.length) {
      if (line1(i).value != line2(i).value) {
        return false
      }
    }

    return true
  }

  def getLine(index: Int): Array[Tile] = {
    var result = new Array[Tile](4)
    for (i <- 0 to 3) {
      result(i) = positionOfTile(i, index)
    }

    return result
  }

  def setLine(index: Int, reset: Array[Tile]): Unit = {
    System.arraycopy(reset, 0, tiles, index * 4, 4)
  }

  def rotateGrid(angle: Int): Array[Tile] = {
    val newTiles = new Array[Tile](16)
    var x = 3
    var y = 3
    if (angle == 90) {
      y = 0
    } else if (angle == 270) {
      x = 0
    }

    val radians = Math.toRadians(angle)
    val cosOfRad = Math.cos(radians).toInt
    val sinOfRad = Math.sin(radians).toInt
    for (i <- 0 to 3) {
      for (j <- 0 to 3) {
        val newX = (x * cosOfRad) - (y * sinOfRad) + x
        val newY = (x * sinOfRad) + (y * cosOfRad) + y
        newTiles(newX + newY * 4) = this.positionOfTile(x, y)
      }
    }

    return newTiles
  }
}
