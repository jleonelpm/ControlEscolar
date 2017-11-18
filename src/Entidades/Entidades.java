/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class Entidades {
    private String clave;
    private String entidad;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        if (clave.length()==1){
        this.clave ="0"+clave;
        }
        if (clave.length()==2){
        this.clave =clave;
        
        
        }
        if(clave.length()>2)
            this.clave =clave.substring(0,2);
        
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        return entidad;
    }

@Override    
   public boolean equals(Object o) {  
       if (o == null) {  
            return false;  
        }  
       if (this == o) {  
            return true;  
        }  
        if (!(o instanceof Entidades)) {  
            return false;  
       }  
        Entidades provincia = (Entidades) o;  
       if (clave == null ? provincia.clave != null : !clave.equals(provincia.clave)) {  
           return false;  
       }  
        if (entidad != null ? !entidad.equals(provincia.entidad) : provincia.entidad != null) {  
           return false;  
        }  
        return true;  
   }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.clave != null ? this.clave.hashCode() : 0);
        return hash;
    }

    

   
}
    
    

