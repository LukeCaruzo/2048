package de.htwg.se.twothousandfortyeight

import de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl._
import de.htwg.se.twothousandfortyeight.controller.turnBaseImpl.Turn
import de.htwg.se.twothousandfortyeight.view.microservice.{CounterService, CounterServiceServer, HighScoreService, HighScoreServiceServer}
import de.htwg.se.twothousandfortyeight.view.tui.{Rest, Tui}

object TwoThousandFortyEight {
  val FIELD_SIZE = 4 // Tests and Slick are configured for 4

  def main(args: Array[String]): Unit = {
    /*val turn = new Turn

    new Rest(turn)
    //new CounterServiceServer(new CounterService) // fix for docker
    //new HighScoreServiceServer(new HighScoreService) // fix for docker
    new Tui(turn)*/

    Move(w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d,w,a,s,d)
  }
}
