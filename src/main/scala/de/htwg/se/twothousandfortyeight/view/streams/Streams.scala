package de.htwg.se.twothousandfortyeight.view.streams

import akka.actor.{ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Sink, Source}
import akka.util.Timeout
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.CommandMessage.Command
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.{CommandActor, TurnAsInstance}
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.util.Utils

import scala.util.Random
import scala.concurrent.Await
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Streams {
  implicit val timeout = Timeout(5 seconds)
  implicit val system = ActorSystem("system")
  implicit val executionContext = system.dispatcher

  val newline = "\n"
  
  def main(args: Array[String]): Unit = {
    val print = true

    val source = Source(1 to 10000)

    val flow = Flow[Int].map(_ => stream(print))

    val sink = Sink.fold(0)((acc: Int, element: Int) => acc + element)

    val example = source.via(flow).filter(x => x == 1)

    val result = example.runWith(sink)

    result.map(println) // Counted wins
  }

  def stream(p: Boolean): Int = {
    var result = 0

    val turn = new Turn
    val turnAsInstance: TurnAsInstance = new TurnAsInstance(turn)
    val cmdActor = system.actorOf(Props(classOf[CommandActor], turnAsInstance.turn))

    while (result == 0) {
      result = singleStream(cmdActor, turn,randomMove, p)
    }

    result
  }

  def singleStream(cmdActor: ActorRef, turn: Turn, command: String, p: Boolean): Int = {
    Await.result((cmdActor ? Command(command)).mapTo[Int], 5 seconds) match {
      case 0 => if(p) print(printTui(turn)); 0
      case 1 => if(p) print(printWin(turn)); 1
      case 2 => if(p) print(printLose(turn)); 2
    }
  }

  def randomMove: String = { // TODO: Implement a weight for different game szenarios
    Random.nextInt(4) match {
      case 0 => "w"
      case 1 => "a"
      case 2 => "s"
      case 3 => "d"
      case _ => " "
    }
  }

  def print(str: String) = {
    println(str)
    println
  }

  def printTui(turn: Turn): String = {
    turn.game.toString + newline + "Your Score: " + turn.game.score.toString
  }

  def printWin(turn: Turn): String = {
    printTui(turn) + newline + "You won!"
  }

  def printLose(turn: Turn): String = {
    printTui(turn) + newline + "You lost!"
  }
}
