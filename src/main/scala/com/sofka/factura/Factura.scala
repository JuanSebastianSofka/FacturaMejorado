package com.sofka.factura

class Factura (val comprador: String, val idComprador: String)

object ImprimirFactuas extends ObtenerMontos {
  override type Consumo = Double
  override type IVA = Double
  override type tieneConsumo = Boolean

  override def obtenerCantidadProductos(list: List[Double]): String = {
    s"La cantidad de productos es: ${list.size}"
  }
  override def obtenerBruto(list: List[Double]): String = {
    s"El precio total bruto es de: ${list.sum}"
  }

  override def obtenerTotalIvaConsumo(list: List[Double], consumo: Consumo, IVA: IVA,
                                      tieneConsumo: tieneConsumo): String = {
    tieneConsumo match{
      case true => s"El total con impuesto al consumo es de: ${list.sum*(IVA + consumo + 1)}"
      case false => s"el total es: ${list.sum*(IVA + 1)}"
    }
  }
}

object Factura{
  def FacturaRealizada(): Unit ={
    println(
      """Factura Realizada
        |A continuación se verán los datos de la compra
        |""".stripMargin)
  }
  def apply(comprador: String, idComprador: String) = new Factura(comprador, idComprador)
}

object FacturaTest{
  def main(args: Array[String]): Unit = {
    val productos = List (5.0,10.0,15.5,12.6)
    Factura.FacturaRealizada()
    val comprador = Factura("Carlos","4568421")
    println(
      s"""Datos del comprador:
         |nombre: ${comprador.comprador}
         |identificación: ${comprador.idComprador}""".stripMargin)

    println(ImprimirFactuas.obtenerCantidadProductos(productos))
    println(ImprimirFactuas.obtenerBruto(productos))
    println(ImprimirFactuas.obtenerTotalIvaConsumo(productos,0.16,0.19,false))
  }
}
