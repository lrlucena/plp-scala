package plp.expressions1.util

import plp.expressions1.expression.ExpAnd
import plp.expressions1.expression.ExpConcat
import plp.expressions1.expression.ExpEquals
import plp.expressions1.expression.ExpLength
import plp.expressions1.expression.ExpMenos
import plp.expressions1.expression.ExpNot
import plp.expressions1.expression.ExpOr
import plp.expressions1.expression.ExpSoma
import plp.expressions1.expression.ExpSub
import plp.expressions1.expression.Expressao
import plp.expressions1.expression.ValorBooleano
import plp.expressions1.expression.ValorInteiro
import plp.expressions1.expression.ValorString

class VisitorException(msg: String = "") extends Exception(msg) {}

class VisitorChecaTipo extends Visitor[Tipo]() {
  def tipo(expr: Expressao) = expr.accept(this)

  def visit(expression: ExpAnd) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eBooleano && tipoDir.eBooleano) {
      BOOLEANO
    } else {
      throw new VisitorException("A operação de conjunção lógica necessita que os " + "seus termos sejam do tipo booleano.")
    }
  }

  def visit(expression: ExpConcat) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eString && tipoDir.eString) {
      STRING
    } else {
      throw new VisitorException("A opera��o de concatena��o necessita que o " + "seu termo seja uma string.")
    }
  }

  def visit(expression: ExpEquals) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq == tipoDir) {
      BOOLEANO
    } else {
      throw new VisitorException("A operação de equals necessita que seus " + "termos sejam do mesmo tipo. ")
    }
  }

  def visit(expression: ExpLength) = {
    val tipoExp = tipo(expression.exp)
    if (tipoExp.eString) {
      INTEIRO
    } else {
      throw new VisitorException("A opera��o de menos necessita que o " + "seu termo seja uma string.")
    }
  }

  def visit(expression: ExpMenos) = {
    val tipoExp = tipo(expression.exp)
    if (tipoExp.eInteiro) {
      INTEIRO
    } else {
      throw new VisitorException("A opera��o de menos necessita que seus " + "termos sejam inteiros. ")
    }
  }

  def visit(expression: ExpNot) = {
    val tipoExp = tipo(expression.exp)
    if (tipoExp.eBooleano) {
      BOOLEANO
    } else {
      throw new VisitorException("A opera��o de nega��o l�gica necessita que o " + "seu termo seja booleano. ")
    }
  }

  def visit(expression: ExpOr) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eBooleano && tipoDir.eBooleano) {
      BOOLEANO
    } else {
      throw new VisitorException("A opera��o de disjun��o l�gica necessita que seus " + "termos sejam booleanos. ")
    }
  }

  def visit(expression: ExpSoma) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eInteiro && tipoDir.eInteiro) {
      INTEIRO
    } else {
      throw new VisitorException("A opera��o de soma necessita que seus " + "termos sejam inteiros. ")
    }
  }

  def visit(expression: ExpSub) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eInteiro && tipoDir.eInteiro) {
      INTEIRO
    } else {
      throw new VisitorException("A opera��o de subtra��o necessita que seus " + "termos sejam inteiros. ")
    }
  }

  def visit(valor: ValorBooleano) = BOOLEANO
  def visit(valor: ValorInteiro) = INTEIRO
  def visit(valor: ValorString) = STRING
}
