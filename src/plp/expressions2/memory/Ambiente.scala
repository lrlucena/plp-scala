package plp.expressions2.memory

import plp.expressions2.expression.Id
import plp.expressions1.util.Tipo
import plp.expressions1.expression.Valor
import collection.mutable.Stack
import collection.mutable.Map

trait Ambiente[T] {
  var pilha = Stack[Map[Id, T]]()

  def incrementa {
    pilha.push(Map())
  }

  def restaura() {
    pilha.pop
  }

  def map(idArg: Id, valorId: T) {
    val topo = pilha.head
    if (topo.contains(idArg)) {
      throw new IdentificadorJaDeclaradoException
    } else {
      topo += idArg -> valorId
    }
  }

  def get(idArg: Id): T = {
    val valor = for (map <- pilha; (k, v) <- map if idArg == k) yield v
    valor match {
      case Stack(a, _*) => a
      case Stack() => throw new IdentificadorNaoDeclaradoException
    }
  }
}

class AmbienteCompilacao extends Ambiente[Tipo]
class AmbienteExecucao extends Ambiente[Valor]