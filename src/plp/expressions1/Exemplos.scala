package plp.expressions1

import ConstrutorPrograma.criarPrograma
import plp.expressions1.expression.{ExpAnd, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, ValorBooleano, ValorInteiro, ValorString}

object Exemplos extends App {
  val prg1 = criarPrograma(
    ExpSub(ExpSoma(ExpMenos(ValorInteiro(4)), ValorInteiro(12)),
      ValorInteiro(3)))
  if (!prg1.checaTipo()) {
    println("Erro de tipo")
  } else {
    println(prg1.executar)
  }

  val prg2 = criarPrograma(ExpNot(ExpOr(ExpAnd(ValorBooleano(true),
    ValorBooleano(false)), ExpAnd(ValorBooleano(true),
    ValorBooleano(true)))))
  if (!prg2.checaTipo()) {
    println("Erro de tipo")
  } else {
    println(prg2.executar)
  }
  val prg3 = criarPrograma(new ExpLength(new ExpConcat(new ValorString("Hello"), new ExpConcat(new ValorString(" world"), new ValorString("!")))))
  if (!prg3.checaTipo()) {
    println("Erro de tipo")
  } else {
    println(prg3.executar)
  }
  val prg4 = criarPrograma(new ExpEquals(new ExpLength(new ValorString("forro")), new ValorInteiro(5)))
  if (!prg4.checaTipo()) {
    println("Erro de tipo")
  } else {
    println(prg4.executar)
  }
  val prg5 = criarPrograma(new ExpEquals(new ExpConcat(new ValorString("hello"), new ValorString(" world")), new ValorString("hello world")))
  if (!prg5.checaTipo()) {
    println("Erro de tipo")
  } else {
    println(prg5.executar)
  }
  val prg6 = criarPrograma(new ExpEquals(new ExpNot(new ValorBooleano(true)), new ExpAnd(new ValorBooleano(false), new ValorInteiro(1))))
  if (!prg6.checaTipo()) {
    println("Erro de tipo")
  } else {
    println(prg6.executar)
  }
}
