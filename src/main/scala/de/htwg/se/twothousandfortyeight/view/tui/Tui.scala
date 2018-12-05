package de.htwg.se.twothousandfortyeight.view.tui

import java.awt.event.KeyEvent

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.util.Utils

import scala.swing.Reactor
import scala.swing.event.KeyReleased

class Tui(game: GameTrait, turn: TurnTrait) extends Reactor {
  listenTo(turn)

  println("Hello. Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println()
  println(game.grid.toString)
  println("Your Score: " + game.score.toString)
  println()

  reactions += {
    case event: KeyReleased => {
      turn.makeTurn(game, Utils.processKey(event.key.id, 'x'), Math.random(), Math.random())

      if (game.win) {
        println("You won!")
      } else if (game.lose) {
        println("You lost!")
      } else {
        println(game.grid.toString)
        println("Your Score: " + game.score.toString)
        println()
      }
    }
  }

  //  def printTui(): Unit = {
  //    if (game.win) {
  //      println("You won!")
  //    } else if (game.lose) {
  //      println("You lost!")
  //    } else {
  //      println(game.grid.toString)
  //      println("Your Score: " + game.score.toString)
  //      println()
  //    }
  //  }

  //  override def keyTyped(e: KeyEvent): Unit = {
  //    val turn = new Turn
  //    turn.makeTurn(game, Utils.processKey(e.getExtendedKeyCode, e.getKeyChar), Math.random(), Math.random())
  //
  //    if (game.win) {
  //      println("You won!")
  //    } else if (game.lose) {
  //      println("You lost!")
  //    } else {
  //      println(game.grid.toString)
  //      println("Your Score: " + game.score.toString)
  //      println()
  //    }
  //  }

  //  reactions += {
  //    case event: GridSizeChanged => printTui
  //  }
  //
  //  def printTui: Unit = {
  //    logger.info(controller.gridToString)
  //    logger.info(GameStatus.message(controller.gameStatus))
  //  }
  //
  //  def printCandidates: Unit = {
  //    logger.info("Candidates: ")
  //    for (row <- 0 until size; col <- 0 until size) {
  //      if (controller.isShowCandidates(row, col)) println("("+row+","+col+"):"+controller.available(row, col).toList.sorted)
  //    }
  //  }
}
