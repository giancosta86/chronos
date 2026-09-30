package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.interpreter.atoms.Atom

class PropertyNotFoundException(val property: Atom) extends ExecutionException(
  s"Property '${property}' not found"
)