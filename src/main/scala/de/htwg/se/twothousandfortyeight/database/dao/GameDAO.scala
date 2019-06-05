package de.htwg.se.twothousandfortyeight.database.dao

import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import slick.jdbc.H2Profile.api._

class GameDAO {
  def buildTables(game: GameTrait): Unit = {
    val db = Database.forConfig("TwoThousandFortyEightDB")


  }
}
