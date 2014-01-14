package plp.expressions1.util

import plp.expressions1.expression._

class VisitorAvaliar extends Visitor[Valor] {
  private def vConcreto(e: Expressao) = e.accept(this).asInstanceOf[ValorConcreto]

  private def vString(e: Expressao) = e.accept(this).asInstanceOf[ValorString]

  private def vBooleano(e: Expressao) = e.accept(this).asInstanceOf[ValorBooleano]

  private def vInteiro(e: Expressao) = e.accept(this).asInstanceOf[ValorInteiro]

  def visit(expr: ExpConcat) = {
    val valorEsq = vString(expr.esq).valor
    val valorDir = vString(expr.dir).valor
    ValorString(valorEsq + valorDir)
  }

  def visit(expr: ExpEquals) = {
    val valorEsq: ValorConcreto = vConcreto(expr.esq)
    val valorDir: ValorConcreto = vConcreto(expr.dir)
    ValorBooleano(valorEsq == valorDir)
  }

  def visit(expr: ExpLength) = {
    val valorExp = vString(expr.exp).valor
    ValorInteiro(valorExp.length)
  }

  def visit(expr: ExpMenos) = {
    val valorExp = vInteiro(expr.exp).valor
    ValorInteiro(-valorExp)
  }

  def visit(expr: ExpNot) = {
    val valorExp = vBooleano(expr.exp).valor
    ValorBooleano(!valorExp)
  }

  def visit(expr: ExpAnd) = {
    val valorEsq = vBooleano(expr.esq).valor
    val valorDir = vBooleano(expr.dir).valor
    ValorBooleano(valorEsq && valorDir)
  }

  def visit(expr: ExpOr) = {
    val valorEsq = vBooleano(expr.esq).valor
    val valorDir = vBooleano(expr.dir).valor
    ValorBooleano(valorEsq || valorDir)
  }

  def visit(expr: ExpSoma) = {
    val valorEsq = vInteiro(expr.esq).valor
    val valorDir = vInteiro(expr.dir).valor
    ValorInteiro(valorEsq + valorDir)
  }

  def visit(expr: ExpSub) = {
    val valorEsq = vInteiro(expr.esq).valor
    val valorDir = vInteiro(expr.dir).valor
    ValorInteiro(valorEsq - valorDir)
  }

  def visit(valorBooleano: ValorBooleano) = valorBooleano

  def visit(valorInteiro: ValorInteiro) = valorInteiro

  def visit(valorString: ValorString) = valorString
}