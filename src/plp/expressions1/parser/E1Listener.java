// Generated from C:\Users\Lucena\Workspaces\Eclipse IDE for Java Developers 421\PLP2014\E1.g4 by ANTLR 4.1
package plp.expressions1.parser;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link E1Parser}.
 */
public interface E1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link E1Parser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(@NotNull E1Parser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link E1Parser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(@NotNull E1Parser.ProgramaContext ctx);

	/**
	 * Enter a parse tree produced by {@link E1Parser#opUnaria}.
	 * @param ctx the parse tree
	 */
	void enterOpUnaria(@NotNull E1Parser.OpUnariaContext ctx);
	/**
	 * Exit a parse tree produced by {@link E1Parser#opUnaria}.
	 * @param ctx the parse tree
	 */
	void exitOpUnaria(@NotNull E1Parser.OpUnariaContext ctx);

	/**
	 * Enter a parse tree produced by {@link E1Parser#terminal}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(@NotNull E1Parser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by {@link E1Parser#terminal}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(@NotNull E1Parser.TerminalContext ctx);

	/**
	 * Enter a parse tree produced by {@link E1Parser#valor}.
	 * @param ctx the parse tree
	 */
	void enterValor(@NotNull E1Parser.ValorContext ctx);
	/**
	 * Exit a parse tree produced by {@link E1Parser#valor}.
	 * @param ctx the parse tree
	 */
	void exitValor(@NotNull E1Parser.ValorContext ctx);

	/**
	 * Enter a parse tree produced by {@link E1Parser#opBin}.
	 * @param ctx the parse tree
	 */
	void enterOpBin(@NotNull E1Parser.OpBinContext ctx);
	/**
	 * Exit a parse tree produced by {@link E1Parser#opBin}.
	 * @param ctx the parse tree
	 */
	void exitOpBin(@NotNull E1Parser.OpBinContext ctx);
}