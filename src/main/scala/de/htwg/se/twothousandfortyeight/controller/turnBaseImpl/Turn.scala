package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.TwoThousandFortyEightModule
import de.htwg.se.twothousandfortyeight.controller.TurnResult.{LOSE, TURN_FINISHED, WIN}
import de.htwg.se.twothousandfortyeight.controller.{TurnResult, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Tile}
import net.codingwell.scalaguice.InjectorExtensions._

@Inject
class Turn extends TurnTrait {
  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]
  val tile2048 = Tile(2048)

  var game = new Game
  var undoGame = game

  def turnLeft: TurnResult.Value = {
    undoGame = game
    game = game.left
    evaluate
  }

  def turnRight: TurnResult.Value = {
    undoGame = game
    game = game.right
    evaluate
  }

  def turnUp: TurnResult.Value = {
    undoGame = game
    game = game.up
    evaluate
  }

  def turnDown: TurnResult.Value = {
    undoGame = game
    game = game.down
    evaluate
  }

  def turnUndo: TurnResult.Value = {
    game = undoGame
    evaluate
  }

  def turnReset: TurnResult.Value = {
    game = game.reset
    evaluate
  }

  def turnSave: TurnResult.Value = {
    fileIo.save("save.2048", game)
    evaluate
  }

  def turnLoad: TurnResult.Value = {
    fileIo.load("save.2048") match {
      case Some(game) =>
        this.game = game
      case None =>
        println("No save found!")
        println()
    }
    evaluate
  }

  def turnExit: TurnResult.Value = {
    sys.exit()
    TURN_FINISHED
  }

  def evaluate: TurnResult.Value = {
    if (game.grid contains tile2048) {
      WIN
    } else if (!Operations.canBeMoved(game.grid)) {
      LOSE
    } else {
      TURN_FINISHED
    }
  }
}
