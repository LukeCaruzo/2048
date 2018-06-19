package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoXmlImpl

import java.io.{BufferedWriter, File, FileWriter}

import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

import scala.io.Source

class FileIo extends FileIoTrait {
  def save(filename: String, game: GameTrait): Unit = {
    val file = new File(filename + ".xml")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write("hello world")
    bw.close()
  }

  def load(filename: String, game: GameTrait): Unit = {
    val source = Source.fromFile(filename + ".xml")
    val lines = try source.mkString finally source.close()
    println(lines)
  }
}
