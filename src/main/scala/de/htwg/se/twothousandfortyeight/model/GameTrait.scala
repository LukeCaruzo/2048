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
}
