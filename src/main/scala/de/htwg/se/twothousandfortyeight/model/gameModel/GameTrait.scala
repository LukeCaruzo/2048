package de.htwg.se.twothousandfortyeight.model.gameModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Grid, Score}

trait GameTrait {
  var win: Boolean
  var lose: Boolean
  var score: Score
  var grid: Grid

  def reset

  def left(random1: Double, random2: Double)

  def right(random1: Double, random2: Double)

  def up(random1: Double, random2: Double)

  def down(random1: Double, random2: Double)
}

trait TileTrait {
  var value: Int

  def isEmpty(): Boolean

  def toString(): String
}