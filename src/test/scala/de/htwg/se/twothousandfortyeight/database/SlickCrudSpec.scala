package de.htwg.se.twothousandfortyeight.database

import de.htwg.se.twothousandfortyeight.database.slick.SlickDao
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class SlickCrudSpec extends WordSpec with Matchers {
  "A SlickCrud" when {
    "new" should {
      val game = new Game()

      val slickDao = new SlickDao

      slickDao.buildTables(game)

      "have a create method" in {

      }
    }
  }
}
