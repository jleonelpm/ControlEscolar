/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class AlumnosGrupo {
    private int id;
    private int id_alumno;
    private int id_carrera;
    private int id_grupo_ciclo;
    private int id_ciclo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
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

    public int getId_grupo_ciclo() {
        return id_grupo_ciclo;
    }

    public void setId_grupo_ciclo(int id_grupo_ciclo) {
        this.id_grupo_ciclo = id_grupo_ciclo;
    }

    @Override
    public String toString() {
        return "AlumnosGrupo{" + "id=" + id + ", id_alumno=" + id_alumno + ", id_carrera=" + id_carrera + ", id_grupo_ciclo=" + id_grupo_ciclo + ", id_ciclo=" + id_ciclo + '}';
    }
    
    
            
    
    
}
