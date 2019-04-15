package de.htwg.se.twothousandfortyeight.model.fileIoModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

import scala.concurrent.Future

trait FileIoTrait {
  def save(filename: String, game: Game): Unit

  def serialize(game: Game): String

  def load(filename: String): Future[Option[Game]]

  def deserialize(text: String): Game
}
