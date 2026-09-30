package info.gianlucacosta.chronos.ast.statements

import info.gianlucacosta.chronos.ast._
import info.gianlucacosta.chronos.ast.expressions.Condition

case class If(condition: Condition, thenPart: Block, elsePart: Option[Node], lineNumber: Int) extends Statement {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
