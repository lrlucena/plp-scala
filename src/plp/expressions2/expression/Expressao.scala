package plp.expressions2.expression

import plp.expressions1.expression.Expressao

trait Declaracao

case class DecVariavel(id: Id, expressao: Expressao) extends Declaracao

case class Id(idName: String) extends Expressao {
  override def toString = idName
}

case class ExpDeclaracao(declaracoes: List[Declaracao], expressao: Expressao)
  extends Expressao
  