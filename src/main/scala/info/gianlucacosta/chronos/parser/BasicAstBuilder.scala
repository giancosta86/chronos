package info.gianlucacosta.chronos.parser

import java.io.{Reader, StringReader}

import info.gianlucacosta.chronos.ast.Program
import org.antlr.v4.runtime._

/**
 * Provides basic functions to create an AST from source code.
 *
 * For more granular control, please consider AstBuildingVisitor.
 *
 */
object BasicAstBuilder {
  def buildAST(sourceReader: Reader): Program = {
    val charStream = new ANTLRInputStream(sourceReader)
    val lexer = new ChronosLexer(charStream)
    val tokenStream = new CommonTokenStream(lexer)

    val parser = new ChronosParser(tokenStream)

    lexer.removeErrorListeners()
    parser.removeErrorListeners()
    parser.addErrorListener(new SyntaxErrorListener)

    val programContext = parser.program()

    val astBuildingVisitor = new AstBuildingVisitor
    astBuildingVisitor.visitProgram(programContext)
  }


  def buildAST(sourceString: String): Program = {
    buildAST(new StringReader(sourceString))
  }
}
