package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoDslImpl

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Tile}

import scala.util.parsing.combinator.RegexParsers

class Parser extends RegexParsers {

  def parseDSL(input: String): Either[String, List[Tile]] = parsePartDsl(input, line)

  def parsePartDsl[T](input: String, parser: Parser[T]): Either[String, T] =
    parseAll(parser, input) match {
      case Success(t, _) => Right(t)
      case NoSuccess(msg, next) =>
        val pos = next.pos
        Left(s"[$pos] failed parsing: $msg\n\n${pos.longString})")
    }

  def line: Parser[List[Tile]] = rep(tile)

  def tile: Parser[Tile] = "(" ~ integer ~ ")" ^^ { case _ ~ value ~ _ => Tile(value) }

  def integer: Parser[Int] = """(0|[1-9]\d*)""".r ^^ (_.toInt)

}
