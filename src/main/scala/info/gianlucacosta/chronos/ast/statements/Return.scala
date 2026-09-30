package info.gianlucacosta.chronos.ast.statements

import info.gianlucacosta.chronos.ast.{AstVisitor, Statement}


case class Return(lineNumber: Int) extends Statement {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
