package de.htwg.se.twothousandfortyeight.model

trait GameTrait extends Serializable {
  var win: Boolean
  var lose: Boolean
  var score: Score
  var grid: Grid

  def reset

  def save(filename: String)

  def load(filename: String)
}
