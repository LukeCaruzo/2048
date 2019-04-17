package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.TwoThousandFortyEightModule
import de.htwg.se.twothousandfortyeight.controller.{Blank, Down, Exit, GameLost, GameWon, Left, Load, ReactorTrait, Reset, Right, Save, TurnMade, TurnTrait, Undo, Up}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Tile}
import net.codingwell.scalaguice.InjectorExtensions._

import scala.swing.Publisher

@Inject
class Reactor(turn: TurnTrait) extends ReactorTrait with swing.Reactor with Publisher {
  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]

  var game = new Game
  var undoGame = game

  listenTo(turn)

  reactions += {
    case _: Left => turnLeft
    case _: Right => turnRight
    case _: Up => turnUp
    case _: Down => turnDown
    case _: Undo => turnUndo
    case _: Reset => turnReset
    case _: Save => turnSave
    case _: Load => turnLoad
    case _: Exit => turnExit
    case _: Blank => evaluate
  }

  def turnLeft = {
    undoGame = game
    game = game.left
    evaluate
  }

  def turnRight = {
    undoGame = game
    game = game.right
    evaluate
  }

  def turnUp = {
    undoGame = game
    game = game.up
    evaluate
  }

  def turnDown = {
    undoGame = game
    game = game.down
    evaluate
  }

  def turnUndo = {
    game = undoGame
    evaluate
  }

  def turnReset = {
    game = game.reset
    evaluate
  }

  def turnSave = {
    fileIo.save("save.2048", game)
    evaluate
  }

  def turnLoad = {
    fileIo.load("save.2048") match {
      case Some(game) =>
        this.game = game
      case None =>
        println("No save found!")
        println()
    }
    evaluate
  }

  def turnExit = sys.exit()

  def evaluate(): Unit = {
    if (game.grid contains new Tile(2048)) {
      publish(new GameWon)
    } else if (!Operations.canBeMoved(game.grid)) {
      publish(new GameLost)
    } else {
      publish(new TurnMade)
    }
  }
}
