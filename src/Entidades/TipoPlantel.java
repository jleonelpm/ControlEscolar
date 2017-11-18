/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;



/**
 *
 * @author Last Develop
 */

public class TipoPlantel {
    
    private String clave;
    
    private String plantel;
    
    private String unidad_administrativa;
    
    private short  clave_unidad;
    
    private String abreviatura;

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public short getClave_unidad() {
        return clave_unidad;
    }

    public void setClave_unidad(short clave_unidad) {
        this.clave_unidad = clave_unidad;
    }
    

   

    public String getUnidad_administrativa() {
        return unidad_administrativa;
    }

    public void setUnidad_administrativa(String unidad_administrativa) {
        this.unidad_administrativa = unidad_administrativa;
    }
    

    public TipoPlantel() {
    }

    public TipoPlantel(String clave) {
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPlantel() {
        return plantel;
    }

    public void setPlantel(String plantel) {
        this.plantel = plantel;
    }

   
    @Override
    public String toString() {
        return  this.plantel ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoPlantel other = (TipoPlantel) obj;
        if ((this.clave == null) ? (other.clave != null) : !this.clave.equals(other.clave)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.clave != null ? this.clave.hashCode() : 0);
        return hash;
    }
    
}
