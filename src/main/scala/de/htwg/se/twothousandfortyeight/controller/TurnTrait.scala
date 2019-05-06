package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game

trait TurnTrait {
  var game: Game

  def turnLeft: Int

  def turnRight: Int

  def turnUp: Int

  def turnDown: Int

  def turnUndo: Int

  def turnReset: Int

  def turnSave: Int

  def turnLoad: Int

  def turnExit: Int

  def evaluate: Int
}