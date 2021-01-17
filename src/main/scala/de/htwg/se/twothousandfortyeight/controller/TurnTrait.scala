package de.htwg.se.twothousandfortyeight.controller

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.Game
trait TurnTrait {
  var game: Game

  def turnLeft: TurnResult.Value

  def turnRight: TurnResult.Value

  def turnUp: TurnResult.Value

  def turnDown: TurnResult.Value

  def turnUndo: TurnResult.Value

  def turnReset: TurnResult.Value

  def turnSave: TurnResult.Value

  def turnLoad: TurnResult.Value

  def turnExit: TurnResult.Value

  def evaluate: TurnResult.Value
}
