package de.htwg.se.twothousandfortyeight.view.spark

import de.htwg.se.twothousandfortyeight.view.streams.Streams.stream
import org.apache.spark.sql.SparkSession

object Spark {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder.appName("Spark Application").config("spark.master", "local").getOrCreate()
    spark.sparkContext.setLogLevel("ERROR")

    val n = 100

    val winCount = spark.sparkContext
      .parallelize(1 to n)
      .map { i => stream(false, false) }
      .filter(x => x == 1)
      .fold(0)((acc: Int, element: Int) => acc + element)

    println(s"Wins: ${winCount}")

    spark.stop()
  }
}
