package info.gianlucacosta.chronos.ast


case class Block(statements: Seq[Statement]) extends Node {
  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}
