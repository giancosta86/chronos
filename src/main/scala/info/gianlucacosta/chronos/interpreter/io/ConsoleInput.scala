package info.gianlucacosta.chronos.interpreter.io

import java.io.{BufferedReader, InputStreamReader}

import info.gianlucacosta.chronos.interpreter.atoms.StringAtom
import info.gianlucacosta.chronos.interpreter.exceptions.FailedReadException

class ConsoleInput extends BasicInput {
  private val lineReader = new BufferedReader(new InputStreamReader(System.in))

  override def readString(prompt: String): StringAtom = {
    print(prompt)

    val line = lineReader.readLine()

    if (line == null) {
      throw new FailedReadException("Interrupted input")
    }

    StringAtom(line)
  }
}
