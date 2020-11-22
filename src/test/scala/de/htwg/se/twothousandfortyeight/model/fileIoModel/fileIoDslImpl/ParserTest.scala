package de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoDslImpl

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Tile
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class ParserTest extends AnyWordSpec with Matchers {
  "A dsl" when {
    "parsed" should {
      "result in 16 tiles" in {
        val game =
          """(2)(0)(0)(0)
            |(0)(2)(0)(0)
            |(0)(0)(0)(0)
            |(0)(0)(0)(0)""".stripMargin

        val tiles = new Parser().parseDSL(game)
//        List[Tile] listOfTiles =  tiles.right;
//        listOfTiles should contain theSameElementsInOrderAs List(2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).map(b => new Tile(b))
      }
    }
  }
}
