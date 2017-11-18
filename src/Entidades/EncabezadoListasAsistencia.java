/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class EncabezadoListasAsistencia {
    private String docente=null;
    private String semestre=null;
    private String grupo=null;
    private String especialidad=null;
    private String periodo_escolar=null;
    private String asignatura=null;

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPeriodo_escolar() {
        return periodo_escolar;
    }

    public void setPeriodo_escolar(String periodo_escolar) {
        this.periodo_escolar = periodo_escolar;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "EncabezadoListasAsistencia{" + "docente=" + docente + ", semestre=" + semestre + ", grupo=" + grupo + ", especialidad=" + especialidad + ", periodo_escolar=" + periodo_escolar + ", asignatura=" + asignatura + '}';
    }
    
}
