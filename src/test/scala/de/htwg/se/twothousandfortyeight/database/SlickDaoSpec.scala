package de.htwg.se.twothousandfortyeight.database

import de.htwg.se.twothousandfortyeight.database.daoBaseImpl.{GameConfig, SlickDao}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.scalatest.wordspec.AnyWordSpec

class SlickDaoSpec extends AnyWordSpec {
  /*"A SlickDao" when {
    "new" should {
      val game = new Game
      val fileIo = new FileIo
      val gameJson = fileIo.serialize(game)
      val slickDao = new SlickDao

      "have a create method" in {
        slickDao.create(new GameConfig(gameJson))
      }
      "have a show method" in {
        slickDao.show
      }
      "have a update method" in {
        slickDao.update(0, new GameConfig(gameJson))
      }
      "have a read method" in {
        slickDao.read(0)
      }
      "have a delete method" in {
        slickDao.delete(0)
      }
    }
  }*/
}
