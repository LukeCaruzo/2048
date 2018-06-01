package de.htwg.se.twothousandfortyeight.view.tui

import java.util.Scanner

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.Player

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

      val key = processKey()

      Turn.makeTurn(key, Math.random(), Math.random())

      println(TwoThousandFortyEight.grid.toString)
      println("Your Score: " + TwoThousandFortyEight.score.toString)
    }
  }

  def processKey(): String = {
    val key = new Scanner(System.in).next

    if (key == "w") {
      return "up"
    } else if (key == "a") {
      return "left"
    } else if (key == "s") {
      return "down"
    } else if (key == "d") {
      return "right"
    } else if (key == "exit") {
      return "exit"
    } else if (key == "reset") {
      return "reset"
    } else {
      println("Wrong key, retry!")
      return processKey()
    }
  }
}
