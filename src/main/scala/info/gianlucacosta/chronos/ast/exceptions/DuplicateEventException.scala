package info.gianlucacosta.chronos.ast.exceptions

class DuplicateEventException(val eventName: String) extends DuplicateIdentifierException(
  s"Duplicate event: '${eventName}'"
)