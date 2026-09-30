package info.gianlucacosta.chronos.interpreter

import info.gianlucacosta.chronos.interpreter.atoms.{Atom, Entity, HeapAtom, StringAtom}
import info.gianlucacosta.chronos.interpreter.exceptions.{ExecutionException, IdentifierNotFoundException}
import info.gianlucacosta.chronos.interpreter.heap.HeapView


private class ContextFrame(heapView: HeapView, parentFrame: Option[ContextFrame]) {
  private var variables = Map.empty[String, Atom]
  private var _canRun = true


  def this(heapView: HeapView) = this(heapView, None)

  def canRun = _canRun

  def terminate(): Unit = {
    _canRun = false
  }


  def resolveReference(reference: RuntimeReference): Atom = {
    val identifier = reference.identifier

    reference.parameter match {
      case None =>
        resolveIdentifier(identifier)


      case Some(entity: Entity) =>
        val propertyValue = entity(StringAtom(identifier))
        checkAtomValidity(propertyValue)
        propertyValue


      case Some(key: Atom) =>
        val resolvedMap = resolveIdentifier(identifier)
        val retrievedValue = resolvedMap(key)
        checkAtomValidity(retrievedValue)
        retrievedValue

      case _ => throw new ExecutionException(s"Error while resolving the reference: '${reference}'")
    }
  }


  def setReference(reference: RuntimeReference, value: Atom): Unit = {
    val identifier = reference.identifier

    reference.parameter match {
      case None =>
        setIdentifier(identifier, value)

      case Some(entity: Entity) =>
        entity(StringAtom(identifier)) = value


      case Some(key: Atom) =>
        val resolvedMap = resolveIdentifier(identifier)
        resolvedMap(key) = value

      case _ => throw new ExecutionException(s"Error while resolving the reference: '${reference}'")
    }
  }


  def removeReference(reference: RuntimeReference): Unit = {
    val identifier = reference.identifier

    reference.parameter match {
      case None =>
        removeIdentifier(identifier)

      case Some(entity: Entity) =>
        entity -= StringAtom(identifier)

      case Some(key: Atom) =>
        val resolvedMap = resolveIdentifier(identifier)
        resolvedMap -= key
    }
  }


  private def resolveIdentifier(identifier: String): Atom = {
    val resolvedAtom = variables.get(identifier)

    if (resolvedAtom.isDefined) {
      checkAtomValidity(resolvedAtom.get)
      resolvedAtom.get
    } else if (parentFrame.isDefined) {
      parentFrame.get.resolveIdentifier(identifier)
    } else {
      throw new IdentifierNotFoundException(identifier)
    }
  }


  private def setIdentifier(identifier: String, atom: Atom): Unit = {
    variables += (identifier -> atom)
  }


  private def removeIdentifier(identifier: String): Unit = {
    if (!variables.contains(identifier)) {
      if (parentFrame.isDefined) {
        parentFrame.get.removeIdentifier(identifier)
      } else {
        throw new IdentifierNotFoundException(identifier)
      }
    } else {
      variables -= identifier
    }
  }


  private def checkAtomValidity(atom: Atom): Unit = {
    atom match {
      case heapAtom: HeapAtom =>
        heapView.assertAtomValidity(heapAtom)

      case _ =>
    }
  }
}