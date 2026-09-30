package info.gianlucacosta.chronos.ast.expressions

object ComparisonOperator {

  case object Less extends ComparisonOperator("<")

  case object LessEqual extends ComparisonOperator("<=")

  case object Greater extends ComparisonOperator(">")

  case object GreaterEqual extends ComparisonOperator(">=")

  case object Equal extends ComparisonOperator("=")

  case object NotEqual extends ComparisonOperator("!=")

}


sealed abstract class ComparisonOperator(operator: String) {
  override def toString = operator
}