package plp.expressions1.parser

import org.antlr.v4.runtime.misc.NotNull
import org.antlr.v4.runtime.tree.{ParseTree, ParseTreeProperty}

import plp.expressions1.expression.{ExpAnd, ExpConcat, ExpEquals, ExpLength, ExpMenos, ExpNot, ExpOr, ExpSoma, ExpSub, Expressao, ValorBooleano, ValorInteiro, ValorString}
import plp.expressions1.parser.E1Parser.{OpBinContext, OpUnariaContext, ProgramaContext, TerminalContext, ValorContext}

trait PropertyList {
  protected val values = new ParseTreeProperty[Any]
  protected def setValue(node: ParseTree, value: Any) {
    values.put(node, value);
  }
  protected def getValue(node: ParseTree) = values.get(node).asInstanceOf[Expressao]
  protected def get(node: ParseTree) = values.get(node)
  protected var _programa: Expressao = _
  def programa = _programa
}

trait E1 extends E1BaseListener with PropertyList {

  override def exitOpUnaria(@NotNull ctx: OpUnariaContext) {
    val exp = getValue(ctx.expressao())
    val resultado =
      ctx.getChild(0).getText() match {
        case "-"      => ExpMenos(exp)
        case "length" => ExpLength(exp)
        case "not"    => ExpNot(exp)
      }
    setValue(ctx, resultado)
  }

  override def exitPrograma(@NotNull ctx: ProgramaContext) {
    _programa = getValue(ctx.expressao())
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

      case _               => ValorString("[[[Erro]]]")
    }
    setValue(ctx, resultado)
  }

  override def exitOpBin(@NotNull ctx: OpBinContext) {
    val esq = getValue(ctx.expressao(0))
    val dir = getValue(ctx.expressao(1))
    val resultado =
      ctx.getChild(1).getText() match {
        case "+"   => ExpSoma(esq, dir)
        case "-"   => ExpSub(esq, dir)
        case "and" => ExpAnd(esq, dir)
        case "or"  => ExpOr(esq, dir)
        case "=="  => ExpEquals(esq, dir)
        case "++"  => ExpConcat(esq, dir)
      }
    setValue(ctx, resultado)
  }
}