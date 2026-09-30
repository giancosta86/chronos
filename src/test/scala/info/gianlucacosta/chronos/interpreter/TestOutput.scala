package info.gianlucacosta.chronos.interpreter

import info.gianlucacosta.chronos.interpreter.atoms.Atom

class TestOutput extends Output {
  var currentLine = ""

  var _outputLines = Seq.empty[String]


  override def print(atom: Atom): Unit = {
    val stringValue = atom.toString
    currentLine += stringValue
  }


  override def println(atom: Atom): Unit = {
    val stringValue = atom.toString

    _outputLines :+= (currentLine + stringValue)
    currentLine = ""
  }


  override def printException(exception: Exception): Unit = {
    throw exception
  }

  def outputLines = _outputLines
}
