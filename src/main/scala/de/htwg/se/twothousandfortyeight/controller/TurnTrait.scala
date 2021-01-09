package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

trait TurnTrait:
  var game: Game

  def turnLeft: 0 | 1 | 2

  def turnRight: 0 | 1 | 2

  def turnUp: 0 | 1 | 2

  def turnDown: 0 | 1 | 2

  def turnUndo: 0 | 1 | 2

  def turnReset: 0 | 1 | 2

  def turnSave: 0 | 1 | 2

  def turnLoad: 0 | 1 | 2

  def turnExit: 0

  def evaluate: 0 | 1 | 2
