package de.htwg.se.twothousandfortyeight.database

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SlickDaoSpec extends WordSpec with Matchers {
  "A SlickCrud" when {
    "new" should {
      val game = new Game
      val fileIo = new FileIo
      val gameJson = fileIo.serialize(game)
      val slickDao = new SlickDao

      "have a create method" in {
        slickDao.create(new GameConfig(gameJson))
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
  }
}
