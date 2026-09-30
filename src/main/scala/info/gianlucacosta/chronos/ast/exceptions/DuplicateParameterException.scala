package info.gianlucacosta.chronos.ast.exceptions

class DuplicateParameterException(val procedureName: String, val param: String) extends DuplicateIdentifierException(
  s"Duplicate parameter '${param}' for procedure '${procedureName}'"
)
