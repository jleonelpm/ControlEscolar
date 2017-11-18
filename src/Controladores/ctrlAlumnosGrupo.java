/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidades.Alumnos;
import Entidades.AlumnosGrupo;
import Entidades.AlumnosRecuperacion;

/**
 *
 * @author Last Develop
 */
public class ctrlAlumnosGrupo {
  private Controladores.Mysql objmysql=new Controladores.Mysql();
  private PreparedStatement objcallstm;
  
  private int totalhombres=0;
  private int totalmujeres=0;

    public int getTotalhombres() {
        return totalhombres;
    }

    

    public int getTotalmujeres() {
        return totalmujeres;
    }

    
  
  public boolean setAlumnoGrupo(AlumnosGrupo alumnogrupo) throws SQLException, ClassNotFoundException
  {
     boolean exito=false;
     int fila=0;
   if(objmysql.Conectar())
   {
       String sql="{call set_alumnosgrupo(?,?,?)}";
       objcallstm= objmysql.conexion.prepareStatement(sql);
         objcallstm.setInt(1, alumnogrupo.getId());                   
         objcallstm.setInt(2, alumnogrupo.getId_alumno());                   
         
         objcallstm.setInt(3, alumnogrupo.getId_grupo_ciclo());                   
                          
        
    
        fila=objcallstm.executeUpdate();
        objmysql.Desconectar();
       if(fila>0)
           exito=true;
       else
           exito=false;
   }
   
   return exito;
  }

    public ctrlAlumnosGrupo() {
        this.objmysql= new Mysql();
    }
        
   public ArrayList<Alumnos> getListaAlumnosGrupo(AlumnosGrupo alumnogrupo) throws SQLException, ClassNotFoundException
   {
    ArrayList<Alumnos> listaAlumnos=new ArrayList<Alumnos>();
    if(this.objmysql.Conectar())
    {
      String sql="{call get_alumnos_redi(?,?,?)}";
      objcallstm= objmysql.conexion.prepareStatement(sql);
      objcallstm.setInt(1, alumnogrupo.getId_ciclo());
      objcallstm.setInt(2, alumnogrupo.getId_grupo_ciclo());
      objcallstm.setInt(3, alumnogrupo.getId_carrera());
      ResultSet rs=objcallstm.executeQuery();
      while(rs.next())
      {
       Alumnos al=new Alumnos();
       al.setMatricula(rs.getString("matricula"));
       al.setNombre(rs.getString("nombre"));
       al.setApePaterno(rs.getString("ape_paterno"));
       al.setApeMaterno(rs.getString("ape_materno"));
       al.setFechaNcto(rs.getDate("fecha_ncto"));
       al.setSecundariaProcedencia(rs.getString("secundaria_procedencia"));
       al.setSexo(rs.getString("sexo"));
       if(al.getSexo()=='M')
           this.totalhombres++;
       else
           this.totalmujeres++;
       al.setNombrecompleto();
       al.setEdad();
       al.setModo_ingreso(rs.getString("modo_ingreso").charAt(0));
       //System.out.println(al.getModo_ingreso());
       listaAlumnos.add(al);
      }
    }
    else
        listaAlumnos=null;
    return listaAlumnos;
   }
   
   public ArrayList<Alumnos> getListaAsistencia(int id_ciclo, int id_oferta) throws SQLException, ClassNotFoundException
   {
    ArrayList<Alumnos> listaAlumnos=new ArrayList<Alumnos>();
    if(this.objmysql.Conectar())
    {
      String sql="{call get_alumnos_lista_asistencia(?,?)}";
      objcallstm= objmysql.conexion.prepareStatement(sql);
      objcallstm.setInt(1,id_ciclo);
      objcallstm.setInt(2, id_oferta);
      
      ResultSet rs=objcallstm.executeQuery();
      while(rs.next())
      {
       Alumnos al=new Alumnos();
      
       al.setNombre(rs.getString("nombre_completo"));
       
       
      
       //System.out.println(al.getModo_ingreso());
       listaAlumnos.add(al);
      }
    }
    else
        listaAlumnos=null;
    return listaAlumnos;
   }
   
   
    public ArrayList<AlumnosRecuperacion> getListaRecuperacion(int id_ciclo, int id_oferta) throws SQLException, ClassNotFoundException
   {
    ArrayList<AlumnosRecuperacion> listaAlumnos=new ArrayList<AlumnosRecuperacion>();
    if(this.objmysql.Conectar())
    {
      String sql="{call get_alumnos_recuperacion(?,?)}";
      objcallstm= objmysql.conexion.prepareStatement(sql);
      objcallstm.setInt(1,id_ciclo);
      objcallstm.setInt(2, id_oferta);
      
      ResultSet rs=objcallstm.executeQuery();
      while(rs.next())
      {
       AlumnosRecuperacion al=new AlumnosRecuperacion();
      
       al.setNombre(rs.getString("nombre_completo"));
       al.setParcial1(rs.getFloat("parcial1"));
       al.setParcial2(rs.getFloat("parcial2"));
       al.setParcial3(rs.getFloat("parcial3"));
       
       //System.out.println(al.getModo_ingreso());
       listaAlumnos.add(al);
      }
    }
    else
        listaAlumnos=null;
    return listaAlumnos;
   }
   
}
