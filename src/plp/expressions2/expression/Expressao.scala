package plp.expressions2.expression

import plp.expressions1.expression.Expressao

case class DecVariavel(id: Id, expressao: Expressao)
case class Id(idName: String) extends Expressao {
  override def toString = idName
}

case class ExpDeclaracao(seqdecVariavel: List[DecVariavel], expressao: Expressao)
  extends Expressao