package info.gianlucacosta.chronos.interpreter.exceptions

class ExecutionException(message: String, cause: Throwable) extends RuntimeException(message, cause) {
  def this(message: String) = this(message, null)
}
