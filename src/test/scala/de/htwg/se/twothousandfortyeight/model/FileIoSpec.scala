package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.scalatest.wordspec.AnyWordSpec

class FileIoSpec extends AnyWordSpec {
  "FileIo" when {
    "new" should {
      val fileIoJson = new FileIo
      val game = new Game

      "have a save (json) " in {
        fileIoJson.save("test.2048", game)
      }
      /*"have a load (json) method" in {
        fileIoJson.load("test.2048").get.score.value should be(0)

        fileIoJson.load("test123.2048") should be(None)
      }*/
    }
  }
}

