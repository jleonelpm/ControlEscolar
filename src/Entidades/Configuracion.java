/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class Configuracion {
    private String directortecnico;
    private String subdirectorenlace;
    private int id_ciclo;
    private int id_configuracion;
    private String ciclo;

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }
    private String activo;
    

    public int getId_configuracion() {
        return id_configuracion;
    }

    public void setId_configuracion(int id_configuracion) {
        this.id_configuracion = id_configuracion;
    }

    public String getDirectortecnico() {
        return directortecnico;
    }

    public void setDirectortecnico(String directortecnico) {
        this.directortecnico = directortecnico;
    }

    public int getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(int id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public String getSubdirectorenlace() {
        return subdirectorenlace;
    }

    public void setSubdirectorenlace(String subdirectorenlace) {
        this.subdirectorenlace = subdirectorenlace;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "directortecnico=" + directortecnico + ", subdirectorenlace=" + subdirectorenlace + ", id_ciclo=" + id_ciclo + ", id_configuracion=" + id_configuracion + ", ciclo=" + ciclo + ", activo=" + activo + '}';
    }
    
    
}
