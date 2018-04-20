package de.htwg.se.twothousandfortyeight.model

import java.util

case class Grid() {
  var tiles = new Array[Tile](16)

  def addTile(): Unit = {
    val list = getAvailableSpace
    if (!getAvailableSpace.isEmpty) {
      val emptyTile = list.get((Math.random * list.size).asInstanceOf[Int] % list.size)
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

  def positionOfTile(x: Int, y: Int) {
    return tiles(x + y * 4)
  }

  def resetGrid {
    tiles = new Array[Tile](16)(new Tile)
    addTile
    addTile
  }
}
