package info.gianlucacosta.chronos.interpreter

import info.gianlucacosta.chronos.interpreter.atoms.Atom

private class RuntimeReference(val identifier: String, val parameter: Option[Atom]) {
  def this(identifier: String) = this(identifier, None)

  override def toString: String = s"${identifier}${
    parameter.map(parameter => s"(${parameter})").getOrElse("")
  }"
}