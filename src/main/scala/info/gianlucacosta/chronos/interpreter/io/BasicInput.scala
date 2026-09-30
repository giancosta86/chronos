package info.gianlucacosta.chronos.interpreter.io

import info.gianlucacosta.chronos.interpreter.Input
import info.gianlucacosta.chronos.interpreter.atoms.{BooleanAtom, DoubleAtom, IntAtom}

/**
 * Simplifies input by implementing most functions in terms of readString(),
 * which remains abtract.
 */
abstract class BasicInput extends Input {
  override def readDouble(prompt: String): DoubleAtom = {
    var result: Option[DoubleAtom] = None

    while (result.isEmpty) {
      val inputString = readString(prompt)

      try {
        result = Some(inputString.toDoubleAtom)
      } catch {
        case _: Exception =>
      }
    }

    result.get
  }

  override def readInt(prompt: String): IntAtom = {
    var result: Option[IntAtom] = None

    while (result.isEmpty) {
      val inputString = readString(prompt)

      try {
        result = Some(inputString.toIntAtom)
      } catch {
        case _: Exception =>
      }
    }

    result.get
  }

  override def readBoolean(prompt: String): BooleanAtom = {
    var result: Option[BooleanAtom] = None

    while (result.isEmpty) {
      val inputString = readString(prompt)

      try {
        result = Some(inputString.toBooleanAtom)
      } catch {
        case _: Exception =>
      }
    }

    result.get
  }
}
