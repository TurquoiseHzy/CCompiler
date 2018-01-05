// Generated from E:/mycompiler/src/main/java\CCompiler.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CCompilerParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CCompilerVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(CCompilerParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#pretreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPretreatment(CCompilerParser.PretreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#presentence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPresentence(CCompilerParser.PresentenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_def(CCompilerParser.Func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#func_block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_block(CCompilerParser.Func_blockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(CCompilerParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#ret}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRet(CCompilerParser.RetContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#return_val}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn_val(CCompilerParser.Return_valContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(CCompilerParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#func_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_declaration(CCompilerParser.Func_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#func_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_type(CCompilerParser.Func_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#func_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_name(CCompilerParser.Func_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#func_param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_param(CCompilerParser.Func_paramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#param_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_type(CCompilerParser.Param_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#param_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam_name(CCompilerParser.Param_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#var_declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_declaration(CCompilerParser.Var_declarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#var_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_type(CCompilerParser.Var_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#var_name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_name(CCompilerParser.Var_nameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#var_value_int}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_value_int(CCompilerParser.Var_value_intContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#var_value_char}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_value_char(CCompilerParser.Var_value_charContext ctx);
}