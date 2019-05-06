package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.actor

import akka.actor.{Actor, ActorIdentity, ActorRef, Identify}

object Resolver {

  case class Resolve(path: String)

  case class Resolved(actorRef: ActorRef)

  case object Failed

}

import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.actor.Resolver._

class Resolver extends Actor {
  var requester: ActorRef = _

  override def receive: Receive = {
    case Resolve(path) => println("Resolve Message received " + path)
      context.system.actorSelection(path).!(Identify(path))
      requester = sender
    case ActorIdentity(path, Some(ref)) => println("Identity Message received")
      println("ActorPath: " + path + " resolved to ActorRef: " + ref)
      requester.!(Resolved(ref))
    case ActorIdentity(path, None) => requester.!(Failed)
  }
}
