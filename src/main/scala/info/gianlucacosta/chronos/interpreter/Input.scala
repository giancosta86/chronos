package info.gianlucacosta.chronos.interpreter

import info.gianlucacosta.chronos.interpreter.atoms._

trait Input {
  def readInt(prompt: String): IntAtom

  def readDouble(prompt: String): DoubleAtom

  def readBoolean(prompt: String): BooleanAtom

  def readString(prompt: String): StringAtom
}
