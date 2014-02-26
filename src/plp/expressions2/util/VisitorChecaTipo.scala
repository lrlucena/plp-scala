package plp.expressions2.util

import scala.util.{ Try, Success }
import plp.expressions1.util.{ Tipo, VisitorChecaTipo => VisitorLE1 }
import plp.expressions2.expression.{ ExpDeclaracao, Id }
import plp.expressions2.memory.AmbienteCompilacao
import plp.expressions2.expression.DecVariavel
import scala.util.Failure

class VisitorChecaTipo(ambiente: AmbienteCompilacao)
    extends VisitorLE1() with Visitor[Try[Tipo]] {

  def visit(id: Id) = ambiente(id)

  def visit(expDeclaracao: ExpDeclaracao) = {
    def resolveAndCheckTypeBindings(expDeclaracao: ExpDeclaracao) = {
      val resolvedTypes =
        expDeclaracao.declaracoes map {
          case dec: DecVariavel => dec.id -> v(dec.expressao)
        }
      resolvedTypes.toMap
    }

    ambiente.incrementa
    val t = Try {
      val resolvedTypes = resolveAndCheckTypeBindings(expDeclaracao)
      includeTypeBindings(resolvedTypes)
      v(expDeclaracao.expressao)
    }
    ambiente.restaura()
    t match {
      case Success(tipo) => tipo
      case Failure(erro) => throw erro
    }
  }

  private def includeTypeBindings(resolvedTypes: scala.collection.immutable.Map[Id, Try[Tipo]]) {
    for ((id, tipo) <- resolvedTypes) {
      ambiente(id) = tipo
    }
  }
}