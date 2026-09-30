package info.gianlucacosta.chronos.ast.statements

import info.gianlucacosta.chronos.ast.{AstVisitor, SortOrder, Statement}

case class CreateSortedQueue(queueName: String, propertyName: String, sortOrder: SortOrder.Value, lineNumber: Int) extends Statement {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
