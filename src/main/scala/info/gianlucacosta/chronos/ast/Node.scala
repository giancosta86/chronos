package info.gianlucacosta.chronos.ast

abstract class Node {
  def accept[T](visitor: AstVisitor[T]): T
}
