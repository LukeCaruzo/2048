package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import com.google.inject.{Guice, Inject}
import de.htwg.se.twothousandfortyeight.TwoThousandFortyEightModule
import de.htwg.se.twothousandfortyeight.controller.{TurnMade, TurnTrait}
import de.htwg.se.twothousandfortyeight.model.fileIoModel.FileIoTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import net.codingwell.scalaguice.InjectorExtensions._

import scala.swing.Publisher

@Inject
class Turn extends TurnTrait with Publisher {
  val injector = Guice.createInjector(new TwoThousandFortyEightModule)
  val fileIo = injector.instance[FileIoTrait]

  def makeTurn(game: GameTrait, key: String, random1: Double, random2: Double) {
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

    publish(new TurnMade)
  }

  def runSpecialMove(game: GameTrait, key: String): Unit = {
    key match {
      case "undo" =>
        fileIo.load("undo.2048", game)
      case "reset" =>
        game.reset
      case "save" =>
        fileIo.save("save.2048", game)
      case "load" =>
        fileIo.load("save.2048", game)
      case "exit" =>
        sys.exit()
      case _ =>
        fileIo.save("undo.2048", game)
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
