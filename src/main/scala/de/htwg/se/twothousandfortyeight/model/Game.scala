package de.htwg.se.twothousandfortyeight.model

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

class Game extends Serializable {
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
    val oos = new ObjectOutputStream(new FileOutputStream("savegame.2048"))
    oos.writeObject(this)
    oos.close
  }

  def load: Unit = {
    val ois = new ObjectInputStream(new FileInputStream("savegame.2048"))
    val game = ois.readObject.asInstanceOf[Game]
    this.win = game.win
    this.lose = game.lose
    this.score = game.score
    this.grid = game.grid
    ois.close
  }
}
