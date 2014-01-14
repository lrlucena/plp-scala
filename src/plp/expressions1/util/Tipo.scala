package plp.expressions1.util

abstract class Tipo() {
  def eInteiro = this == INTEIRO
  def eBooleano = this == BOOLEANO
  def eString = this == STRING
  def eValido = eInteiro || eBooleano || eString
}
case object INTEIRO extends Tipo
case object BOOLEANO extends Tipo
case object STRING extends Tipo