/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class AlumnosRecuperacion {
    private String nombre="";

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    private int contador=0;
    private float parcial1=0;
    private float parcial2=0;
    private float parcial3=0;
    private String descripcion="";

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    
    public float getParcial1() {
        return parcial1;
    }

    public void setParcial1(float parcial1) {
        
        this.parcial1 = parcial1;
        if(this.parcial1<6)
            this.contador++;
    }

    public float getParcial2() {
        return parcial2;
    }

    public void setParcial2(float parcial2) {
        this.parcial2 = parcial2;
        if(this.parcial2<6)
            this.contador++;
    }

    public float getParcial3() {
        return parcial3;
    }

    public void setParcial3(float parcial3) {
        this.parcial3 = parcial3;
        if(this.parcial3<6)
            this.contador++;
        this.setDescripcion();
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public void setDescripcion() {
        switch(this.contador)
        {
            case 1: 
            case 2: 
                this.descripcion="RECUPERACIÓN";
                break;
            case 3: 
                this.descripcion="EXTRAORDINARIO";
                break;
        }
        
    }

}
