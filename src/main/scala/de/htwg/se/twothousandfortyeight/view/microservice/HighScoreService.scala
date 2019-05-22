package de.htwg.se.twothousandfortyeight.view.microservice

import java.util

import scala.io.StdIn

object HighScoreServiceMain {
  def main(args: Array[String]): Unit = {
    val webserver = new HighScoreServiceServer(new HighScoreService)

    println("Server online at http://localhost:8082/")
    println("Press RETURN to stop...")

    //StdIn.readLine() // let it run until user presses return

    while(true){
      println("running: highscore") // fix for docker
    }

    webserver.unbind()
  }
}

class HighScoreService {
  val highScoreList = new util.ArrayList[HighScore]()

  def setHighScore(player: String, highScore: Int) = {
    highScoreList.add(new HighScore(player, highScore))
  }

  override def toString: String = {
    var string = ""

    highScoreList.forEach(highScore => {
      string = string + highScore.player + " - " + highScore.highScore + "\n"
    })

    return string
  }

  def toHtml: String = {
    "<p>" + toString.replace("\n", "<br>") + "</p>"
  }
}

case class HighScore(player: String, highScore: Int)