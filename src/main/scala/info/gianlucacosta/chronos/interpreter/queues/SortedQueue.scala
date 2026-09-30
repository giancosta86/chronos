package info.gianlucacosta.chronos.interpreter.queues

import info.gianlucacosta.chronos.ast.SortOrder
import info.gianlucacosta.chronos.interpreter.atoms.{Entity, StringAtom}

import scala.collection.mutable

private[interpreter] class SortedQueue(propertyName: String, sortOrder: SortOrder.Type) extends EntityQueue {

  private case class QueueItem(entity: Entity) extends Ordered[QueueItem] {
    override def compare(that: QueueItem): Int = {
      val thisPropertyValue = entity(StringAtom(propertyName))
      val thatPropertyValue = that.entity(StringAtom(propertyName))

      val ascendingComparisonResult = thisPropertyValue.compare(thatPropertyValue)

      if (sortOrder == SortOrder.Asc)
        ascendingComparisonResult
      else
        -ascendingComparisonResult
    }
  }

  private val internalSet = mutable.TreeSet.empty[QueueItem]

  override def enqueue(entity: Entity): Unit = {
    internalSet += new QueueItem(entity)
  }

  override def dequeue(): Entity = {
    val resultItem = internalSet.head
    internalSet -= resultItem

    resultItem.entity
  }

  override def remove(entity: Entity): Unit = {
    internalSet.remove(QueueItem(entity))
  }

  override def isEmpty: Boolean = internalSet.isEmpty
}
