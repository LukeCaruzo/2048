package de.htwg.se.twothousandfortyeight.controller.actorDslImpl

import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.stream.ActorMaterializer
import akka.util.Timeout
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.CommandMessage.Command
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.{CommandActor, TurnAsInstance}
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.util.Utils

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Player {
  implicit val timeout = Timeout(5 seconds)
  implicit val system = ActorSystem("system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val turn = new Turn
  val turnAsInstance: TurnAsInstance = new TurnAsInstance(turn)
  val cmdActor = system.actorOf(Props(classOf[CommandActor], turnAsInstance.turn), "commandactor")

  def play(command: String) = {
    Await.result((cmdActor ? Command(command)).mapTo[Int], 5 seconds) match {
      case 0 => printTui
      case 1 => printWin
      case 2 => printLose
      case 3 => printHelp
    }
  }

  def printTui = {
    println(turn.game.toString)
    println("Your Score: " + turn.game.score.toString)
    println
  }

  def printWin = {
    printTui
    println("You won!")
  }

  def printLose = {
    printTui
    println("You lost!")
  }

  def printHelp = {
    println(Utils.help)
    println
  }
}
