package info.gianlucacosta.chronos.ast.statements

import info.gianlucacosta.chronos.ast.{AstVisitor, Expression, Reference, Statement}

case class ScheduleAfter(eventName: String, eventNoticeReference: Option[Reference], delay: Expression, lineNumber: Int) extends Statement {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
