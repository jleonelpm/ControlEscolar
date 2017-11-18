/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class ReporteHistorialAcademico {
    private String nombreasignatura ;
    private int semestre;
    private float promedio;
    private String letras;
    private String acreditacion;

    public String getAcreditacion() {
        return acreditacion;
    }

    public void setAcreditacion(String acreditacion) {
        this.acreditacion = acreditacion;
    }

    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }

    public String getNombreasignatura() {
        return nombreasignatura;
    }

    public void setNombreasignatura(String nombreasignatura) {
        this.nombreasignatura = nombreasignatura;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @Override
    public String toString() {
        return "ReporteHistorialAcademico{" + "nombreasignatura=" + nombreasignatura + ", semestre=" + semestre + ", promedio=" + promedio + ", letras=" + letras + ", acreditacion=" + acreditacion + '}';
    }
    
    
}
