package info.gianlucacosta.chronos.interpreter.atoms

import info.gianlucacosta.chronos.ast.Event

class EventNotice(name: String, val event: Event) extends Entity(name, event.name) {
  override def toString =
    s"Event notice '${name}' for event '${event.name}' {${properties.mkString(",")}}"
}
