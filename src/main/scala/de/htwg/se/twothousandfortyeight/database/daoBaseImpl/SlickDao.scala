package de.htwg.se.twothousandfortyeight.database.daoBaseImpl

import de.htwg.se.twothousandfortyeight.database.DaoTrait
import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class SlickDao extends DaoTrait {
  private lazy val db = Database.forConfig("TwoThousandFortyEightDB")
  private lazy val gameConfigs = TableQuery[GameConfigTable]

  private def filterByIdQuery(id: Int): Query[GameConfigTable, GameConfig, Seq] = {
    gameConfigs.filter(f => f.id === id)
  }

  override def show: Future[Seq[Option[Int]]] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf) // creates database because it is stored in memory
    db.run(gameConfigs.result.map(_.map(f => f.id)))
  }

  override def create(gameConfig: GameConfig): Future[Int] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf) // creates database because it is stored in memory
    db.run(gameConfigs += gameConfig)
  }

  override def read(id: Int): Future[GameConfig] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf) // creates database because it is stored in memory
    db.run(filterByIdQuery(id).result.head)
  }

  override def update(id: Int, gameConfig: GameConfig): Future[Int] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf) // creates database because it is stored in memory
    db.run(filterByIdQuery(id).update(gameConfig))
  }

  override def delete(id: Int): Future[Int] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf) // creates database because it is stored in memory
    db.run(filterByIdQuery(id).delete)
  }
}
