package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.TwoThousandFortyEightModule
import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Tile}
import net.codingwell.scalaguice.InjectorExtensions._

@Inject
class Turn extends TurnTrait {
  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]

  var game = new Game
  var undoGame = game

  val EXIT = 0
  val WON = 1
  val LOST = 2


  def turnLeft: Int = {
    undoGame = game
    game = game.left
    evaluate
  }

  def turnRight: Int = {
    undoGame = game
    game = game.right
    evaluate
  }

  def turnUp: Int = {
    undoGame = game
    game = game.up
    evaluate
  }

  def turnDown: Int = {
    undoGame = game
    game = game.down
    evaluate
  }

  def turnUndo: Int = {
    game = undoGame
    evaluate
  }

  def turnReset: Int = {
    game = game.reset
    evaluate
  }

  def turnSave: Int = {
    fileIo.save("save.2048", game)
    evaluate
  }

  def turnLoad: Int = {
    fileIo.load("save.2048") match {
      case Some(game) =>
        this.game = game
      case None =>
        println("No save found!")
        println()
    }
    evaluate
  }

  def turnExit: Int = {
    sys.exit()
    EXIT
  }

  def evaluate: Int = {
    if (game.grid contains new Tile(2048)) {
      WON
    } else if (!Operations.canBeMoved(game.grid)) {
      LOST
    } else {
      EXIT
    }
  }
}
