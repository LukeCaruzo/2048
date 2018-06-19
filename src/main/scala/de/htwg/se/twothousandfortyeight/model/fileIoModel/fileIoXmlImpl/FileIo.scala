package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoXmlImpl

import java.io._

import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

import scala.io.Source

class FileIo extends FileIoTrait {
  def save(filename: String, game: GameTrait): Unit = {
    val file = new File(filename + ".xml")
    val bw = new BufferedWriter(new FileWriter(file))

    bw.write("")
    bw.close()
  }

  def load(filename: String, game: GameTrait): Unit = {
    val source = Source.fromFile(filename + ".xml")
    val lines = try source.mkString finally source.close()

    val xmlGame = new Game

    game.win = xmlGame.win
    game.lose = xmlGame.lose
    game.score = xmlGame.score
    game.grid = xmlGame.grid
  }
}
