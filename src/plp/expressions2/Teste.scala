package plp.expressions2

import org.antlr.v4.runtime.ANTLRInputStream
import org.antlr.v4.runtime.CommonTokenStream
import org.antlr.v4.runtime.tree.ParseTreeWalker
import plp.expressions2.memory.AmbienteExecucao
import plp.expressions2.parser.E2
import plp.expressions2.util.VisitorAvaliar
import plp.expressions2.parser.E2Lexer
import plp.expressions2.parser.E2Parser

object Teste extends App {
  val resultado = programa("""let var x = 1 in x+4""")
  val ambiente = new AmbienteExecucao()
  val visitorAval = new VisitorAvaliar(ambiente)
  val p = resultado.accept(visitorAval)
  println(p)

  def programa(codigo: String) = {
    val input = new ANTLRInputStream(codigo)
    val lexer = new E2Lexer(input)
    val tokens = new CommonTokenStream(lexer)
    val parser = new E2Parser(tokens)
    val tree = parser.programa()
    val walker = new ParseTreeWalker()
    val listener = new E2 {}
    walker.walk(listener, tree)
    listener.programa
  }
}