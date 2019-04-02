package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait

import scala.swing.Publisher

import scala.swing.event.Event

trait TurnTrait extends Publisher {
  def makeTurn(game: GameTrait, key: String, random1: Double, random2: Double)
}

class TurnMade extends Event

class GameWon extends Event

class GameLost extends Event
