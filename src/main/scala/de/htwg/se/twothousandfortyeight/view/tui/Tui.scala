package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

import scala.swing.Reactor

class Tui(player: String, game: GameTrait, turn: TurnTrait) extends Reactor {
  listenTo(turn)

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
