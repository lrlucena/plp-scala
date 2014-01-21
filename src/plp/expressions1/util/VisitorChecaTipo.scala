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
import plp.expressions1.expression.ExpBinaria

class VisitorException(msg: String = "") extends Exception(msg) {}

trait ChecaTipo {
  def tipo(expr: Expressao): Tipo
  
  protected def opBinBool(expression: ExpBinaria, erro: String) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eBooleano && tipoDir.eBooleano) BOOLEANO
    else throw new VisitorException(erro)
  }
  protected def opBinInt(expression: ExpBinaria, erro: String) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eInteiro && tipoDir.eInteiro) INTEIRO
    else throw new VisitorException(erro)
  }
  protected def opBinStr(expression: ExpBinaria, erro: String) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eString && tipoDir.eString) STRING
    else throw new VisitorException(erro)
  }
}

class VisitorChecaTipo extends Visitor[Tipo] with ChecaTipo {
  def tipo(expr: Expressao) = expr.accept(this)

  def visit(expression: ExpAnd) = opBinBool(expression,
    "A operação de conjunção lógica necessita que os seus termos sejam do tipo booleano.")

  def visit(expression: ExpConcat) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq.eString && tipoDir.eString) {
      STRING
    } else {
      throw new VisitorException("A operação de concatenação necessita que o seu termo seja uma string.")
    }
  }

  def visit(expression: ExpEquals) = {
    val tipoEsq = tipo(expression.esq)
    val tipoDir = tipo(expression.dir)
    if (tipoEsq == tipoDir) {
      BOOLEANO
    } else {
      throw new VisitorException("A operação de equals necessita que seus termos sejam do mesmo tipo. ")
    }
  }

  def visit(expression: ExpLength) = {
    val tipoExp = tipo(expression.exp)
    if (tipoExp.eString) {
      INTEIRO
    } else {
      throw new VisitorException("A operação de menos necessita que o seu termo seja uma string.")
    }
  }

  def visit(expression: ExpMenos) = {
    val tipoExp = tipo(expression.exp)
    if (tipoExp.eInteiro) {
      INTEIRO
    } else {
      throw new VisitorException("A operação de menos necessita que seus termos sejam inteiros.")
    }
  }

  def visit(expression: ExpNot) = {
    val tipoExp = tipo(expression.exp)
    if (tipoExp.eBooleano) {
      BOOLEANO
    } else {
      throw new VisitorException("A operaçãoo de negação lógica necessita que o seu termo seja booleano.")
    }
  }

  def visit(expression: ExpOr) = opBinBool(expression,
    "A operação de disjunção lógica necessita que seus termos sejam booleanos.")

  def visit(expression: ExpSoma) = opBinInt(expression,
    "A operação de soma necessita que seus termos sejam inteiros.")

  def visit(expression: ExpSub) = opBinInt(expression,
    "A operação de subtração necessita que seus termos sejam inteiros. ")

  def visit(valor: ValorBooleano) = BOOLEANO
  def visit(valor: ValorInteiro) = INTEIRO
  def visit(valor: ValorString) = STRING
}
