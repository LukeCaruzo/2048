package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.actor

import akka.actor.{Actor, Props}

class Counter extends Actor {
  val counter = context.actorOf(Props[Counter], "counter")
  val resolver = context.actorOf(Props[Resolver], "resolver")
  val path = "akka://Main/user/app/counter"

  resolver.!(Resolver.Resolve(path))

  def receive = {
    case Resolver.Resolved(actorRef) => println("Actor received")
      actorRef.!("incr")
      actorRef.!("incr")
      actorRef.!("get")
    case Resolver.Failed => println("Failed to resolve ActorPath: " + path)
      context.stop(self)
    case count => println("Count is: " + count)
      context.stop(self)
  }
}
