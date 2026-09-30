package info.gianlucacosta.chronos.interpreter.atoms

import info.gianlucacosta.chronos.interpreter.exceptions.{IllegalIndexTypeException, PropertyNotFoundException}

class Entity(val name: String, val entityType: String) extends Atom with HeapAtom {
  protected var properties = Map.empty[String, Atom]


  override def compare(right: Atom): Int = {
    right match {
      case rightEntity: Entity =>
        System.identityHashCode(this) compare System.identityHashCode(rightEntity)

      case _ => super.compare(right)
    }
  }

  override def apply(property: Atom): Atom = {
    property match {
      case StringAtom(propertyName) =>
        properties.getOrElse(
          propertyName,

          throw new PropertyNotFoundException(property)
        )

      case _ => throw new IllegalIndexTypeException(s"Invalid value for property name: '${property}'")
    }
  }

  override def update(property: Atom, value: Atom): Unit = {
    property match {
      case StringAtom(propertyName) =>
        properties += (propertyName -> value)

      case _ => throw new IllegalIndexTypeException(s"Invalid value for property name: '${property}'")
    }
  }


  override def -=(property: Atom): Unit = {
    property match {
      case StringAtom(propertyName) =>
        if (!properties.contains(propertyName)) {
          throw new PropertyNotFoundException(property)
        }
        properties -= propertyName

      case _ => throw new IllegalIndexTypeException(s"Invalid property name: '${property}'")
    }
  }


  override def toString =
    s"Entity(name: ${name}, type: ${entityType}) {${properties.mkString(",")}}"
}
