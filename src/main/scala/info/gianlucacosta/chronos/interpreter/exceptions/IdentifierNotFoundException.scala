package info.gianlucacosta.chronos.interpreter.exceptions

class IdentifierNotFoundException(val identifier: String) extends ExecutionException(
  s"Identifier '${identifier}' not found"
)