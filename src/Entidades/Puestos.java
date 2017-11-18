/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;



/**
 *
 * @author Last Develop
 */

public class Puestos {
    
    
    private int idPuesto;
    
    private String descripcion;
    
    

    public Puestos() {
    }

    public Puestos(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public int getIdPuesto() {
        return idPuesto;
    }

    public void setIdPuesto(int idPuesto) {
        this.idPuesto = idPuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean setDescripcion(String descripcion) {
        boolean asignado=true;
        if(descripcion.length()>0)
        {
            this.descripcion = descripcion;
        
        }
        else
            asignado=false;
        return asignado;
        
    }

   

   

    @Override
    public String toString() {
        return "sice.Entidades.Puestos[ idPuesto=" + idPuesto + " ]";
    }
    
}
