package plp.expressions1

import scala.util.{Failure, Success}

import plp.expressions1.expression.{Expressao, Valor}
import plp.expressions1.util.{VisitorAvaliar, VisitorChecaTipo}

class Programa(val exp: Expressao, visitorCheca: VisitorChecaTipo, visitorAvaliar: VisitorAvaliar) {

  case class Erro(mensagem: String) extends Valor {
    override def toString = s"Erro: $mensagem."
  }

  def executar = checaTipo match {
    case Success(_) => visitorAvaliar.v(exp)
    case Failure(e) => Erro(e.getMessage())
  }

  def checaTipo = visitorCheca.v(exp)
}
