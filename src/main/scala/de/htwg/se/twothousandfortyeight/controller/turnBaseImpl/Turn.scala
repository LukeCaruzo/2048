package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.{TwoThousandFortyEight, TwoThousandFortyEightModule}
import de.htwg.se.twothousandfortyeight.controller.{GameLost, GameWon, TurnMade, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Functions, Game, Move, Score, Tile}
import net.codingwell.scalaguice.InjectorExtensions._

import scala.swing.Publisher

@Inject
class Turn extends TurnTrait with Publisher {
  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]

  var game = new Game

  def makeTurn(key: String) {
    runSpecialMove(key)

    runMove(key)

    if(game.grid contains new Tile(2048)) {
      publish(new GameWon)
    } else if (!Move.canBeMoved(game.grid)) {
      publish(new GameLost)
    } else {
      publish(new TurnMade)
    }
  }

  def runSpecialMove(key: String): Unit = {
    key match {
      case "undo" =>
        game = fileIo.load("undo.2048", game)
      case "reset" =>
        game = Functions.reset
      case "save" =>
        game = fileIo.save("save.2048", game)
      case "load" =>
        game = fileIo.load("save.2048", game)
      case "exit" =>
        sys.exit()
      case _ =>
        game = fileIo.save("undo.2048", game)
    }
  }

  def runMove(key: String): Unit = {
    key match {
      case "left" =>
        game = Move.left(game)
      case "right" =>
        game = Move.right(game)
      case "down" =>
        game = Move.down(game)
      case "up" =>
        game = Move.up(game)
      case _ =>
    }
  }
}
