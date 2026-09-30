package info.gianlucacosta.chronos.ast

import info.gianlucacosta.chronos.ast.exceptions.DuplicateParameterException


case class Procedure(name: String, params: Seq[String], block: Block) extends Node {
  {
    var uniqueParams = Set.empty[String]

    for (param <- params) {
      if (uniqueParams.contains(param)) {
        throw new DuplicateParameterException(name, param)
      }

      uniqueParams += param
    }
  }

  override def accept[T](visitor: AstVisitor[T]): T =
    visitor.visit(this)
}