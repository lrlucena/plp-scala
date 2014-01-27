package plp.expressions2

import plp.expressions1.expression.ExpSoma
import plp.expressions1.expression.ValorInteiro
import plp.expressions2.expression.ExpDeclaracao
import plp.expressions2.expression.Id
import plp.expressions2.expression.DecVariavel
import plp.expressions2.expression.Id

object Exemplos extends App {
  val idX = Id("x")
  val idY = Id("y")
  val decX2 = DecVariavel(idX, ValorInteiro(5))
  val list3 = List(decX2)

  val exp3 = ExpDeclaracao(list3, idY)
  val decY = DecVariavel(idY, ExpSoma(idX, ValorInteiro(1)))
  val list2 = List(decY)
  val exp2 = ExpDeclaracao(list2, exp3)
  val decX1 = DecVariavel(idX, ValorInteiro(3))
  val list1 = List(decX1)
  val exp1 = ExpDeclaracao(list1, exp2)
  val prg = ConstrutorPrograma.criarPrograma(exp1)
  try {
    if (!prg.checaTipo()) {
      println("Erro de tipo")
    } else {
      println(prg.executar)
    }
  } catch {
    case e: Exception => {
      println("Erro: " + e)
      e.printStackTrace()
    }
  }
}