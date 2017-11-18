/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Areas {
  private Integer idArea;
  private String descripcion;

  public Areas() {
  }

  public Areas(Integer idArea) {
    this.idArea = idArea;
  }
  
  public Areas(Integer idArea, String descripcion) {
    this.idArea = idArea;
    this.descripcion = descripcion;    
  }

  
  public Integer getIdArea() {
    return idArea;
  }

  public void setIdArea(Integer idArea) {
    this.idArea = idArea;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idArea != null ? idArea.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Areas)) {
      return false;
    }
    Areas other = (Areas) object;
    if ((this.idArea == null && other.idArea != null) || (this.idArea != null && !this.idArea.equals(other.idArea))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return this.descripcion;
  }
  
}
