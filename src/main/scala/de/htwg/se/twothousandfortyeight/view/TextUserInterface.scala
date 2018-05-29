package de.htwg.se.twothousandfortyeight.view

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.controller.{KeyListener, Turn}
import de.htwg.se.twothousandfortyeight.model.Player

case class TextUserInterface() {
  def this(player: Player) {
    this()
    println("Hello " + player.toString + ". Game started!")
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

      val key = KeyListener.processKey()

      Turn.makeTurn(key, Math.random(), Math.random())

      println(TwoThousandFortyEight.grid.toString)
      println("Your Score: " + TwoThousandFortyEight.score.toString)
    }
  }
}
