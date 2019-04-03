package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Score}
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FileIoSpec extends WordSpec with Matchers {
  "FileIo" when {
    "new" should {
      val fileIoJson = new fileIoJsonImpl.FileIo

      val game = new Game
      "have a save (json) " in {
        game.status.score.value = 0
        fileIoJson.save("test.2048", game)
      }
      "have a load (json) method" in {
        game.status.score.value = 5
        fileIoJson.load("test.2048", game)
        game.status.score.value should be(0)
      }
    }
  }
}

