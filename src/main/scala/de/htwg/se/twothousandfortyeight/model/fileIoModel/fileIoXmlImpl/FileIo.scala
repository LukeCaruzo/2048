package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoXmlImpl

import java.io._

import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{GameStatus, Grid, Score, Tile}

import scala.io.Source
import scala.xml.{Elem, XML}

class FileIo extends FileIoTrait {
  def save(filename: String, game: GameStatus): Unit = {
    val file = new File(filename + ".xml")
    val bw = new BufferedWriter(new FileWriter(file))
    bw.write(toXml(game).toString)
    bw.close()
  }

  def load(filename: String, game: GameStatus): Unit = {
    val source = Source.fromFile(filename + ".xml")
    val lines = try source.mkString finally source.close()

    fromXml(XML.loadString(lines), game)
  }

  def toXml(game: GameStatus): Elem = {
    return <game>
      <score>{game.score.value}</score>
      <grid>{serializeTiles(game.grid.tiles)}</grid>
    </game>
  }

  def serializeTiles(tiles: Array[Tile]): String = {
    val sb = new StringBuilder

    for (i <- tiles.indices) {
      sb.append(tiles(i).value)
      if (i != (tiles.length - 1)) {
        sb.append(",")
      }
    }

    return sb.toString
  }

  def fromXml(node: scala.xml.Node, game: GameStatus): Unit = {
    val scoreObj = new Score()
    scoreObj.value = (node \ "score").text.toInt

    val gridObj = new Grid
    gridObj.tiles = deserializeTiles((node \ "grid").text)

    game.score = scoreObj
    game.grid = gridObj
  }

  def deserializeTiles(tiles: String): Array[Tile] = {
    val splitTiles = tiles.split(",")

    val tempTilesArray = new Array[Tile](splitTiles.length)
    for (i <- splitTiles.indices) {
      tempTilesArray(i) = new Tile()
      tempTilesArray(i).value = splitTiles(i).toInt
    }

    return tempTilesArray
  }
}
