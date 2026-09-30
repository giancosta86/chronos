package info.gianlucacosta.chronos.interpreter.heap

import info.gianlucacosta.chronos.interpreter.atoms.HeapAtom

private[interpreter] class DisabledHeap extends Heap {
  override def allocate(atom: HeapAtom): Unit = {}

  override def deallocate(atom: HeapAtom): Unit = {}

  override def assertAtomValidity(atom: HeapAtom): Unit = {}

  override def assertEmpty(): Unit = {}

  override def isEmpty: Boolean = true
}
