// Generated from C:\Users\Lucena\Workspaces\Eclipse IDE for Java Developers 421\PLP2014\E1.g4 by ANTLR 4.1
package plp.expressions1.parser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class E1Lexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, Inteiro=9, 
		Booleano=10, String=11, S=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'length'", "'and'", "'+'", "'-'", "'or'", "'not'", "'=='", "'++'", "Inteiro", 
		"Booleano", "String", "S"
	};
	public static final String[] ruleNames = {
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "Inteiro", 
		"Booleano", "String", "S"
	};


	public E1Lexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "E1.g4"; }

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
		case 11: S_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void S_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\2\16Z\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\4\3"+
		"\4\3\5\3\5\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\6\n"+
		"9\n\n\r\n\16\n:\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\5\13L\n\13\3\f\3\f\7\fP\n\f\f\f\16\fS\13\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3Q\16\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\1\23\13\1\25\f\1\27\r\1\31\16\2\3\2\3\4\2\13\f\"\"\\\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3"+
		"\33\3\2\2\2\5\"\3\2\2\2\7&\3\2\2\2\t(\3\2\2\2\13*\3\2\2\2\r-\3\2\2\2\17"+
		"\61\3\2\2\2\21\64\3\2\2\2\238\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31V\3\2"+
		"\2\2\33\34\7n\2\2\34\35\7g\2\2\35\36\7p\2\2\36\37\7i\2\2\37 \7v\2\2 !"+
		"\7j\2\2!\4\3\2\2\2\"#\7c\2\2#$\7p\2\2$%\7f\2\2%\6\3\2\2\2&\'\7-\2\2\'"+
		"\b\3\2\2\2()\7/\2\2)\n\3\2\2\2*+\7q\2\2+,\7t\2\2,\f\3\2\2\2-.\7p\2\2."+
		"/\7q\2\2/\60\7v\2\2\60\16\3\2\2\2\61\62\7?\2\2\62\63\7?\2\2\63\20\3\2"+
		"\2\2\64\65\7-\2\2\65\66\7-\2\2\66\22\3\2\2\2\679\4\62;\28\67\3\2\2\29"+
		":\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\24\3\2\2\2<=\7x\2\2=>\7g\2\2>?\7t\2\2?"+
		"@\7f\2\2@A\7c\2\2AB\7f\2\2BC\7g\2\2CD\7k\2\2DE\7t\2\2EL\7q\2\2FG\7h\2"+
		"\2GH\7c\2\2HI\7n\2\2IJ\7u\2\2JL\7q\2\2K<\3\2\2\2KF\3\2\2\2L\26\3\2\2\2"+
		"MQ\7$\2\2NP\13\2\2\2ON\3\2\2\2PS\3\2\2\2QR\3\2\2\2QO\3\2\2\2RT\3\2\2\2"+
		"SQ\3\2\2\2TU\7$\2\2U\30\3\2\2\2VW\t\2\2\2WX\3\2\2\2XY\b\r\2\2Y\32\3\2"+
		"\2\2\6\2:KQ";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}