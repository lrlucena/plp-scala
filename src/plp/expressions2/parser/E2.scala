package plp.expressions2.parser

import org.antlr.v4.runtime.misc.NotNull

import plp.expressions1.expression.ExpAnd
import plp.expressions1.expression.ExpConcat
import plp.expressions1.expression.ExpEquals
import plp.expressions1.expression.ExpLength
import plp.expressions1.expression.ExpMenos
import plp.expressions1.expression.ExpNot
import plp.expressions1.expression.ExpOr
import plp.expressions1.expression.ExpSoma
import plp.expressions1.expression.ExpSub
import plp.expressions1.expression.ValorBooleano
import plp.expressions1.expression.ValorInteiro
import plp.expressions1.expression.ValorString
import plp.expressions1.parser.PropertyList
import plp.expressions2.expression.DecVariavel
import plp.expressions2.expression.ExpDeclaracao
import plp.expressions2.expression.Id
import plp.expressions2.parser.E2Parser.DecVarContext
import plp.expressions2.parser.E2Parser.DecVariavelContext
import plp.expressions2.parser.E2Parser.OpBinContext
import plp.expressions2.parser.E2Parser.OpUnariaContext
import plp.expressions2.parser.E2Parser.ProgramaContext
import plp.expressions2.parser.E2Parser.TerminalContext
import plp.expressions2.parser.E2Parser.ValorContext

trait E2 extends E2BaseListener with PropertyList {
  override def exitPrograma(@NotNull ctx: ProgramaContext) {
    _programa = getValue(ctx.expressao())
  }

  override def exitOpUnaria(@NotNull ctx: OpUnariaContext) {
    val exp = getValue(ctx.expressao())
    val resultado =
      ctx.getChild(0).getText() match {
        case "-" => ExpMenos(exp)
        case "length" => ExpLength(exp)
        case "not" => ExpNot(exp)
      }
    setValue(ctx, resultado)
  }

  override def exitTerminal(@NotNull ctx: TerminalContext) {
    setValue(ctx, getValue(ctx.getChild(0)))
  }

  override def exitValor(@NotNull ctx: ValorContext) {
    val booleano = Option(ctx.Booleano())
    val inteiro = Option(ctx.Inteiro())
    val string = Option(ctx.String())
    val lista = (booleano, inteiro, string)
    val resultado = lista match {
      case (Some(a), _, _) => ValorBooleano(a.getText() == "verdadeiro")
      case (_, Some(a), _) => ValorInteiro(a.getText().toInt)
      case (_, _, Some(a)) => ValorString(a.getText().stripPrefix(""""""").stripSuffix("""""""))

      case _ => ValorString("[[[Erro]]]")
    }
    setValue(ctx, resultado)
  }

  override def exitOpBin(@NotNull ctx: OpBinContext) {
    val esq = getValue(ctx.expressao(0))
    val dir = getValue(ctx.expressao(1))
    val resultado =
      ctx.getChild(1).getText() match {
        case "+" => ExpSoma(esq, dir)
        case "-" => ExpSub(esq, dir)
        case "and" => ExpAnd(esq, dir)
        case "or" => ExpOr(esq, dir)
        case "==" => ExpEquals(esq, dir)
        case "++" => ExpConcat(esq, dir)
      }
    setValue(ctx, resultado)
  }

  override def exitId(@NotNull ctx: E2Parser.IdContext) {
    val resultado = Id(ctx.ID().getText())
    setValue(ctx, resultado)
  }

  override def exitDecVar(@NotNull ctx: DecVarContext) {
    val dec = ctx.decVars().decVariavel()
    val x = for (i <- 0 to dec.size - 1) yield {
      getValue(dec.get(i)).asInstanceOf[DecVariavel]
    }
    val exp = getValue(ctx.expressao())
    setValue(ctx, ExpDeclaracao(x.toList, exp))
  }

  override def exitDecVariavel(@NotNull ctx: DecVariavelContext) {
    val id = Id(ctx.ID.getText())
    val exp = getValue(ctx.expressao())
    setValue(ctx, DecVariavel(id, exp))
  }
}
