package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.ast.{Expression, Procedure}

class IllegalCallException(val procedure: Procedure, val arguments: Seq[Expression]) extends ExecutionException(
  s"Procedure '${procedure.name}' expects ${procedure.params.size} parameters, not ${arguments.size}"
)