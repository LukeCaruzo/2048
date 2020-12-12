package de.htwg.se.twothousandfortyeight.view.kafka

import de.htwg.se.twothousandfortyeight.view.streams.Streams
import org.apache.kafka.clients.producer._

import java.util.Properties

object Producer extends App {
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)

  val TOPIC = "move"
  val KEY = "message"

  for (i <- 1 to 100) {
    val record = new ProducerRecord(TOPIC, KEY, Streams.randomMoveSimple)
    Thread.sleep(2000)
    println("Sending ...")
    producer.send(record)
  }

  producer.close()
}
