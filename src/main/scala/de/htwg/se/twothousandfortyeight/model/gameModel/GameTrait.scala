package de.htwg.se.twothousandfortyeight.model.gameModel

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl.{Score, Tile}

trait GameTrait:
  val grid: Array[Tile]

  val score: Score

trait TileTrait:
  val value: Int

  def isEmpty: Boolean

  def toString(): String
