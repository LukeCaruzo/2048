package de.htwg.se.twothousandfortyeight.view.microservice

import akka.actor.ActorSystem
import akka.http.javadsl.server.directives.RouteDirectives
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.{Route, StandardRoute}
import akka.stream.ActorMaterializer

import scala.concurrent.Future

class HighScoreServiceServer(highScore: HighScoreService) {
  implicit val system = ActorSystem("my-system")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher

  val route: Route = get {
    pathSingleSlash {
      complete(HttpEntity(ContentTypes.`text/plain(UTF-8)`, "<h1>SimpleCounter</h1>"))
    }
    path("") {
      parseHtml
    } ~
      path("setHighScore" / Segment / IntNumber) {
        (command1, command2) => {
          highScore.setHighScore(command1, command2)
          parseHtml
        }
      }
  }

  def parseHtml: StandardRoute = {
    complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, highScore.toHtml))
  }

  val bindingFuture: Future[Http.ServerBinding] = Http().bindAndHandle(route, "0.0.0.0", 8082)

  def unbind(): Unit = {
    bindingFuture
      .flatMap(_.unbind()) // trigger unbinding from the port
      .onComplete(_ => system.terminate()) // and shutdown when done
  }
}
