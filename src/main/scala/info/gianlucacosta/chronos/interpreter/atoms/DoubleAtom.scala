package info.gianlucacosta.chronos.interpreter.atoms


case class DoubleAtom(value: Double) extends ImmutableAtom {
  override def unary_-(): Atom = DoubleAtom(-value)

  override def +(right: Atom): Atom =
    right match {
      case DoubleAtom(rightDouble) => DoubleAtom(value + rightDouble)
      case IntAtom(rightInt) => DoubleAtom(value + rightInt)
      case PlusInfAtom => PlusInfAtom
      case MinusInfAtom => MinusInfAtom
      case StringAtom(rightString) => StringAtom(value.toString + rightString)
      case _ => super.+(right)
    }

  override def -(right: Atom): Atom =
    right match {
      case DoubleAtom(rightDouble) => DoubleAtom(value - rightDouble)
      case IntAtom(rightInt) => DoubleAtom(value - rightInt)
      case PlusInfAtom => MinusInfAtom
      case MinusInfAtom => PlusInfAtom
      case _ => super.-(right)
    }

  override def *(right: Atom): Atom =
    right match {
      case DoubleAtom(rightDouble) =>
        DoubleAtom(value * rightDouble)

      case IntAtom(rightInt) =>
        DoubleAtom(value * rightInt)

      case inf: InfinityAtom =>
        InfinityAtom.fromSign(Math.signum(value) * inf.sign)

      case _ => super.*(right)
    }

  override def /(right: Atom): Atom =
    right match {
      case DoubleAtom(0) =>
        InfinityAtom.fromSign(value)

      case DoubleAtom(rightDouble) =>
        DoubleAtom(value / rightDouble)

      case IntAtom(0) =>
        InfinityAtom.fromSign(value)

      case IntAtom(rightInt) =>
        DoubleAtom(value / rightInt)

      case inf: InfinityAtom => DoubleAtom(0)

      case _ => super./(right)
    }


  override def compare(right: Atom): Int =
    right match {
      case DoubleAtom(rightDouble: Double) => value compareTo rightDouble
      case IntAtom(rightInt: Int) => value compareTo rightInt
      case PlusInfAtom => -1
      case MinusInfAtom => +1
      case _ => super.compare(right)
    }


  override def toDoubleAtom: DoubleAtom = this

  override def toIntAtom: IntAtom = IntAtom(value.toInt)

  override def toBooleanAtom: BooleanAtom = BooleanAtom(value != 0)


  override def getFloor: IntAtom = IntAtom(math.floor(value).toInt)

  override def getCeil: IntAtom = IntAtom(math.ceil(value).toInt)


  override def toString: String = value.toString
}
