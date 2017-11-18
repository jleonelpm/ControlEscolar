/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class Calificaciones{
    
private int no;
private String NombreCompleto;
private String matricula;

private int faltas1;
private int faltas2;
private int faltas3;
        
private float parcial1;
private float parcial2;
private float parcial3;

private int id_tipo1;
private int id_tipo2;
private int id_tipo3;


private int id_calificacion;
private int id_inscripcion;
private int id_asignatura;
private int id_oferta_academica;
private int id_alumno;


private int id_usuario1;
private int id_usuario2;
private int id_usuario3;

private float promedio;

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio() {
        if(this.parcial1>5 && parcial2>5 && parcial3>5)
        {
            this.promedio = (this.parcial1+this.parcial2+this.parcial3)/3;
            this.promedio  =Math.round(promedio)  ;
        }
        else
        {
            this.promedio=5;
        }
    }
    public void setPromedio(float prom)
    {
    this.promedio=Math.round(prom);    
    }
    

    public int getId_usuario1() {
        return id_usuario1;
    }

    public void setId_usuario1(int id_usuario1) {
        this.id_usuario1 = id_usuario1;
    }

    public int getId_usuario2() {
        return id_usuario2;
    }

    public void setId_usuario2(int id_usuario2) {
        this.id_usuario2 = id_usuario2;
    }

    public int getId_usuario3() {
        return id_usuario3;
    }

    public void setId_usuario3(int id_usuario3) {
        this.id_usuario3 = id_usuario3;
    }



    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }


    public int getId_calificacion() {
        return id_calificacion;
    }

    public void setId_calificacion(int id_calificacion) {
        this.id_calificacion = id_calificacion;
    }

    public Calificaciones() {
        
    }

    public int getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(int id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public int getId_oferta_academica() {
        return id_oferta_academica;
    }

    public void setId_oferta_academica(int id_oferta_academica) {
        this.id_oferta_academica = id_oferta_academica;
    }

   

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }
      





    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String nombre,String ape_paterno, String ape_materno) {
        this.NombreCompleto = ape_paterno + " " + ape_materno+" "+nombre;
    }
public void setNombreCompleto(String nombre) {
        this.NombreCompleto = nombre;
    }
    public int getFaltas1() {
        return faltas1;
    }

    public void setFaltas1(int faltas1) {
        if(faltas1>=0 && faltas1<=20)
                this.faltas1 = faltas1;
        else
            this.faltas1=0;
    }

    public int getFaltas2() {
        return faltas2;
    }

    public void setFaltas2(int faltas2) {
     if(faltas2>=0 && faltas2<=20)
                this.faltas2 = faltas2;
        else
            this.faltas2=0;
    }

    public int getFaltas3() {
        return faltas3;
    }

   

    

    public void setFaltas3(int faltas3) {
       if(faltas3>=0 && faltas3<=20)
                this.faltas3 = faltas3;
        else
            this.faltas3=0;
    }

   


    public int getId_tipo1() {
        return id_tipo1;
    }

    public void setId_tipo1(int id_tipo1) {
        switch(id_tipo1)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                this.id_tipo1 = id_tipo1;
            break;
            default:
                this.id_tipo1 =0;
        }
        
    }

    public int getId_tipo2() {
        return id_tipo2;
    }

    public void setId_tipo2(int id_tipo2) {
        switch(id_tipo2)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                this.id_tipo2 = id_tipo2;
            break;
            default:
                this.id_tipo2 =0;
        }
    }

    public int getId_tipo3() {
        return id_tipo3;
    }

    public void setId_tipo3(int id_tipo3) {
      switch(id_tipo3)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                this.id_tipo3 = id_tipo3;
            break;
            default:
                this.id_tipo3 =0;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getParcial1() {
        return parcial1;
    }

    public void setParcial1(float parcial1) {
        if(parcial1>=5 && parcial1<=10)
            this.parcial1 = parcial1;
        else
            this.parcial1=0;
    }

    public float getParcial2() {
        return parcial2;
    }

    public void setParcial2(float parcial2) {
        if(parcial2>=5 && parcial2<=10)
            this.parcial2 = parcial2;
        else
            parcial2=0;
    }

    public float getParcial3() {
        return parcial3;
    }

    public void setParcial3(float parcial3) {
       
        if(parcial3>=5 && parcial3<=10)
                this.parcial3 = parcial3;
        else
            this.parcial3=0;
    }
    

}
