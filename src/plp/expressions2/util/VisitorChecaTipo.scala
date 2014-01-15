package plp.expressions2.util

import plp.expressions1.util.Tipo
import plp.expressions1.util.{VisitorChecaTipo => VisitorLE1}
import plp.expressions2.expression.ExpDeclaracao
import plp.expressions2.expression.Id
import plp.expressions2.memory.AmbienteCompilacao

class VisitorChecaTipo(ambiente: AmbienteCompilacao) extends VisitorLE1() with Visitor[Tipo] {

  def visit(expressao: Id): Tipo = {
    ambiente.get(expressao)
  }

  def visit(expDeclaracao: ExpDeclaracao) = {
    ambiente.incrementa
    var resolvedTypes: Map[Id, Tipo] = null
    val result = false
    try {
      resolvedTypes = resolveAndCheckTypeBindings(expDeclaracao)
      this.includeTypeBindings(resolvedTypes)
      expDeclaracao.expressao.accept(this)
    } finally {
      ambiente.restaura()
    }
  }

  private def resolveAndCheckTypeBindings(expDeclaracao: ExpDeclaracao): Map[Id, Tipo] = {
    var resolvedTypes = Map[Id, Tipo]()
    for (declaration <- expDeclaracao.seqdecVariavel) {
      val tipo = declaration.expressao.accept(this)
      resolvedTypes = resolvedTypes + (declaration.id -> tipo)
    }
    resolvedTypes
  }

  private def includeTypeBindings(resolvedTypes: Map[Id, Tipo]) {
    for (id <- resolvedTypes.keySet) {
      val `type` = resolvedTypes.get(id).get
      ambiente.map(id, `type`)
    }
  }
}