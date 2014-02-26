package plp.expressions2.util

import plp.expressions1.expression.Valor
import plp.expressions1.util.{ VisitorAvaliar => VisitorLE1 }
import plp.expressions2.expression.{ ExpDeclaracao, Id }
import plp.expressions2.memory.AmbienteExecucao
import plp.expressions2.expression.DecVariavel

class VisitorAvaliar(ambiente: AmbienteExecucao)
    extends VisitorLE1()
    with Visitor[Valor] {

  override def visit(declaracao: ExpDeclaracao): Valor = {
    ambiente.incrementa
    val resolvedValues = resolveValueBindings(declaracao)
    includeValueBindings(resolvedValues)
    val result = v(declaracao.expressao)
    ambiente.restaura
    result
  }

  protected def includeValueBindings(resolvedValues: Map[Id, Valor]) {
    for ((id, valor) <- resolvedValues) {
      ambiente(id) = valor
    }
  }

  protected def resolveValueBindings(expressaoDec: ExpDeclaracao) = {
    val resolvedValues = expressaoDec.declaracoes map {
      case dec: DecVariavel => dec.id -> v(dec.expressao)
    }
    resolvedValues.toMap
  }

  override def visit(id: Id) = {
    ambiente(id)
  }
}
