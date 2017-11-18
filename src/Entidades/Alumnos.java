/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controladores.ctrlEscuela;


/**
 *
 * @author Last Develop
 */

public class Alumnos {
    
    
    private int idAlumno;
    
    private String matricula;
    
    private String apePaterno;
    
    private String apeMaterno;
    
    private String nombre;
    
    private String direccion;
    
    
    private Date fechaNcto;
    
    private char sexo;
    
    private String estadoCivil;
    
    private String curp;
    
    private String lugarNcto;
   
    private String telefono;
   
    private String fotografia;
   
    private String tutor;
   
    private String beca;
   
    private String estado;
   
    private String fichaMedica;
   
    private String secundariaProcedencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    private float promedioSecundaria;
    

    private Date fechaBaja;
    
    private String motivoBaja;
    
    private Date fechaEgreso;
    
    private Date fechaIngreso;
    
    private char repetidor;
    
    private char titulado;
    
    private char modo_ingreso;
    
    private String folio_certificado;
    
    
    private String nombrecompleto;
    
    
    private String urlFotoOrigen="";

    public void setNombrecompleto() {
        this.nombrecompleto = this.apePaterno + " " + this.apeMaterno+ " " + this.nombre;
    }
    public String getNombrecompleto()
    {
    return this.nombrecompleto;
    }
    
    
    /*edad es calculada*/
    
    private int edad;

    public int getEdad() {
        return edad;
    }

    public void setEdad() {
    Calendar fechaActual = Calendar.getInstance();
    if(this.fechaNcto!=null)
    {
    String []elementos=this.fechaNcto.toString().split("-");
    
    
    
    Calendar fechanacto=this.getCalendar(this.fechaNcto.toString());
     
   int dia= fechaActual.get(Calendar.DATE);
   int mes= fechaActual.get(Calendar.MONTH);
   int anio= fechaActual.get(Calendar.YEAR);
   
   
   //System.out.println(dia + " " + mes + " "+ anio);
   
   int dia_al= Integer.valueOf( elementos[2]);
   int mes_al= Integer.valueOf( elementos[1]);
   int anio_al= Integer.valueOf( elementos[0]);
    
   //System.out.println(dia_al + " " + mes_al + " "+ anio_al);
    int anios = anio-anio_al;
    int meses = mes-mes_al;
    if (meses < 0) {
      anios = anios - 1;
    } else 
        if (meses == 0) {
            int dias = dia -dia_al;
      if (dias > 0) {
        anios = anios - 1;
      }
    }
    
   //System.out.println("Años:"+anios);
    this.edad=anios;
    
    }
    else
        this.edad=0;
         
      
            
        
    }

    public String getFolio_certificado() {
        return folio_certificado;
    }

    public void setFolio_certificado(String folio_certificado) {
        this.folio_certificado = folio_certificado;
    }

    public char getModo_ingreso() {
        return modo_ingreso;
    }

    public void setModo_ingreso(char modo_ingreso) {
        this.modo_ingreso = modo_ingreso;
    }
    
    public void sqlToModoIngreso(String modo_ingreso)
    {
      this.modo_ingreso = modo_ingreso.charAt(0);
    }
    public String ModoIngresoToForm(char modo)
    {
       String mensaje="";
      if(modo=='1')
          mensaje="INGRESO";
      if(modo=='2')
          mensaje="CAMBIO DE PLANTEL";
      if(modo==3)
          mensaje="PORTABILIDAD";
      return mensaje;
    }
    public void FormToModoIngreso(String modo)
    {
     if(modo.equals("INGRESO"))
         this.modo_ingreso='1';
     if(modo.equals("CAMBIO DE PLANTEL"))
         this.modo_ingreso='2';
     if(modo.equals("PORTABILIDAD"))
         this.modo_ingreso='3';
    }

    public char getTitulado() {
        return titulado;
    }

    public void setTitulado(char titulado) {
        this.titulado = titulado;
    }
    
    
    private Grupos grupo;

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Alumnos() {
    }

    public Alumnos(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(Integer idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNcto() {
        if(this.fechaNcto!=null)
        return fechaNcto;
        else
            return null;
    }
    
    public String getFechaToForm(Date fecha)
    {
        if(fecha!=null)
        {
            SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
            return formato.format(fecha);
        }
        else
            return null;
    }

    public void setFechaNcto(Date fechaNcto) {
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
            formato.format(fechaNcto);
        this.fechaNcto = fechaNcto;
    }
    public void setFechaNcto(String fechaNcto) {
        try {
            Calendar calendario=this.getCalendar(fechaNcto);
          if(calendario!=null)
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
        if(fecha!=null && fecha.length()>0)
        {
        
        elementos=fecha.split("-");
                
        }
        else
            elementos=null;
      return elementos;
    }
    private Calendar getCalendar(String fecha)
    {
        String []elementos=this.elementosFecha(fecha);
    Calendar calendario=Calendar.getInstance();
    int mes, anio,dia;
        if(elementos!=null)
        {
         dia=Integer.parseInt(elementos[0]);
         mes=Integer.parseInt(elementos[1]);
         anio=Integer.parseInt(elementos[2]);
         
         
         calendario.set(anio, mes-1, dia,0,0,0);
         
         
         
        }
        else
            calendario=null;
        return calendario;
        
    }
    
    
private String getGenerarMatricula()
{

 return "";
}

    public Character getSexo() {
        return sexo;
    }
    public boolean getSeleccionaSexo()
    {
        boolean sex=false;
     if(this.sexo=='M')
     {
         sex=true;
     }
     else
        {
            sex=false;
        }
     return sex;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }
    public void setSexo(String sexo)
    {
     this.sexo=sexo.charAt(0);
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getLugarNcto() {
        return lugarNcto;
    }

    public void setLugarNcto(String lugarNcto) {
        this.lugarNcto = lugarNcto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotografia() {
        return fotografia;
    }

    public void setFotografia(String fotografia) {
        this.fotografia = fotografia;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }

    public String getEstado() {
        if(estado!=null)
        {
        if(estado.equals("AC"))
            
                this.estado="ACTIVO";
          if(estado.equals("BT")) 
                this.estado="BAJA TEMPORAL";
          if(estado.equals("BD"))
                        this.estado="BAJA DEFINITIVA";
          if(estado.equals("EG"))
            this.estado="EGRESADO";
        }
       return this.estado;
    }
public String getEstadoToSql() {
        if(estado.equals("ACTIVO"))
            
                this.estado="AC";
          if(estado.equals("BAJA TEMPORAL")) 
                this.estado="BT";
          if(estado.equals("BAJA DEFINITIVA"))
                        this.estado="BD";
          if(estado.equals("EGRESADO"))
            this.estado="EG";
       return this.estado;
    }
    public void setEstado(String estado) {
      
        if(estado.equals("ACTIVO"))
            
                this.estado="AC";
          if(estado.equals("BAJA TEMPORAL")) 
                this.estado="BT";
          if(estado.equals("BAJA DEFINITIVA"))
                        this.estado="BD";
          if(estado.equals("EGRESADO"))
            this.estado="EG";
            
                
        
      
        
    }
     public void setSqlToEstado(String estado) {
      
        if(estado.equals("AC"))
            
                this.estado="ACTIVO";
          if(estado.equals("BT")) 
                this.estado="BAJA TEMPORAL";
          if(estado.equals("BD"))
                        this.estado="BAJA DEFINITIVA";
          if(estado.equals("EG"))
            this.estado="EGRESADO";
            
                
        
      
        
    }

    public String getFichaMedica() {
        return fichaMedica;
    }

    public void setFichaMedica(String fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    public String getSecundariaProcedencia() {
        return secundariaProcedencia;
    }

    public void setSecundariaProcedencia(String secundariaProcedencia) {
        this.secundariaProcedencia = secundariaProcedencia;
    }

    public float getPromedioSecundaria() {
        return promedioSecundaria;
    }

    public void setPromedioSecundaria(Float promedioSecundaria) {
        this.promedioSecundaria = promedioSecundaria;
    }
    
    public void setPromedioSecundaria(String promedioSecundaria)
    {
      if(promedioSecundaria.length()>0)
      {
      this.promedioSecundaria=Float.parseFloat(promedioSecundaria);
      }
      else
          this.promedioSecundaria=0;
    }

    public Date getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(Date fechaBaja) {
        if(fechaBaja!=null)
        {
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
         formato.format(fechaBaja);
         this.fechaBaja = fechaBaja;
        }
        else
            this.fechaBaja=null;
    }
public String  FechaBajaToSql()
    {
        if(fechaBaja!=null)
        {
        SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
        formato.format(fechaBaja);
        
        return  this.fechaBaja.toString();
        }
        else
            return null;
    }
    public String getMotivoBaja() {
        return motivoBaja;
    }

    public void setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }

    public Date getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(Date fechaEgreso) {
        if(fechaEgreso!=null)
        {
         SimpleDateFormat formato=new SimpleDateFormat("yyyy-MM-dd");
         formato.format(fechaEgreso);
         this.fechaEgreso = fechaEgreso;
        
        }
        else
        this.fechaEgreso=null;
    }
    
   public void setFechaEgreso(String fechaEgreso)
   {
   
    try {
            Calendar calendario=this.getCalendar(fechaEgreso);
          if(calendario!=null)
          {           
            java.sql.Date sqlToday=new java.sql.Date(calendario.getTime().getTime());
            this.fechaEgreso = sqlToday;
          }
          else
              this.fechaEgreso=null;
           
        } catch (Exception ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
public void setFechaBaja(String fechaBaja)
   {
   
    try {
            Calendar calendario=this.getCalendar(fechaBaja);
          if(calendario!=null)
          {           
            java.sql.Date sqlToday=new java.sql.Date(calendario.getTime().getTime());
            this.fechaBaja = sqlToday;
          }
          else
              this.fechaBaja=null;
           
        } catch (Exception ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
       try {
            Calendar calendario=this.getCalendar(fechaIngreso);
          if(calendario!=null)
          {           
            java.sql.Date sqlToday=new java.sql.Date(calendario.getTime().getTime());
            this.fechaIngreso = sqlToday;
          }
          else
              this.fechaIngreso=null;
           
        } catch (Exception ex) {
            Logger.getLogger(Alumnos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public void setFechaIngreso(Date fechaIngreso) {
       
         if(fechaIngreso!=null)
         {
            SimpleDateFormat formato=new SimpleDateFormat("dd-MM-yyyy");
            formato.format(fechaIngreso);
            this.fechaIngreso = fechaIngreso;
         }
         else
             this.fechaIngreso=null;
       
    }
    
    



    public char getRepetidor() {
        return repetidor;
    }

    public void setRepetidor(Character repetidor) {
        this.repetidor = repetidor;
    }
    
    

       public void setRepetidor(String repetidor) {
        this.repetidor = repetidor.charAt(0);
    }
 public String getCalcularMatricula()
   {
        Calendar f=Calendar.getInstance();
            int anio= f.get(Calendar.YEAR);
         String a=String.valueOf(anio);
         a=a.substring(2);
         ctrlEscuela ctrlescuela=new ctrlEscuela();
         Escuelas objescuela=ctrlescuela.getEscuelas();
         if(objescuela!=null)
         {
          a=a+String.valueOf(objescuela.getTipoPlantel().getClave_unidad());
         }
         a=a+objescuela.getEntidad().getClave();
         a=a+objescuela.getTipoPlantel().getClave();
          String parte_num=objescuela.getNumero().substring(1, objescuela.getNumero().length());
         a=a+=parte_num;
         
         
         return a;
   }
 
 
 public void sqlToTitulado(String titulado)
 {
  this.titulado=titulado.charAt(0);
 }
 
 
 
public void ToString()
        
{
 System.out.print(this.idAlumno + "-" + this.matricula);
}

public String getUrlFoto()
{
 
 String url="";
        if(this.fotografia!=null && this.fotografia.length()>0)
        {
          Utilerias.Configuracion conf=new Utilerias.Configuracion();
          String host=conf.getPropiedad("servidor.host");
          url="\\\\"+host+"\\imagenes\\"+this.fotografia;
        }
 return url;
}

    @Override
    public String toString() {
        return "Alumnos{" + "idAlumno=" + idAlumno + ", matricula=" + matricula + ", apePaterno=" + apePaterno + ", apeMaterno=" + apeMaterno + ", nombre=" + nombre + ", direccion=" + direccion + ", fechaNcto=" + fechaNcto + ", sexo=" + sexo + ", estadoCivil=" + estadoCivil + ", curp=" + curp + ", lugarNcto=" + lugarNcto + ", telefono=" + telefono + ", fotografia=" + fotografia + ", tutor=" + tutor + ", beca=" + beca + ", estado=" + estado + ", fichaMedica=" + fichaMedica + ", secundariaProcedencia=" + secundariaProcedencia + ", promedioSecundaria=" + promedioSecundaria + ", fechaBaja=" + fechaBaja + ", motivoBaja=" + motivoBaja + ", fechaEgreso=" + fechaEgreso + ", fechaIngreso=" + fechaIngreso + ", repetidor=" + repetidor + ", titulado=" + titulado + ", modo_ingreso=" + modo_ingreso + ", folio_certificado=" + folio_certificado + ", grupo=" + grupo + '}';
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
