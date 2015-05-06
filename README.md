PLP
===

[![Join the chat at https://gitter.im/lrlucena/PLP-Scala](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/lrlucena/PLP-Scala?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

Reimplementação das linguagens de programação do curso de PLP da UFPE (http://www.cin.ufpe.br/~in1007/linguagens/) na linguagem Scala usando o ANTLR.


```ANTLR
grammar E1;

programa : expressao ;
expressao : 'length' expressao              # opUnaria
          | 'not' expressao                 # opUnaria
          | '-' expressao                   # opUnaria
          | expressao ('+'|'-') expressao   # opBin
          | expressao '==' expressao        # opBin
          | expressao 'and' expressao       # opBin
          | expressao 'or' expressao        # opBin
          | expressao '++' expressao        # opBin
          | valor                           # terminal
          ;

valor : Inteiro | Booleano | String ;

Inteiro : ('0'..'9')+ ;
Booleano : 'verdadeiro' | 'falso';
String : '"' .*? '"' ;
S: (' '|'\n'|'\t') -> skip;
```
