package de.htwg.se.twothousandfortyeight.view.gui

import java.awt.Dimension

import de.htwg.se.twothousandfortyeight.model.{GameTrait, Player}
import javax.swing.{WindowConstants, _}

class GraphicalUserInterface extends JFrame {
  def this(player: Player, game: GameTrait) {
    this()

    setTitle("2048")
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    setSize(680, 800)
    setResizable(false)

    val component: Component = new Component(player, game)
    component.addKeyListener(component)
    component.setFocusable(true)
    component.setPreferredSize(new Dimension(680, 800))

    add(component)

    setLocationRelativeTo(null)
    setVisible(true)
  }
}
