package plp.expressions2.expression

import plp.expressions1.expression.Expressao
import plp.expressions1.util.Tipo
import plp.expressions2.memory.AmbienteCompilacao

case class DecVariavel(id: Id, expressao: Expressao)
case class Id(idName: String) extends Expressao {
  override def toString = idName
}

case class ExpDeclaracao(seqdecVariavel: List[DecVariavel], expressao: Expressao)
  extends Expressao {

  private def includeTypeBindings(ambiente: AmbienteCompilacao, resolvedTypes: Map[Id, Tipo]) {
    for ((id, tipo) <- resolvedTypes) {
      ambiente(id) = tipo
    }
  }
}