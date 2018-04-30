package de.htwg.se.twothousandfortyeight.model

case class Score(var value: Int = 0) {
  def resetScore(): Unit = {
    this.value = 0
  }

  override def toString: String = value.toString
}
