package de.htwg.se.twothousandfortyeight.view.tui

import java.util.Scanner

import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.GameTrait
import de.htwg.se.twothousandfortyeight.model.game.Player
import de.htwg.se.twothousandfortyeight.util.Utils

class TextUserInterface {
  def this(player: Player, game: GameTrait) {
    this()
    println("Hello " + player.toString + ". Game started!")
    println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
    println()
    println(game.grid.toString)
    println("Your Score: " + game.score.toString)

    while (true) {
      if (game.win) {
        println("You won!")
        sys.exit()
      } else if (game.lose) {
        println("You lost!")
        sys.exit()
      }

      val key = new Scanner(System.in).next()

      Turn.makeTurn(game, Utils.processKey(0, key.toCharArray()(0)), Math.random(), Math.random())

      println(game.grid.toString)
      println("Your Score: " + game.score.toString)
    }
  }
}
