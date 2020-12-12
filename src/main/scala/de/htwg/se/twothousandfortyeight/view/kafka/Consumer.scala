package de.htwg.se.twothousandfortyeight.view.kafka

import akka.actor.Props
import de.htwg.se.twothousandfortyeight.controller.actorBaseImpl.{CommandActor, TurnAsInstance}
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.view.streams.Streams.{singleStream, system}
import org.apache.kafka.clients.consumer.KafkaConsumer

import java.util
import java.util.Properties
import scala.collection.JavaConverters._

object Consumer extends App {
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "something")

  val consumer = new KafkaConsumer[String, String](props)
  val TOPIC = "move"

  consumer.subscribe(util.Collections.singletonList(TOPIC))

  val turn = new Turn
  val turnAsInstance: TurnAsInstance = new TurnAsInstance(turn)
  val cmdActor = system.actorOf(Props(classOf[CommandActor], turnAsInstance.turn))

  while (true) {
    println("Polling ...")
    val records = consumer.poll(500)

    for (record <- records.asScala) {
      singleStream(cmdActor, turn, record.value(), true)
    }
  }
}
