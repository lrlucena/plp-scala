package plp.expressions1.parser

import org.antlr.v4.runtime.ParserRuleContext
import org.antlr.v4.runtime.misc.NotNull
import org.antlr.v4.runtime.tree.ErrorNode
import org.antlr.v4.runtime.tree.TerminalNode
import plp.expressions1.expression._
import org.antlr.v4.runtime.tree.ParseTreeProperty
import org.antlr.v4.runtime.tree.ParseTree
import plp.expressions1.Programa

class E1 extends E1BaseListener {
  private val values = new ParseTreeProperty[Expressao]

  private def setValue(node: ParseTree, value: Expressao) {
    values.put(node, value);
  }

  private def getValue(node: ParseTree) = values.get(node)

  private var _programa: Expressao = _

  def programa = _programa

  override def exitPrograma(@NotNull ctx: E1Parser.ProgramaContext) {
    _programa = getValue(ctx.expressao())
  }

  override def exitOpUnaria(@NotNull ctx: E1Parser.OpUnariaContext) {
    val exp = getValue(ctx.expressao())
    val resultado =
      ctx.getChild(0).getText() match {
        case "-" => ExpMenos(exp)
        case "length" => ExpLength(exp)
        case "not" => ExpNot(exp)
      }
    setValue(ctx, resultado)
  }

  override def exitTerminal(@NotNull ctx: E1Parser.TerminalContext) {
    setValue(ctx, getValue(ctx.getChild(0)))
  }

  override def exitValor(@NotNull ctx: E1Parser.ValorContext) {
    val booleano = Option(ctx.Booleano())
    val inteiro = Option(ctx.Inteiro())
    val string = Option(ctx.String())
    val lista = (booleano, inteiro, string)
    val resultado = lista match {
      case (Some(a), _, _) => ValorBooleano(a.getText()=="verdadeiro")
      case (_, Some(a), _) => ValorInteiro(a.getText().toInt)
      case (_, _, Some(a)) => ValorString(a.getText())

      case _ => ValorString("[[[Erro]]]")
    }
    setValue(ctx, resultado)
  }

  override def exitOpBin(@NotNull ctx: E1Parser.OpBinContext) {
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
}