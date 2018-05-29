package de.htwg.se.twothousandfortyeight.controller

import java.util.Scanner

object KeyListener {
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
    } else {
      println("Wrong key, retry!")
      return processKey()
    }
  }
}
