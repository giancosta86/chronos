package info.gianlucacosta.chronos.ast.expressions

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression, Reference}

case class ReferenceValue(reference: Reference) extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
