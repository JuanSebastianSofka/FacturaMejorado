package com.sofka.factura

trait ObtenerMontos {
  type Consumo
  type IVA
  type tieneConsumo

  def obtenerCantidadProductos(list: List[Double]): String
  def obtenerBruto(list: List[Double]): String
  def obtenerTotalIvaConsumo(list: List[Double], consumo: Consumo, IVA: IVA, tieneConsumo: tieneConsumo): String

}
