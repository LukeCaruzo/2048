package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight

object Rotate {
  def rotate(game: Game): Game = {
    val newTiles = new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE)
    val oX = TwoThousandFortyEight.FIELD_SIZE - 1
    val oY = 0
    val angle = 90

    val radians = Math.toRadians(angle)
    val cos = Math.cos(radians).toInt
    val sin = Math.sin(radians).toInt

    for (x <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      for (y <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        val nX = (x * cos) - (y * sin) + oX
        val nY = (x * sin) + (y * cos) + oY
        newTiles(nX + nY * TwoThousandFortyEight.FIELD_SIZE) = Move.getPositionOfTile(game.grid, x, y)
      }
    }

    return new Game(newTiles, game.score)
  }
}
