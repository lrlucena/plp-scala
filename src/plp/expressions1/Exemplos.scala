package plp.expressions1

import ConstrutorPrograma.criarPrograma
import plp.expressions1.expression.{ExpAnd, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, ValorBooleano, ValorInteiro, ValorString}

object Exemplos extends App {
  val prg1 = criarPrograma(
    ExpSub(ExpSoma(ExpMenos(ValorInteiro(4)), ValorBooleano(true)),
      ValorInteiro(3)))
  println(prg1.executar)

  val prg2 = criarPrograma(ExpNot(ExpOr(ExpAnd(ValorBooleano(true),
    ValorBooleano(false)), ExpAnd(ValorBooleano(true),
    ValorBooleano(true)))))
  println(prg2.executar)

  val prg3 = criarPrograma(new ExpLength(new ExpConcat(new ValorString("Hello"), new ExpConcat(new ValorString(" world"), new ValorString("!")))))
  println(prg3.executar)

  val prg4 = criarPrograma(new ExpEquals(new ExpLength(new ValorString("forro")), new ValorInteiro(5)))
  println(prg4.executar)

  val prg5 = criarPrograma(new ExpEquals(new ExpConcat(new ValorString("hello"), new ValorString(" world")), new ValorString("hello world")))
  println(prg5.executar)

  val prg6 = criarPrograma(new ExpEquals(new ExpNot(new ValorInteiro(1)), new ExpAnd(new ValorBooleano(false), new ValorBooleano(false))))
  println(prg6.executar)
}
