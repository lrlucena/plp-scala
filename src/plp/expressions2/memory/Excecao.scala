package plp.expressions2.memory

import plp.expressions1.expression.Expressao

class IdentificadorJaDeclaradoException(msg: String = "") extends Exception(msg)

class IdentificadorNaoDeclaradoException(msg: String = "") extends Exception(msg)

class VariavelJaDeclaradaException(id: Expressao) extends Exception(s"Variavel ${id} ja declarada.")

class VariavelNaoDeclaradaException(id: Expressao) extends Exception("Variavel ${id} nao declarada.")