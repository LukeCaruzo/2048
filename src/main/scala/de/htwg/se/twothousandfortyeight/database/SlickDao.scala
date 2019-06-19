package de.htwg.se.twothousandfortyeight.database

import slick.jdbc.H2Profile.api._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

class SlickDao {
  private lazy val db = Database.forConfig("TwoThousandFortyEightDB")
  private lazy val gameConfigs = TableQuery[GameConfigTable]

  private def filterByIdQuery(id: Int): Query[GameConfigTable, GameConfig, Seq] = {
    gameConfigs.filter(f => f.id === id)
  }

  def findAll: Future[Seq[Option[Int]]] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf)
    db.run(gameConfigs.result.map(_.map(f => f.id)))
  }

  def create(gameConfig: GameConfig): Future[Int] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf)
    db.run(gameConfigs += gameConfig)
  }

  def read(id: Int): Future[GameConfig] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf)
    db.run(filterByIdQuery(id).result.head)
  }

  def update(id: Int, gameConfig: GameConfig): Future[Int] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf)
    db.run(filterByIdQuery(id).update(gameConfig))
  }

  def delete(id: Int): Future[Int] = {
    Await.result(db.run(gameConfigs.schema.createIfNotExists), Duration.Inf)
    db.run(filterByIdQuery(id).delete)
  }
}
