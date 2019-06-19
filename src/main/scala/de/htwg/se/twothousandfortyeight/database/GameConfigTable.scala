package de.htwg.se.twothousandfortyeight.database

import slick.jdbc.H2Profile.api._

case class GameConfig(game: String, id: Option[Int] = None)

class GameConfigTable(tag: Tag) extends Table[GameConfig](tag, "GAMECONFIGS") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def config = column[String]("CONFIG")

  def * = (config, id.?) <> (GameConfig.tupled, GameConfig.unapply)
}