package de.htwg.se.twothousandfortyeight.database.dao

import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import slick.jdbc.H2Profile.api._

class GameDAO {
  def buildTables(game: GameTrait): Unit = {
    val db = Database.forConfig("TwoThousandFortyEightDB")

    try {
      class Game(tag: Tag) extends Table[(Int, Int)](tag, "Game") {
        def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

        def score= column[Int]("Score")

        def * = (id, score)
      }

      val gameTable = TableQuery[Game]

      class Grid(tag: Tag) extends Table[(Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int, Int)](tag,
        "Grid") {
        def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)

        def gameId = column[Int]("GameID")

        def game = foreignKey("MY_GAME", gameId, gameTable)(_.id)

        def tile1 = column[Int]("Tile1")
        def tile2 = column[Int]("Tile2")
        def tile3 = column[Int]("Tile3")
        def tile4 = column[Int]("Tile4")
        def tile5 = column[Int]("Tile5")
        def tile6 = column[Int]("Tile6")
        def tile7 = column[Int]("Tile7")
        def tile8 = column[Int]("Tile8")
        def tile9 = column[Int]("Tile9")
        def tile10 = column[Int]("Tile10")
        def tile11 = column[Int]("Tile11")
        def tile12 = column[Int]("Tile12")
        def tile13 = column[Int]("Tile13")
        def tile14 = column[Int]("Tile14")
        def tile15 = column[Int]("Tile15")
        def tile16 = column[Int]("Tile16")

        def * = (id, gameId, tile1, tile2, tile3, tile4, tile5, tile6, tile7, tile8, tile9, tile10, tile11, tile12, tile13, tile14, tile15, tile16)
      }

    } finally db.close
  }
}
