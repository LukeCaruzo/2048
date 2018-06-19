package de.htwg.se.twothousandfortyeight

import com.google.inject.AbstractModule
import de.htwg.se.twothousandfortyeight.model.fileIoModel.{FileIoTrait, fileIoXmlImpl}
import de.htwg.se.twothousandfortyeight.model.gameModel.GameTrait
import de.htwg.se.twothousandfortyeight.model.gameModel.TileTrait

import de.htwg.se.twothousandfortyeight.model.gameModel.gameBaseImpl
import net.codingwell.scalaguice.ScalaModule;

class TwoThousandFortyEightModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    bind[GameTrait].to[gameBaseImpl.Game]
    bind[TileTrait].to[gameBaseImpl.Tile]
    bind[FileIoTrait].to[fileIoXmlImpl.FileIo]
  }
}
