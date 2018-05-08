package de.htwg.se.twothousandfortyeight.view


import java.util.Scanner

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.Player

import scala.util.control.Breaks._

case class TextUserInterface() {
  def this(player: Player) {
    this()
    println("Hello " + player.toString + ". Game started!")
    println(TwoThousandFortyEight.grid.toString)
    println("Your Score: " + TwoThousandFortyEight.score.toString)

    val scanner = new Scanner(System.in)

    breakable {
      while (true) {
        if (TwoThousandFortyEight.win) {
          System.out.println("You won!")
          break
        } else if (TwoThousandFortyEight.lose) {
          System.out.println("You lost!")
          break
        }

        var key = scanner.next

        if (key == "exit") {
          break
        }

        Turn.makeTurn(key)

        System.out.println(TwoThousandFortyEight.grid.toString)
        System.out.println("Your Score: " + TwoThousandFortyEight.score.toString)
      }
    }

    scanner.close
  }
}
