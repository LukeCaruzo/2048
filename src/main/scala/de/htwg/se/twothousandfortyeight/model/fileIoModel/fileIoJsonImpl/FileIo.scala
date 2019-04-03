package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl

import java.io._

import com.google.gson.Gson
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

import scala.io.Source

class FileIo extends FileIoTrait {
  def save(filename: String, game: GameTrait) {
    val file = new File(filename + ".json")
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write(serialize(game))
    bw.close()
  }

  def serialize(game: GameTrait): String = {
    val gson = new Gson
    return gson.toJson(game)
  }

  def load(filename: String, game: GameTrait) {
    val source = Source.fromFile(filename + ".json")
    val lines = try source.mkString finally source.close()

    val gameNew = deserialize(lines)

    game.score = gameNew.score
    game.grid = gameNew.grid
  }

  def deserialize(json: String): GameTrait = {
    val gson = new Gson
    return gson.fromJson(json, classOf[Game])
  }
}
