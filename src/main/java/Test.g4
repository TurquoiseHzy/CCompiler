grammar Test;

test : expr[0] EOF;

expr[int pr] : id
               ( {4 >= $pr}? '*' expr[5]
               | {3 >= $pr}? '+' expr[4]
               | {2 >= $pr}? '(' expr[0] ')'
               )*
             ;

id : ID;

ID : [0-9];

WS: [ \t\r\n]+ -> skip ;
