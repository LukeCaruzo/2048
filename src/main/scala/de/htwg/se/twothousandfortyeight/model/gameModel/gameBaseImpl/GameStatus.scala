package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

class GameStatus {
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
}
