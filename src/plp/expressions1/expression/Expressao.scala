package plp.expressions1.expression

import plp.expressions1.util.Visitor

trait Expressao {
  def accept[T](visitor: Visitor[T]): T
}

trait Valor extends Expressao {}

abstract class ExpBinaria(operador: String) extends Expressao {
  val esq: Expressao
  val dir: Expressao
  override def toString = s"${esq} ${operador} ${dir}"
}

case class ExpAnd(esq: Expressao, dir: Expressao) extends ExpBinaria("and") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ExpOr(esq: Expressao, dir: Expressao) extends ExpBinaria("or") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ExpSoma(esq: Expressao, dir: Expressao) extends ExpBinaria("+") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ExpSub(esq: Expressao, dir: Expressao) extends ExpBinaria("-") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}
case class ExpConcat(esq: Expressao, dir: Expressao) extends ExpBinaria("++") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}
case class ExpEquals(esq: Expressao, dir: Expressao) extends ExpBinaria("==") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

abstract class ExpUnaria(operador: String) extends Expressao {
  val exp: Expressao
  override def toString = s"${operador} ${exp}"
}

case class ExpLength(exp: Expressao) extends ExpUnaria("length") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ExpMenos(exp: Expressao) extends ExpUnaria("-") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ExpNot(exp: Expressao) extends ExpUnaria("~") {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

trait ValorConcreto[V] extends Valor {
  val valor: V
  override def toString = valor.toString
}

case class ValorInteiro(valor: Int) extends ValorConcreto[Int] {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ValorString(valor: String) extends ValorConcreto[String] {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
}

case class ValorBooleano(valor: Boolean) extends ValorConcreto[Boolean] {
  override def accept[T](visitor: Visitor[T]) = visitor.visit(this)
  override def toString = if (valor) "verdadeiro" else "falso"
  def this(valor: String) {
    this(valor == "verdadeiro")
  }
}
