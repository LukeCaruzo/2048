package de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl

import akka.actor.Props
import akka.pattern.ask
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.CommandMessage.Command
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.{CommandActor, TurnAsInstance}
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.util.Utils

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

class MoveActor(actorName: String) {
  val newline = System.getProperty("line.separator")
  val turn = new Turn
  val turnAsInstance: TurnAsInstance = new TurnAsInstance(turn)
  val cmdActor = system.actorOf(Props(classOf[CommandActor], turnAsInstance.turn), actorName)

  def move(command: String) = {
    Await.result((cmdActor ? Command(command)).mapTo[Int], 5 seconds) match {
      case 0 => print(printTui)
      case 1 => printWin
      case 2 => printLose
      case 3 => printHelp
    }
  }

  def print(str: String) = {
    println(str)
    println
  }

  def printTui: String = {
    turn.game.toString + newline + "Your Score: " + turn.game.score.toString
  }

  def printWin: String = {
    printTui + newline + "You won!"
  }

  def printLose: String = {
    printTui + newline + "You lost!"
  }

  def printHelp: String = {
    Utils.help
  }
}
