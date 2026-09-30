package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.interpreter.atoms.Atom

class MapKeyNotFoundException(index: Atom) extends ExecutionException(
  s"Map key '${index}' not found"
)
