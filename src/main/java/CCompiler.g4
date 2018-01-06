grammar CCompiler;

prog : ( preTreatment | globalTreatment | functionTreatment )* EOF;

preTreatment : '#' 'include' '<' IDENTIFIER ('.h')? '>'; //ignore

globalTreatment : defineExpression ';' ;

functionTreatment : functionDefine | functionDeclare;

functionDeclare : functionTitle ';' ;

functionDefine : functionTitle functionBlock ;

functionTitle : functionType functionName '(' functionParams ')';

functionBlock : '{' ( (defineExpression ';') | controlExpression | assignExpression ';' | returnExpression';' )*  '}' ;

functionType : TYPE | VOID ;

functionName : IDENTIFIER ;

functionParams : param (',' param)*
				| ;

param : TYPE IDENTIFIER ;

controlExpression : forExpression | ifExpression | whileExpression ;

forExpression : forTitle block;

forTitle : FOR '(' assignExpression ';' valueExpression ';' assignExpression ')' ;

block : '{' ( (defineExpression ';') | controlExpression | assignExpression ';' | returnExpression ';' )* '}'
		| ( (defineExpression ';') | controlExpression | assignExpression ';' | returnExpression ';' );

returnExpression : RETURN valueExpression;

whileExpression : whileTitle block;

whileTitle : WHILE '(' valueExpression ')' ;

ifExpression : ifTitle block ( elseifTitle block )* ( elseTitle block )? ;

ifTitle : IF '(' valueExpression ')' ;

elseifTitle : ELSEIF '(' valueExpression ')' ;

elseTitle : ELSE ;

defineExpression : variableDefine | arrayDefine ;

variableName : IDENTIFIER
            | IDENTIFIER'[' (variableName | CONSTANT )']';

variableDefine : TYPE IDENTIFIER '=' valueExpression # varDefineWithInit
				| TYPE IDENTIFIER # varDefineWithoutInit;

arrayDefine : TYPE IDENTIFIER '[' CONSTANT ']' ; //to think

assignExpression : variableName '=' valueExpression  #binaryAssign
				|  variableName op = ('++' | '--')     #unaryAssign
				|  callExpression                    #callAssign;

valueExpression : vExpr | cExpr | STRING | CHARVAL;

vExpr :   vExpr op = ('+' | '-' | '*' | '/' |'+=' | '-=' | '*=' | '/=' | '%' | '%=') vExpr  #binaryVExpr
		| callExpression                                                                    #callVExpr
		| variableName                                                                      #varVExpr
		| CONSTANT                                                                         #constVExpr;

cExpr : cunitExpr ( op = ('||' | '&&')  cunitExpr)*;

cunitExpr : (vExpr op = ('>=' | '>' | '<' | '<=' | '==' | '!=' ) vExpr);

callExpression : IDENTIFIER '(' callParam ')';

callParam : (valueExpression) (',' valueExpression )*
			| ;


TYPE : INT | CHAR | BOOL | LONG | CHARSTAR | INTSTAR;

INTSTAR : 'int*';
CHARSTAR : 'char*';
VOID : 'void';
INT : 'int';
CHAR : 'char';
BOOL : 'bool';
LONG : 'long';

FOR : 'for';
IF : 'if';
WHILE : 'while';
ELSE : 'else';
ELSEIF : 'else if';
RETURN : 'return';

CONSTANT: [-]? [0-9]+ ('.' [0-9]+)? ;
IDENTIFIER: [a-zA-Z_] [a-zA-Z0-9_]* ;
STRING: '"' (~["])* '"' ;
CHARVAL : '\'' (~[']) '\'';
WS : [ \t\r\n] -> skip;

