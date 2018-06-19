package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.fileIoModel.fileIoJsonImpl.FileIo
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

object Turn {
  def makeTurn(game: GameTrait, key: String, random1: Double, random2: Double): Unit = {
    runSpecialMove(game, key)

    if (!game.grid.canBeMoved) {
      game.lose = true
    }

    if (!game.win && !game.lose) {
      runMove(game, key, random1, random2)
    }

    if (!game.win && !game.grid.canBeMoved) {
      game.lose = true
    }
  }

  def runSpecialMove(game: GameTrait, key: String): Unit = {
    key match {
      case "undo" =>
      //game.load("undo.2048")
      case "reset" =>
        game.reset
      case "save" =>
        new FileIo().save("save.2048", game)
      //game.save("save.2048")
      case "load" =>
        new FileIo().load("save.2048", game)
      //game.load("save.2048")
      case "exit" =>
        sys.exit()
      case _ =>
      //game.save("undo.2048")
    }
  }

  def runMove(game: GameTrait, key: String, random1: Double, random2: Double): Unit = {
    key match {
      case "left" =>
        game.left(random1, random2)
      case "right" =>
        game.right(random1, random2)
      case "down" =>
        game.down(random1, random2)
      case "up" =>
        game.up(random1, random2)
      case _ =>
    }
  }
}
