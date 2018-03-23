package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.model.Player

object TwoThousandFortyEight {
  def main(args: Array[String]): Unit = {
    val student = Player("Lucas/Bilal")
    println("Hello, " + student.name)
  }
}
