grammar CCompiler;

prog : ( preTreatment | globalTreatment | functionTreatment | structTreatment )* EOF;catch[RecognitionException e] { throw e; }

preTreatment : '#' 'include' '<' IDENTIFIER ('.h')? '>' | '#' 'include' '"' IDENTIFIER ('.h')? '"'; //ignore

globalTreatment : defineExpression ';'
                | typedefTreatment ';';

typedefTreatment : TYPEDEF complexType myTypeName;

complexType : (TYPE | 'STRUCT'? myTypeName) (POINTER)? ;

structTreatment : STRUCT myTypeName? structblock ';';

myTypeName : IDENTIFIER ;

structblock :   '{' attrDefine* '}';

attrDefine :  complexType IDENTIFIER ';' ;

functionTreatment : functionDefine | functionDeclare;

functionDeclare : functionTitle ';' ;

functionDefine : functionTitle functionBlock ;

functionTitle : functionType functionName '(' functionParams ')';

functionBlock : '{' ( (defineExpression ';') | controlExpression | assignExpression ';' | returnExpression';' )*  '}' ;

functionType : complexType | VOID POINTER? ;

functionName : IDENTIFIER ;

functionParams : param (',' param)*
				| ;

param : complexType IDENTIFIER ;

controlExpression : forExpression | ifExpression | whileExpression | CONTINUE ';'| BREAK ';';

forExpression : forTitle block;

forTitle : FOR '(' assignExpression ';' valueExpression ';' assignExpression ')' ;

block : '{' ( (defineExpression ';') | controlExpression | assignExpression ';' | returnExpression ';')* '}'
		| ( (defineExpression ';') | controlExpression | assignExpression ';' | returnExpression ';');

returnExpression : RETURN valueExpression;

whileExpression : whileTitle block;

whileTitle : WHILE '(' valueExpression ')' ;

ifExpression : ifTitle block ( elseifTitle block )* ( elseTitle block )? ;

ifTitle : IF '(' valueExpression ')' ;

elseifTitle : ELSEIF '(' valueExpression ')' ;

elseTitle : ELSE ;

defineExpression : variableDefine | arrayDefine ;

variableName : IDENTIFIER
            | IDENTIFIER'[' (variableName | valueExpression )']'
            | variableName op = ('.'|'->') IDENTIFIER;

variableDefine : complexType  IDENTIFIER '=' valueExpression # varDefineWithInit
				| complexType IDENTIFIER # varDefineWithoutInit;

arrayDefine : complexType IDENTIFIER '[' CONSTANT ']' ( '=' ( list | STRING))?; //to think

list : '{' (| CONSTANT (',' CONSTANT)? )'}';

assignExpression : variableName '=' valueExpression  #binaryAssign
				|  variableName op = ('++' | '--')     #unaryAssign
				|  callExpression                    #callAssign;

valueExpression : vExpr #valExpr
                | cExpr #cmpExpr
                | STRING #stringExpr
                | CHARVAL #charExpr;

vExpr :   vExpr op = ('+' | '-' | '*' | '/' |'+=' | '-=' | '*=' | '/=' | '%' | '%=') vExpr  #binaryVExpr
		| callExpression                                                                    #callVExpr
		| variableName                                                                      #varVExpr
		| CONSTANT                                                                         #constVExpr
		| '('  vExpr ')'                                                                   #bracketsVExpr
		| CHARVAL                                                                           #charVExpr;

cExpr : cunitExpr ( op = ('||' | '&&')  cunitExpr)* ;

cunitExpr : (vExpr op = ('>=' | '>' | '<' | '<=' | '==' | '!=' ) vExpr)       #binaryCExpr
            | '(' cunitExpr ')'                                                 #bracketCExpr
            |  '!' cunitExpr                                                    #notCExpr
            | callExpression                                                    #callCExpr;

callExpression : IDENTIFIER '(' callParam ')';

callParam : (valueExpression) (',' valueExpression )*
			| ;


TYPE :  INT | CHAR | BOOL | LONG | DOUBLE;


STRUCT : 'struct';
TYPEDEF : 'typedef';
POINTER : '*';
VOID : 'void';
INT : 'int';
CHAR : 'char';
BOOL : 'bool';
LONG : 'long';
DOUBLE : 'double';

FOR : 'for';
IF : 'if';
WHILE : 'while';
ELSE : 'else';
ELSEIF : 'else if';
RETURN : 'return';
CONTINUE : 'continue';
BREAK: 'break';


CONSTANT: [-]? [0-9]+ ('.' [0-9]+)? ;
IDENTIFIER: [a-zA-Z_] [a-zA-Z0-9_]* ;
STRING:  '"'(~["])* '"' ;
CHARVAL : '\'' (~[']) '\'' | '\'\\n\'' | '\'\\t\'';
WS : [ \t\r\n] -> skip;

