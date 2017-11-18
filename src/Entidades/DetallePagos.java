/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class DetallePagos {
  private Integer idPago;
  private String idCuenta;
  private Pagos pago;
  private Partidas partida;
  private Short cantidad;
  private Float importe;

  public DetallePagos() {
  }

  public Short getCantidad() {
    return cantidad;
  }

  public void setCantidad(Short cantidad) {
    this.cantidad = cantidad;
  }

  public Float getImporte() {
    return importe;
  }

  public void setImporte(Float importe) {
    this.importe = importe;
  }

  public String getIdCuenta() {
    return idCuenta;
  }

  public void setIdCuenta(String idCuenta) {
    this.idCuenta = idCuenta;
  }

  public Integer getIdPago() {
    return idPago;
  }

  public void setIdPago(Integer idPago) {
    this.idPago = idPago;
  }

  public Pagos getPago() {
    return pago;
  }

  public void setPago(Pagos pago) {
    this.pago = pago;
  }

  public Partidas getPartida() {
    return partida;
  }

  public void setPartida(Partidas partida) {
    this.partida = partida;
  }

}
