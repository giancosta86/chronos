package info.gianlucacosta.chronos.interpreter.atoms

object InfinityAtom {
  def fromSign(sign: Double): InfinityAtom =
    if (sign > 0) {
      PlusInfAtom
    } else if (sign < 0) {
      MinusInfAtom
    } else {
      throw new IllegalArgumentException("Inf without sign demanded (for example, in ∞ * 0)")
    }
}


trait InfinityAtom extends ImmutableAtom {
  val sign: Int

  override def unary_-(): Atom = InfinityAtom.fromSign(-sign)

  override def *(right: Atom): Atom =
    right match {
      case DoubleAtom(rightDouble) =>
        InfinityAtom.fromSign(this.sign * Math.signum(rightDouble))

      case IntAtom(rightInt) =>
        InfinityAtom.fromSign(this.sign * Math.signum(rightInt))

      case rightInf: InfinityAtom =>
        InfinityAtom.fromSign(this.sign * rightInf.sign)

      case _ => super.*(right)

    }


  override def /(right: Atom): Atom =
    right match {
      case DoubleAtom(rightDouble) =>
        InfinityAtom.fromSign(this.sign * Math.signum(rightDouble))

      case IntAtom(rightInt) =>
        InfinityAtom.fromSign(this.sign * Math.signum(rightInt))


      case _ => super./(right)
    }

  override def toBooleanAtom: BooleanAtom = BooleanAtom(true)
}
