package de.htwg.se.twothousandfortyeight.controller.actorBaseImpl

import akka.actor.Actor
import de.htwg.se.twothousandfortyeight.controller.TurnTrait
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.CommandMessage.Command
import de.htwg.se.twothousandfortyeight.util.Utils

object CommandMessage {

  final case class Command(cmd: String)

}

class TurnAsInstance(val turn: TurnTrait) extends AnyVal

class CommandActor(val conf: TurnAsInstance) extends Actor {
  val turn: TurnTrait = conf.turn

  override def receive: Receive = {
    case Command(command) =>
      command.charAt(0) match {
        case 'a' => sender ! Utils.processAction(turn, "left")
        case 'd' => sender ! Utils.processAction(turn, "right")
        case 's' => sender ! Utils.processAction(turn, "down")
        case 'w' => sender ! Utils.processAction(turn, "up")
        case 'q' => sender ! Utils.processAction(turn, "undo")
        case 'r' => sender ! Utils.processAction(turn, "reset")
        case 'z' => sender ! Utils.processAction(turn, "save")
        case 'u' => sender ! Utils.processAction(turn, "load")
        case 't' => sender ! Utils.processAction(turn, "exit")
        case 'h' => sender ! Utils.processAction(turn, "help")
        case _ => sender ! Utils.processAction(turn, "blank")
      }
  }
}
