package info.gianlucacosta.chronos.interpreter.exceptions

import info.gianlucacosta.chronos.interpreter.atoms.HeapAtom

class MissedDeallocationException(val heapAtoms: Iterable[HeapAtom]) extends HeapException(
{
  val messageBuilder = new StringBuilder
  messageBuilder.append("The following objects were not dellocated (use destroy to deallocate them):\n")


  heapAtoms.foreach(item => messageBuilder.append(s"${item}\n"))

  messageBuilder.toString()
}
)