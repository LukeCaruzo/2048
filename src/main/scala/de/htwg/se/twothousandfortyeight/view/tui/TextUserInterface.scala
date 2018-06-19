package de.htwg.se.twothousandfortyeight.view.tui

import de.htwg.se.twothousandfortyeight.model.GameTrait
import javax.swing.{JFrame, WindowConstants}

class TextUserInterface extends JFrame {
  def this(player: String, game: GameTrait) {
    this()

    setTitle("2048")
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    setSize(1, 1)
    setResizable(false)

    val component: Component = new Component(player, game)
    component.addKeyListener(component)
    component.setFocusable(true)
    add(component)

    setLocationRelativeTo(null)
    setVisible(true)
  }
}
