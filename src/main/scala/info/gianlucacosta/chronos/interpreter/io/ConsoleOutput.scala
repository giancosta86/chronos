package info.gianlucacosta.chronos.interpreter.io

import info.gianlucacosta.chronos.interpreter.Output
import info.gianlucacosta.chronos.interpreter.atoms.Atom
import info.gianlucacosta.chronos.interpreter.exceptions.StatementFailedException

class ConsoleOutput extends Output {
  override def print(atom: Atom): Unit = {
    System.out.print(atom)
  }

  override def println(atom: Atom): Unit = {
    System.out.println(atom)
  }

  override def printException(exception: Exception): Unit = {
    exception match {
      case _: StatementFailedException => System.err.println(exception.getMessage)
      case _ => exception.printStackTrace(System.err)
    }

    System.exit(1)
  }
}
