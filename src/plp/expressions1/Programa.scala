package plp.expressions1

import plp.expressions1.expression.{Expressao, Valor}
import plp.expressions1.util.{VisitorAvaliar, VisitorChecaTipo, VisitorException}

class Programa(val exp: Expressao, visitorCheca: VisitorChecaTipo, visitorAvaliar: VisitorAvaliar) {

  def executar: Valor = {
    try {
      visitorAvaliar.v(exp)
    } catch {
      case ve: VisitorException => {
        ve.printStackTrace()
        null
      }
    }
  }

  def checaTipo(): Boolean = {
    try {
      visitorCheca.v(exp)
      true
    } catch {
      case ve: VisitorException => false
    }
  }
}
