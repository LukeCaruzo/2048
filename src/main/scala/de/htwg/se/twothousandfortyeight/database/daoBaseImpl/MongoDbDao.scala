package de.htwg.se.twothousandfortyeight.database.daoBaseImpl

import de.htwg.se.twothousandfortyeight.database.DaoTrait
import org.mongodb.scala.{Completed, Document, MongoClient, MongoCollection, MongoDatabase, Observable, Observer}
import play.api.libs.json.Json

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class MongoDbDao extends DaoTrait {
  val client: MongoClient = MongoClient()
  val database: MongoDatabase = client.getDatabase("TwoThousandFortyEightMongoDB")
  val collection: MongoCollection[Document] = database.getCollection("TwoThousandFortyEightCollection")

  override def show: Future[Seq[Option[Int]]] = ???

  override def create(gameConfig: GameConfig): Future[Int] = {
    return Future {
      val observable: Observable[Completed] = collection.insertOne(Document(Json.obj("config" -> gameConfig.game).toString()))

      observable.subscribe(new Observer[Completed] {
        override def onNext(result: Completed): Unit = println(s"onNext: $result")
        override def onError(e: Throwable): Unit = println(s"onError: $e")
        override def onComplete(): Unit = println("onComplete")
      })

      0
    }
  }

  override def read(id: Int): Future[GameConfig] = {
    Future {
      var waitOnResult = true
      var result = new GameConfig("")
      val observable: Observable[Document] = collection.find().first

      observable.subscribe(new Observer[Document] {
        override def onNext(nextResult: Document): Unit = {
          println(s"onNext: $result")

          result = new GameConfig((Json.parse(nextResult.toJson()) \ "config").get.as[String])
        }

        override def onError(e: Throwable): Unit = println(s"onError: $e")

        override def onComplete(): Unit = {
          waitOnResult = false
          println("onComplete")
        }
      })

      while (waitOnResult) {
        Thread.sleep(10)
      }

      result
    }
  }

  override def update(id: Int, gameConfig: GameConfig): Future[Int] = ???

  override def delete(id: Int): Future[Int] = ???
}
