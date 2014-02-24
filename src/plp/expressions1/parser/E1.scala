package plp.expressions1.parser

import scala.language.reflectiveCalls

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.NotNull
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}

import plp.expressions1.expression.{ExpAnd, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, Expressao, ValorBooleano, ValorInteiro, ValorString}
import plp.expressions1.parser.E1Parser.{OpBinContext, OpUnariaContext, ProgramaContext, TerminalContext, ValorContext}
import plp.expressions1.util.Tipo.{BOOLEANO, INTEIRO, STRING}

trait PropertyList {
  protected val values = new ParseTreeProperty[Any]
  protected def setValue(node: ParseTree, value: Any) {
    values.put(node, value);
  }
  protected def getValue(node: ParseTree) = values.get(node).asInstanceOf[Expressao]
  protected def get[T](node: ParseTree) = values.get(node).asInstanceOf[T]
  protected var _programa: Expressao = _
  def programa = _programa
}

trait Antlr2Scala {
  protected implicit class rule2scala(rule: ParserRuleContext) {
    def apply(i: Int) = rule.getChild(i)
  }
  protected implicit class tree2scala(tree: ParseTree) {
    def text = tree.getText
  }
}

trait LE1 extends PropertyList with Antlr2Scala {
  import scala.language.reflectiveCalls
  import plp.expressions1.util.Tipo.{ BOOLEANO, INTEIRO, STRING }
  import org.antlr.v4.runtime.tree.TerminalNode

  private type OpUnariaContext = ParserRuleContext { def expressao(): ParserRuleContext }
  private type ValorContext = ParserRuleContext { def Booleano(): TerminalNode; def Inteiro(): TerminalNode; def String(): TerminalNode }
  private type OpBinContext = ParserRuleContext { def expressao(i: Int): ParserRuleContext }

  protected def opUnaria(ctx: OpUnariaContext) {
    val exp = getValue(ctx.expressao)
    val resultado =
      ctx(0).text match {
        case "-"      => ExpMenos(exp)
        case "length" => ExpLength(exp)
        case "not"    => ExpNot(exp)
      }
    setValue(ctx, resultado)
  }

  protected def valor(ctx: ValorContext) {
    val valor = 0 match {
      case _ if (Option(ctx.Booleano).isDefined) => (ctx.Booleano, BOOLEANO)
      case _ if (Option(ctx.Inteiro).isDefined)  => (ctx.Inteiro, INTEIRO)
      case _ if (Option(ctx.String).isDefined)   => (ctx.String, STRING)
    }

    val resultado = valor match {
      case (a, BOOLEANO) => ValorBooleano(a.text == "verdadeiro")
      case (a, INTEIRO)  => ValorInteiro(a.text.toInt)
      case (a, STRING)   => ValorString(a.text.stripPrefix(""""""").stripSuffix("""""""))

      case _             => ValorString("[[[Erro]]]")
    }
    setValue(ctx, resultado)
  }

  protected def opBin(ctx: OpBinContext) {
    val esq = getValue(ctx.expressao(0))
    val dir = getValue(ctx.expressao(1))
    val resultado =
      ctx(1).text match {
        case "+"   => ExpSoma(esq, dir)
        case "-"   => ExpSub(esq, dir)
        case "and" => ExpAnd(esq, dir)
        case "or"  => ExpOr(esq, dir)
        case "=="  => ExpEquals(esq, dir)
        case "++"  => ExpConcat(esq, dir)
      }
    setValue(ctx, resultado)
  }

  protected def terminal(@NotNull ctx: ParserRuleContext) {
    setValue(ctx, getValue(ctx(0)))
  }

  protected def programa(ctx: OpUnariaContext) {
    _programa = getValue(ctx.expressao)
  }
}

trait E1 extends E1BaseListener with LE1 {
  override def exitPrograma(@NotNull ctx: ProgramaContext) { programa(ctx) }
  override def exitValor(@NotNull ctx: ValorContext) { valor(ctx) }
  override def exitOpBin(@NotNull ctx: OpBinContext) { opBin(ctx) }
  override def exitOpUnaria(@NotNull ctx: OpUnariaContext) { opUnaria(ctx) }
  override def exitTerminal(@NotNull ctx: TerminalContext) { terminal(ctx) }
}
