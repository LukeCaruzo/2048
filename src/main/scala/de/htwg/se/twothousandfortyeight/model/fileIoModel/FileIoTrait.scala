package de.htwg.se.twothousandfortyeight.model.fileIoModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

trait FileIoTrait {
  def save(filename: String, game: Game): Unit

  def serialize(game: Game): String

  def load(filename: String): Option[Game]

  def deserialize(text: String): Game
}
