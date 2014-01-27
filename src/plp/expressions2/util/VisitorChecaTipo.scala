package plp.expressions2.util

import plp.expressions1.util.Tipo
import plp.expressions1.util.{ VisitorChecaTipo => VisitorLE1 }
import plp.expressions2.expression.ExpDeclaracao
import plp.expressions2.expression.Id
import plp.expressions2.memory.AmbienteCompilacao

class VisitorChecaTipo(ambiente: AmbienteCompilacao) extends VisitorLE1() with Visitor[Tipo] {

  def visit(id: Id): Tipo = ambiente(id)

  def visit(expDeclaracao: ExpDeclaracao) = {
    ambiente.incrementa
    val result = false
    try {
      val resolvedTypes = resolveAndCheckTypeBindings(expDeclaracao)
      includeTypeBindings(resolvedTypes)
      v(expDeclaracao.expressao)
    } finally {
      ambiente.restaura()
    }
  }

  private def resolveAndCheckTypeBindings(expDeclaracao: ExpDeclaracao) = {
    val resolvedTypes =
      for (declaration <- expDeclaracao.seqdecVariavel) yield {
        val tipo = v(declaration.expressao)
        (declaration.id -> tipo)
      }
    resolvedTypes.toMap
  }

  private def includeTypeBindings(resolvedTypes: Map[Id, Tipo]) {
    for ((id, tipo) <- resolvedTypes) {
      ambiente(id) = tipo
    }
  }
}