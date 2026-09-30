package info.gianlucacosta.chronos.parser.exceptions

import org.antlr.v4.runtime.RecognitionException

class SyntaxException(
                       val line: Int,
                       val charPositionInLine: Int,
                       val errorMessage: String,
                       val offendingSymbol: Any,
                       val recognitionException: RecognitionException) extends ParsingException(
  s"Syntax error at line ${line}, position: ${charPositionInLine}: ${errorMessage} "
)
