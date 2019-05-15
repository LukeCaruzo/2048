package de.htwg.se.twothousandfortyeight.view.microservice

import scala.io.StdIn

object HighScoreServiceMain {
  def main(args: Array[String]): Unit = {
    val webserver = new HighScoreServiceServer(new HighScoreService)

    println("Server online at http://localhost:8081/")
    println("Press RETURN to stop...")

    StdIn.readLine() // let it run until user presses return
    webserver.unbind()
  }
}

class HighScoreService {
  var player = ""
  var highScore = 0

  def setPlayer(newPlayer: String) = {
    player = newPlayer
  }

  def setHighScore(newHighScore: Int) = {
    highScore = newHighScore
  }

  override def toString: String = "HighScore:\n" + player + " - " + highScore

  def toHtml: String = {
    "<p>" + toString + "</p>"
  }
}
