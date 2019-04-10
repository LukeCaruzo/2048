package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight

case class Game(val grid: Array[Tile] = Move.addTile(Move.addTile(new Array[Tile](TwoThousandFortyEight.FIELD_SIZE * TwoThousandFortyEight.FIELD_SIZE).map(_ => new Tile()))),
           val score: Score = new Score)
