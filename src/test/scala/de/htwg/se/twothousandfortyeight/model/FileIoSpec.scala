package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Functions, Score}
import org.junit.runner.RunWith
import org.scalatest.{Matchers, WordSpec}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class FileIoSpec extends WordSpec with Matchers {
  /*"FileIo" when {
    "new" should {
      val fileIoJson = new fileIoJsonImpl.FileIo

      val game = new Functions
      "have a save (json) " in {
        game.score.value = 0
        fileIoJson.save("test.2048", game)
      }
      "have a load (json) method" in {
        game.score.value = 5
        fileIoJson.load("test.2048", game)
        game.score.value should be(0)
      }
    }
  }*/
}

