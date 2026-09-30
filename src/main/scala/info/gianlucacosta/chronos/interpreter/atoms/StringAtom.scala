package info.gianlucacosta.chronos.interpreter.atoms

case object StringAtom {
  val Empty = StringAtom("")
}


case class StringAtom(value: String) extends ImmutableAtom {
  override def +(right: Atom): Atom = StringAtom(value + right.toString)

  override def compare(right: Atom): Int =
    right match {
      case StringAtom(rightString) => value compareTo rightString
      case _ => super.compare(right)
    }


  override def toDoubleAtom: DoubleAtom = DoubleAtom(value.toDouble)

  override def toIntAtom: IntAtom = IntAtom(value.toInt)

  override def toBooleanAtom: BooleanAtom = BooleanAtom(if (value == BooleanAtom.TrueString) true else false)

  override def toStringAtom: StringAtom = this


  override def toString: String = value.toString
}
