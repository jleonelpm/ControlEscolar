/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Planes {
  private Integer idPlan;
  private String descripcion;
  private String estado;

  public Planes() {
  }

  public Planes(Integer idPlan) {
    this.idPlan = idPlan;
  }

  public Planes(Integer idPlan, String descripcion) {
    this.idPlan = idPlan;
    this.descripcion = descripcion;
  }

  
  public Integer getIdPlan() {
    return idPlan;
  }

  public void setIdPlan(Integer idPlan) {
    this.idPlan = idPlan;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return this.descripcion;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Planes other = (Planes) obj;
    if (this.idPlan != other.idPlan && (this.idPlan == null || !this.idPlan.equals(other.idPlan))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 7;
    hash = 67 * hash + (this.idPlan != null ? this.idPlan.hashCode() : 0);
    return hash;
  }
  
}