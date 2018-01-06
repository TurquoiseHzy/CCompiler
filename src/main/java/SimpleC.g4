grammar SimpleC;


prog: include+ func+ EOF;

include: '#include' COMP packageName COMP ;

packageName: IDENTIFIER ('.' IDENTIFIER)? ;

func: funcHeader enclosedBlock ;

funcHeader: type isPointer funcName=IDENTIFIER '(' funcParam ')' ;

funcParam: (type isPointer IDENTIFIER ( ',' type isPointer IDENTIFIER )* )? ;

isPointer: ('*' | '[]')? ;

enclosedBlock: '{' (expression)* '}' ;

expression: declareExpr | assignExpr | unaryExpr | funcCallExpr | whileBlock | ifBlock | returnExpr ;

declareExpr: type isPointer declare (',' declare)* ';' ;

type: INT | CHAR | BOOL | VOID;

declare : IDENTIFIER            # DeclareWithoutInit
        | IDENTIFIER '=' valueExpr  # DeclareWithInit
        | IDENTIFIER '[' CONSTANT ']' # DeclareArray
        ;

assignExpr  : IDENTIFIER '=' valueExpr ';' # AssignVar
            | IDENTIFIER '[' valueExpr ']' '=' valueExpr ';' # AssignArrayMember
            ;

unaryExpr  : IDENTIFIER op=('++' | '--') ';'
            ;

funcCallExpr: funcCall ';' ;

funcCall: funcName=IDENTIFIER '(' ( valueExpr ( ',' valueExpr )* )? ')' ;

block: enclosedBlock | expression ;

whileBlock: WHILE condition block ;

ifBlock : IF condition block        # IfWithoutElse
        | IF condition block ELSE block # IfWithElse
        ;

condition: '(' valueExpr ')';

primaryExpr: IDENTIFIER
            | IDENTIFIER '[' valueExpr ']'
            | CONSTANT
            | '(' compareExpr ')'
            ;

multiplicativeExpr : primaryExpr
                    | multiplicativeExpr op=('*' | '/') primaryExpr
                    ;

additiveExpr   : ('+' | '-')? multiplicativeExpr
                | additiveExpr op=('+' | '-') multiplicativeExpr
                ;

compareExpr : additiveExpr
            | additiveExpr COMP additiveExpr
            ;

logicalExpr : compareExpr                   # LogicalSingle
            | logicalExpr '&&' compareExpr  # LogicalAnd
            | logicalExpr '||' compareExpr  # LogicalOr
            ;

valueExpr   : logicalExpr   # EvaluateValue
            | STRING        # StringValue
            | funcCall      # FuncValue
            ;

returnExpr: RETURN valueExpr ';';


IF: 'if' ;
ELSE: 'else' ;
WHILE: 'while' ;
FOR: 'for' ;
RETURN: 'return' ;
INT: 'int' ;
CHAR: 'char' ;
BOOL: 'bool' ;
VOID: 'void' ;

STRING: '"' (~["])* '"' ;
CONSTANT: [0-9]+ ('.' [0-9]+)? ;
IDENTIFIER: [a-zA-Z_] [a-zA-Z0-9_]* ;
COMP    : '==' | '<' | '>' | '<=' | '>=' | '!=';

WS: [ \t\r\n]+ -> skip ;