// Generated from E2.g4 by ANTLR 4.1
package plp.expressions2.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class E2Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__12=1, T__11=2, T__10=3, T__9=4, T__8=5, T__7=6, T__6=7, T__5=8, T__4=9, 
		T__3=10, T__2=11, T__1=12, T__0=13, Inteiro=14, Booleano=15, String=16, 
		S=17, ID=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'length'", "'in'", "'and'", "','", "'+'", "'let'", "'-'", 
		"'or'", "'not'", "'=='", "'='", "'++'", "'var'", "Inteiro", "Booleano", 
		"String", "S", "ID"
	};
	public static final int
		RULE_programa = 0, RULE_expressao = 1, RULE_valor = 2, RULE_decVars = 3, 
		RULE_decVariavel = 4;
	public static final String[] ruleNames = {
		"programa", "expressao", "valor", "decVars", "decVariavel"
	};

	@Override
	public String getGrammarFileName() { return "E2.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public E2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramaContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(10); expressao(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressaoContext extends ParserRuleContext {
		public int _p;
		public ExpressaoContext(ParserRuleContext parent, int invokingState) { super(parent, invokingState); }
		public ExpressaoContext(ParserRuleContext parent, int invokingState, int _p) {
			super(parent, invokingState);
			this._p = _p;
		}
		@Override public int getRuleIndex() { return RULE_expressao; }
	 
		public ExpressaoContext() { }
		public void copyFrom(ExpressaoContext ctx) {
			super.copyFrom(ctx);
			this._p = ctx._p;
		}
	}
	public static class IdContext extends ExpressaoContext {
		public TerminalNode ID() { return getToken(E2Parser.ID, 0); }
		public IdContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitId(this);
		}
	}
	public static class OpUnariaContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public OpUnariaContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterOpUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitOpUnaria(this);
		}
	}
	public static class DecVarContext extends ExpressaoContext {
		public DecVarsContext decVars() {
			return getRuleContext(DecVarsContext.class,0);
		}
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public DecVarContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterDecVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitDecVar(this);
		}
	}
	public static class TerminalContext extends ExpressaoContext {
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitTerminal(this);
		}
	}
	public static class OpBinContext extends ExpressaoContext {
		public ExpressaoContext expressao(int i) {
			return getRuleContext(ExpressaoContext.class,i);
		}
		public List<ExpressaoContext> expressao() {
			return getRuleContexts(ExpressaoContext.class);
		}
		public OpBinContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterOpBin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitOpBin(this);
		}
	}

	public final ExpressaoContext expressao(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressaoContext _localctx = new ExpressaoContext(_ctx, _parentState, _p);
		ExpressaoContext _prevctx = _localctx;
		int _startState = 2;
		enterRecursionRule(_localctx, RULE_expressao);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			switch (_input.LA(1)) {
			case 1:
				{
				_localctx = new OpUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(13); match(1);
				setState(14); expressao(11);
				}
				break;
			case 9:
				{
				_localctx = new OpUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15); match(9);
				setState(16); expressao(10);
				}
				break;
			case 7:
				{
				_localctx = new OpUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(17); match(7);
				setState(18); expressao(9);
				}
				break;
			case 6:
				{
				_localctx = new DecVarContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(19); match(6);
				setState(20); decVars();
				setState(21); match(2);
				setState(22); expressao(1);
				}
				break;
			case Inteiro:
			case Booleano:
			case String:
				{
				_localctx = new TerminalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(24); valor();
				}
				break;
			case ID:
				{
				_localctx = new IdContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25); match(ID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(45);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(43);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(28);
						if (!(8 >= _localctx._p)) throw new FailedPredicateException(this, "8 >= $_p");
						setState(29);
						_la = _input.LA(1);
						if ( !(_la==5 || _la==7) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(30); expressao(9);
						}
						break;

					case 2:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(31);
						if (!(7 >= _localctx._p)) throw new FailedPredicateException(this, "7 >= $_p");
						setState(32); match(10);
						setState(33); expressao(8);
						}
						break;

					case 3:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(34);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(35); match(3);
						setState(36); expressao(7);
						}
						break;

					case 4:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(37);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(38); match(8);
						setState(39); expressao(6);
						}
						break;

					case 5:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(40);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(41); match(12);
						setState(42); expressao(5);
						}
						break;
					}
					} 
				}
				setState(47);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ValorContext extends ParserRuleContext {
		public TerminalNode String() { return getToken(E2Parser.String, 0); }
		public TerminalNode Booleano() { return getToken(E2Parser.Booleano, 0); }
		public TerminalNode Inteiro() { return getToken(E2Parser.Inteiro, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitValor(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Inteiro) | (1L << Booleano) | (1L << String))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecVarsContext extends ParserRuleContext {
		public DecVariavelContext decVariavel(int i) {
			return getRuleContext(DecVariavelContext.class,i);
		}
		public List<DecVariavelContext> decVariavel() {
			return getRuleContexts(DecVariavelContext.class);
		}
		public DecVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterDecVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitDecVars(this);
		}
	}

	public final DecVarsContext decVars() throws RecognitionException {
		DecVarsContext _localctx = new DecVarsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_decVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50); decVariavel();
			setState(55);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==4) {
				{
				{
				setState(51); match(4);
				setState(52); decVariavel();
				}
				}
				setState(57);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DecVariavelContext extends ParserRuleContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public TerminalNode ID() { return getToken(E2Parser.ID, 0); }
		public DecVariavelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decVariavel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).enterDecVariavel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E2Listener ) ((E2Listener)listener).exitDecVariavel(this);
		}
	}

	public final DecVariavelContext decVariavel() throws RecognitionException {
		DecVariavelContext _localctx = new DecVariavelContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_decVariavel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58); match(13);
			setState(59); match(ID);
			setState(60); match(11);
			setState(61); expressao(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 8 >= _localctx._p;

		case 1: return 7 >= _localctx._p;

		case 2: return 6 >= _localctx._p;

		case 3: return 5 >= _localctx._p;

		case 4: return 4 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\24B\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\5\3\35\n\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\4\3\4\3\5\3\5\3\5\7"+
		"\58\n\5\f\5\16\5;\13\5\3\6\3\6\3\6\3\6\3\6\3\6\2\7\2\4\6\b\n\2\4\4\2\7"+
		"\7\t\t\3\2\20\22G\2\f\3\2\2\2\4\34\3\2\2\2\6\62\3\2\2\2\b\64\3\2\2\2\n"+
		"<\3\2\2\2\f\r\5\4\3\2\r\3\3\2\2\2\16\17\b\3\1\2\17\20\7\3\2\2\20\35\5"+
		"\4\3\2\21\22\7\13\2\2\22\35\5\4\3\2\23\24\7\t\2\2\24\35\5\4\3\2\25\26"+
		"\7\b\2\2\26\27\5\b\5\2\27\30\7\4\2\2\30\31\5\4\3\2\31\35\3\2\2\2\32\35"+
		"\5\6\4\2\33\35\7\24\2\2\34\16\3\2\2\2\34\21\3\2\2\2\34\23\3\2\2\2\34\25"+
		"\3\2\2\2\34\32\3\2\2\2\34\33\3\2\2\2\35/\3\2\2\2\36\37\6\3\2\3\37 \t\2"+
		"\2\2 .\5\4\3\2!\"\6\3\3\3\"#\7\f\2\2#.\5\4\3\2$%\6\3\4\3%&\7\5\2\2&.\5"+
		"\4\3\2\'(\6\3\5\3()\7\n\2\2).\5\4\3\2*+\6\3\6\3+,\7\16\2\2,.\5\4\3\2-"+
		"\36\3\2\2\2-!\3\2\2\2-$\3\2\2\2-\'\3\2\2\2-*\3\2\2\2.\61\3\2\2\2/-\3\2"+
		"\2\2/\60\3\2\2\2\60\5\3\2\2\2\61/\3\2\2\2\62\63\t\3\2\2\63\7\3\2\2\2\64"+
		"9\5\n\6\2\65\66\7\6\2\2\668\5\n\6\2\67\65\3\2\2\28;\3\2\2\29\67\3\2\2"+
		"\29:\3\2\2\2:\t\3\2\2\2;9\3\2\2\2<=\7\17\2\2=>\7\24\2\2>?\7\r\2\2?@\5"+
		"\4\3\2@\13\3\2\2\2\6\34-/9";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}