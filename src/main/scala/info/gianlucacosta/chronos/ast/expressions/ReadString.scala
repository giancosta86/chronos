package info.gianlucacosta.chronos.ast.expressions

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression, Reference, Statement}

case class ReadString(prompt: Expression, lineNumber: Int) extends Expression {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
