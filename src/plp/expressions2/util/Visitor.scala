package plp.expressions2.util

import plp.expressions1.util.{Visitor => VisitorE1}
import plp.expressions2.expression.ExpDeclaracao
import plp.expressions2.expression.Id

trait Visitor[T] extends VisitorE1[T] {
  def visit(expression: ExpDeclaracao): T
  def visit(expression: Id): T
  override def v = super.v.orElse{
    case a: ExpDeclaracao => visit(a)
    case a: Id => visit(a)
  }
}
