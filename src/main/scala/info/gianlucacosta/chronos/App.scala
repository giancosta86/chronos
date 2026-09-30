package info.gianlucacosta.chronos

import java.io.{File, FileReader}

import info.gianlucacosta.chronos.interpreter.Interpreter
import info.gianlucacosta.chronos.interpreter.io.{ConsoleInput, ConsoleOutput}
import info.gianlucacosta.chronos.parser.BasicAstBuilder
import info.gianlucacosta.chronos.parser.exceptions.ParsingException


object App {
  def main(args: Array[String]): Unit = {
    if (args.length != 1) {
      exitWithUsage()
    }

    val sourceFile = new File(args(0))
    if (!sourceFile.exists()) {
      exitWithUsage()
    }


    try {
      val program = BasicAstBuilder.buildAST(new FileReader(sourceFile))

      val input = new ConsoleInput
      val output = new ConsoleOutput
      val interpreter = new Interpreter(input, output)

      interpreter.run(program)
      System.exit(0)
    } catch {
      case ex@(_: ParsingException) => System.err.println(ex.getMessage)
        System.exit(1)
    }
  }


  private def exitWithUsage(): Unit = {
    println(s"${ArtifactInfo.name} - Version ${ArtifactInfo.version}")
    println(s"Copyright © ${ArtifactInfo.copyrightYears} Gianluca Costa")
    println()
    println(s"Usage: <program source file>")
    System.exit(1)
  }
}
