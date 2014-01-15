package plp.expressions1.util

import plp.expressions1.expression._

trait Visitor[T] {
  def visit(expAnd: ExpAnd): T
  def visit(expConcat: ExpConcat): T
  def visit(expEquals: ExpEquals): T
  def visit(expLength: ExpLength): T
  def visit(expMenos: ExpMenos): T
  def visit(expNot: ExpNot): T
  def visit(expOr: ExpOr): T
  def visit(expSoma: ExpSoma): T
  def visit(expSub: ExpSub): T
  def visit(valor: ValorBooleano): T
  def visit(valor: ValorInteiro): T
  def visit(valor: ValorString): T
}
