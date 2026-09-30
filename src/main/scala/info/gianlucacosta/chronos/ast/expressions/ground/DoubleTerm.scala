package info.gianlucacosta.chronos.ast.expressions.ground

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression}

final case class DoubleTerm(value: Double) extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
