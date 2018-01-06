grammar CCompiler;

prog : (pretreatment | declaration | func_def )* EOF;

pretreatment : '#' presentence;

presentence : 'include';

func_def : func_type func_name '(' func_param ')' func_block;

func_block : '{' statement* '}';

statement :  var_declaration | ret ;

    ret : RETURN return_val ';' ;

    return_val : INTVALUE | CHARVALUE ;

declaration : func_declaration | var_declaration;

func_declaration : func_type func_name '(' func_param ')' ';' ;

func_type : TYPE | VOID;

func_name : IDENTIFIER;

func_param : param_type param_name? (',' param_type param_name?)*  //has name?
            | ;

param_type : TYPE;

param_name : IDENTIFIER;

var_declaration : var_type var_name ('='(
{$var_type.text == "int"}? (var_value_int) |
{$var_type.text == "char"}? (var_value_char) )
)? ';' ;

var_type : TYPE;

var_name : IDENTIFIER;

var_value_int : INTVALUE;

var_value_char : '\'' CHARVALUE '\'';

//for




// words;

TYPE : INT | CHAR;

INT : 'int';

VOID : 'void';

CHAR : 'char';

INTVALUE : [0-9]+;

CHARVALUE : [a-z];

IDENTIFIER : [a-zA-Z_][a-zA-Z0-9_]* ;

    RETURN :  'return';

WS : [ \t\r\n]+ -> skip ;