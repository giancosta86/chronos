package info.gianlucacosta.chronos.interpreter.queues

import info.gianlucacosta.chronos.interpreter.atoms.Entity

import scala.collection.mutable.ListBuffer


private[interpreter] class FifoQueue extends EntityQueue {
  private val internalQueue = ListBuffer.empty[Entity]

  override def enqueue(entity: Entity): Unit = {
    internalQueue += entity
  }

  override def dequeue(): Entity = {
    internalQueue.remove(0)
  }

  override def remove(entity: Entity): Unit = {
    internalQueue -= entity
  }

  override def isEmpty: Boolean =
    internalQueue.isEmpty
}
