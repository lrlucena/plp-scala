package plp.expressions1.util

import scala.util.{ Failure, Success, Try }

import Tipo.{ BOOLEANO, INTEIRO, STRING }
import plp.expressions1.expression.{ ExpAnd, ExpBinaria, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, ExpUnaria, Expressao, ValorBooleano, ValorInteiro, ValorString }

class VisitorException(msg: String = "") extends Exception(msg) {}

trait ChecaTipo {
  def tipo(expr: Expressao): Try[Tipo]

  private def opBin(eTipo: Tipo => Boolean, t: Tipo)(implicit expression: ExpBinaria, erro: String) = {
    for (
      esq <- tipo(expression.esq);
      dir <- tipo(expression.dir);
      if (eTipo(esq) && eTipo(dir))
    ) yield t
  } orElse { Failure(new VisitorException(erro)) }

  protected def opBinBool(implicit expression: ExpBinaria, erro: String) =
    opBin(_.eBooleano, BOOLEANO)

  protected def opBinInt(implicit expression: ExpBinaria, erro: String) =
    opBin(_.eInteiro, INTEIRO)

  protected def opBinStr(implicit expression: ExpBinaria, erro: String) =
    opBin(_.eString, STRING)

  protected def opBinCmp(implicit expression: ExpBinaria, erro: String) = {
    for (
      esq <- tipo(expression.esq);
      dir <- tipo(expression.dir)
      if esq == dir
    ) yield BOOLEANO
  } orElse {
    Failure(new VisitorException(erro))
  }

  protected def opUnaria(eTipo: Tipo => Boolean, t: Tipo)(expression: ExpUnaria, erro: String) = {
    for (
      exp <- tipo(expression.exp) if eTipo(exp)
    ) yield t
  } orElse {
    Failure(new VisitorException(erro))
  }
}

class VisitorChecaTipo extends Visitor[Try[Tipo]] with ChecaTipo {
  def tipo(expr: Expressao) = v(expr)

  def visit(expression: ExpAnd) =
    opBinBool(expression,
      "A operação de conjunção lógica necessita que os seus termos sejam do tipo booleano.")

  def visit(expression: ExpConcat) =
    opBinStr(expression,
      "A operação de concatenação necessita que os seus termos sejam strings.")

  def visit(expression: ExpEquals) = opBinCmp(expression,
    "A operação de equals necessita que seus termos sejam do mesmo tipo.")

  def visit(expression: ExpLength) =
    opUnaria(_.eString, INTEIRO)(expression,
      "A operação length necessita que o seu termo seja uma string.")

  def visit(expression: ExpMenos) =
    opUnaria(_.eInteiro, INTEIRO)(expression,
      "A operação de menos necessita que seus termos sejam inteiros.")

  def visit(expression: ExpNot) =
    opUnaria(_.eBooleano, BOOLEANO)(expression,
      "A operaçãoo de negação lógica necessita que o seu termo seja booleano.")

  def visit(expression: ExpOr) =
    opBinBool(expression,
      "A operação de disjunção lógica necessita que seus termos sejam booleanos.")

  def visit(expression: ExpSoma) = opBinInt(expression,
    "A operação de soma necessita que seus termos sejam inteiros.")

  def visit(expression: ExpSub) = opBinInt(expression,
    "A operação de subtração necessita que seus termos sejam inteiros. ")

  def visit(valor: ValorBooleano) = Success(BOOLEANO)
  def visit(valor: ValorInteiro) = Success(INTEIRO)
  def visit(valor: ValorString) = Success(STRING)
}
