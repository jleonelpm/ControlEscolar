/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Carreras {
  private Integer idCarrera;
  private String clave;
  private String nombre;
  private String estado;
  private String nooficio;

    public String getNooficio() {
        return nooficio;
    }

    public void setNooficio(String nooficio) {
        this.nooficio = nooficio;
    }

  public Carreras() {
  }
  
  public Carreras(Integer idCarrera) {
    this.idCarrera = idCarrera;
  }
  
  public Carreras(int idCarrera, String nombre) {
    this.idCarrera = idCarrera;
    this.nombre= nombre;
  }
  
  

  public Integer getIdCarrera() {
    return idCarrera;
  }

  public void setIdCarrera(Integer idCarrera) {
    this.idCarrera = idCarrera;
  }

  public String getClave() {
    return clave;
  }

  public void setClave(String clave) {
    this.clave = clave;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }
  
  @Override
  public String toString() {
    return nombre;
  }

    @Override  
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (!(o instanceof Carreras)) {
            return false;
        }
        Carreras carrera = (Carreras) o;
        if (idCarrera != carrera.idCarrera) {
            return false;
        }
        /*
        if (nombre != null ? !nombre.equals(carrera.nombre) : carrera.nombre != null) {
            return false;
        }*/
        return true;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        //hash = 89 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
        hash = 89 * hash + this.idCarrera;
        return hash;
    }  
  
}
