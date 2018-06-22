package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoXmlImpl

import java.io._

import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

import scala.io.Source
import scala.xml.XML

class FileIo extends FileIoTrait {
  def save(filename: String, game: GameTrait): Unit = {
    val file = new File(filename + ".xml")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(game.toXml.toString)
    bw.close()
  }

  def load(filename: String, game: GameTrait): Unit = {
    val source = Source.fromFile(filename + ".xml")
    val lines = try source.mkString finally source.close()

    game.fromXml(XML.loadString(lines))
  }
}
