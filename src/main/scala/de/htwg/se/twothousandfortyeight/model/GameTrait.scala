package de.htwg.se.twothousandfortyeight.model

import de.htwg.se.twothousandfortyeight.model.game.{Grid, Score}

trait GameTrait extends Serializable {
  var win: Boolean
  var lose: Boolean
  var score: Score
  var grid: Grid

  def reset

  def save(filename: String)

  def load(filename: String)

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