/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;


/**
 *
 * @author Last Develop
 */

public class Partidas  {
    
    private String idCuenta;
    
    private String descripcion;
    
    private float importe;
    
    private String idGrupo;

    public String getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(String idGrupo) {
        this.idGrupo = idGrupo;
    }
    
    

    public Partidas() {
    }

    public Partidas(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }
public void setImporte(String importe)
{
 try{
     if(importe.length()>0)
     {
      importe= importe.trim();
      this.importe=Float.parseFloat(importe);
     }
     else
         this.importe=0;
 }
 catch(Exception ex)
 {
 this.importe=0;
 }
}

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Partidas other = (Partidas) obj;
        if ((this.idCuenta == null) ? (other.idCuenta != null) : !this.idCuenta.equals(other.idCuenta)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + (this.idCuenta != null ? this.idCuenta.hashCode() : 0);
        return hash;
    }

   

    @Override
    public String toString() {
        return  this.idCuenta +"-" +this.descripcion;
    }
    
}
