package info.gianlucacosta.chronos.ast.exceptions

class DuplicateProcedureException(val procedureName: String) extends DuplicateIdentifierException(
  s"Duplicate procedure: '${procedureName}'"
)