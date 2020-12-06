package de.htwg.se.twothousandfortyeight.view.streams

import akka.actor.{ActorSystem, Props}
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
  val turn = new Turn
  val turnAsInstance: TurnAsInstance = new TurnAsInstance(turn)
  val cmdActor = system.actorOf(Props(classOf[CommandActor], turnAsInstance.turn), "streamActor")

  def main(args: Array[String]): Unit = {
    val source = Source(1 to 10)

    val flow = Flow[Int].map(_ => stream)

    val sink = Sink.foreach[Int](println)
      //reduce[Int]((x, y) => { var a = 0; a = if( x == 2 ) a + 1 else a; println(a); a})

    val example = source.via(flow).to(sink)

    example.run()
  }

  def stream: Int = {
    var result = 0

    while (result == 0) {
      result = singleStream(randomMove)
    }

    result
  }

  def singleStream(command: String): Int = {
    Await.result((cmdActor ? Command(command)).mapTo[Int], 5 seconds) match {
      case 0 => print(printTui); 0
      case 1 => print(printWin); 1
      case 2 => print(printLose); 2
    }
  }

  def randomMove: String = {
    Random.nextInt(3) match {
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

  def printTui: String = {
    turn.game.toString + newline + "Your Score: " + turn.game.score.toString
  }

  def printWin: String = {
    printTui + newline + "You won!"
  }

  def printLose: String = {
    printTui + newline + "You lost!"
  }
}
