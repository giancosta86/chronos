package info.gianlucacosta.chronos.ast.statements

import info.gianlucacosta.chronos.ast.{AstVisitor, Reference, Statement}

case class CreateEntity(entityType: String, reference: Option[Reference], lineNumber: Int) extends Statement {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}