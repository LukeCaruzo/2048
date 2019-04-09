package de.htwg.se.twothousandfortyeight

import com.google.inject.AbstractModule
import de.htwg.se.twothousandfortyeight.model.fileIoModel.{FileIoTrait, fileIoJsonImpl}
import net.codingwell.scalaguice.ScalaModule

class TwoThousandFortyEightModule extends AbstractModule with ScalaModule {
  override def configure(): Unit = {
    //bind[GameTrait].to[gameBaseImpl.Functions]
    bind[FileIoTrait].to[fileIoJsonImpl.FileIo]
  }
}
