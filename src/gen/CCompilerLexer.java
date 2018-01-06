// Generated from C:/Users/dlwog/CCompiler/src/main/java\CCompiler.g4 by ANTLR 4.7
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CCompilerLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, TYPE=33, INTSTAR=34, CHARSTAR=35, VOID=36, INT=37, CHAR=38, 
		BOOL=39, LONG=40, FOR=41, IF=42, WHILE=43, ELSE=44, ELSEIF=45, RETURN=46, 
		CONSTANT=47, IDENTIFIER=48, STRING=49, CHARVAL=50, WS=51;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "TYPE", 
		"INTSTAR", "CHARSTAR", "VOID", "INT", "CHAR", "BOOL", "LONG", "FOR", "IF", 
		"WHILE", "ELSE", "ELSEIF", "RETURN", "CONSTANT", "IDENTIFIER", "STRING", 
		"CHARVAL", "WS"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'#'", "'include'", "'<'", "'.h'", "'>'", "';'", "'('", "')'", "'{'", 
		"'}'", "','", "'['", "']'", "'='", "'++'", "'--'", "'+'", "'-'", "'*'", 
		"'/'", "'+='", "'-='", "'*='", "'/='", "'%'", "'%='", "'||'", "'&&'", 
		"'>='", "'<='", "'=='", "'!='", null, "'int*'", "'char*'", "'void'", "'int'", 
		"'char'", "'bool'", "'long'", "'for'", "'if'", "'while'", "'else'", "'else if'", 
		"'return'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "TYPE", "INTSTAR", 
		"CHARSTAR", "VOID", "INT", "CHAR", "BOOL", "LONG", "FOR", "IF", "WHILE", 
		"ELSE", "ELSEIF", "RETURN", "CONSTANT", "IDENTIFIER", "STRING", "CHARVAL", 
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


	public CCompilerLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CCompiler.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\65\u0131\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64"+
		"\t\64\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00c4"+
		"\n\"\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3*\3*\3*\3*\3+\3+\3+\3,\3"+
		",\3,\3,\3,\3,\3-\3-\3-\3-\3-\3.\3.\3.\3.\3.\3.\3.\3.\3/\3/\3/\3/\3/\3"+
		"/\3/\3\60\5\60\u010b\n\60\3\60\6\60\u010e\n\60\r\60\16\60\u010f\3\60\3"+
		"\60\6\60\u0114\n\60\r\60\16\60\u0115\5\60\u0118\n\60\3\61\3\61\7\61\u011c"+
		"\n\61\f\61\16\61\u011f\13\61\3\62\3\62\7\62\u0123\n\62\f\62\16\62\u0126"+
		"\13\62\3\62\3\62\3\63\3\63\3\63\3\63\3\64\3\64\3\64\3\64\2\2\65\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65\3\2\t\3\2//\3\2"+
		"\62;\5\2C\\aac|\6\2\62;C\\aac|\3\2$$\3\2))\5\2\13\f\17\17\"\"\2\u013b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5k\3\2\2\2\7s\3\2\2"+
		"\2\tu\3\2\2\2\13x\3\2\2\2\rz\3\2\2\2\17|\3\2\2\2\21~\3\2\2\2\23\u0080"+
		"\3\2\2\2\25\u0082\3\2\2\2\27\u0084\3\2\2\2\31\u0086\3\2\2\2\33\u0088\3"+
		"\2\2\2\35\u008a\3\2\2\2\37\u008c\3\2\2\2!\u008f\3\2\2\2#\u0092\3\2\2\2"+
		"%\u0094\3\2\2\2\'\u0096\3\2\2\2)\u0098\3\2\2\2+\u009a\3\2\2\2-\u009d\3"+
		"\2\2\2/\u00a0\3\2\2\2\61\u00a3\3\2\2\2\63\u00a6\3\2\2\2\65\u00a8\3\2\2"+
		"\2\67\u00ab\3\2\2\29\u00ae\3\2\2\2;\u00b1\3\2\2\2=\u00b4\3\2\2\2?\u00b7"+
		"\3\2\2\2A\u00ba\3\2\2\2C\u00c3\3\2\2\2E\u00c5\3\2\2\2G\u00ca\3\2\2\2I"+
		"\u00d0\3\2\2\2K\u00d5\3\2\2\2M\u00d9\3\2\2\2O\u00de\3\2\2\2Q\u00e3\3\2"+
		"\2\2S\u00e8\3\2\2\2U\u00ec\3\2\2\2W\u00ef\3\2\2\2Y\u00f5\3\2\2\2[\u00fa"+
		"\3\2\2\2]\u0102\3\2\2\2_\u010a\3\2\2\2a\u0119\3\2\2\2c\u0120\3\2\2\2e"+
		"\u0129\3\2\2\2g\u012d\3\2\2\2ij\7%\2\2j\4\3\2\2\2kl\7k\2\2lm\7p\2\2mn"+
		"\7e\2\2no\7n\2\2op\7w\2\2pq\7f\2\2qr\7g\2\2r\6\3\2\2\2st\7>\2\2t\b\3\2"+
		"\2\2uv\7\60\2\2vw\7j\2\2w\n\3\2\2\2xy\7@\2\2y\f\3\2\2\2z{\7=\2\2{\16\3"+
		"\2\2\2|}\7*\2\2}\20\3\2\2\2~\177\7+\2\2\177\22\3\2\2\2\u0080\u0081\7}"+
		"\2\2\u0081\24\3\2\2\2\u0082\u0083\7\177\2\2\u0083\26\3\2\2\2\u0084\u0085"+
		"\7.\2\2\u0085\30\3\2\2\2\u0086\u0087\7]\2\2\u0087\32\3\2\2\2\u0088\u0089"+
		"\7_\2\2\u0089\34\3\2\2\2\u008a\u008b\7?\2\2\u008b\36\3\2\2\2\u008c\u008d"+
		"\7-\2\2\u008d\u008e\7-\2\2\u008e \3\2\2\2\u008f\u0090\7/\2\2\u0090\u0091"+
		"\7/\2\2\u0091\"\3\2\2\2\u0092\u0093\7-\2\2\u0093$\3\2\2\2\u0094\u0095"+
		"\7/\2\2\u0095&\3\2\2\2\u0096\u0097\7,\2\2\u0097(\3\2\2\2\u0098\u0099\7"+
		"\61\2\2\u0099*\3\2\2\2\u009a\u009b\7-\2\2\u009b\u009c\7?\2\2\u009c,\3"+
		"\2\2\2\u009d\u009e\7/\2\2\u009e\u009f\7?\2\2\u009f.\3\2\2\2\u00a0\u00a1"+
		"\7,\2\2\u00a1\u00a2\7?\2\2\u00a2\60\3\2\2\2\u00a3\u00a4\7\61\2\2\u00a4"+
		"\u00a5\7?\2\2\u00a5\62\3\2\2\2\u00a6\u00a7\7\'\2\2\u00a7\64\3\2\2\2\u00a8"+
		"\u00a9\7\'\2\2\u00a9\u00aa\7?\2\2\u00aa\66\3\2\2\2\u00ab\u00ac\7~\2\2"+
		"\u00ac\u00ad\7~\2\2\u00ad8\3\2\2\2\u00ae\u00af\7(\2\2\u00af\u00b0\7(\2"+
		"\2\u00b0:\3\2\2\2\u00b1\u00b2\7@\2\2\u00b2\u00b3\7?\2\2\u00b3<\3\2\2\2"+
		"\u00b4\u00b5\7>\2\2\u00b5\u00b6\7?\2\2\u00b6>\3\2\2\2\u00b7\u00b8\7?\2"+
		"\2\u00b8\u00b9\7?\2\2\u00b9@\3\2\2\2\u00ba\u00bb\7#\2\2\u00bb\u00bc\7"+
		"?\2\2\u00bcB\3\2\2\2\u00bd\u00c4\5K&\2\u00be\u00c4\5M\'\2\u00bf\u00c4"+
		"\5O(\2\u00c0\u00c4\5Q)\2\u00c1\u00c4\5G$\2\u00c2\u00c4\5E#\2\u00c3\u00bd"+
		"\3\2\2\2\u00c3\u00be\3\2\2\2\u00c3\u00bf\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c3"+
		"\u00c1\3\2\2\2\u00c3\u00c2\3\2\2\2\u00c4D\3\2\2\2\u00c5\u00c6\7k\2\2\u00c6"+
		"\u00c7\7p\2\2\u00c7\u00c8\7v\2\2\u00c8\u00c9\7,\2\2\u00c9F\3\2\2\2\u00ca"+
		"\u00cb\7e\2\2\u00cb\u00cc\7j\2\2\u00cc\u00cd\7c\2\2\u00cd\u00ce\7t\2\2"+
		"\u00ce\u00cf\7,\2\2\u00cfH\3\2\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7q\2"+
		"\2\u00d2\u00d3\7k\2\2\u00d3\u00d4\7f\2\2\u00d4J\3\2\2\2\u00d5\u00d6\7"+
		"k\2\2\u00d6\u00d7\7p\2\2\u00d7\u00d8\7v\2\2\u00d8L\3\2\2\2\u00d9\u00da"+
		"\7e\2\2\u00da\u00db\7j\2\2\u00db\u00dc\7c\2\2\u00dc\u00dd\7t\2\2\u00dd"+
		"N\3\2\2\2\u00de\u00df\7d\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1\7q\2\2\u00e1"+
		"\u00e2\7n\2\2\u00e2P\3\2\2\2\u00e3\u00e4\7n\2\2\u00e4\u00e5\7q\2\2\u00e5"+
		"\u00e6\7p\2\2\u00e6\u00e7\7i\2\2\u00e7R\3\2\2\2\u00e8\u00e9\7h\2\2\u00e9"+
		"\u00ea\7q\2\2\u00ea\u00eb\7t\2\2\u00ebT\3\2\2\2\u00ec\u00ed\7k\2\2\u00ed"+
		"\u00ee\7h\2\2\u00eeV\3\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1\7j\2\2\u00f1"+
		"\u00f2\7k\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7g\2\2\u00f4X\3\2\2\2\u00f5"+
		"\u00f6\7g\2\2\u00f6\u00f7\7n\2\2\u00f7\u00f8\7u\2\2\u00f8\u00f9\7g\2\2"+
		"\u00f9Z\3\2\2\2\u00fa\u00fb\7g\2\2\u00fb\u00fc\7n\2\2\u00fc\u00fd\7u\2"+
		"\2\u00fd\u00fe\7g\2\2\u00fe\u00ff\7\"\2\2\u00ff\u0100\7k\2\2\u0100\u0101"+
		"\7h\2\2\u0101\\\3\2\2\2\u0102\u0103\7t\2\2\u0103\u0104\7g\2\2\u0104\u0105"+
		"\7v\2\2\u0105\u0106\7w\2\2\u0106\u0107\7t\2\2\u0107\u0108\7p\2\2\u0108"+
		"^\3\2\2\2\u0109\u010b\t\2\2\2\u010a\u0109\3\2\2\2\u010a\u010b\3\2\2\2"+
		"\u010b\u010d\3\2\2\2\u010c\u010e\t\3\2\2\u010d\u010c\3\2\2\2\u010e\u010f"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0117\3\2\2\2\u0111"+
		"\u0113\7\60\2\2\u0112\u0114\t\3\2\2\u0113\u0112\3\2\2\2\u0114\u0115\3"+
		"\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116\3\2\2\2\u0116\u0118\3\2\2\2\u0117"+
		"\u0111\3\2\2\2\u0117\u0118\3\2\2\2\u0118`\3\2\2\2\u0119\u011d\t\4\2\2"+
		"\u011a\u011c\t\5\2\2\u011b\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011b"+
		"\3\2\2\2\u011d\u011e\3\2\2\2\u011eb\3\2\2\2\u011f\u011d\3\2\2\2\u0120"+
		"\u0124\7$\2\2\u0121\u0123\n\6\2\2\u0122\u0121\3\2\2\2\u0123\u0126\3\2"+
		"\2\2\u0124\u0122\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0127\3\2\2\2\u0126"+
		"\u0124\3\2\2\2\u0127\u0128\7$\2\2\u0128d\3\2\2\2\u0129\u012a\7)\2\2\u012a"+
		"\u012b\n\7\2\2\u012b\u012c\7)\2\2\u012cf\3\2\2\2\u012d\u012e\t\b\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0130\b\64\2\2\u0130h\3\2\2\2\n\2\u00c3\u010a\u010f"+
		"\u0115\u0117\u011d\u0124\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}