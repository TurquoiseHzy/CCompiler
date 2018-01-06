// Generated from /Users/turquoise/IdeaProjects/mycompiler/src/main/java/SimpleC.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleCParser}.
 */
public interface SimpleCListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleCParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleCParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#include}.
	 * @param ctx the parse tree
	 */
	void enterInclude(SimpleCParser.IncludeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#include}.
	 * @param ctx the parse tree
	 */
	void exitInclude(SimpleCParser.IncludeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(SimpleCParser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(SimpleCParser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(SimpleCParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(SimpleCParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#funcHeader}.
	 * @param ctx the parse tree
	 */
	void enterFuncHeader(SimpleCParser.FuncHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#funcHeader}.
	 * @param ctx the parse tree
	 */
	void exitFuncHeader(SimpleCParser.FuncHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void enterFuncParam(SimpleCParser.FuncParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void exitFuncParam(SimpleCParser.FuncParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#isPointer}.
	 * @param ctx the parse tree
	 */
	void enterIsPointer(SimpleCParser.IsPointerContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#isPointer}.
	 * @param ctx the parse tree
	 */
	void exitIsPointer(SimpleCParser.IsPointerContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#enclosedBlock}.
	 * @param ctx the parse tree
	 */
	void enterEnclosedBlock(SimpleCParser.EnclosedBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#enclosedBlock}.
	 * @param ctx the parse tree
	 */
	void exitEnclosedBlock(SimpleCParser.EnclosedBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SimpleCParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SimpleCParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#declareExpr}.
	 * @param ctx the parse tree
	 */
	void enterDeclareExpr(SimpleCParser.DeclareExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#declareExpr}.
	 * @param ctx the parse tree
	 */
	void exitDeclareExpr(SimpleCParser.DeclareExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(SimpleCParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(SimpleCParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareWithoutInit}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclareWithoutInit(SimpleCParser.DeclareWithoutInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareWithoutInit}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclareWithoutInit(SimpleCParser.DeclareWithoutInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareWithInit}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclareWithInit(SimpleCParser.DeclareWithInitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareWithInit}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclareWithInit(SimpleCParser.DeclareWithInitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeclareArray}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 */
	void enterDeclareArray(SimpleCParser.DeclareArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeclareArray}
	 * labeled alternative in {@link SimpleCParser#declare}.
	 * @param ctx the parse tree
	 */
	void exitDeclareArray(SimpleCParser.DeclareArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link SimpleCParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignVar(SimpleCParser.AssignVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignVar}
	 * labeled alternative in {@link SimpleCParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignVar(SimpleCParser.AssignVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignArrayMember}
	 * labeled alternative in {@link SimpleCParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void enterAssignArrayMember(SimpleCParser.AssignArrayMemberContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignArrayMember}
	 * labeled alternative in {@link SimpleCParser#assignExpr}.
	 * @param ctx the parse tree
	 */
	void exitAssignArrayMember(SimpleCParser.AssignArrayMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(SimpleCParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(SimpleCParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#funcCallExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncCallExpr(SimpleCParser.FuncCallExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#funcCallExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncCallExpr(SimpleCParser.FuncCallExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall(SimpleCParser.FuncCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall(SimpleCParser.FuncCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SimpleCParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void enterWhileBlock(SimpleCParser.WhileBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#whileBlock}.
	 * @param ctx the parse tree
	 */
	void exitWhileBlock(SimpleCParser.WhileBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfWithoutElse}
	 * labeled alternative in {@link SimpleCParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfWithoutElse(SimpleCParser.IfWithoutElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfWithoutElse}
	 * labeled alternative in {@link SimpleCParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfWithoutElse(SimpleCParser.IfWithoutElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfWithElse}
	 * labeled alternative in {@link SimpleCParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void enterIfWithElse(SimpleCParser.IfWithElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfWithElse}
	 * labeled alternative in {@link SimpleCParser#ifBlock}.
	 * @param ctx the parse tree
	 */
	void exitIfWithElse(SimpleCParser.IfWithElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(SimpleCParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(SimpleCParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryExpr(SimpleCParser.PrimaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#primaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryExpr(SimpleCParser.PrimaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(SimpleCParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(SimpleCParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(SimpleCParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(SimpleCParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void enterCompareExpr(SimpleCParser.CompareExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#compareExpr}.
	 * @param ctx the parse tree
	 */
	void exitCompareExpr(SimpleCParser.CompareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalSingle}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalSingle(SimpleCParser.LogicalSingleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalSingle}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalSingle(SimpleCParser.LogicalSingleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAnd(SimpleCParser.LogicalAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAnd}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAnd(SimpleCParser.LogicalAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOr(SimpleCParser.LogicalOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOr}
	 * labeled alternative in {@link SimpleCParser#logicalExpr}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOr(SimpleCParser.LogicalOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EvaluateValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 */
	void enterEvaluateValue(SimpleCParser.EvaluateValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EvaluateValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 */
	void exitEvaluateValue(SimpleCParser.EvaluateValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 */
	void enterStringValue(SimpleCParser.StringValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 */
	void exitStringValue(SimpleCParser.StringValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FuncValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 */
	void enterFuncValue(SimpleCParser.FuncValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FuncValue}
	 * labeled alternative in {@link SimpleCParser#valueExpr}.
	 * @param ctx the parse tree
	 */
	void exitFuncValue(SimpleCParser.FuncValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SimpleCParser#returnExpr}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpr(SimpleCParser.ReturnExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleCParser#returnExpr}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpr(SimpleCParser.ReturnExprContext ctx);
}