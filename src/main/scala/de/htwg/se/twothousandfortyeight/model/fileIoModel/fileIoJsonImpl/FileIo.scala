package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl

import java.io._

import com.google.gson.Gson
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
import scala.concurrent.ExecutionContext.Implicits.global

import scala.concurrent.Future
import scala.io.Source
import scala.util.{Failure, Success, Try}

class FileIo extends FileIoTrait {
  def save(filename: String, game: Game) {
    val file = new File(filename + ".json")
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write(serialize(game))
    bw.close()
  }

  def serialize(game: Game): String = {
    val gson = new Gson
    gson.toJson(game)
  }

  def load(filename: String): Future[Option[Game]] = {
    val data = Future {
      Try(Source.fromFile(filename + ".json").mkString) match {
        case Success(lines) => Some(deserialize(lines))
        case Failure(_) => None
      }
    }

    return data
  }

  def deserialize(json: String): Game = {
    val gson = new Gson
    gson.fromJson(json, classOf[Game])
  }
}
