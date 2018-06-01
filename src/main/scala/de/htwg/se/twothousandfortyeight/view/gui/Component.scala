package de.htwg.se.twothousandfortyeight.view.gui

import java.awt.event.{KeyEvent, KeyListener}
import java.awt.{Color, Graphics2D, _}

import de.htwg.se.twothousandfortyeight.TwoThousandFortyEight
import de.htwg.se.twothousandfortyeight.controller.Turn
import de.htwg.se.twothousandfortyeight.model.{Player, Tile}
import javax.swing._

class Component extends JPanel with KeyListener {
  val BACKGROUND_COLOR = new Color(0x000000)
  val FONT_NAME = "Helvetica"
  val TILE_SIZE = 128
  val TILES_BORDER = 32
  var player = new Player("")

  def this(player: Player) {
    this()

    this.player = player

    repaint()
  }

  override def keyTyped(e: KeyEvent): Unit = {
    Turn.makeTurn(processKey(e.getExtendedKeyCode, e.getKeyChar), Math.random(), Math.random())

    repaint()
  }

  override def keyPressed(e: KeyEvent): Unit = {}

  override def keyReleased(e: KeyEvent): Unit = {}

  def processKey(key1: Int, key2: Char): String = {
    if (key1 == 87 || key2 == "w") {
      return "up"
    } else if (key1 == 65 || key2 == "a") {
      return "left"
    } else if (key1 == 83 || key2 == "s") {
      return "down"
    } else if (key1 == 68 || key2 == "d") {
      return "right"
    } else if (key1 == 27) {
      return "exit"
    } else {
      return ""
    }
  }

  override def paint(graphics: Graphics): Unit = {
    super.paint(graphics)

    graphics.setColor(BACKGROUND_COLOR)
    graphics.fillRect(0, 0, this.getSize().width, this.getSize().height)

    for (x <- 0 to 3) {
      for (y <- 0 to 3) {
        drawTile(graphics, TwoThousandFortyEight.grid.tiles(x + y * 4), x, y);
      }
    }
  }

  private def drawTile(graphics2: Graphics, tile: Tile, x: Int, y: Int): Unit = {
    val graphics = graphics2.asInstanceOf[Graphics2D]

    graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
    graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE)

    val valueOfTile = tile.value
    graphics.setColor(getBackGroundColor(tile))
    val xO = x * (TILES_BORDER + TILE_SIZE) + TILES_BORDER
    val yO = y * (TILES_BORDER + TILE_SIZE) + TILES_BORDER
    graphics.fillRoundRect(xO, yO, TILE_SIZE, TILE_SIZE, 28, 28)
    graphics.setColor(getForegroundColor(tile))

    val size = if (valueOfTile < 100) 72 else if (valueOfTile < 1000) 64 else 58
    val font = new Font(FONT_NAME, Font.BOLD, size)
    graphics.setFont(font)

    val valueString = String.valueOf(valueOfTile)
    val fontMetrics = getFontMetrics(font)
    val stringWidth = fontMetrics.stringWidth(valueString)
    val stringHeight = -fontMetrics.getLineMetrics(valueString, graphics).getBaselineOffsets()(2).asInstanceOf[Int]

    if (!tile.isEmpty) {
      graphics.drawString(valueString, xO + (TILE_SIZE - stringWidth) / 2, yO + TILE_SIZE - (TILE_SIZE - stringHeight) / 2 - 2)
    }

    if (TwoThousandFortyEight.win || TwoThousandFortyEight.lose) {
      graphics.setColor(new Color(255, 255, 255, 40))
      graphics.fillRect(0, 0, getWidth, getHeight)
      graphics.setColor(new Color(0xFF0000))
      graphics.setFont(new Font(FONT_NAME, Font.BOLD, 96))

      if (TwoThousandFortyEight.win) {
        graphics.drawString("You won!", 136, 300)
      }

      if (TwoThousandFortyEight.lose) {
        graphics.drawString("Game over!", 90, 260)
        graphics.drawString("You lost!", 140, 400)
      }

      if (TwoThousandFortyEight.win || TwoThousandFortyEight.lose) {
        graphics.setFont(new Font(FONT_NAME, Font.PLAIN, 32))
        graphics.setColor(new Color(0x545454))
        graphics.drawString("Press ESC to exit!", 200, getHeight - 80)
      }
    }

    graphics.setFont(new Font(FONT_NAME, Font.PLAIN, 32))
    graphics.setColor(new Color(0x545454))
    graphics.drawString("Score: " + TwoThousandFortyEight.score.value, 400, 740)
    graphics.drawString(this.player.name, 70, 740)
  }

  def getForegroundColor(tile: Tile): Color = {
    return new Color(0xededed)
  }

  def getBackGroundColor(tile: Tile): Color = {
    tile.value match {
      case 2 =>
        return new Color(0xc6d100)
      case 4 =>
        return new Color(0xaed100)
      case 8 =>
        return new Color(0x7dd100)
      case 16 =>
        return new Color(0x50d100)
      case 32 =>
        return new Color(0x00d1a0)
      case 64 =>
        return new Color(0x005ad1)
      case 128 =>
        return new Color(0x4c00d1)
      case 256 =>
        return new Color(0xb500d1)
      case 512 =>
        return new Color(0xd10099)
      case 1024 =>
        return new Color(0xd1005e)
      case 2048 =>
        return new Color(0xd10000)
      case _ =>
        return new Color(0x707070)
    }
  }
}
