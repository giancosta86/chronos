package info.gianlucacosta.chronos.parser

import info.gianlucacosta.chronos.parser.exceptions.SyntaxException
import org.antlr.v4.runtime._

class SyntaxErrorListener extends BaseErrorListener {
  override def syntaxError(recognizer: Recognizer[_, _], offendingSymbol: scala.Any, line: Int, charPositionInLine: Int, msg: String, e: RecognitionException): Unit =
    throw new SyntaxException(line, charPositionInLine, msg, offendingSymbol, e)
}
