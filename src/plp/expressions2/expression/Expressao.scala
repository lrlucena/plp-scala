package plp.expressions2.expression

import plp.expressions1.expression.Expressao
import plp.expressions1.util.Tipo
import plp.expressions2.memory.AmbienteCompilacao

case class DecVariavel(id: Id, expressao: Expressao) extends Expressao

case class Id(idName: String) extends Expressao {
  override def toString = idName
}

case class ExpDeclaracao(seqdecVariavel: List[DecVariavel], expressao: Expressao)
  extends Expressao {

  private def includeTypeBindings(ambiente: AmbienteCompilacao, resolvedTypes: Map[Id, Tipo]) {
    for (id <- resolvedTypes.keySet) {
      val `type` = resolvedTypes.get(id).get
      ambiente.map(id, `type`)
    }
  }
}