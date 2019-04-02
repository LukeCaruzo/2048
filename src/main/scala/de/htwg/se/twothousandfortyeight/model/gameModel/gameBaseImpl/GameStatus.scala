package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

case class GameStatus(var score: Score = new Score, var grid: Grid = new Grid) {
  def reset: Unit = {
    score = new Score
    grid = new Grid
  }
}
