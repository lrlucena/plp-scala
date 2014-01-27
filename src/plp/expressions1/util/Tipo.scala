package plp.expressions1.util

object Tipo {
  trait TipoPrimitivo extends Tipo
  case object INTEIRO extends TipoPrimitivo {}
  case object BOOLEANO extends TipoPrimitivo {}
  case object STRING extends TipoPrimitivo {}
}

trait Tipo {
  import Tipo._
  def eInteiro = this == INTEIRO
  def eBooleano = this == BOOLEANO
  def eString = this == STRING
  def eValido = eInteiro || eBooleano || eString
  def intersecao(outroTipo: Tipo) = if (this == outroTipo) Some(this) else None
}
