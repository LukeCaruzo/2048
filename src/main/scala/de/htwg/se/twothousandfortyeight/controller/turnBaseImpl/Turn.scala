package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.TwoThousandFortyEightModule
import de.htwg.se.twothousandfortyeight.controller.{GameLost, GameWon, TurnMade, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Tile}
import de.htwg.se.twothousandfortyeight.view.tui.Tui
import net.codingwell.scalaguice.InjectorExtensions._

import scala.swing.{Publisher, Reactor}

@Inject
class Turn extends TurnTrait with Publisher { //with Reactor
  //  listenTo(tui)
  //
  //  reactions += {
  //    case _: y => x
  //  }

  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]

  var game = new Game
  var undoGame = game

  def makeTurn(key: Char): Unit = {
    runMove(key)

    if (game.grid contains new Tile(2048)) {
      publish(new GameWon)
    } else if (!Operations.canBeMoved(game.grid)) {
      publish(new GameLost)
    } else {
      publish(new TurnMade)
    }
  }

  def runMove(key: Char): Unit = {
    key match {
      case 'a' =>
        game = game.left
      case 'd' =>
        game = game.right
      case 's' =>
        game = game.down
      case 'w' =>
        game = game.up
      case 'q' =>
        game = undoGame
      case 'r' =>
        game = game.reset
      case 'z' =>
        fileIo.save("save.2048", game)
      case 'u' =>
        fileIo.load("save.2048") match {
          case Some(game) =>
            this.game = game
          case None =>
            println("No save found!")
            println()
        }
      case 't' =>
        sys.exit()
      case _ =>
        undoGame = game
    }
  }
}
