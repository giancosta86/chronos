package info.gianlucacosta.chronos.ast.expressions.ground

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression}

sealed abstract class PlusInfTerm extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}


case object PlusInfTerm extends PlusInfTerm