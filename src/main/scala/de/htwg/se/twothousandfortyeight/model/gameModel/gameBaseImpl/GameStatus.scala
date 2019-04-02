package de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl

case class GameStatus(var win: Boolean = false,
                      var lose: Boolean = false,
                      var score: Score = new Score,
                      var grid: Grid = new Grid) {

  def reset: Unit = {
    win = false
    lose = false
    score = new Score
    grid = new Grid
  }
}
