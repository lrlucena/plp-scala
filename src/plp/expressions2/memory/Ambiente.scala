package plp.expressions2.memory

import scala.collection.mutable.Map
import scala.collection.mutable.Stack

import plp.expressions1.expression.Valor
import plp.expressions1.util.Tipo
import plp.expressions2.expression.Id

trait Ambiente[T] {
  val pilha = Stack[Map[Id, T]]()

  def incrementa {
    pilha.push(Map())
  }

  def restaura() {
    pilha.pop
  }

  def update(idArg: Id, valorId: T) {
    val topo = pilha.top
    if (topo.contains(idArg)) {
      throw new IdentificadorJaDeclaradoException
    } else {
      topo(idArg) = valorId
    }
  }

  @deprecated("Usar ambiente(id)=valor")
  def map(idArg: Id, valorId: T) {
    this(idArg) = valorId
  }

  def apply(idArg: Id): T = {
    val valor = for (map <- pilha; (k, v) <- map if idArg == k) yield v
    valor match {
      case Stack(a, _*) => a
      case Stack() => throw new IdentificadorNaoDeclaradoException
    }
  }

  @deprecated("Usar ambiente(id)")
  def get(idArg: Id): T = this(idArg)

}

class AmbienteCompilacao extends Ambiente[Tipo]
class AmbienteExecucao extends Ambiente[Valor]