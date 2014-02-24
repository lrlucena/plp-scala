package plp.expressions1.util

import plp.expressions1.expression.{ExpAnd, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, Expressao, Valor, ValorBooleano, ValorConcreto, ValorInteiro, ValorString}

class VisitorAvaliar extends Visitor[Valor] {

  private def valor[T](e: Expressao) = v(e).asInstanceOf[ValorConcreto[T]].valor

  def visit(expr: ExpConcat) = {
    val esq: String = valor(expr.esq)
    val dir: String = valor(expr.dir)
    ValorString(esq + dir)
  }

  def visit(expr: ExpEquals) = {
    val esq: Any = valor(expr.esq)
    val dir: Any = valor(expr.dir)
    ValorBooleano(esq == dir)
  }

  def visit(expr: ExpLength) = {
    val exp: String = valor(expr.exp)
    ValorInteiro(exp.length)
  }

  def visit(expr: ExpMenos) = {
    val exp: Int = valor(expr.exp)
    ValorInteiro(-exp)
  }

  def visit(expr: ExpNot) = {
    val exp: Boolean = valor(expr.exp)
    ValorBooleano(!exp)
  }

  def visit(expr: ExpAnd) = {
    val esq: Boolean = valor(expr.esq)
    val dir: Boolean = valor(expr.dir)
    ValorBooleano(esq && dir)
  }

  def visit(expr: ExpOr) = {
    val esq: Boolean = valor(expr.esq)
    val dir: Boolean = valor(expr.dir)
    ValorBooleano(esq || dir)
  }

  def visit(expr: ExpSoma) = {
    val esq: Int = valor(expr.esq)
    val dir: Int = valor(expr.dir)
    ValorInteiro(esq + dir)
  }

  def visit(expr: ExpSub) = {
    val esq: Int = valor(expr.esq)
    val dir: Int = valor(expr.dir)
    ValorInteiro(esq - dir)
  }

  def visit(valorBooleano: ValorBooleano) = valorBooleano
  def visit(valorInteiro: ValorInteiro) = valorInteiro
  def visit(valorString: ValorString) = valorString
}
