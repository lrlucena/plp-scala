package plp.expressions2.util

import scala.util.Try

import plp.expressions1.util.{Tipo, VisitorChecaTipo => VisitorLE1}
import plp.expressions2.expression.{ExpDeclaracao, Id}
import plp.expressions2.memory.AmbienteCompilacao

class VisitorChecaTipo(ambiente: AmbienteCompilacao) extends VisitorLE1() with Visitor[Try[Tipo]] {

  def visit(id: Id) = ambiente(id)

  def visit(expDeclaracao: ExpDeclaracao) = {
    def resolveAndCheckTypeBindings(expDeclaracao: ExpDeclaracao) = {
      val resolvedTypes =
        for (declaration <- expDeclaracao.seqdecVariavel) yield {
          val tipo = v(declaration.expressao)
          (declaration.id -> tipo)
        }
      resolvedTypes.toMap
    }

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

  private def includeTypeBindings(resolvedTypes: scala.collection.immutable.Map[Id, Try[Tipo]]) {
    for ((id, tipo) <- resolvedTypes) {
      ambiente(id) = tipo
    }
  }
}