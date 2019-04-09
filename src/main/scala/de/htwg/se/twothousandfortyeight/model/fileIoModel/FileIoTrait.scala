package de.htwg.se.twothousandfortyeight.model.fileIoModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

trait FileIoTrait {
  def save(filename: String, game: Game)

  def serialize(game: Game): String

  def load(filename: String): Game

  def deserialize(text: String): Game
}
