package de.htwg.se.twothousandfortyeight.controller.actorInternalDslImpl

class Player {
  val moveActor = new MoveActor("playerActor")

  def Move(seq: String*): Unit = {
    seq.foreach(e => moveActor.move(e))
    sys.exit
  }
}
