package info.gianlucacosta.chronos.interpreter.queues

import info.gianlucacosta.chronos.interpreter.atoms.Entity

private[interpreter] trait EntityQueue {
  def enqueue(entity: Entity)

  def dequeue(): Entity

  def remove(entity: Entity)

  def isEmpty: Boolean
}
