package de.htwg.se.twothousandfortyeight.model

case class Tile(cx: Int, cy: Int, cvalue: Int = 0) {
  var x: Int = cx
  var y: Int = cy
  var value: Int = cvalue

  def updatePosition(dx: Int, dy: Int) {
    x = dx
    this.y = dy
  }

  def updateValue(dvalue: Int) {
    this.value = dvalue
  }

  def isEmpty: Boolean = this.value == 0

  def isNotEmpty: Boolean = !isEmpty

  override def toString: String = value.toString
}
