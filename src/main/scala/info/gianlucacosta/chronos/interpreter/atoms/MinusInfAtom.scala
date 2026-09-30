package info.gianlucacosta.chronos.interpreter.atoms


case object MinusInfAtom extends InfinityAtom {
  override val sign: Int = -1


  override def unary_-(): Atom = PlusInfAtom

  override def +(right: Atom): Atom =
    right match {
      case DoubleAtom(_) | IntAtom(_) => MinusInfAtom
      case MinusInfAtom => MinusInfAtom
      case StringAtom(rightString) => StringAtom(this.toString + rightString)
      case _ => super.+(right)
    }


  override def -(right: Atom): Atom =
    right match {
      case DoubleAtom(_) | IntAtom(_) => MinusInfAtom
      case PlusInfAtom => MinusInfAtom
      case _ => super.-(right)
    }


  override def compare(right: Atom): Int =
    right match {
      case DoubleAtom(rightDouble: Double) => -1
      case IntAtom(rightInt: Int) => -1
      case PlusInfAtom => -1
      case MinusInfAtom => 0
      case _ => super.compare(right)
    }


  override def toString = "-∞"
}
