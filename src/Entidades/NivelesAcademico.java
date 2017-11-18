/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;



/**
 *
 * @author Last Develop
 */

public class NivelesAcademico{
    private static final long serialVersionUID = 1L;
   
    private int idNivel;
   
    private String descripcion;
   
    

    public NivelesAcademico() {
    }

    public NivelesAcademico(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public Integer getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(Integer idNivel) {
        this.idNivel = idNivel;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    

    @Override
    public String toString() {
        return "sice.Entidades.NivelesAcademico[ idNivel=" + idNivel + " ]";
    }
    
}
