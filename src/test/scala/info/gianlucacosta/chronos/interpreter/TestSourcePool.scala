package info.gianlucacosta.chronos.interpreter

import java.io.{InputStream, InputStreamReader}

import info.gianlucacosta.chronos.ast.Program
import info.gianlucacosta.chronos.parser.BasicAstBuilder

object TestSourcePool {
  def getProgram(programFileName: String): Program = {
    val sourceStream = new InputStreamReader(getProgramStream(programFileName))

    BasicAstBuilder.buildAST(sourceStream)
  }


  def getProgramStream(programFileName: String): InputStream =
    getClass.getResourceAsStream("programs/" + programFileName)
}
