package info.gianlucacosta.chronos.ast.statements

import info.gianlucacosta.chronos.ast.expressions.Condition
import info.gianlucacosta.chronos.ast.{AstVisitor, Block, Statement}

case class While(condition: Condition, block: Block, lineNumber: Int) extends Statement {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
