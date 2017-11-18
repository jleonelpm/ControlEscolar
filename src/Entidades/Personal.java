/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Last Develop
 */

public class Personal {
    
    
    private int idPersonal;
    
    private String folio;
    
    private String apePaterno;
    
    private String apeMaterno;
    
    private String nombre;
    
    private String curp;
    
    private String rfc;
    
    private char sexo;
    
    private String email;
    
    private String telefono;
    
    private String celular;
    
    
    private Date fechaNcto;
    
    private String carrera;
    
    private String especialidad;
    
    private String perfil;
    
    private String cedulaPro;

    private String institucion;

    private char frenteGrupo;

    private char estado;

    private String foto;

    private Puestos puestos;

    private NivelesAcademico nivelesAcademico;
    
    private String nombrecompleto;
    
    private String urlFotoOrigen="";

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto() {
        this.nombrecompleto = this.nombre + " " + this.apePaterno + " " + this.apeMaterno;
                
    }
    

    public Personal() {
    }

    public Personal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public Personal(int idPersonal, String folio) {
        this.idPersonal = idPersonal;
        this.folio = folio;
    }

    public Personal(int idPersonal, String folio, String apePaterno, String apeMaterno, String nombre) {
        this.idPersonal = idPersonal;
        this.folio = folio;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
    }

    public Personal(int idPersonal, String apePaterno, String apeMaterno, String nombre) {
        this.idPersonal = idPersonal;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.nombre = nombre;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        
        this.sexo = sexo;
    }
    public void setSexo(boolean sexo)
    {
     if(sexo==true)
         this.sexo='M';
     else
         this.sexo='F';
    }
    public void setSexo(String sexo)
    {
     this.sexo=sexo.charAt(0);
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Date getFechaNcto() {
        
        
        if(this.fechaNcto!=null)
        {
            SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        formato.format(this.fechaNcto);
        }
        return  this.fechaNcto;
    }
    
  public String getFechaToForm(Date fecha)
    {
        SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
            return formato.format(fecha);
    } 

    public void setFechaNcto(Date fechaNcto) {
        
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
         formato.format(fechaNcto);
        this.fechaNcto = fechaNcto;
    }
    public void setFechaNcto(String fechaNcto) {
        try {
           
           
         
            Calendar calendario=this.getCalendar(fechaNcto);
            if( calendario!=null)
                    {
                        java.sql.Date sqlToday=new java.sql.Date(calendario.getTime().getTime());

                        this.fechaNcto = sqlToday;
                    }
            else
                this.fechaNcto=null;
            
        } catch (Exception ex) {
            Logger.getLogger(Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String [] elementosFecha(String fecha)
    {
        String []elementos=new String[3];
        if(fecha!=null && fecha.trim().length()>0)
        {
        
        elementos=fecha.split("-");
        }
        else
            elementos=null;
      return elementos;
    }
    private Calendar getCalendar(String fecha)
    {
         String []elem=this.elementosFecha(fecha);
    Calendar calendario=Calendar.getInstance();
    int mes, anio,dia;
        if(elem!=null)
        {
         dia=Integer.parseInt(elem[0]);
         mes=Integer.parseInt(elem[1]);
         anio=Integer.parseInt(elem[2]);
         calendario.set(anio, mes-1, dia);
         
        }
        else
            calendario=null;
        return calendario;
        
    }
    
    
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getCedulaPro() {
        return cedulaPro;
    }

    public void setCedulaPro(String cedulaPro) {
        this.cedulaPro = cedulaPro;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public char getFrenteGrupo() {
        return frenteGrupo;
    }
 public boolean esFrenteGrupo()
 {
  if(this.frenteGrupo=='S')
      return true;
  else
      return false;
 }
    public void setFrenteGrupo(char frenteGrupo) {
        this.frenteGrupo = frenteGrupo;
    }
    public void setFrenteGrupo(boolean frenteGrupo) {
        if (frenteGrupo)
            
        this.frenteGrupo = 'S';
        else
            this.frenteGrupo = 'N';
            
    }
    public void setFrenteGrupo(String frenteGrupo) {
        this.frenteGrupo=frenteGrupo.charAt(0);
            
    }
   

    public void setEstado(char estado) {
        this.estado = estado;
    }
    public void setEstado(boolean estado) {
        if(estado)
        this.estado = 'A';
        else
            this.estado='N';
    }
    public boolean getEstado()
    {
         if(this.estado=='A')
             return true;
         else 
     return false;
    }
    public String getEstado(boolean estado)
    {
     if(estado)
         return "A";
     else
         return "N";
    }
    
    public void setEstado(String estado)
    {
    this.estado=estado.charAt(0);
    }

    public String getFoto() {
        if(this.foto!=null)
        {
        if(this.foto.length()>0)
        {
            return foto;
        
        }
        else
            return "";
        }
        else
            
        return null;
    }
    
    public String getUrlImagen()
    {
        String ruta="";
        if(this.foto!=null)
        {
        if(this.foto.length()>0)
        {
            Utilerias.Configuracion conf = new Utilerias.Configuracion();           
            String host = conf.getPropiedad("servidor.host");
            ruta="\\\\"+host+"\\imagenes\\personal\\"+foto;
        
        }
        return ruta;
        }
        else 
            return null;
                
    }

    public void setFoto(String foto) {
        
        
            this.foto = foto;
        
        
            
    }

    public Puestos getPuestos() {
        return puestos;
    }

    public void setPuestos(Puestos puestos) {
        this.puestos = puestos;
    }

    public NivelesAcademico getNivelesAcademico() {
        return nivelesAcademico;
    }

    public void setNivelesAcademico(NivelesAcademico nivelesAcademico) {
        this.nivelesAcademico = nivelesAcademico;
    }

  
    

    @Override
    public String toString() {
        return  this.nombre + " "+ this.apePaterno + " "+ this.apeMaterno;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personal other = (Personal) obj;
        if ((this.folio == null) ? (other.folio != null) : !this.folio.equals(other.folio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + (this.folio != null ? this.folio.hashCode() : 0);
        return hash;
    }
    
     public void setUrlFotoOrigen(String urlOrigen)
    {
     this.urlFotoOrigen=urlOrigen;
    }
    
    public String generarNombreFoto()
    {
        
        int r=(int) (Math.random()*10000);
     return this.apePaterno +"_"+this.apeMaterno+"_"+ String.valueOf(r);
    }
    
    
}
