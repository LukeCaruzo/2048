package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.Player

object TwoThousandFortyEight {
  def main(args: Array[String]): Unit = {
    val student = Player("Your Name")
    println("Hello, " + student.name)
  }
}
