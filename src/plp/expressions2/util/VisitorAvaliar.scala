package plp.expressions2.util

import plp.expressions1.expression.Valor
import plp.expressions1.util.{ VisitorAvaliar => VisitorLE1 }
import plp.expressions2.expression.{ DecVariavel, ExpDeclaracao, Id }
import plp.expressions2.memory.AmbienteExecucao

class VisitorAvaliar(ambiente: AmbienteExecucao)
    extends VisitorLE1()
    with Visitor[Valor] {

  override def visit(declaracao: ExpDeclaracao): Valor = {
    val resolvedValues = resolveValueBindings(declaracao)
    ambiente execute {
      includeValueBindings(resolvedValues)
      v(declaracao.expressao)
    }
  }

  protected def includeValueBindings(resolvedValues: Map[Id, Valor]) {
    ambiente ++ resolvedValues
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
