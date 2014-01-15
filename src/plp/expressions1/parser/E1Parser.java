// Generated from C:\Users\Lucena\Workspaces\Eclipse IDE for Java Developers 421\PLP2014\E1.g4 by ANTLR 4.1
package plp.expressions1.parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class E1Parser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__7=1, T__6=2, T__5=3, T__4=4, T__3=5, T__2=6, T__1=7, T__0=8, Inteiro=9, 
		Booleano=10, String=11, S=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'length'", "'and'", "'+'", "'-'", "'or'", "'not'", "'=='", 
		"'++'", "Inteiro", "Booleano", "String", "S"
	};
	public static final int
		RULE_programa = 0, RULE_expressao = 1, RULE_valor = 2;
	public static final String[] ruleNames = {
		"programa", "expressao", "valor"
	};

	@Override
	public String getGrammarFileName() { return "E1.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public E1Parser(TokenStream input) {
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
			if ( listener instanceof E1Listener ) ((E1Listener)listener).enterPrograma(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).exitPrograma(this);
		}
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(6); expressao(0);
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
	public static class OpUnariaContext extends ExpressaoContext {
		public ExpressaoContext expressao() {
			return getRuleContext(ExpressaoContext.class,0);
		}
		public OpUnariaContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).enterOpUnaria(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).exitOpUnaria(this);
		}
	}
	public static class TerminalContext extends ExpressaoContext {
		public ValorContext valor() {
			return getRuleContext(ValorContext.class,0);
		}
		public TerminalContext(ExpressaoContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).exitTerminal(this);
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
			if ( listener instanceof E1Listener ) ((E1Listener)listener).enterOpBin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).exitOpBin(this);
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
			setState(16);
			switch (_input.LA(1)) {
			case 1:
				{
				_localctx = new OpUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(9); match(1);
				setState(10); expressao(9);
				}
				break;
			case 6:
				{
				_localctx = new OpUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(11); match(6);
				setState(12); expressao(8);
				}
				break;
			case 4:
				{
				_localctx = new OpUnariaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(13); match(4);
				setState(14); expressao(7);
				}
				break;
			case Inteiro:
			case Booleano:
			case String:
				{
				_localctx = new TerminalContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15); valor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(35);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=-1 ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(33);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(18);
						if (!(6 >= _localctx._p)) throw new FailedPredicateException(this, "6 >= $_p");
						setState(19);
						_la = _input.LA(1);
						if ( !(_la==3 || _la==4) ) {
						_errHandler.recoverInline(this);
						}
						consume();
						setState(20); expressao(7);
						}
						break;

					case 2:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(21);
						if (!(5 >= _localctx._p)) throw new FailedPredicateException(this, "5 >= $_p");
						setState(22); match(2);
						setState(23); expressao(6);
						}
						break;

					case 3:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(24);
						if (!(4 >= _localctx._p)) throw new FailedPredicateException(this, "4 >= $_p");
						setState(25); match(5);
						setState(26); expressao(5);
						}
						break;

					case 4:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(27);
						if (!(3 >= _localctx._p)) throw new FailedPredicateException(this, "3 >= $_p");
						setState(28); match(7);
						setState(29); expressao(4);
						}
						break;

					case 5:
						{
						_localctx = new OpBinContext(new ExpressaoContext(_parentctx, _parentState, _p));
						pushNewRecursionContext(_localctx, _startState, RULE_expressao);
						setState(30);
						if (!(2 >= _localctx._p)) throw new FailedPredicateException(this, "2 >= $_p");
						setState(31); match(8);
						setState(32); expressao(3);
						}
						break;
					}
					} 
				}
				setState(37);
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
		public TerminalNode String() { return getToken(E1Parser.String, 0); }
		public TerminalNode Booleano() { return getToken(E1Parser.Booleano, 0); }
		public TerminalNode Inteiro() { return getToken(E1Parser.Inteiro, 0); }
		public ValorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).enterValor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof E1Listener ) ((E1Listener)listener).exitValor(this);
		}
	}

	public final ValorContext valor() throws RecognitionException {
		ValorContext _localctx = new ValorContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_valor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 1: return expressao_sempred((ExpressaoContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expressao_sempred(ExpressaoContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return 6 >= _localctx._p;

		case 1: return 5 >= _localctx._p;

		case 2: return 4 >= _localctx._p;

		case 3: return 3 >= _localctx._p;

		case 4: return 2 >= _localctx._p;
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\uacf5\uee8c\u4f5d\u8b0d\u4a45\u78bd\u1b2f\u3378\3\16+\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3\23\n\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\7\3$\n\3\f\3\16\3"+
		"\'\13\3\3\4\3\4\3\4\2\5\2\4\6\2\4\3\2\5\6\3\2\13\r/\2\b\3\2\2\2\4\22\3"+
		"\2\2\2\6(\3\2\2\2\b\t\5\4\3\2\t\3\3\2\2\2\n\13\b\3\1\2\13\f\7\3\2\2\f"+
		"\23\5\4\3\2\r\16\7\b\2\2\16\23\5\4\3\2\17\20\7\6\2\2\20\23\5\4\3\2\21"+
		"\23\5\6\4\2\22\n\3\2\2\2\22\r\3\2\2\2\22\17\3\2\2\2\22\21\3\2\2\2\23%"+
		"\3\2\2\2\24\25\6\3\2\3\25\26\t\2\2\2\26$\5\4\3\2\27\30\6\3\3\3\30\31\7"+
		"\4\2\2\31$\5\4\3\2\32\33\6\3\4\3\33\34\7\7\2\2\34$\5\4\3\2\35\36\6\3\5"+
		"\3\36\37\7\t\2\2\37$\5\4\3\2 !\6\3\6\3!\"\7\n\2\2\"$\5\4\3\2#\24\3\2\2"+
		"\2#\27\3\2\2\2#\32\3\2\2\2#\35\3\2\2\2# \3\2\2\2$\'\3\2\2\2%#\3\2\2\2"+
		"%&\3\2\2\2&\5\3\2\2\2\'%\3\2\2\2()\t\3\2\2)\7\3\2\2\2\5\22#%";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}