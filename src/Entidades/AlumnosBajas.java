/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Last Develop
 */
public class AlumnosBajas {
    private int id_baja;
    private Alumnos alumno=null;
    
    private CicloEscolar ciclo=null;
    private Usuarios usuario =null;
    private String codigobaja=null;
    private String observaciones;
    private String tipobaja;
    private Date fechabaja;

    public Alumnos getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumnos alumno) {
        this.alumno = alumno;
    }

    public CicloEscolar getCiclo() {
        return ciclo;
    }

    public void setCiclo(CicloEscolar ciclo) {
        this.ciclo = ciclo;
    }

    public String getCodigobaja() {
        return codigobaja;
    }

    public void setCodigobaja(String codigobaja) {
        this.codigobaja = codigobaja;
    }

    public Date getFechabaja() {
        return fechabaja;
    }

    public void setFechabaja(Date fechabaja) {
        this.fechabaja = fechabaja;
    }

    public int getId_baja() {
        return id_baja;
    }

    public void setId_baja(int id_baja) {
        this.id_baja = id_baja;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getTipobaja() {
        return tipobaja;
    }

    public void setTipobaja(String tipobaja) {
        this.tipobaja = tipobaja;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
    
            
    
}
