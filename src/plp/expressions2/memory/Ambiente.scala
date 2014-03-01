package plp.expressions2.memory

import scala.collection.mutable.{Map, Stack}
import scala.util.Try

import plp.expressions1.expression.Valor
import plp.expressions1.util.Tipo
import plp.expressions2.expression.Id

trait Ambiente[T] {
  private val pilha = Stack[Map[Id, T]]()

  protected def incrementa() {
    pilha.push(Map())
  }

  protected def restaura() {
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

  def ++(maps: scala.collection.Map[Id, T]) {
    for ((id, tipo) <- maps) {
      this(id) = tipo
    }
  }

  def execute[V](comando: => V): V = {
    incrementa
    val v = comando
    restaura
    v
  }

  def apply(idArg: Id): T = {
    val valor = for (map <- pilha; (k, v) <- map if idArg == k) yield v
    valor match {
      case Stack(a, _*) => a
      case Stack()      => throw new IdentificadorNaoDeclaradoException
    }
  }
}

class AmbienteCompilacao extends Ambiente[Try[Tipo]]
class AmbienteExecucao extends Ambiente[Valor]
