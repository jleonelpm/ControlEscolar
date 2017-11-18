/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author leonel
 */
public class Generaciones {
    int idGeneracion;
    String nombre;
    String status;


    public int getIdGeneracion() {
        return idGeneracion;
    }
    
    public Generaciones(int idGeneracion, String nombre) {
        this.idGeneracion = idGeneracion;
        this.nombre= nombre;
    }
    
    
    public Generaciones(){
        
    }

    public void setIdGeneracion(int idGeneracion) {
        this.idGeneracion = idGeneracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Generaciones other = (Generaciones) obj;
        if (this.idGeneracion != other.idGeneracion) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.idGeneracion;
        return hash;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
}
