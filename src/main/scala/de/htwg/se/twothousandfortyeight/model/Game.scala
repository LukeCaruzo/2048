package de.htwg.se.twothousandfortyeight.model

class Game {
  var win = false
  var lose = false
  var score = new Score
  var grid = new Grid

  def reset: Unit = {
    win = false
    lose = false
    score = new Score
    grid = new Grid
  }

  def save: Unit = {
    // TODO
  }

  def load: Unit = {
    // TODO
  }
}
