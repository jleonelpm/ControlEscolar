/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import Entidades.Alumnos;
import Entidades.AlumnosGrupo;
import Entidades.Calificaciones;
import Entidades.CalificacionesSubmodulo;
import Entidades.Carreras;
import Entidades.CicloEscolar;
import Entidades.GruposCiclo;
import Entidades.Inscripciones;
import Entidades.Grupos;
import Entidades.OfertaAcademica;
import Entidades.PagosInscripcion;
import Entidades.Usuarios;
import java.sql.ResultSet;

/**
 *
 * @author Last Develop
 */
public class ctrlInscripciones {
    
    private int exito=0;

    public int getExito() {
        return exito;
    }

    public void setExito(int exito) {
        this.exito = exito;
    }
    
    private String sql="";
    private Mysql db;
    private PreparedStatement cs=null;

    public ctrlInscripciones() {
        this.db = new Mysql();
        
    }
    
    
    
    public boolean getSepuedeInscribir(int asignaturas,int modulos)
    {
        boolean sipuede=false;
                if(asignaturas==0 && modulos==0)
                    sipuede=true;
                if(asignaturas==1 && modulos==0)
                        sipuede=true;
                if(asignaturas==0 && modulos==1)
                    sipuede=true;
                if(asignaturas==1 && modulos==1)
                    sipuede=true;
               if(asignaturas==2 && modulos==0)
                   sipuede=true;
                
                
                        
                        
     return sipuede;
    }
    
    public boolean getEsBajaDefinitiva(int asignaturas, int modulos)
    {
       boolean bajadefinitiva=false;
        if(!this.getSepuedeInscribir(asignaturas, modulos)) //No se puede reinscribir
        {
            if(asignaturas+modulos>3)
               bajadefinitiva=true;
        }
        return bajadefinitiva;
    }
    

    
    
    
    /*METODO PARA INSCRIBIR 18-06-2012*/
    public boolean setInscripciones(Alumnos al, ModeloOfertaAsignaturas tablaasignaturas, Grupos grupo, CicloEscolar cicloactivo, Usuarios usuario,boolean pagado) throws SQLException, ClassNotFoundException 
    {
    
        
        
      int id_inscripcion=-1;  
    sql = "{call set_inscripcion_asignatura(?,?,?,?,?,?)} ";
    boolean band = true;        
    
    db.Conectar();
    db.begin(); //Iniciamos la transacción
    
   //Agregar en la tabla inscripcion
    
       ArrayList<Inscripciones> lista=  this.getListaInscribir(al, tablaasignaturas,grupo,cicloactivo);
       //ArrayList<Calificaciones> listacalificaciones=new ArrayList<Calificaciones>();
       for (int i=0;i<lista.size();i++)
       {
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, lista.get(i).getId_inscripcion());
        cs.setInt(2, lista.get(i).getId_alumno());
        cs.setInt(3,lista.get(i).getId_oferta_academica() );
        cs.setInt(4,lista.get(i).getId_ciclo() );
        cs.setString(5,String.valueOf( lista.get(i).getRecursamiento().charAt(0))); 
        cs.setString(6, lista.get(i).getModulo());
        ResultSet rs=cs.executeQuery();
        if(rs.next())
        {
          id_inscripcion= rs.getInt(1);
          
        }
       cs.close();
       if(id_inscripcion>-1)
       { 
            band=true;
          /*CREAMOS LA LISTA DE CALIFICACIONES*/
           if(lista.get(i).getModulo().equals("N"))
            { //si se va a la tabla calificaciones o módulos.
            Calificaciones cali=new Calificaciones();
            
            cali.setId_calificacion(0);  
            cali.setId_inscripcion(id_inscripcion); 
            cali.setId_oferta_academica(lista.get(i).getId_oferta_academica());
            cali.setId_asignatura(lista.get(i).getId_asignatura());
            cali.setId_alumno(lista.get(i).getId_alumno());
            
            cali.setParcial1(0);
            cali.setFaltas1(0);
            cali.setId_tipo1(0);
            cali.setId_usuario1(0);
            
            cali.setParcial2(0);
            cali.setFaltas2(0);
            cali.setId_tipo2(0);
            cali.setId_usuario2(0);
            
            cali.setParcial3(0);
            cali.setFaltas3(0);
            cali.setId_tipo3(0);
            cali.setId_usuario3(0);
            
            cali.setPromedio(0);
            
            ctrlCalificaciones ctrlcalificaciones=new ctrlCalificaciones();
            band= ctrlcalificaciones.setCalificaciones(cali);
            if(band==false)
            {
                break;
            }
       }//Fin de si se va a la tabla modulos  o calificaciones /si no se va a módulos
           
           // listacalificaciones.add(cali);
           else  //La lisra de calificaciones será en la tabla calificaciones_modulo
           {
            CalificacionesSubmodulo cali=new CalificacionesSubmodulo();
            
            cali.setId_calificacion(0);  
            cali.setId_inscripcion(id_inscripcion); 
            cali.setId_oferta_academica(lista.get(i).getId_oferta_academica());
            cali.setId_asignatura(lista.get(i).getId_asignatura());
            cali.setId_alumno(lista.get(i).getId_alumno());
            
            cali.setParcial1(0);
            cali.setPonderacion1(0);
            cali.setFaltas1(0);
            cali.setFecha_pa1(null);
            cali.setId_usuario1(0);
            
            cali.setParcial2(0);
            cali.setPonderacion2(0);
            cali.setFaltas2(0);
            cali.setFecha_pa2(null);
            cali.setId_usuario2(0);
            
            cali.setParcial3(0);
            cali.setPonderacion3(0);
            cali.setFaltas3(0);
            cali.setFecha_pa3(null);
            cali.setId_usuario3(0);
            
            cali.setParcial4(0);
            cali.setPonderacion4(0);
            cali.setFaltas4(0);
            cali.setFecha_pa4(null);
            cali.setId_usuario4(0);
            
            cali.setParcial5(0);
            cali.setPonderacion5(0);
            cali.setFaltas5(0);
            cali.setFecha_pa5(null);
            cali.setId_usuario5(0);
            
            cali.setParcial6(0);
            cali.setPonderacion6(0);
            cali.setFaltas6(0);
            cali.setFecha_pa6(null);
            cali.setId_usuario6(0);
            
            cali.setParcial7(0);
            cali.setPonderacion7(0);
            cali.setFaltas7(0);
            cali.setFecha_pa7(null);
            cali.setId_usuario7(0);
            
            cali.setParcial8(0);
            cali.setPonderacion8(0);
            cali.setFaltas8(0);
            cali.setFecha_pa8(null);
            cali.setId_usuario8(0);
            
            cali.setParcial9(0);
            cali.setPonderacion9(0);
            cali.setFaltas9(0);
            cali.setFecha_pa9(null);
            cali.setId_usuario9(0);
            
            cali.setParcial10(0);
            cali.setPonderacion10(0);
            cali.setFaltas10(0);
            cali.setFecha_pa10(null);
            cali.setId_usuario10(0);
            
            cali.setTotal(0);
            cali.setId_tipo(1);
            ctrlCalificacionesSubmodulo ctrlcalificacionessubmodulo=new ctrlCalificacionesSubmodulo();
            band=ctrlcalificacionessubmodulo.setCalificacionesModulo(cali);
           if(band==false)
            {
                break;
            }
           }
       }//fin del id_inscripcion>-1
       else
       {
           band=false;
           break;
       }
       }//Fin del for
       
       PagosInscripcion pagoinscripcion=new PagosInscripcion();
       
       pagoinscripcion.setId_pago_inscripcion(0);
       pagoinscripcion.setId_alumno(lista.get(0).getId_alumno());
       pagoinscripcion.setId_ciclo(lista.get(0).getId_ciclo());
       pagoinscripcion.setId_usuario(usuario.getId_usuario());
       if(pagado)
       {
           pagoinscripcion.setPagado("Si");
       }
       else
       {
           pagoinscripcion.setPagado("No");
       }
       ctrlPagosInscripciones ctrlpagosinscripcion=new ctrlPagosInscripciones();//Almacenamos en la tabla inscripciones
       
       
       
       if( ctrlpagosinscripcion.setPagoInscripcion(pagoinscripcion))
           band=true;
       else
           band=false;
       
       AlumnosGrupo alumnogrupo=new AlumnosGrupo();
       alumnogrupo.setId_alumno(al.getIdAlumno());
       alumnogrupo.setId(0);
       alumnogrupo.setId_carrera(0);
       alumnogrupo.setId_ciclo(cicloactivo.getIdCiclo());
       alumnogrupo.setId_grupo_ciclo(grupo.getIdGrupo());
       
       ctrlAlumnosGrupo ctrlalumnosgrupo=new ctrlAlumnosGrupo();
       band= ctrlalumnosgrupo.setAlumnoGrupo(alumnogrupo);
       
        if (band){
            db.commit();
            }
        else{
            db.rollback();
            }
    db.Desconectar(); 
        
    return band;
    
    }
    
    private ArrayList<Inscripciones> getListaInscribir(Alumnos al, ModeloOfertaAsignaturas tablaasignaturas, Grupos grupo,CicloEscolar cicloactivo)
    {
         ArrayList<Inscripciones> listainscribir=new ArrayList<Inscripciones>();
         ArrayList<OfertaAcademica> listaoferta= tablaasignaturas.getListaOfertaAcademica();
         for(int i=0;i<listaoferta.size();i++)
         {
          
             if(listaoferta.get(i).isSeleccionado())
             {
                Inscripciones obj=new Inscripciones();
                obj.setId_inscripcion(0);
                obj.setId_ciclo(cicloactivo.getIdCiclo());
                obj.setId_oferta_academica(listaoferta.get(i).getIdOfertaAcademica());
                obj.setId_alumno(al.getIdAlumno());
                obj.setRecursamiento("N");
                obj.setId_asignatura(listaoferta.get(i).getIdAsignatura()); //No se almacena en inscripciones, se utilza en calificaciones
                obj.setModulo(listaoferta.get(i).getAsignatura().getModulo());
                listainscribir.add(obj);
                //System.out.println(obj.toString());
             }
         }
         
      return listainscribir;
              
    }
  
    /**/
    /*METODO PARA REINSCRIBIR 18-06-2012*/
    
    public boolean setReinscripcion()
    {
        return true;
    }
    
    
    /*METODO QUE TRAE ALUMNOS INSCRITOS DEL CICLO ACTIVO  29-06-2012 PARA QUE SE PUEDA EDITAR LA INSCRIPCION
     * 
     */
    
    public ArrayList<Alumnos> getListaInscrito(String in_criterio, String in_campo) throws SQLException, ClassNotFoundException
    {
     ArrayList<Alumnos> listaInscritos=new ArrayList<Alumnos>();
     ctrlCicloEscolar ctrlciclo=new ctrlCicloEscolar();
      CicloEscolar ciclo=  ctrlciclo.getCicloActivo();
        sql = "{call get_alumnos_inscritos(?,?,?)} ";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, ciclo.getIdCiclo());
        cs.setString(2, in_criterio);
        cs.setString(3,in_campo );
        
        ResultSet rs=cs.executeQuery();
        while (rs.next())
        {
        Alumnos inscrito=this.rellenarInscripciones(rs);
        listaInscritos.add(inscrito);
        
        }
     return listaInscritos;
    }
    
    private Alumnos rellenarInscripciones(ResultSet rs) throws SQLException
    {
      Alumnos inscrito=new Alumnos();
      inscrito.setIdAlumno(rs.getInt("id_alumno"));
      inscrito.setIdAlumno(rs.getInt("id_alumno"));
      inscrito.setMatricula(rs.getString( "matricula"));
      inscrito.setNombre(rs.getString("nombre"));
      inscrito.setApePaterno(rs.getString("ape_paterno"));
      inscrito.setApeMaterno(rs.getString("ape_materno"));
      return inscrito;
    }
    
    public ModeloTablaAlumnos getTablaAlumnos(ArrayList<Alumnos> lista)
    {
        String []columnas={"Clave","Matricula","Paterno","Materno","Nombre"};
     ModeloTablaAlumnos modelo=new ModeloTablaAlumnos(columnas);
     if(lista.size()>0)
     {
       for(int i=0;i<lista.size();i++)
        {
            modelo.addAlumnoInscrito(lista.get(i));
        }
     }
    return modelo;
    }
    
    public ModeloEditarInscripcion getCargaACademica(int id_alumno) throws SQLException, ClassNotFoundException
    {
        String[]columnas={"Clave","Asignatura"};
        ModeloEditarInscripcion dm=new ModeloEditarInscripcion(columnas);
        ArrayList<Inscripciones> lista=this.getCargaAcademicaAlumno(id_alumno);
        if(lista!=null)
        {
            if(lista.size()>0)
            {
             for(int i=0;i<lista.size();i++)
             {
              dm.addOfertaAcademica(lista.get(i));
             }
            }
        }
    return dm;
    }
    
    private ArrayList<Inscripciones> getCargaAcademicaAlumno(int id_alumno ) throws SQLException, ClassNotFoundException
    {
      ArrayList<Inscripciones> lista=new ArrayList<Inscripciones>();
      ctrlCicloEscolar ctrlciclo=new ctrlCicloEscolar();
      CicloEscolar cicloactivo=ctrlciclo.getCicloActivo();
        sql = "{call get_carga_academica_alumno(?,?)} ";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, cicloactivo.getIdCiclo());
        cs.setInt(2, id_alumno);
      
        
        ResultSet rs=cs.executeQuery();
        while (rs.next())
        {
        Inscripciones inscrito=this.rellenaCargaAcademica(rs);
        lista.add(inscrito);
        
        }
      db.Desconectar();
      return lista;
    }
    
    private Inscripciones rellenaCargaAcademica(ResultSet rs) throws SQLException
    {
     Inscripciones ins=new Inscripciones();
     ins.setId_inscripcion(rs.getInt("id_inscripcion"));
     ins.setId_oferta_academica(rs.getInt("id_oferta_academica"));
     ins.setId_asignatura(rs.getInt( "id_asignatura"));
     ins.setAsignatura(rs.getString("nombre"));
     ins.setModulo(rs.getString("modulo"));
     return ins;
    }
    
    public boolean eliminarInscripcion(Inscripciones ins) throws SQLException, ClassNotFoundException
    {
           boolean band=false;
           sql = "{call delete_inscripcion(?,?)} ";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, ins.getId_inscripcion());
        cs.setString(2, ins.getModulo());
      int res=cs.executeUpdate();
      if(res>0)
      {
          band=true;
      }
      else
      {
          band=false;
      }
        
       
      db.Desconectar();
           return band;
    }
    
    /*Solo se agrega a la tabla inscripciones y a la tabbla calificaciones*/
    public boolean setAjusteCargaAcademica(ArrayList<Inscripciones> lista) throws SQLException, ClassNotFoundException
    {
        int id_inscripcion=-1;  
    sql = "{call set_inscripcion_asignatura(?,?,?,?,?,?)} ";
    boolean band = true;        
    
    db.Conectar();
    db.begin(); //Iniciamos la transacción
    
   //Agregar en la tabla inscripcion
    
      
       //ArrayList<Calificaciones> listacalificaciones=new ArrayList<Calificaciones>();
       for (int i=0;i<lista.size();i++)
       {
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, lista.get(i).getId_inscripcion());
        cs.setInt(2, lista.get(i).getId_alumno());
        cs.setInt(3,lista.get(i).getId_oferta_academica() );
        cs.setInt(4,lista.get(i).getId_ciclo() );
        cs.setString(5,String.valueOf( lista.get(i).getRecursamiento().charAt(0))); 
        cs.setString(6, lista.get(i).getModulo());
        ResultSet rs=cs.executeQuery();
        if(rs.next())
        {
          id_inscripcion= rs.getInt(1);
          
        }
       cs.close();
       if(id_inscripcion>-1)
       { 
           // band=true;
          /*CREAMOS LA LISTA DE CALIFICACIONES*/
          if(lista.get(i).getModulo().equals("N"))
            { //si se va a la tabla calificaciones o módulos.
            Calificaciones cali=new Calificaciones();
            
            cali.setId_calificacion(0);  
            cali.setId_inscripcion(id_inscripcion); 
            cali.setId_oferta_academica(lista.get(i).getId_oferta_academica());
            cali.setId_asignatura(lista.get(i).getId_asignatura());
            cali.setId_alumno(lista.get(i).getId_alumno());
            
            cali.setParcial1(0);
            cali.setFaltas1(0);
            cali.setId_tipo1(0);
            cali.setId_usuario1(0);
            
            cali.setParcial2(0);
            cali.setFaltas2(0);
            cali.setId_tipo2(0);
            cali.setId_usuario2(0);
            
            cali.setParcial3(0);
            cali.setFaltas3(0);
            cali.setId_tipo3(0);
            cali.setId_usuario3(0);
            
            cali.setPromedio(0);
            
            ctrlCalificaciones ctrlcalificaciones=new ctrlCalificaciones();
            band= ctrlcalificaciones.setCalificaciones(cali);
            if(band==false)
            {
                break;
            }
       }//Fin de si se va a la tabla modulos  o calificaciones /si no se va a módulos
           
           // listacalificaciones.add(cali);
           else  //La lisra de calificaciones será en la tabla calificaciones_modulo
           {
            CalificacionesSubmodulo cali=new CalificacionesSubmodulo();
            
            cali.setId_calificacion(0);  
            cali.setId_inscripcion(id_inscripcion); 
            cali.setId_oferta_academica(lista.get(i).getId_oferta_academica());
            cali.setId_asignatura(lista.get(i).getId_asignatura());
            cali.setId_alumno(lista.get(i).getId_alumno());
            
            cali.setParcial1(0);
            cali.setFaltas1(0);
            cali.setFecha_pa1(null);
            cali.setId_usuario1(0);
            
            cali.setParcial2(0);
            cali.setFaltas2(0);
            cali.setFecha_pa2(null);
            cali.setId_usuario2(0);
            
            cali.setParcial3(0);
            cali.setFaltas3(0);
            cali.setFecha_pa3(null);
            cali.setId_usuario3(0);
            
            cali.setParcial4(0);
            cali.setFaltas4(0);
            cali.setFecha_pa4(null);
            cali.setId_usuario4(0);
            
            cali.setParcial5(0);
            cali.setFaltas5(0);
            cali.setFecha_pa5(null);
            cali.setId_usuario5(0);
            
            cali.setParcial6(0);
            cali.setFaltas6(0);
            cali.setFecha_pa6(null);
            cali.setId_usuario6(0);
            
            cali.setParcial7(0);
            cali.setFaltas7(0);
            cali.setFecha_pa7(null);
            cali.setId_usuario7(0);
            
            cali.setParcial8(0);
            cali.setFaltas8(0);
            cali.setFecha_pa8(null);
            cali.setId_usuario8(0);
            
            cali.setParcial9(0);
            cali.setFaltas9(0);
            cali.setFecha_pa9(null);
            cali.setId_usuario9(0);
            
            cali.setParcial10(0);
            cali.setFaltas10(0);
            cali.setFecha_pa10(null);
            cali.setId_usuario10(0);
            
            cali.setTotal(0);
            ctrlCalificacionesSubmodulo ctrlcalificacionessubmodulo=new ctrlCalificacionesSubmodulo();
            band=ctrlcalificacionessubmodulo.setCalificacionesModulo(cali);
           if(band==false)
            {
                break;
            }
           }
       }//fin del id_inscripcion>-1
       else
       {
           band=false;
           break;
       
       }
       
       }//Fin del for
       if(band)
       {
       db.commit();
       }
       else
           db.rollback();
    return band;
    
    }
    
    
}
