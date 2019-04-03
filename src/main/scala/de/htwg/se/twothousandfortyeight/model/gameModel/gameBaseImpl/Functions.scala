package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight

object Functions {
  def reset: Game = {
    return new Game()
  }

  def toString(game: Game): String = {
    val sb = new StringBuilder

    for (i <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      val tiles = Move.getSingleLine(game, i).grid
      for (j <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        sb.append("(" + tiles(j) + ")")
      }

      if (i != (TwoThousandFortyEight.FIELD_SIZE - 1)) {
        sb.append(System.getProperty("line.separator"))
      }
    }

    return sb.toString
  }
}
