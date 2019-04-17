package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

import scala.swing.Publisher
import scala.swing.event.Event

trait TurnTrait extends Publisher {
  var game: Game

  def makeTurn(key: Char)
}

class TurnMade extends Event

class GameWon extends Event

class GameLost extends Event

