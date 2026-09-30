package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.interpreter.atoms.Atom

class IllegalUnaryOperandException(operation: String, target: Atom) extends ExecutionException(
  s"Invalid operand for '${operation}': '${target}'"
)
