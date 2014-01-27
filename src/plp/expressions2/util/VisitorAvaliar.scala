package plp.expressions2.util

import plp.expressions1.expression.Valor
import plp.expressions1.util.{ VisitorAvaliar => VisitorLE1 }
import plp.expressions2.expression.ExpDeclaracao
import plp.expressions2.expression.Id
import plp.expressions2.memory.AmbienteExecucao

class VisitorAvaliar(ambiente: AmbienteExecucao)
  extends VisitorLE1() with Visitor[Valor] {

  override def visit(declaracao: ExpDeclaracao): Valor = {
    ambiente.incrementa
    val resolvedValues = resolveValueBindings(declaracao)
    includeValueBindings(ambiente, resolvedValues)
    val result = v(declaracao.expressao)
    ambiente.restaura
    result
  }

  protected def includeValueBindings(ambiente: AmbienteExecucao, resolvedValues: Map[Id, Valor]) {
    for ((id, valor) <- resolvedValues) {
      ambiente(id) = valor
    }
  }

  protected def resolveValueBindings(expressaoDec: ExpDeclaracao) = {
    val resolvedValues =
      for (declaration <- expressaoDec.seqdecVariavel) yield {
        val valor = v(declaration.expressao)
        (declaration.id -> valor)
      }
    resolvedValues.toMap
  }

  override def visit(id: Id) = {
    println(ambiente(id))
    ambiente(id)
  }
}
