package info.gianlucacosta.chronos.interpreter.exceptions

class ProcedureNotFoundException(procedureName: String) extends ExecutionException(
  s"Procedure '${procedureName}' not found"
)
