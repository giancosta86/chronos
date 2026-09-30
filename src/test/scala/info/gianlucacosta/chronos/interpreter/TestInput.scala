package info.gianlucacosta.chronos.interpreter

import info.gianlucacosta.chronos.interpreter.atoms.{BooleanAtom, DoubleAtom, IntAtom, StringAtom}

class TestInput(
                 private var doubles: Seq[Double],
                 private var ints: Seq[Int],
                 private var booleans: Seq[Boolean],
                 private var strings: Seq[String]) extends Input {
  def this() = this(Nil, Nil, Nil, Nil)

  override def readDouble(prompt: String): DoubleAtom = {
    val result = DoubleAtom(doubles.head)
    doubles = doubles.tail
    result
  }

  override def readInt(prompt: String): IntAtom = {
    val result = IntAtom(ints.head)
    ints = ints.tail
    result
  }


  override def readBoolean(prompt: String): BooleanAtom = {
    val result = BooleanAtom(booleans.head)
    booleans = booleans.tail
    result
  }


  override def readString(prompt: String): StringAtom = {
    val result = StringAtom(strings.head)
    strings = strings.tail
    result
  }
}
