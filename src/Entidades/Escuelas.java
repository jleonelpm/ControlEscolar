/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;



/**
 *
 * @author Last Develop
 */

public class Escuelas{
    
    
    private int idEscuela;
    
    private String nombre;
    
    private String direccion;
    
    private String claveCt;
    
    private String telefono;
    
    private String correo;
    
    private String logotipo;
    
    private String numero;
    
    private TipoPlantel tipoplantel;

    public TipoPlantel getTipoplantel() {
        return tipoplantel;
    }

    public void setTipoplantel(TipoPlantel tipoplantel) {
        this.tipoplantel = tipoplantel;
    }

    private Entidades entidad;
    
    private Personal director;

    public Entidades getEntidad() {
        return entidad;
    }

    public void setEntidad(Entidades entidad) {
        this.entidad = entidad;
    }

    public Personal getDirector() {
        return director;
    }

    public void setDirector(Personal director) {
        this.director = director;
    }


    public void setNumero(String numero) {
       if(numero.length()==1)
       {
        this.numero = "00"+numero;
       }
       if(numero.length()==2)
       {
        this.numero = "0"+numero;
       }
       if(numero.length()==3)
       {
        this.numero = numero;
       }
       if(numero.length()==4)
       {
       this.numero = numero;
       }
    }

    public Entidades getLugarEntidad() {
        return entidad;
    }

    public void setLugarEntidad(Entidades entidad) {
        this.entidad = entidad;
    }
    
    public String getNumero() {
        return numero;
    }
    
    private TipoPlantel tipoPlantel;

    public Escuelas() {
    }

    public Escuelas(int idEscuela) {
        this.idEscuela = idEscuela;
    }

    public int getIdEscuela() {
        return idEscuela;
    }

    public void setIdEscuela(Integer idEscuela) {
        this.idEscuela = idEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getClaveCt() {
        return claveCt;
    }

    public void setClaveCt(String claveCt) {
        this.claveCt = claveCt;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getLogotipo() {
        return logotipo;
    }

    public void setLogotipo(String logotipo) {
        this.logotipo = logotipo;
    }

    public TipoPlantel getTipoPlantel() {
        return tipoPlantel;
    }

    public void setTipoPlantel(TipoPlantel tipoPlantel) {
        this.tipoPlantel = tipoPlantel;
    }

  
    @Override
    public String toString() {
        return "sice.Entidades.Escuelas[ idEscuela=" + idEscuela + " ]";
    }
    
    public String getUrlLogotipo()
    {
        String url="";
        if(this.logotipo!=null && this.logotipo.length()>0)
        {
          Utilerias.Configuracion conf=new Utilerias.Configuracion();
          String host=conf.getPropiedad("servidor.host");
          url="\\\\"+host+"\\imagenes\\"+this.logotipo;
        }
     return url;
    }

   

 

    
  
}
