package de.htwg.se.twothousandfortyeight.database

import de.htwg.se.twothousandfortyeight.database.daoBaseImpl.{GameConfig, MongoDbDao}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class MongoDbDaoSpec extends WordSpec with Matchers {
  "A MongoDbDao" when {
    "new" should {
      val game = new Game
      val fileIo = new FileIo
      val gameJson = fileIo.serialize(game)
      val mongoDbDao = new MongoDbDao

      "have a create method" in {
        mongoDbDao.create(new GameConfig(gameJson))
      }
      "have a read method" in {
        mongoDbDao.read(0)
      }
    }
  }
}
