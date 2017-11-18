/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class Inscripciones {
private int id_inscripcion;
private int id_alumno;
private int id_oferta_academica; //

private int id_carga_academica; //Es el id_ de la oferta academica
private String reinscrito;
private String recursamiento;
private String pago;
private int id_ciclo;
private int id_carrera;

private boolean seleccionado;
private int id_asignatura;
private String modulo;

/*Actualizado el 2 de Julio*/

private String asignatura;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }


    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }


    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }


    public int getId_oferta_academica() {
        return id_oferta_academica;
    }

    public void setId_oferta_academica(int id_oferta_academica) {
        this.id_oferta_academica = id_oferta_academica;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }


    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }

    public int getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(int id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_carga_academica() {
        return id_carga_academica;
    }

    public void setId_carga_academica(int id_carga_academica) {
        this.id_carga_academica = id_carga_academica;
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public String getPago() {
        return pago;
    }

    public void setPago(String pago) {
        this.pago = pago;
    }

    public String getRecursamiento() {
        return recursamiento;
    }

    public void setRecursamiento(String recursamiento) {
        this.recursamiento = recursamiento;
    }

    public String getReinscrito() {
        return reinscrito;
    }

    public void setReinscrito(String reinscrito) {
        this.reinscrito = reinscrito;
    }

    @Override
    public String toString() {
        return "Inscripciones{" + "id_inscripcion=" + id_inscripcion + ", id_alumno=" + id_alumno + ", id_carga_academica=" + id_oferta_academica + "Recursamiento" + recursamiento + "Id ciclo: "+ id_ciclo + '}';
    }



}
