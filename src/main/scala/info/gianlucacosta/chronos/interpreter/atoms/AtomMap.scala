package info.gianlucacosta.chronos.interpreter.atoms

import info.gianlucacosta.chronos.interpreter.exceptions.{IllegalIndexTypeException, MapKeyNotFoundException}

class AtomMap extends Atom {
  var internalMap = Map.empty[Atom, Atom]

  override def apply(key: Atom): Atom = {
    key match {
      case _: ImmutableAtom =>
        internalMap.getOrElse(
          key,

          throw new MapKeyNotFoundException(key)
        )

      case _ => throw new IllegalIndexTypeException(s"Invalid key: '${key}'")
    }
  }


  override def update(key: Atom, value: Atom): Unit = {
    key match {
      case _: ImmutableAtom =>
        internalMap += (key -> value)

      case _ => throw new IllegalIndexTypeException(s"Invalid key: '${key}'")
    }
  }


  override def -=(key: Atom): Unit = {
    key match {
      case _: ImmutableAtom =>
        if (!internalMap.contains(key)) {
          throw new MapKeyNotFoundException(key)
        }
        internalMap -= key

      case _ => throw new IllegalIndexTypeException(s"Invalid key: '${key}'")
    }
  }

  override def toString = s"Map(${internalMap.mkString(",")})"
}
