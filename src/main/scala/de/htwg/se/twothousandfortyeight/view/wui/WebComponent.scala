package de.htwg.se.twothousandfortyeight.view.wui

import java.awt.event.KeyEvent

import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.util.Utils

class WebComponent(player: String, game: GameTrait) {
  println("Hello " + player + ". Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println()
  println(game.grid.toString)
  println("Your Score: " + game.score.toString)
  println()

  def action(input: Char): Unit = {
    Turn.makeTurn(game, Utils.processKey(0, input), Math.random(), Math.random())

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
