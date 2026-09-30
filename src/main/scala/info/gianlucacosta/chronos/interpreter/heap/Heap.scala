package info.gianlucacosta.chronos.interpreter.heap

import info.gianlucacosta.chronos.interpreter.atoms.HeapAtom

private[interpreter] trait Heap extends HeapView {
  def allocate(atom: HeapAtom): Unit

  def deallocate(atom: HeapAtom): Unit
}
