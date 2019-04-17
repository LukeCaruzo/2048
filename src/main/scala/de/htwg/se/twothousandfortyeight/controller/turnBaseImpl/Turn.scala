package de.htwg.se.twothousandfortyeight.controller.turnBaseImpl

import de.htwg.se.twothousandfortyeight.controller.{Blank, Down, Exit, Left, Load, Reset, Right, Save, TurnTrait, Undo, Up}

import scala.swing.Publisher

class Turn extends TurnTrait with Publisher {
  def makeTurn(key: Char): Unit = {
    key match {
      case 'a' =>
        publish(new Left)
      case 'd' =>
        publish(new Right)
      case 's' =>
        publish(new Down)
      case 'w' =>
        publish(new Up)
      case 'q' =>
        publish(new Undo)
      case 'r' =>
        publish(new Reset)
      case 'z' =>
        publish(new Save)
      case 'u' =>
        publish(new Load)
      case 't' =>
        publish(new Exit)
      case _ =>
        publish(new Blank)
    }
  }
}
