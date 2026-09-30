package info.gianlucacosta.chronos.interpreter.atoms


case object PlusInfAtom extends InfinityAtom {
  override val sign: Int = +1


  override def unary_-(): Atom = MinusInfAtom

  override def +(right: Atom): Atom =
    right match {
      case DoubleAtom(_) | IntAtom(_) => PlusInfAtom
      case PlusInfAtom => PlusInfAtom
      case StringAtom(rightString) => StringAtom(this.toString + rightString)
      case _ => super.+(right)
    }


  override def -(right: Atom): Atom =
    right match {
      case DoubleAtom(_) | IntAtom(_) => PlusInfAtom
      case MinusInfAtom => PlusInfAtom
      case _ => super.-(right)

    }


  override def compare(right: Atom): Int =
    right match {
      case DoubleAtom(rightDouble: Double) => +1
      case IntAtom(rightInt: Int) => +1
      case PlusInfAtom => 0
      case MinusInfAtom => +1
      case _ => super.compare(right)
    }


  override def toString = "∞"
}
