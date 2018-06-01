package de.htwg.se.twothousandfortyeight.view.tui

import java.util.Scanner

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.Player
import de.htwg.se.twothousandfortyeight.util.Utils

class TextUserInterface {
  def this(player: Player) {
    this()
    println("Hello " + player.toString + ". Game started!")
    println()
    println(TwoThousandFortyEight.grid.toString)
    println("Your Score: " + TwoThousandFortyEight.score.toString)

    while (true) {
      if (TwoThousandFortyEight.win) {
        println("You won!")
        sys.exit()
      } else if (TwoThousandFortyEight.lose) {
        println("You lost!")
        sys.exit()
      }

      val key = new Scanner(System.in).next()

      Turn.makeTurn(Utils.processKey(0, key.toCharArray()(0)), Math.random(), Math.random())

      println(TwoThousandFortyEight.grid.toString)
      println("Your Score: " + TwoThousandFortyEight.score.toString)
    }
  }
}
