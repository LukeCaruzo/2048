package de.htwg.se.twothousandfortyeight.model

case class Tile(cvalue: Int = 0) {
  var value: Int = cvalue

  def isEmpty: Boolean = this.value == 0

  def isNotEmpty: Boolean = !isEmpty

  override def toString: String = value.toString
}
