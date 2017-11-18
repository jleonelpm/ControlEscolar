/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Last Develop
 */
public class CalificacionesSubmodulo {
    private int id_calificacion;
    private int id_alumno;
    private int id_inscripcion;
    private int id_oferta_academica;
    private int id_asignatura; /*Es el id pero en submodulo*/
    
    private float parcial1=0;
    private float ponderacion1=0;
    private int faltas1;
    private Date fecha_pa1;
    private int id_usuario1;
    
    private float parcial2=0;
    private float ponderacion2=0;
    private int faltas2;
    private Date fecha_pa2;
    private int id_usuario2;
    
    private float parcial3=0;
    private float ponderacion3=0;
    private int faltas3;
    private Date fecha_pa3;
    private int id_usuario3;
    
    private float parcial4=0;
    private float ponderacion4=0;
    private int faltas4;
    private Date fecha_pa4;
    private int id_usuario4;

    private float parcial5=0;
    private float ponderacion5=0;
    private int faltas5;
    private Date fecha_pa5;
    private int id_usuario5;
    
    private float parcial6=0;
    private float ponderacion6=0;
    private int faltas6;
    private Date fecha_pa6;
    private int id_usuario6;
    
    private float parcial7=0;
    private float ponderacion7=0;
    private int faltas7;
    private Date fecha_pa7;
    private int id_usuario7;
    
    private float parcial8=0;
    private float ponderacion8=0;
    private int faltas8;
    private Date fecha_pa8;
    private int id_usuario8;
    
   private float parcial9=0;
   private float ponderacion9=0;
    private int faltas9;
    private Date fecha_pa9;
    private int id_usuario9;
    
    private float parcial10=0;
    private float ponderacion10=0;
    private int faltas10;
    private Date fecha_pa10;
    private int id_usuario10;
    
    private float total;
    private int id_tipo;

    public int getId_tipo() {
        return id_tipo;
    }

    public void setId_tipo(int id_tipo) {
        this.id_tipo = id_tipo;
    }

    public float getPonderacion1() {
        return ponderacion1;
    }

    public void setPonderacion1(float ponderacion1) {
        this.ponderacion1 = ponderacion1;
    }

    public float getPonderacion10() {
        return ponderacion10;
    }

    public void setPonderacion10(float ponderacion10) {
        this.ponderacion10 = ponderacion10;
    }

    public float getPonderacion2() {
        return ponderacion2;
    }

    public void setPonderacion2(float ponderacion2) {
        this.ponderacion2 = ponderacion2;
    }

    public float getPonderacion3() {
        return ponderacion3;
    }

    public float getPonderacion5() {
        return ponderacion5;
    }

    public void setPonderacion5(float ponderacion5) {
        this.ponderacion5 = ponderacion5;
    }

    public void setPonderacion3(float ponderacion3) {
        this.ponderacion3 = ponderacion3;
    }

    public float getPonderacion4() {
        return ponderacion4;
    }

    public void setPonderacion4(float ponderacion4) {
        this.ponderacion4 = ponderacion4;
    }

    public float getPonderacion6() {
        return ponderacion6;
    }

    public void setPonderacion6(float ponderacion6) {
        this.ponderacion6 = ponderacion6;
    }

    public float getPonderacion7() {
        return ponderacion7;
    }

    public void setPonderacion7(float ponderacion7) {
        this.ponderacion7 = ponderacion7;
    }

    public float getPonderacion8() {
        return ponderacion8;
    }

    public void setPonderacion8(float ponderacion8) {
        this.ponderacion8 = ponderacion8;
    }

    public float getPonderacion9() {
        return ponderacion9;
    }

    public void setPonderacion9(float ponderacion9) {
        this.ponderacion9 = ponderacion9;
    }
    

    private ArrayList<UnidadAprendizaje> unidadaprendizaje=null;

    public ArrayList<UnidadAprendizaje> getUnidadaprendizaje() {
        return unidadaprendizaje;
    }

    public void setUnidadaprendizaje(ArrayList<UnidadAprendizaje> unidadaprendizaje) {
        this.unidadaprendizaje = unidadaprendizaje;
    }

    
    
    
    
    /*Solo se utilizan para dar formato al Reporte*/
    private String NombreCompleto;
    private String matricula;
    private int no;
    
    /*Util en Calificaciones*/
    
    
    
    

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getNombreCompleto() {
        return NombreCompleto;
    }

    public void setNombreCompleto(String NombreCompleto) {
        this.NombreCompleto = NombreCompleto;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    
    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total=total;
    }
    public void setTotal()
    {
     this.total=this.ponderacion1+this.ponderacion2+this.ponderacion3+
             this.ponderacion3+this.ponderacion4+this.ponderacion5+this.ponderacion6+this.ponderacion7+ this.ponderacion8+
             this.ponderacion9+this.ponderacion10;
    }
    
    
    public int getFaltas4() {
        return faltas4;
    }

    public void setFaltas4(int faltas4) {
        this.faltas4 = faltas4;
    }

    public Date getFecha_pa4() {
        return fecha_pa4;
    }

    public void setFecha_pa4(Date fecha_pa4) {
        this.fecha_pa4 = fecha_pa4;
    }

    public int getId_usuario4() {
        return id_usuario4;
    }

    public void setId_usuario4(int id_usuario4) {
        this.id_usuario4 = id_usuario4;
    }

    public float getParcial5() {
        return parcial5;
    }

    public void setParcial5(float parcial5) {
        this.parcial5 = parcial5;
    }
    


    public int getFaltas1() {
        return faltas1;
    }

    public void setFaltas1(int faltas1) {
        this.faltas1 = faltas1;
    }

    public int getFaltas10() {
        return faltas10;
    }

    public void setFaltas10(int faltas10) {
        this.faltas10 = faltas10;
    }

    public int getFaltas2() {
        return faltas2;
    }

    public void setFaltas2(int faltas2) {
        this.faltas2 = faltas2;
    }

    public int getFaltas3() {
        return faltas3;
    }

    public void setFaltas3(int faltas3) {
        this.faltas3 = faltas3;
    }

    public int getFaltas5() {
        return faltas5;
    }

    public void setFaltas5(int faltas5) {
        this.faltas5 = faltas5;
    }

    public int getFaltas6() {
        return faltas6;
    }

    public void setFaltas6(int faltas6) {
        this.faltas6 = faltas6;
    }

    public int getFaltas7() {
        return faltas7;
    }

    public void setFaltas7(int faltas7) {
        this.faltas7 = faltas7;
    }

    public int getFaltas8() {
        return faltas8;
    }

    public void setFaltas8(int faltas8) {
        this.faltas8 = faltas8;
    }

    public int getFaltas9() {
        return faltas9;
    }

    public void setFaltas9(int faltas9) {
        this.faltas9 = faltas9;
    }

    public Date getFecha_pa1() {
        return fecha_pa1;
    }

    public void setFecha_pa1(Date fecha_pa1) {
        this.fecha_pa1 = fecha_pa1;
    }

    public Date getFecha_pa10() {
        return fecha_pa10;
    }

    public void setFecha_pa10(Date fecha_pa10) {
        this.fecha_pa10 = fecha_pa10;
    }

    public Date getFecha_pa2() {
        return fecha_pa2;
    }

    public void setFecha_pa2(Date fecha_pa2) {
        this.fecha_pa2 = fecha_pa2;
    }

    public Date getFecha_pa3() {
        return fecha_pa3;
    }

    public void setFecha_pa3(Date fecha_pa3) {
        this.fecha_pa3 = fecha_pa3;
    }

    public Date getFecha_pa5() {
        return fecha_pa5;
    }

    public void setFecha_pa5(Date fecha_pa5) {
        this.fecha_pa5 = fecha_pa5;
    }

    public Date getFecha_pa6() {
        return fecha_pa6;
    }

    public void setFecha_pa6(Date fecha_pa6) {
        this.fecha_pa6 = fecha_pa6;
    }

    public Date getFecha_pa7() {
        return fecha_pa7;
    }

    public void setFecha_pa7(Date fecha_pa7) {
        this.fecha_pa7 = fecha_pa7;
    }

    public Date getFecha_pa8() {
        return fecha_pa8;
    }

    public void setFecha_pa8(Date fecha_pa8) {
        this.fecha_pa8 = fecha_pa8;
    }

    public Date getFecha_pa9() {
        return fecha_pa9;
    }

    public void setFecha_pa9(Date fecha_pa9) {
        this.fecha_pa9 = fecha_pa9;
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

    public int getId_usuario1() {
        return id_usuario1;
    }

    public void setId_usuario1(int id_usuario1) {
        this.id_usuario1 = id_usuario1;
    }

    public int getId_usuario10() {
        return id_usuario10;
    }

    public void setId_usuario10(int id_usuario10) {
        this.id_usuario10 = id_usuario10;
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

    public int getId_usuario5() {
        return id_usuario5;
    }

    public void setId_usuario5(int id_usuario5) {
        this.id_usuario5 = id_usuario5;
    }

    public int getId_usuario6() {
        return id_usuario6;
    }

    public void setId_usuario6(int id_usuario6) {
        this.id_usuario6 = id_usuario6;
    }

    public int getId_usuario7() {
        return id_usuario7;
    }

    public void setId_usuario7(int id_usuario7) {
        this.id_usuario7 = id_usuario7;
    }

    public int getId_usuario8() {
        return id_usuario8;
    }

    public void setId_usuario8(int id_usuario8) {
        this.id_usuario8 = id_usuario8;
    }

    public int getId_usuario9() {
        return id_usuario9;
    }

    public void setId_usuario9(int id_usuario9) {
        this.id_usuario9 = id_usuario9;
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

    public float getParcial10() {
        return parcial10;
    }

    public void setParcial10(float parcial10) {
        if(parcial10>=5 && parcial10<=10)
            this.parcial10 = parcial10;
        else
            
        this.parcial10 = 0;
    }

    public float getParcial2() {
        return parcial2;
    }

    public void setParcial2(float parcial2) {
        if(parcial2>=5 && parcial2<=10)
            this.parcial2 = parcial2;
        else
            this.parcial2=0;
        
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

    public float getParcial4() {
        return parcial4;
    }

    public void setParcial4(float parcial4) {
        if(parcial4>=5 && parcial4<=10)
            this.parcial4 = parcial4;
        else
            this.parcial4=0;
        
    }

    public float getParcial6() {
        return parcial6;
    }

    public void setParcial6(float parcial6) {
        if(parcial6>=5 && parcial6<=10)
            this.parcial6 = parcial6;
        else
            this.parcial6=0;
        
    }

    public float getParcial7() {
        return parcial7;
    }

    public void setParcial7(float parcial7) {
        if(parcial7>=5 && parcial7<=10)
            this.parcial7 = parcial7;
        else
            this.parcial7=0;
        
    }

    public float getParcial8() {
        return parcial8;
    }

    public void setParcial8(float parcial8) {
        if(parcial8>=5 && parcial8<=10)
            this.parcial8 = parcial8;
        else
            this.parcial8=0;
        
    }

    public float getParcial9() {
        return parcial9;
    }

    public void setParcial9(float parcial9) {
        if(parcial9>=5 && parcial9<=10)
            this.parcial9 = parcial9;
        else
            this.parcial9=0;
        
    }
    
    
            
}
