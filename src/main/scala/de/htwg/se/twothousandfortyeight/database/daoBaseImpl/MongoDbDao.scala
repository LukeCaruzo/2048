package de.htwg.se.twothousandfortyeight.database.daoBaseImpl

import de.htwg.se.twothousandfortyeight.database.DaoTrait

import scala.concurrent.Future

class MongoDbDao extends DaoTrait{
  override def show: Future[Seq[Option[Int]]] = ???

  override def create(gameConfig: GameConfig): Future[Int] = ???

  override def read(id: Int): Future[GameConfig] = ???

  override def update(id: Int, gameConfig: GameConfig): Future[Int] = ???

  override def delete(id: Int): Future[Int] = ???
}
