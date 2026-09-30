package info.gianlucacosta.chronos.ast

case class Event(name: String, block: Block) extends Node {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
