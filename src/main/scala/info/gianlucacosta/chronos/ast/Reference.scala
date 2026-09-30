package info.gianlucacosta.chronos.ast

case class Reference(identifier: String, parameter: Option[Expression]) extends Node {
  def this(identifier: String) = this(identifier, None)

  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
