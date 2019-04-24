package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

import scala.swing.Publisher
import scala.swing.event.Event

trait TurnTrait extends Publisher {
  var game: Game
}

class TurnMade extends Event

class GameWon extends Event

class GameLost extends Event

class Up extends Event

class Down extends Event

class Left extends Event

class Right extends Event

class Undo extends Event

class Reset extends Event

class Save extends Event

class Load extends Event

class Exit extends Event

class Blank extends Event

