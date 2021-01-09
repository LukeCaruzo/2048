package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Game, Operations, Tile}

class Turn extends TurnTrait:
  val fileIo = new FileIo
  var game = new Game
  var undoGame = game

  def turnLeft =
    undoGame = game
    game = game.left
    evaluate

  def turnRight =
    undoGame = game
    game = game.right
    evaluate

  def turnUp =
    undoGame = game
    game = game.up
    evaluate

  def turnDown =
    undoGame = game
    game = game.down
    evaluate

  def turnUndo =
    game = undoGame
    evaluate

  def turnReset =
    game = game.reset
    evaluate

  def turnSave =
    fileIo.save("save.2048", game)
    evaluate

  def turnLoad =
    fileIo.load("save.2048") match {
      case Some(game) =>
        this.game = game
      case None =>
        println("No save found!")
        println()
    }
    evaluate

  def turnExit: Int =
    sys.exit()
    return 0

  def evaluate: Int =
    if (game.grid contains new Tile(2048)) {
      return 1 // won
    } else if (!Operations.canBeMoved(game.grid)) {
      return 2 // lost
    } else {
      return 0
    }