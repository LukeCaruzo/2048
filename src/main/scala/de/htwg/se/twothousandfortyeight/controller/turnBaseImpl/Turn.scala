package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.TwoThousandFortyEightModule
import de.htwg.se.twothousandfortyeight.controller.{GameLost, GameWon, TurnMade, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Tile}
import net.codingwell.scalaguice.InjectorExtensions._

import scala.swing.Publisher

@Inject
class Turn extends TurnTrait with Publisher {
  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]

  var game = new Game
  var undoGame = game

  def makeTurn(key: String): Unit = {
    runSpecialMove(key)

    runMove(key)

    if (game.grid contains new Tile(2048)) {
      publish(new GameWon)
    } else if (!Operations.canBeMoved(game.grid)) {
      publish(new GameLost)
    } else {
      publish(new TurnMade)
    }
  }

  def runSpecialMove(key: String): Unit = {
    key match {
      case "undo" =>
        game = undoGame
      case "reset" =>
        game = game.reset
      case "save" =>
        fileIo.save("save.2048", game)
      case "load" =>
        fileIo.load("save.2048") match {
          case Some(game) =>
            this.game = game
          case None =>
            println("No save found!")
            println()
        }
      case "exit" =>
        sys.exit()
      case _ =>
        undoGame = game
    }
  }

  def runMove(key: String): Unit = {
    key match {
      case "left" =>
        game = game.left
      case "right" =>
        game = game.right
      case "down" =>
        game = game.down
      case "up" =>
        game = game.up
      case _ =>
    }
  }
}
