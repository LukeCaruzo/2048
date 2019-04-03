package de.htwg.se.twothousandfortyeight.model.gameModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{GameStatus, Grid, Score}

import scala.swing.Publisher
import scala.swing.event.Event

trait GameTrait {
  val status: GameStatus

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

/*trait GameStatusTrait {
  var score: Score

  var grid: Grid

  def reset(): Unit
}*/
