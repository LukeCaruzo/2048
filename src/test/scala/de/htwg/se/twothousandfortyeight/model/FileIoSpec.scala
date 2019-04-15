package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}
import scala.concurrent.ExecutionContext.Implicits.global

import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class FileIoSpec extends WordSpec with Matchers {
  "FileIo" when {
    "new" should {
      val fileIoJson = new FileIo
      var game = new Game

      "have a save (json) " in {
        fileIoJson.save("test.2048", game)
      }
      "have a load (json) method" in {
        fileIoJson.load("test.2048").onComplete {
          case Success(game) => game.get.score.value should be(0)
          case Failure(error) => error.printStackTrace()
        }

        fileIoJson.load("test123.2048").onComplete {
          case Success(game) => game.get.score.value should be(None)
          case Failure(error) => error.printStackTrace()
        }
      }
    }
  }
}

