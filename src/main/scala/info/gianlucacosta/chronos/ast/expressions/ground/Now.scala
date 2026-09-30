package info.gianlucacosta.chronos.ast.expressions.ground

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression}

sealed abstract class Now extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}

case object Now extends Now
