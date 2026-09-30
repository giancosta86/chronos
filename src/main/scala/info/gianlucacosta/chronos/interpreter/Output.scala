package info.gianlucacosta.chronos.interpreter

import info.gianlucacosta.chronos.interpreter.atoms.Atom

trait Output {
  def print(atom: Atom)

  def println(atom: Atom)

  def printException(exception: Exception)
}
