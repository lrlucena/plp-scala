// Generated from C:\Users\Lucena\Workspaces\Eclipse IDE for Java Developers 421\PLP2014\E2.g4 by ANTLR 4.1
package plp.expressions2.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class E2Lexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, Inteiro=14, Booleano=15, String=16, 
		S=17, ID=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'length'", "'in'", "'and'", "','", "'+'", "'let'", "'-'", "'or'", "'not'", 
		"'=='", "'='", "'++'", "'var'", "Inteiro", "Booleano", "String", "S", 
		"ID"
	};
	public static final String[] ruleNames = {
		"T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", 
		"T__3", "T__2", "T__1", "T__0", "Inteiro", "Booleano", "String", "S", 
		"ID"
	};


	public E2Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "E2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 16: S_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void S_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\24z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\5"+
		"\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\6\17T\n\17\r\17"+
		"\16\17U\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\5\20g\n\20\3\21\3\21\7\21k\n\21\f\21\16\21n\13\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\23\6\23w\n\23\r\23\16\23x\3l\24\3\3\1\5\4\1"+
		"\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1"+
		"\33\17\1\35\20\1\37\21\1!\22\1#\23\2%\24\1\3\2\4\4\2\13\f\"\"\4\2C\\c"+
		"|}\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3"+
		"\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2"+
		"\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3"+
		"\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5.\3\2\2\2\7\61\3\2\2\2\t\65\3\2\2\2\13"+
		"\67\3\2\2\2\r9\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23B\3\2\2\2\25F\3\2\2\2"+
		"\27I\3\2\2\2\31K\3\2\2\2\33N\3\2\2\2\35S\3\2\2\2\37f\3\2\2\2!h\3\2\2\2"+
		"#q\3\2\2\2%v\3\2\2\2\'(\7n\2\2()\7g\2\2)*\7p\2\2*+\7i\2\2+,\7v\2\2,-\7"+
		"j\2\2-\4\3\2\2\2./\7k\2\2/\60\7p\2\2\60\6\3\2\2\2\61\62\7c\2\2\62\63\7"+
		"p\2\2\63\64\7f\2\2\64\b\3\2\2\2\65\66\7.\2\2\66\n\3\2\2\2\678\7-\2\28"+
		"\f\3\2\2\29:\7n\2\2:;\7g\2\2;<\7v\2\2<\16\3\2\2\2=>\7/\2\2>\20\3\2\2\2"+
		"?@\7q\2\2@A\7t\2\2A\22\3\2\2\2BC\7p\2\2CD\7q\2\2DE\7v\2\2E\24\3\2\2\2"+
		"FG\7?\2\2GH\7?\2\2H\26\3\2\2\2IJ\7?\2\2J\30\3\2\2\2KL\7-\2\2LM\7-\2\2"+
		"M\32\3\2\2\2NO\7x\2\2OP\7c\2\2PQ\7t\2\2Q\34\3\2\2\2RT\4\62;\2SR\3\2\2"+
		"\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2V\36\3\2\2\2WX\7x\2\2XY\7g\2\2YZ\7t\2"+
		"\2Z[\7f\2\2[\\\7c\2\2\\]\7f\2\2]^\7g\2\2^_\7k\2\2_`\7t\2\2`g\7q\2\2ab"+
		"\7h\2\2bc\7c\2\2cd\7n\2\2de\7u\2\2eg\7q\2\2fW\3\2\2\2fa\3\2\2\2g \3\2"+
		"\2\2hl\7$\2\2ik\13\2\2\2ji\3\2\2\2kn\3\2\2\2lm\3\2\2\2lj\3\2\2\2mo\3\2"+
		"\2\2nl\3\2\2\2op\7$\2\2p\"\3\2\2\2qr\t\2\2\2rs\3\2\2\2st\b\22\2\2t$\3"+
		"\2\2\2uw\t\3\2\2vu\3\2\2\2wx\3\2\2\2xv\3\2\2\2xy\3\2\2\2y&\3\2\2\2\7\2"+
		"Uflx";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}