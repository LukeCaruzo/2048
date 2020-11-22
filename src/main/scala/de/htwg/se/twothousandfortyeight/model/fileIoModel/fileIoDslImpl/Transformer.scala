package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoDslImpl

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight.FIELD_SIZE
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Tile}

object Transformer {
  def apply(parseResult: Either[String, List[Tile]]): Either[String, Game] =
    for {
      parsed <- parseResult
      arrays <- transformToArrays(parsed)
    } yield {
      transformToGame(arrays)
    }

  def transformToArrays(tiles: List[Tile]): Either[String, Array[Tile]] = {
    if (tiles.size != FIELD_SIZE * FIELD_SIZE) {
      Left("not supported game size")
    } else {
      Right(tiles.toArray)
    }
  }

  def transformToGame(tiles: Array[Tile]): Game = Game(grid = tiles)
}

