package de.htwg.se.twothousandfortyeight.model.fileIoModel

import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

trait FileIoTrait {
  def save(filename: String, game: GameTrait)

  def load(filename: String, game: GameTrait)
}
