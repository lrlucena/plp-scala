package plp.expressions1

import plp.expressions1.expression.Expressao
import plp.expressions1.expression.Valor
import plp.expressions1.util.VisitorAvaliar
import plp.expressions1.util.VisitorChecaTipo
import plp.expressions1.util.VisitorException

class Programa(val exp: Expressao, visitorCheca: VisitorChecaTipo, visitorAvaliar: VisitorAvaliar) {

  def executar: Valor = {
    try {
      exp.accept(visitorAvaliar)
    } catch {
      case ve: VisitorException => {
        ve.printStackTrace()
        null
      }
    }
  }

  def checaTipo(): Boolean = {
    try {
      exp.accept(visitorCheca)
      true
    } catch {
      case ve: VisitorException => false
    }
  }

}