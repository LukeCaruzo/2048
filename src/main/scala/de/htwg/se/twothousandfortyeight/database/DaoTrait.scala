package de.htwg.se.twothousandfortyeight.database

import de.htwg.se.twothousandfortyeight.database.daoBaseImpl.GameConfig

import scala.concurrent.Future

trait DaoTrait {
  def show: Future[Seq[Option[Int]]]

  def create(gameConfig: GameConfig): Future[Int]

  def read(id: Int): Future[GameConfig]

  def update(id: Int, gameConfig: GameConfig): Future[Int]

  def delete(id: Int): Future[Int]
}
