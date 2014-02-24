package plp.expressions2.parser

import scala.language.reflectiveCalls

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.NotNull

import plp.expressions1.parser.{Antlr2Scala, LE1, PropertyList}
import plp.expressions2.expression.{DecVariavel, ExpDeclaracao, Id}
import plp.expressions2.parser.E2Parser.{DecVarContext, DecVariavelContext, DecVarsContext, IdContext, OpBinContext, OpUnariaContext, ProgramaContext, TerminalContext, ValorContext}

trait LE2 extends PropertyList with Antlr2Scala {
  import scala.language.reflectiveCalls
  import org.antlr.v4.runtime.tree.TerminalNode

  private type IdContext = ParserRuleContext {
    def ID(): TerminalNode
  }
  private type DecVariavelContext = ParserRuleContext {
    def ID(): TerminalNode
    def expressao(): ParserRuleContext
  }
  private type DecVarContext = ParserRuleContext {
    def decVars(): ParserRuleContext
    def expressao(): ParserRuleContext
  }
  private type DecVarsContext = ParserRuleContext {
    def decVariavel(): java.util.List[_ <: ParserRuleContext]
    def decVariavel(i: Int): ParserRuleContext
  }

  protected def id(ctx: IdContext) {
    val resultado = Id(ctx.ID.text)
    setValue(ctx, resultado)
  }
  protected def decVariavel(ctx: DecVariavelContext) {
    val id = Id(ctx.ID.text)
    val exp = getValue(ctx.expressao)
    setValue(ctx, DecVariavel(id, exp))
  }
  protected def decVar(ctx: DecVarContext) {
    val declaracoes: List[DecVariavel] = get(ctx.decVars)
    val exp = getValue(ctx.expressao)
    setValue(ctx, ExpDeclaracao(declaracoes, exp))
  }
  protected def decVars1(ctx: DecVarsContext) {
    val vars: List[DecVariavel] =
      (for (i <- 0 to (ctx.decVariavel.size - 1)) yield {
        get(ctx.decVariavel(i)).asInstanceOf[DecVariavel]
      }).toList
    setValue(ctx, vars)
  }

}

trait E2 extends E2BaseListener with LE1 with LE2 {
  import plp.expressions2.parser.E2Parser.{ DecVarContext, DecVariavelContext, DecVarsContext, IdContext, OpBinContext, OpUnariaContext, ProgramaContext, TerminalContext, ValorContext }

  override def exitPrograma(@NotNull ctx: ProgramaContext) { programa(ctx) }
  override def exitValor(@NotNull ctx: ValorContext) { valor(ctx) }
  override def exitOpBin(@NotNull ctx: OpBinContext) { opBin(ctx) }
  override def exitOpUnaria(@NotNull ctx: OpUnariaContext) { opUnaria(ctx) }
  override def exitTerminal(@NotNull ctx: TerminalContext) { terminal(ctx) }
  override def exitId(@NotNull ctx: IdContext) { id(ctx) }
  override def exitDecVariavel(@NotNull ctx: DecVariavelContext) { decVariavel(ctx) }
  override def exitDecVar(@NotNull ctx: DecVarContext) { decVar(ctx) }
  override def exitDecVars(@NotNull ctx: DecVarsContext) { decVars1(ctx) }
}
