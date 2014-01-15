package plp.expressions2.memory

import plp.expressions2.expression.Id
import plp.expressions1.util.Tipo
import plp.expressions1.expression.Valor

trait Ambiente[T] {
  var pilha: List[Map[Id, T]] = List[Map[Id, T]]()

  def incrementa {
    pilha = Map[Id, T]() :: pilha
  }

  def restaura() {
    pilha = pilha.tail
  }

  def map(idArg: Id, valorId: T) {
    val aux = pilha.head
    if (aux.contains(idArg)) {
      throw new IdentificadorJaDeclaradoException()
    } else
      pilha = (aux + (idArg -> valorId)) :: pilha.tail
  }

  def get(idArg: Id): T = {
    var result: Option[T] = None
    for (map <- pilha) {
      val x = map.find(_._1 == idArg)
      x match {
        case Some((_, a)) if result == None => result = Some(a)
        case _ =>
      }
    }
    result match {
      case None => throw new IdentificadorNaoDeclaradoException("")
      case Some(a) => a
    }
  }
}

class AmbienteCompilacao extends Ambiente[Tipo]
class AmbienteExecucao extends Ambiente[Valor]