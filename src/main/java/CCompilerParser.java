// Generated from E:/mycompiler/src/main/java\CCompiler.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CCompilerParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, TYPE=11, INT=12, VOID=13, CHAR=14, INTVALUE=15, CHARVALUE=16, 
		IDENTIFIER=17, RETURN=18, WS=19;
	public static final int
		RULE_prog = 0, RULE_pretreatment = 1, RULE_presentence = 2, RULE_func_def = 3, 
		RULE_func_block = 4, RULE_statement = 5, RULE_ret = 6, RULE_return_val = 7, 
		RULE_declaration = 8, RULE_func_declaration = 9, RULE_func_type = 10, 
		RULE_func_name = 11, RULE_func_param = 12, RULE_param_type = 13, RULE_param_name = 14, 
		RULE_var_declaration = 15, RULE_var_type = 16, RULE_var_name = 17, RULE_var_value_int = 18, 
		RULE_var_value_char = 19;
	public static final String[] ruleNames = {
		"prog", "pretreatment", "presentence", "func_def", "func_block", "statement", 
		"ret", "return_val", "declaration", "func_declaration", "func_type", "func_name", 
		"func_param", "param_type", "param_name", "var_declaration", "var_type", 
		"var_name", "var_value_int", "var_value_char"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'#'", "'include'", "'('", "')'", "'{'", "'}'", "';'", "','", "'='", 
		"'''", null, "'int'", "'void'", "'char'", null, null, null, "'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "TYPE", 
		"INT", "VOID", "CHAR", "INTVALUE", "CHARVALUE", "IDENTIFIER", "RETURN", 
		"WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CCompilerParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(CCompilerParser.EOF, 0); }
		public List<PretreatmentContext> pretreatment() {
			return getRuleContexts(PretreatmentContext.class);
		}
		public PretreatmentContext pretreatment(int i) {
			return getRuleContext(PretreatmentContext.class,i);
		}
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << TYPE) | (1L << VOID))) != 0)) {
				{
				setState(43);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(40);
					pretreatment();
					}
					break;
				case 2:
					{
					setState(41);
					declaration();
					}
					break;
				case 3:
					{
					setState(42);
					func_def();
					}
					break;
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(EOF);
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

	public static class PretreatmentContext extends ParserRuleContext {
		public PresentenceContext presentence() {
			return getRuleContext(PresentenceContext.class,0);
		}
		public PretreatmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pretreatment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitPretreatment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PretreatmentContext pretreatment() throws RecognitionException {
		PretreatmentContext _localctx = new PretreatmentContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pretreatment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(T__0);
			setState(51);
			presentence();
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

	public static class PresentenceContext extends ParserRuleContext {
		public PresentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_presentence; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitPresentence(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PresentenceContext presentence() throws RecognitionException {
		PresentenceContext _localctx = new PresentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_presentence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(T__1);
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

	public static class Func_defContext extends ParserRuleContext {
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public Func_paramContext func_param() {
			return getRuleContext(Func_paramContext.class,0);
		}
		public Func_blockContext func_block() {
			return getRuleContext(Func_blockContext.class,0);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunc_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			func_type();
			setState(56);
			func_name();
			setState(57);
			match(T__2);
			setState(58);
			func_param();
			setState(59);
			match(T__3);
			setState(60);
			func_block();
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

	public static class Func_blockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Func_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunc_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_blockContext func_block() throws RecognitionException {
		Func_blockContext _localctx = new Func_blockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_func_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(T__4);
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TYPE || _la==RETURN) {
				{
				{
				setState(63);
				statement();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(69);
			match(T__5);
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

	public static class StatementContext extends ParserRuleContext {
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public RetContext ret() {
			return getRuleContext(RetContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(73);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(71);
				var_declaration();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(72);
				ret();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class RetContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(CCompilerParser.RETURN, 0); }
		public Return_valContext return_val() {
			return getRuleContext(Return_valContext.class,0);
		}
		public RetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ret; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitRet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final RetContext ret() throws RecognitionException {
		RetContext _localctx = new RetContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_ret);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			match(RETURN);
			setState(76);
			return_val();
			setState(77);
			match(T__6);
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

	public static class Return_valContext extends ParserRuleContext {
		public TerminalNode INTVALUE() { return getToken(CCompilerParser.INTVALUE, 0); }
		public TerminalNode CHARVALUE() { return getToken(CCompilerParser.CHARVALUE, 0); }
		public Return_valContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_val; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitReturn_val(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_valContext return_val() throws RecognitionException {
		Return_valContext _localctx = new Return_valContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_return_val);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			_la = _input.LA(1);
			if ( !(_la==INTVALUE || _la==CHARVALUE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class DeclarationContext extends ParserRuleContext {
		public Func_declarationContext func_declaration() {
			return getRuleContext(Func_declarationContext.class,0);
		}
		public Var_declarationContext var_declaration() {
			return getRuleContext(Var_declarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaration);
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				func_declaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(82);
				var_declaration();
				}
				break;
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

	public static class Func_declarationContext extends ParserRuleContext {
		public Func_typeContext func_type() {
			return getRuleContext(Func_typeContext.class,0);
		}
		public Func_nameContext func_name() {
			return getRuleContext(Func_nameContext.class,0);
		}
		public Func_paramContext func_param() {
			return getRuleContext(Func_paramContext.class,0);
		}
		public Func_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunc_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_declarationContext func_declaration() throws RecognitionException {
		Func_declarationContext _localctx = new Func_declarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_func_declaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			func_type();
			setState(86);
			func_name();
			setState(87);
			match(T__2);
			setState(88);
			func_param();
			setState(89);
			match(T__3);
			setState(90);
			match(T__6);
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

	public static class Func_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CCompilerParser.TYPE, 0); }
		public TerminalNode VOID() { return getToken(CCompilerParser.VOID, 0); }
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunc_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_func_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !(_la==TYPE || _la==VOID) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class Func_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CCompilerParser.IDENTIFIER, 0); }
		public Func_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunc_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_nameContext func_name() throws RecognitionException {
		Func_nameContext _localctx = new Func_nameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_func_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(IDENTIFIER);
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

	public static class Func_paramContext extends ParserRuleContext {
		public List<Param_typeContext> param_type() {
			return getRuleContexts(Param_typeContext.class);
		}
		public Param_typeContext param_type(int i) {
			return getRuleContext(Param_typeContext.class,i);
		}
		public List<Param_nameContext> param_name() {
			return getRuleContexts(Param_nameContext.class);
		}
		public Param_nameContext param_name(int i) {
			return getRuleContext(Param_nameContext.class,i);
		}
		public Func_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_param; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitFunc_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_paramContext func_param() throws RecognitionException {
		Func_paramContext _localctx = new Func_paramContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_func_param);
		int _la;
		try {
			setState(111);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TYPE:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				param_type();
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(97);
					param_name();
					}
				}

				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(100);
					match(T__7);
					setState(101);
					param_type();
					setState(103);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==IDENTIFIER) {
						{
						setState(102);
						param_name();
						}
					}

					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Param_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CCompilerParser.TYPE, 0); }
		public Param_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitParam_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_typeContext param_type() throws RecognitionException {
		Param_typeContext _localctx = new Param_typeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_param_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(TYPE);
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

	public static class Param_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CCompilerParser.IDENTIFIER, 0); }
		public Param_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitParam_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_nameContext param_name() throws RecognitionException {
		Param_nameContext _localctx = new Param_nameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_param_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			match(IDENTIFIER);
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

	public static class Var_declarationContext extends ParserRuleContext {
		public Var_typeContext var_type;
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Var_nameContext var_name() {
			return getRuleContext(Var_nameContext.class,0);
		}
		public Var_value_intContext var_value_int() {
			return getRuleContext(Var_value_intContext.class,0);
		}
		public Var_value_charContext var_value_char() {
			return getRuleContext(Var_value_charContext.class,0);
		}
		public Var_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitVar_declaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declarationContext var_declaration() throws RecognitionException {
		Var_declarationContext _localctx = new Var_declarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_var_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			((Var_declarationContext)_localctx).var_type = var_type();
			setState(118);
			var_name();
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(119);
				match(T__8);
				setState(124);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
				case 1:
					{
					setState(120);
					if (!((((Var_declarationContext)_localctx).var_type!=null?_input.getText(((Var_declarationContext)_localctx).var_type.start,((Var_declarationContext)_localctx).var_type.stop):null) == "int")) throw new FailedPredicateException(this, "$var_type.text == \"int\"");
					{
					setState(121);
					var_value_int();
					}
					}
					break;
				case 2:
					{
					setState(122);
					if (!((((Var_declarationContext)_localctx).var_type!=null?_input.getText(((Var_declarationContext)_localctx).var_type.start,((Var_declarationContext)_localctx).var_type.stop):null) == "char")) throw new FailedPredicateException(this, "$var_type.text == \"char\"");
					{
					setState(123);
					var_value_char();
					}
					}
					break;
				}
				}
			}

			setState(128);
			match(T__6);
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

	public static class Var_typeContext extends ParserRuleContext {
		public TerminalNode TYPE() { return getToken(CCompilerParser.TYPE, 0); }
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitVar_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_var_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(TYPE);
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

	public static class Var_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(CCompilerParser.IDENTIFIER, 0); }
		public Var_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_name; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitVar_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_nameContext var_name() throws RecognitionException {
		Var_nameContext _localctx = new Var_nameContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_var_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(IDENTIFIER);
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

	public static class Var_value_intContext extends ParserRuleContext {
		public TerminalNode INTVALUE() { return getToken(CCompilerParser.INTVALUE, 0); }
		public Var_value_intContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_value_int; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitVar_value_int(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_value_intContext var_value_int() throws RecognitionException {
		Var_value_intContext _localctx = new Var_value_intContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_var_value_int);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(INTVALUE);
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

	public static class Var_value_charContext extends ParserRuleContext {
		public TerminalNode CHARVALUE() { return getToken(CCompilerParser.CHARVALUE, 0); }
		public Var_value_charContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_value_char; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CCompilerVisitor ) return ((CCompilerVisitor<? extends T>)visitor).visitVar_value_char(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_value_charContext var_value_char() throws RecognitionException {
		Var_value_charContext _localctx = new Var_value_charContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_var_value_char);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(136);
			match(T__9);
			setState(137);
			match(CHARVALUE);
			setState(138);
			match(T__9);
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
		case 15:
			return var_declaration_sempred((Var_declarationContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean var_declaration_sempred(Var_declarationContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return (((Var_declarationContext)_localctx).var_type!=null?_input.getText(((Var_declarationContext)_localctx).var_type.start,((Var_declarationContext)_localctx).var_type.stop):null) == "int";
		case 1:
			return (((Var_declarationContext)_localctx).var_type!=null?_input.getText(((Var_declarationContext)_localctx).var_type.start,((Var_declarationContext)_localctx).var_type.stop):null) == "char";
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\u008f\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\3\2\3\2\3\2\7\2.\n\2\f\2\16\2\61\13\2\3"+
		"\2\3\2\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\7\6C\n"+
		"\6\f\6\16\6F\13\6\3\6\3\6\3\7\3\7\5\7L\n\7\3\b\3\b\3\b\3\b\3\t\3\t\3\n"+
		"\3\n\5\nV\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\5\16e\n\16\3\16\3\16\3\16\5\16j\n\16\7\16l\n\16\f\16\16\16o\13\16"+
		"\3\16\5\16r\n\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\177\n\21\5\21\u0081\n\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\2\2\26\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
		" \"$&(\2\4\3\2\21\22\4\2\r\r\17\17\2\u0086\2/\3\2\2\2\4\64\3\2\2\2\6\67"+
		"\3\2\2\2\b9\3\2\2\2\n@\3\2\2\2\fK\3\2\2\2\16M\3\2\2\2\20Q\3\2\2\2\22U"+
		"\3\2\2\2\24W\3\2\2\2\26^\3\2\2\2\30`\3\2\2\2\32q\3\2\2\2\34s\3\2\2\2\36"+
		"u\3\2\2\2 w\3\2\2\2\"\u0084\3\2\2\2$\u0086\3\2\2\2&\u0088\3\2\2\2(\u008a"+
		"\3\2\2\2*.\5\4\3\2+.\5\22\n\2,.\5\b\5\2-*\3\2\2\2-+\3\2\2\2-,\3\2\2\2"+
		".\61\3\2\2\2/-\3\2\2\2/\60\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\2"+
		"\2\3\63\3\3\2\2\2\64\65\7\3\2\2\65\66\5\6\4\2\66\5\3\2\2\2\678\7\4\2\2"+
		"8\7\3\2\2\29:\5\26\f\2:;\5\30\r\2;<\7\5\2\2<=\5\32\16\2=>\7\6\2\2>?\5"+
		"\n\6\2?\t\3\2\2\2@D\7\7\2\2AC\5\f\7\2BA\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE"+
		"\3\2\2\2EG\3\2\2\2FD\3\2\2\2GH\7\b\2\2H\13\3\2\2\2IL\5 \21\2JL\5\16\b"+
		"\2KI\3\2\2\2KJ\3\2\2\2L\r\3\2\2\2MN\7\24\2\2NO\5\20\t\2OP\7\t\2\2P\17"+
		"\3\2\2\2QR\t\2\2\2R\21\3\2\2\2SV\5\24\13\2TV\5 \21\2US\3\2\2\2UT\3\2\2"+
		"\2V\23\3\2\2\2WX\5\26\f\2XY\5\30\r\2YZ\7\5\2\2Z[\5\32\16\2[\\\7\6\2\2"+
		"\\]\7\t\2\2]\25\3\2\2\2^_\t\3\2\2_\27\3\2\2\2`a\7\23\2\2a\31\3\2\2\2b"+
		"d\5\34\17\2ce\5\36\20\2dc\3\2\2\2de\3\2\2\2em\3\2\2\2fg\7\n\2\2gi\5\34"+
		"\17\2hj\5\36\20\2ih\3\2\2\2ij\3\2\2\2jl\3\2\2\2kf\3\2\2\2lo\3\2\2\2mk"+
		"\3\2\2\2mn\3\2\2\2nr\3\2\2\2om\3\2\2\2pr\3\2\2\2qb\3\2\2\2qp\3\2\2\2r"+
		"\33\3\2\2\2st\7\r\2\2t\35\3\2\2\2uv\7\23\2\2v\37\3\2\2\2wx\5\"\22\2x\u0080"+
		"\5$\23\2y~\7\13\2\2z{\6\21\2\3{\177\5&\24\2|}\6\21\3\3}\177\5(\25\2~z"+
		"\3\2\2\2~|\3\2\2\2\177\u0081\3\2\2\2\u0080y\3\2\2\2\u0080\u0081\3\2\2"+
		"\2\u0081\u0082\3\2\2\2\u0082\u0083\7\t\2\2\u0083!\3\2\2\2\u0084\u0085"+
		"\7\r\2\2\u0085#\3\2\2\2\u0086\u0087\7\23\2\2\u0087%\3\2\2\2\u0088\u0089"+
		"\7\21\2\2\u0089\'\3\2\2\2\u008a\u008b\7\f\2\2\u008b\u008c\7\22\2\2\u008c"+
		"\u008d\7\f\2\2\u008d)\3\2\2\2\r-/DKUdimq~\u0080";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}