package plp.expressions2

import plp.expressions1.Programa
import plp.expressions1.expression.Expressao
import plp.expressions2.memory.AmbienteCompilacao
import plp.expressions2.memory.AmbienteExecucao
import plp.expressions2.util.VisitorAvaliar
import plp.expressions2.util.VisitorChecaTipo

object ConstrutorPrograma {
  def criarPrograma(exp: Expressao): Programa = {
    val visitoAvaliar = new VisitorAvaliar(new AmbienteExecucao())
    val visitorChe = new VisitorChecaTipo(new AmbienteCompilacao())
    new Programa(exp, visitorChe, visitoAvaliar)
  }
}
