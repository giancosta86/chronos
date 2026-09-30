package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.interpreter.atoms.Atom

class IllegalBinaryOperandsException(operation: String, left: Atom, right: Atom) extends ExecutionException(
  s"Invalid operands for '${operation}': '${left}' and '${right}'"
)