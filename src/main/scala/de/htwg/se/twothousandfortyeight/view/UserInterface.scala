package de.htwg.se.twothousandfortyeight.view

import java.awt.Dimension

import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.view.gui.GuiComponent
import de.htwg.se.twothousandfortyeight.view.tui.TuiComponent
import javax.swing.{WindowConstants, _}

class UserInterface extends JFrame {
  def this(player: String, game: GameTrait) {
    this()

    setTitle("2048")
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    setSize(680, 800)
    setResizable(false)

    val component: GuiComponent = new GuiComponent(player, game)
    //component.addKeyListener(new TuiComponent(player, game))
    component.addKeyListener(component)
    component.setFocusable(true)
    component.setPreferredSize(new Dimension(680, 800))

    add(component)

    setLocationRelativeTo(null)
    setVisible(true)
  }
}
