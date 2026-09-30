package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.ast.Statement

class StatementFailedException(val statement: Statement, cause: Throwable) extends ExecutionException(
  s"Line: ${statement.lineNumber} - ${cause.getMessage}",

  cause
)
