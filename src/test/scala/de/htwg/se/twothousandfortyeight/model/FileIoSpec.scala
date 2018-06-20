package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl
import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoXmlImpl
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FileIoSpec extends WordSpec with Matchers {
  "FileIo" when {
    "new" should {
      val fileIoJson = new fileIoJsonImpl.FileIo
      val fileIoXml = new fileIoXmlImpl.FileIo

      val game = new Game
      "have a save (json) " in {
        game.win = true
        fileIoJson.save("test.2048", game)
      }
      "have a load (json) method" in {
        game.win = false
        fileIoJson.load("test.2048", game)
        game.win should be(true)
      }
      "have a save (xml) " in {
        game.win = true
        fileIoXml.save("test.2048", game)
      }
      "have a load (xml) method" in {
        game.win = false
        fileIoXml.load("test.2048", game)
        game.win should be(true)
      }
    }
  }
}

