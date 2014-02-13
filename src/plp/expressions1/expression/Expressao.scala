package plp.expressions1.expression

trait Expressao {}

trait Valor extends Expressao {}

abstract class ExpBinaria(operador: String) extends Expressao {
  val esq: Expressao
  val dir: Expressao
  override def toString = s"${esq} ${operador} ${dir}"
}

case class ExpAnd(esq: Expressao, dir: Expressao) extends ExpBinaria("and")
case class ExpOr(esq: Expressao, dir: Expressao) extends ExpBinaria("or")
case class ExpSoma(esq: Expressao, dir: Expressao) extends ExpBinaria("+")
case class ExpSub(esq: Expressao, dir: Expressao) extends ExpBinaria("-")
case class ExpConcat(esq: Expressao, dir: Expressao) extends ExpBinaria("++")
case class ExpEquals(esq: Expressao, dir: Expressao) extends ExpBinaria("==")

abstract class ExpUnaria(operador: String) extends Expressao {
  val exp: Expressao
  override def toString = s"${operador} ${exp}"
}

case class ExpLength(exp: Expressao) extends ExpUnaria("length")
case class ExpMenos(exp: Expressao) extends ExpUnaria("-")
case class ExpNot(exp: Expressao) extends ExpUnaria("~")

trait ValorConcreto[V] extends Valor {
  val valor: V
  override def toString = valor.toString
}

case class ValorInteiro(valor: Int) extends ValorConcreto[Int]

case class ValorString(valor: String) extends ValorConcreto[String]

case class ValorBooleano(valor: Boolean) extends ValorConcreto[Boolean] {
  override def toString = if (valor) "verdadeiro" else "falso"
}
