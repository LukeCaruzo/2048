package de.htwg.se.twothousandfortyeight.model.fileIoModel

import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

trait FileIoTrait {
  def save(filename: String, game: GameTrait)

  def serialize(game: GameTrait): String

  def load(filename: String, game: GameTrait)

  def deserialize(text: String): GameTrait
}
