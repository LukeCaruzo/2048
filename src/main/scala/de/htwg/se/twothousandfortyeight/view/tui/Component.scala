package de.htwg.se.twothousandfortyeight.view.tui

import java.awt.event.{KeyEvent, KeyListener}

import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.GameTrait
import de.htwg.se.twothousandfortyeight.util.Utils
import javax.swing.JPanel

class Component(player: String, game: GameTrait) extends JPanel with KeyListener {
  println("Hello " + player + ". Game started!")
  println("Used W A S D to move and R to reset and T to exit and Z to save and U to load and Q to undo.")
  println()
  println(game.grid.toString)
  println("Your Score: " + game.score.toString)
  println()

  override def keyTyped(e: KeyEvent): Unit = {
    if (game.win) {
      println("You won!")
      sys.exit()
    } else if (game.lose) {
      println("You lost!")
      sys.exit()
    }

    Turn.makeTurn(game, Utils.processKey(e.getExtendedKeyCode, e.getKeyChar), Math.random(), Math.random())

    println(game.grid.toString)
    println("Your Score: " + game.score.toString)
    println()
  }

  override def keyPressed(e: KeyEvent): Unit = {}

  override def keyReleased(e: KeyEvent): Unit = {}
}