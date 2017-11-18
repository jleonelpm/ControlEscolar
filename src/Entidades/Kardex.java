/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class Kardex {
    private Integer id_kardex;
    private Integer id_ciclo;
    private Integer id_alumno;
    private Integer id_asignatura;
    private Integer id_oferta_academica;
    private Integer id_escala;
    private int semestre;
    private int  id_acreditacion=1;
    private float promedio=0;
    private String status;
    private String acreditado;
    private String modulo;

    
    
    
    public Integer getId_oferta_academica() {
        return id_oferta_academica;
    }

    public void setId_oferta_academica(Integer id_oferta_academica) {
        this.id_oferta_academica = id_oferta_academica;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
    
    
    
    
    /*ESTOS CAMPOS NO ESTAN EN LA TABLA...OJO*/
    private Integer id_personal;
    private Integer id_oferta;
     
    
    private int id_carrera;
    private String nombreasignatura;
   private boolean seleccionado;

    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public String toString() {
        return "Kardex{" + "id_kardex=" + id_kardex + ", id_ciclo=" + id_ciclo + ", id_alumno=" + id_alumno + ", id_asignatura=" + id_asignatura + ", id_oferta_academica=" + id_oferta_academica + ", id_escala=" + id_escala + ", semestre=" + semestre + ", id_acreditacion=" + id_acreditacion + ", promedio=" + promedio + ", status=" + status + ", acreditado=" + acreditado + ", modulo=" + modulo + ", seleccionado=" + seleccionado + '}';
    }


   
    public String getNombreasignatura() {
        return nombreasignatura;
    }

    public void setNombreasignatura(String nombreasignatura) {
        this.nombreasignatura = nombreasignatura;
    }
    public int getId_carrera() {
        return id_carrera;
    }

    public void setId_carrera(int id_carrera) {
        this.id_carrera = id_carrera;
    }
    

    public String getAcreditado() {
        return acreditado;
    }

    public void setAcreditado(String acreditado) {
        this.acreditado = acreditado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }
    

    public int getId_acreditacion() {
        return id_acreditacion;
    }

    public void setId_acreditacion(int id_acreditacion) {
        this.id_acreditacion = id_acreditacion;
    }

    public Integer getId_escala() {
        return id_escala;
    }

    public void setId_escala(Integer id_escala) {
        this.id_escala = id_escala;
    }

    public Integer getId_oferta() {
        return id_oferta;
    }

    public void setId_oferta(Integer id_oferta) {
        this.id_oferta = id_oferta;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(short semestre) {
        this.semestre = semestre;
    }
    

    

    public Integer getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(Integer id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public Integer getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(Integer id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    
    public Integer getId_kardex() {
        return id_kardex;
    }

    public void setId_kardex(Integer id_kardex) {
        this.id_kardex = id_kardex;
    }

    public Integer getId_personal() {
        return id_personal;
    }

    public void setId_personal(Integer id_personal) {
        this.id_personal = id_personal;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        if(promedio>=5 && promedio<=10)
        {
            this.promedio = promedio;
            this.setAcreditado("S");
        }
        else
        {
         promedio=0;
         this.setAcreditado("N");
        }
    }

   
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    

    
    
}
