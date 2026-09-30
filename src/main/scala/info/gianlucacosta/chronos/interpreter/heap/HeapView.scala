package info.gianlucacosta.chronos.interpreter.heap

import info.gianlucacosta.chronos.interpreter.atoms.HeapAtom

private[interpreter] trait HeapView {
  def assertAtomValidity(atom: HeapAtom)

  def assertEmpty(): Unit

  def isEmpty: Boolean
}
