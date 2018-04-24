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
    tiles = new Array[Tile](16)(new Tile)
    addTile
    addTile
  }

  def left(): Unit = {
    var needAddTile = false
    for (i <- 0 to 3) {
      val line = getLine(i)
      val merged = mergeLine(moveLine(line))
      setLine(i, merged)
      if (!needAddTile && !compare(line, merged)) {
        needAddTile = true
      }
    }

    if (needAddTile) {
      addTile
    }
  }

  def right(): Unit = {
    tiles = rotate(180)
    left()
    tiles = rotate(180)
  }

  def up(): Unit = {
    tiles = rotate(270)
    left()
    tiles = rotate(90)
  }

  def down(): Unit = {
    tiles = rotate(90)
    left()
    tiles = rotate(270)
  }

  def canMove: Boolean = {
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

  def compare(line1: Array[Tile], line2: Array[Tile]): Boolean = {
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

  def rotate(angle: Int): Array[Tile] = {
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
        newTiles(newX + newY * 4) = positionOfTile(x, y)
      }
    }

    return newTiles
  }

  def moveLine(oldLine: Array[Tile]): Array[Tile] = {
    var list = new util.LinkedList[Tile]
    for (i <- 0 to 3) {
      if (!oldLine(i).isEmpty) {
        list.addLast(oldLine(i))
      }
    }

    if (list.size() == 0) {
      return oldLine
    } else {
      val newLine = new Array[Tile](4)

      ensureSize(list, 4)

      for (i <- 0 to 3) {
        newLine(i) = list.removeFirst()
      }

      return newLine
    }
  }

  def ensureSize(list: util.List[Tile], s: Int): Unit = {
    while (list.size != s) {
      list.add(new Tile)
    }
  }

  def mergeLine(oldLine: Array[Tile]): Array[Tile] = {
    var list = new util.LinkedList[Tile]

    var i = 0
    while (i < 4 && !oldLine(i).isEmpty) {

      var num = oldLine(i).value

      if (i < 3 && oldLine(i).value == oldLine(i + 1).value) {
        num *= 2
        // SET SCORE (in main game): score += num
        var goal = 2048
        if (num == goal) {
          //SET WIN (in main game): win = true
        }

        i = i + 1
      }

      list.add(new Tile(num))
    }

    if (list.size() == 0) {
      return oldLine
    } else {
      ensureSize(list, 4)
      return list.toArray(new Array[Tile](4))
    }
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
}
