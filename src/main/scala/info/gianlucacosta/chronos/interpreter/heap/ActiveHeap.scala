package info.gianlucacosta.chronos.interpreter.heap

import info.gianlucacosta.chronos.interpreter.atoms.HeapAtom
import info.gianlucacosta.chronos.interpreter.exceptions.{HeapException, MissedDeallocationException}

import scala.collection.mutable

private[interpreter] class ActiveHeap extends Heap {
  private val allocatedAtoms = new mutable.HashSet[HeapAtom]()


  def assertAtomValidity(atom: HeapAtom) {
    if (!allocatedAtoms.contains(atom)) {
      throw new HeapException(s"${atom} has already been deallocated")
    }
  }


  override def assertEmpty(): Unit = {
    if (allocatedAtoms.nonEmpty) {
      throw new MissedDeallocationException(allocatedAtoms)
    }
  }

  def allocate(atom: HeapAtom): Unit = {
    allocatedAtoms += atom
  }


  def deallocate(atom: HeapAtom): Unit = {
    allocatedAtoms -= atom
  }

  override def isEmpty: Boolean = allocatedAtoms.isEmpty
}
