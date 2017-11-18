/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Modulos {
  private Integer idModulo;
  private Integer idCarrera;    
  private String modulo;      
  private String clave; 
  private String descripcion;
  private Integer horas;
  private Carreras carrera;

    public Modulos() {
        
    }
  
    public Modulos(Integer idModulo, String modulo, String descripcion) {
        this.idModulo = idModulo;
        this.modulo = modulo;
        this.descripcion = descripcion;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }
        
    @Override
    public String toString() {
        return modulo + " " + descripcion;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Modulos other = (Modulos) obj;
        if (this.idModulo != other.idModulo && (this.idModulo == null || !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.idModulo != null ? this.idModulo.hashCode() : 0);
        return hash;
    }
    
}
