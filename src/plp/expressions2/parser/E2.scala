package plp.expressions2.parser

import scala.collection.JavaConverters.asScalaBufferConverter
import scala.language.reflectiveCalls
import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.NotNull
import plp.expressions1.parser.{ Antlr2Scala, LE1, PropertyList }
import plp.expressions2.expression.{ DecVariavel, ExpDeclaracao, Id }
import plp.expressions2.parser.E2Parser.{ DecVariavelContext, ExpDeclaracaoContext, IdContext, OpBinContext, OpUnariaContext, ProgramaContext, TerminalContext, ValorContext }
import plp.expressions2.expression.Declaracao
import plp.expressions2.parser.E2Parser.DeclaracaoContext

trait LE2 extends PropertyList with Antlr2Scala {
  import scala.language.reflectiveCalls
  import org.antlr.v4.runtime.tree.TerminalNode

  private type ParserRuleContextList = java.util.List[_ <: ParserRuleContext]

  private type IdContext = ParserRuleContext {
    def ID(): TerminalNode
  }
  private type DecVariavelContext = ParserRuleContext {
    def ID(): TerminalNode
    def expressao(): ParserRuleContext
  }
  private type ExpDeclaracaoContext = ParserRuleContext {
    def declaracao(): ParserRuleContextList
    def expressao(): ParserRuleContext
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
  protected def declaracao(ctx: ParserRuleContext) {
    val decl: Declaracao = get(ctx.getChild(0))
    setValue(ctx, decl)
  }
  protected def expDeclaracao(ctx: ExpDeclaracaoContext) {
    import scala.collection.JavaConverters._
    val declaracoes: List[Declaracao] = ctx.declaracao.asScala.toList.map(get(_).asInstanceOf[Declaracao])
    val exp = getValue(ctx.expressao)
    setValue(ctx, ExpDeclaracao(declaracoes, exp))
  }
}

trait E2 extends E2BaseListener with LE1 with LE2 {
  import plp.expressions2.parser.E2Parser.{ ExpDeclaracaoContext, DecVariavelContext, IdContext, OpBinContext, OpUnariaContext, ProgramaContext, TerminalContext, ValorContext }
  // LE1
  override def exitPrograma(@NotNull ctx: ProgramaContext) { programa(ctx) }
  override def exitValor(@NotNull ctx: ValorContext) { valor(ctx) }
  override def exitOpBin(@NotNull ctx: OpBinContext) { opBin(ctx) }
  override def exitOpUnaria(@NotNull ctx: OpUnariaContext) { opUnaria(ctx) }
  override def exitTerminal(@NotNull ctx: TerminalContext) { terminal(ctx) }
  // LE2
  override def exitId(@NotNull ctx: IdContext) { id(ctx) }
  override def exitDecVariavel(@NotNull ctx: DecVariavelContext) { decVariavel(ctx) }
  override def exitDeclaracao(@NotNull ctx: DeclaracaoContext) { declaracao(ctx) }
  override def exitExpDeclaracao(@NotNull ctx: ExpDeclaracaoContext) { expDeclaracao(ctx) }
}
