package info.gianlucacosta.chronos.ast.expressions.ground

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression}

final case class BooleanTerm(value: Boolean) extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
