// Generated from E:/mycompiler/CCompiler/src/main/java\CCompiler.g4 by ANTLR 4.7
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
	 * Visit a parse tree produced by {@link CCompilerParser#preTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreTreatment(CCompilerParser.PreTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#globalTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalTreatment(CCompilerParser.GlobalTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#typedefTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedefTreatment(CCompilerParser.TypedefTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#complexType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComplexType(CCompilerParser.ComplexTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#structTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructTreatment(CCompilerParser.StructTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#myTypeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMyTypeName(CCompilerParser.MyTypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#structblock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStructblock(CCompilerParser.StructblockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#attrDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrDefine(CCompilerParser.AttrDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionTreatment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTreatment(CCompilerParser.FunctionTreatmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionDeclare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclare(CCompilerParser.FunctionDeclareContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefine(CCompilerParser.FunctionDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTitle(CCompilerParser.FunctionTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBlock(CCompilerParser.FunctionBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(CCompilerParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionName(CCompilerParser.FunctionNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#functionParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParams(CCompilerParser.FunctionParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(CCompilerParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#controlExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlExpression(CCompilerParser.ControlExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#forExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForExpression(CCompilerParser.ForExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#forTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForTitle(CCompilerParser.ForTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(CCompilerParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#returnExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpression(CCompilerParser.ReturnExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#whileExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileExpression(CCompilerParser.WhileExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#whileTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileTitle(CCompilerParser.WhileTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(CCompilerParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#ifTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfTitle(CCompilerParser.IfTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#elseifTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseifTitle(CCompilerParser.ElseifTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#elseTitle}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseTitle(CCompilerParser.ElseTitleContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#defineExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefineExpression(CCompilerParser.DefineExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(CCompilerParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefineWithInit}
	 * labeled alternative in {@link CCompilerParser#variableDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefineWithInit(CCompilerParser.VarDefineWithInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDefineWithoutInit}
	 * labeled alternative in {@link CCompilerParser#variableDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDefineWithoutInit(CCompilerParser.VarDefineWithoutInitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#arrayDefine}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDefine(CCompilerParser.ArrayDefineContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(CCompilerParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryAssign}
	 * labeled alternative in {@link CCompilerParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryAssign(CCompilerParser.BinaryAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unaryAssign}
	 * labeled alternative in {@link CCompilerParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryAssign(CCompilerParser.UnaryAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callAssign}
	 * labeled alternative in {@link CCompilerParser#assignExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallAssign(CCompilerParser.CallAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code valExpr}
	 * labeled alternative in {@link CCompilerParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValExpr(CCompilerParser.ValExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cmpExpr}
	 * labeled alternative in {@link CCompilerParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmpExpr(CCompilerParser.CmpExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link CCompilerParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(CCompilerParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charExpr}
	 * labeled alternative in {@link CCompilerParser#valueExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharExpr(CCompilerParser.CharExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketsVExpr}
	 * labeled alternative in {@link CCompilerParser#vExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketsVExpr(CCompilerParser.BracketsVExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code charVExpr}
	 * labeled alternative in {@link CCompilerParser#vExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCharVExpr(CCompilerParser.CharVExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varVExpr}
	 * labeled alternative in {@link CCompilerParser#vExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarVExpr(CCompilerParser.VarVExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code constVExpr}
	 * labeled alternative in {@link CCompilerParser#vExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstVExpr(CCompilerParser.ConstVExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryVExpr}
	 * labeled alternative in {@link CCompilerParser#vExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryVExpr(CCompilerParser.BinaryVExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callVExpr}
	 * labeled alternative in {@link CCompilerParser#vExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallVExpr(CCompilerParser.CallVExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#cExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCExpr(CCompilerParser.CExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code binaryCExpr}
	 * labeled alternative in {@link CCompilerParser#cunitExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryCExpr(CCompilerParser.BinaryCExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketCExpr}
	 * labeled alternative in {@link CCompilerParser#cunitExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketCExpr(CCompilerParser.BracketCExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notCExpr}
	 * labeled alternative in {@link CCompilerParser#cunitExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotCExpr(CCompilerParser.NotCExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callCExpr}
	 * labeled alternative in {@link CCompilerParser#cunitExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallCExpr(CCompilerParser.CallCExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#callExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallExpression(CCompilerParser.CallExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CCompilerParser#callParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallParam(CCompilerParser.CallParamContext ctx);
}