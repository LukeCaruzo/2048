package de.htwg.se.twothousandfortyeight.model.fileIoModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.GameStatus

trait FileIoTrait {
  def save(filename: String, game: GameStatus)

  def load(filename: String, game: GameStatus)
}
