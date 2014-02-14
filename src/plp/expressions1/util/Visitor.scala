package plp.expressions1.util

import plp.expressions1.expression.{ExpAnd, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, Expressao, ValorBooleano, ValorInteiro, ValorString}

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
  def v: PartialFunction[Expressao, T] = {
    case a: ExpAnd        => visit(a)
    case a: ExpOr         => visit(a)
    case a: ExpSoma       => visit(a)
    case a: ExpSub        => visit(a)
    case a: ExpConcat     => visit(a)
    case a: ExpEquals     => visit(a)
    case a: ExpLength     => visit(a)
    case a: ExpMenos      => visit(a)
    case a: ExpNot        => visit(a)
    case a: ValorInteiro  => visit(a)
    case a: ValorString   => visit(a)
    case a: ValorBooleano => visit(a)
  }
}