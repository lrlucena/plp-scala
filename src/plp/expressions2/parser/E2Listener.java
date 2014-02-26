// Generated from E2.g4 by ANTLR 4.1
package plp.expressions2.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link E2Parser}.
 */
public interface E2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link E2Parser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(@NotNull E2Parser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(@NotNull E2Parser.IdContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(@NotNull E2Parser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(@NotNull E2Parser.ProgramaContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#opUnaria}.
	 * @param ctx the parse tree
	 */
	void enterOpUnaria(@NotNull E2Parser.OpUnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#opUnaria}.
	 * @param ctx the parse tree
	 */
	void exitOpUnaria(@NotNull E2Parser.OpUnariaContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(@NotNull E2Parser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(@NotNull E2Parser.TerminalContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(@NotNull E2Parser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(@NotNull E2Parser.ValorContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#expDeclaracao}.
	 * @param ctx the parse tree
	 */
	void enterExpDeclaracao(@NotNull E2Parser.ExpDeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#expDeclaracao}.
	 * @param ctx the parse tree
	 */
	void exitExpDeclaracao(@NotNull E2Parser.ExpDeclaracaoContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#opBin}.
	 * @param ctx the parse tree
	 */
	void enterOpBin(@NotNull E2Parser.OpBinContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#opBin}.
	 * @param ctx the parse tree
	 */
	void exitOpBin(@NotNull E2Parser.OpBinContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#declaracao}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracao(@NotNull E2Parser.DeclaracaoContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#declaracao}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracao(@NotNull E2Parser.DeclaracaoContext ctx);

	/**
	 * Enter a parse tree produced by {@link E2Parser#decVariavel}.
	 * @param ctx the parse tree
	 */
	void enterDecVariavel(@NotNull E2Parser.DecVariavelContext ctx);
	/**
	 * Exit a parse tree produced by {@link E2Parser#decVariavel}.
	 * @param ctx the parse tree
	 */
	void exitDecVariavel(@NotNull E2Parser.DecVariavelContext ctx);
}