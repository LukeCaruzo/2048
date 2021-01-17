package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoDslImpl

import java.nio.file.{Files, Paths}

import java.util

import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

import scala.io.Source
import scala.util.{Failure, Success, Try}

class DslFileIo extends FileIoTrait {
  override def save(filename: String, game: Game) {
    Files.write(Paths.get(filename + ".dsl"), util.Arrays.asList(serialize(game)))
  }

  override def serialize(game: Game): String = game.toString()

  override def load(filename: String): Option[Game] =
    Try(Source.fromFile(filename + ".dsl").mkString) match {
      case Success(lines) => Some(deserialize(lines))
      case Failure(_) => None
    }

  override def deserialize(text: String): Game = {
    val parser = new Parser()
    val parseResult = parser.parseDSL(text)
    val transformResult = Transformer.apply(parseResult)
    transformResult.getOrElse(Game())
  }
}
