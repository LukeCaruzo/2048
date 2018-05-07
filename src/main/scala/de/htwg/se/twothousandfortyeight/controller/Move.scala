package de.htwg.se.twothousandfortyeight.controller

import java.util

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.model.Tile
import de.htwg.se.twothousandfortyeight.model.Grid

case class Move() {
  def left(grid: Grid): Unit = {
    var needAddTile = false
    for (i <- 0 to 3) {
      val line = grid.getLine(i)
      val moved = moveLine(line)
      val merged = mergeLine(moved)
      grid.setLine(i, merged)

      if (!needAddTile && !grid.compareLines(line, merged)) {
        needAddTile = true
      }
    }

    if (needAddTile) {
      grid.addTile()
    }
  }

  def right(grid: Grid): Unit = {
    grid.tiles = grid.rotateGrid(180)
    left(grid)
    grid.tiles = grid.rotateGrid(180)
  }

  def up(grid: Grid): Unit = {
    grid.tiles = grid.rotateGrid(270)
    left(grid)
    grid.tiles = grid.rotateGrid(90)
  }

  def down(grid: Grid): Unit = {
    grid.tiles = grid.rotateGrid(90)
    left(grid)
    grid.tiles = grid.rotateGrid(270)
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

      while (list.size != 4) {
        list.add(new Tile())
      }

      for (i <- 0 to 3) {
        newLine(i) = list.removeFirst()
      }

      return newLine
    }
  }

  def mergeLine(oldLine: Array[Tile]): Array[Tile] = {
    var list = new util.LinkedList[Tile]

    var i = 0
    while (i < 4 && !oldLine(i).isEmpty) {

      var num = oldLine(i).value

      if (i < 3 && oldLine(i).value == oldLine(i + 1).value) {
        num *= 2
        TwoThousandFortyEight.score.value += num
        var goal = 2048
        if (num == goal) {
          TwoThousandFortyEight.win = true
        }

        i = i + 1
      }

      list.add(new Tile(num))
    }

    if (list.size() == 0) {
      return oldLine
    } else {
      while (list.size != 4) {
        list.add(new Tile())
      }

      return list.toArray(new Array[Tile](4))
    }
  }
}
