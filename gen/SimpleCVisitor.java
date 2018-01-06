// Generated from /Users/turquoise/IdeaProjects/mycompiler/src/main/java/SimpleC.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleCParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleCVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SimpleCParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#include}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclude(SimpleCParser.IncludeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#packageName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageName(SimpleCParser.PackageNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(SimpleCParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#funcHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncHeader(SimpleCParser.FuncHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#funcParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncParam(SimpleCParser.FuncParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#isPointer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsPointer(SimpleCParser.IsPointerContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#enclosedBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnclosedBlock(SimpleCParser.EnclosedBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SimpleCParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#declareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareExpr(SimpleCParser.DeclareExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(SimpleCParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareWithoutInit}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareWithoutInit(SimpleCParser.DeclareWithoutInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareWithInit}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareWithInit(SimpleCParser.DeclareWithInitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeclareArray}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclareArray(SimpleCParser.DeclareArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link SimpleCParser#assignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignVar(SimpleCParser.AssignVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignArrayMember}
	 * labeled alternative in {@link SimpleCParser#assignExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignArrayMember(SimpleCParser.AssignArrayMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(SimpleCParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#funcCallExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCallExpr(SimpleCParser.FuncCallExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(SimpleCParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#whileBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileBlock(SimpleCParser.WhileBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfWithoutElse}
	 * labeled alternative in {@link SimpleCParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfWithoutElse(SimpleCParser.IfWithoutElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfWithElse}
	 * labeled alternative in {@link SimpleCParser#ifBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfWithElse(SimpleCParser.IfWithElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(SimpleCParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#primaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryExpr(SimpleCParser.PrimaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(SimpleCParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(SimpleCParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#compareExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompareExpr(SimpleCParser.CompareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalSingle}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalSingle(SimpleCParser.LogicalSingleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAnd(SimpleCParser.LogicalAndContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOr(SimpleCParser.LogicalOrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EvaluateValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvaluateValue(SimpleCParser.EvaluateValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringValue(SimpleCParser.StringValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FuncValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncValue(SimpleCParser.FuncValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleCParser#returnExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpr(SimpleCParser.ReturnExprContext ctx);
}