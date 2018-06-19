package de.htwg.se.twothousandfortyeight.view.gui

import java.awt.event.{KeyEvent, KeyListener}
import java.awt.{Color, Graphics2D, _}

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.GameTrait
import de.htwg.se.twothousandfortyeight.model.TileTrait
import de.htwg.se.twothousandfortyeight.util.Utils
import javax.swing._

class Component(player: String, game: GameTrait) extends JPanel with KeyListener {
  val BACKGROUND_COLOR = new Color(0x000000)
  val FOREGROUND_COLOR = new Color(0xededed)
  val FONT_NAME = "Helvetica"
  val TILE_SIZE = 512 / TwoThousandFortyEight.FIELD_SIZE
  val TILES_BORDER = 128 / TwoThousandFortyEight.FIELD_SIZE
  repaint()

  override def keyTyped(e: KeyEvent): Unit = {
    Turn.makeTurn(game, Utils.processKey(e.getExtendedKeyCode, e.getKeyChar), Math.random(), Math.random())

    repaint()
  }

  override def keyPressed(e: KeyEvent): Unit = {}

  override def keyReleased(e: KeyEvent): Unit = {}

  override def paint(graphics: Graphics): Unit = {
    super.paint(graphics)

    graphics.setColor(BACKGROUND_COLOR)
    graphics.fillRect(0, 0, this.getSize().width, this.getSize().height)

    for (x <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
      for (y <- 0 until TwoThousandFortyEight.FIELD_SIZE) {
        draw(graphics, game.grid.getPositionOfTile(x, y), x, y);
      }
    }
  }

  private def draw(graphics2: Graphics, tile: TileTrait, x: Int, y: Int): Unit = {
    val graphics = graphics2.asInstanceOf[Graphics2D]

    val valueOfTile = tile.value
    graphics.setColor(Utils.getBackGroundColor(tile))
    val xO = x * (TILES_BORDER + TILE_SIZE) + TILES_BORDER
    val yO = y * (TILES_BORDER + TILE_SIZE) + TILES_BORDER
    graphics.fillRoundRect(xO, yO, TILE_SIZE, TILE_SIZE, 12, 12)
    graphics.setColor(FOREGROUND_COLOR)

    var size = 0

    if (valueOfTile < 100) {
      size = 288 / TwoThousandFortyEight.FIELD_SIZE
    } else if (valueOfTile < 1000) {
      size = 256 / TwoThousandFortyEight.FIELD_SIZE
    } else {
      size = 232 / TwoThousandFortyEight.FIELD_SIZE
    }

    val font = new Font(FONT_NAME, Font.BOLD, size)
    graphics.setFont(font)

    val valueString = String.valueOf(valueOfTile)
    val fontMetrics = getFontMetrics(font)
    val stringWidth = fontMetrics.stringWidth(valueString)
    val stringHeight = -fontMetrics.getLineMetrics(valueString, graphics).getBaselineOffsets()(2).asInstanceOf[Int]

    if (!tile.isEmpty) {
      graphics.drawString(valueString, xO + (TILE_SIZE - stringWidth) / 2, yO + TILE_SIZE - (TILE_SIZE - stringHeight) / 2 - 2)
    }

    if (game.win || game.lose) {
      graphics.setColor(new Color(255, 255, 255, 40))
      graphics.fillRect(0, 0, getWidth, getHeight)
      graphics.setColor(new Color(0xFF0000))
      graphics.setFont(new Font(FONT_NAME, Font.BOLD, 96))

      if (game.win) {
        graphics.drawString("You won!", 136, 300)
      }

      if (game.lose) {
        graphics.drawString("Game over!", 90, 260)
        graphics.drawString("You lost!", 140, 400)
      }

      if (game.win || game.lose) {
        graphics.setFont(new Font(FONT_NAME, Font.PLAIN, 32))
        graphics.setColor(new Color(0x545454))
        graphics.drawString("Press T to exit or R to reset!", 150, getHeight - 80)
      }
    }

    graphics.setFont(new Font(FONT_NAME, Font.PLAIN, 32))
    graphics.setColor(new Color(0x545454))
    graphics.drawString("Score: " + game.score.value, 400, 740)
    graphics.drawString(this.player, 70, 740)
  }
}
