package info.gianlucacosta.chronos.ast.expressions

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression}

case class Or(operands: Seq[Expression]) extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
