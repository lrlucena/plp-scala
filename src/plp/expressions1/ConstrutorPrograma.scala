package plp.expressions1

import plp.expressions1.expression.Expressao
import plp.expressions1.util.{VisitorAvaliar, VisitorChecaTipo}

object ConstrutorPrograma {

  def criarPrograma(exp: Expressao): Programa = {
    val visitorChe = new VisitorChecaTipo()
    val visitorAval = new VisitorAvaliar()
    new Programa(exp, visitorChe, visitorAval)
  }
}
