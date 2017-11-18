/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.CalificacionesSubmodulo;
import Entidades.UnidadAprendizaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Last Develop
 */
public class ctrlCalificacionesSubmodulo {
  Mysql db;
  String sql = "";
  PreparedStatement objcallstm =  null;
  
  
  
  public ctrlCalificacionesSubmodulo(){
    db = new Mysql();    
  } 
  
  
  public boolean setCalificacionesModulo(CalificacionesSubmodulo ca) throws SQLException, ClassNotFoundException
  {
    boolean band=false;
    sql="{call set_calificaciones_submodulo(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      db.Conectar();
      objcallstm=db.conexion.prepareStatement(sql);
      objcallstm.setInt(1, ca.getId_calificacion());
      objcallstm.setInt(2, ca.getId_alumno());
      objcallstm.setInt(3, ca.getId_inscripcion());
      objcallstm.setInt(4, ca.getId_oferta_academica());
      objcallstm.setInt(5, ca.getId_asignatura());
      
      objcallstm.setFloat(6, ca.getParcial1());
      objcallstm.setFloat(7, ca.getPonderacion1());
      objcallstm.setInt(8, ca.getFaltas1());
      objcallstm.setDate(9, null);
      objcallstm.setInt(10, ca.getId_usuario1());
      
      
      
      objcallstm.setFloat(11, ca.getParcial2());
      objcallstm.setFloat(12, ca.getPonderacion2());
      objcallstm.setInt(13, ca.getFaltas2());
      objcallstm.setDate(14, null);
      objcallstm.setInt(15, ca.getId_usuario2());
      
      objcallstm.setFloat(16, ca.getParcial3());
      objcallstm.setFloat(17, ca.getPonderacion3());
      objcallstm.setInt(18, ca.getFaltas3());
      objcallstm.setDate(19, null);
      objcallstm.setInt(20, ca.getId_usuario3());
      
      objcallstm.setFloat(21, ca.getParcial4());
      objcallstm.setFloat(22, ca.getPonderacion4());
      objcallstm.setInt(23, ca.getFaltas4());
      objcallstm.setDate(24, null);
      objcallstm.setInt(25, ca.getId_usuario4());
      
      objcallstm.setFloat(26, ca.getParcial5());
      objcallstm.setFloat(27, ca.getPonderacion5());
      objcallstm.setInt(28, ca.getFaltas5());
      objcallstm.setDate(29, null);
      objcallstm.setInt(30, ca.getId_usuario5());
      
      objcallstm.setFloat(31, ca.getParcial6());
      objcallstm.setFloat(32, ca.getPonderacion6());
      objcallstm.setInt(33, ca.getFaltas6());
      objcallstm.setDate(34, null);
      objcallstm.setInt(35, ca.getId_usuario6());
      
      objcallstm.setFloat(36, ca.getParcial7());
      objcallstm.setFloat(37, ca.getPonderacion7());
      objcallstm.setInt(38, ca.getFaltas7());
      objcallstm.setDate(39, null);
      objcallstm.setInt(40, ca.getId_usuario7());
      
      objcallstm.setFloat(41, ca.getParcial8());
      objcallstm.setFloat(42, ca.getPonderacion8());
      objcallstm.setInt(43, ca.getFaltas8());
      objcallstm.setDate(44, null);
      objcallstm.setInt(45, ca.getId_usuario8());
      
      objcallstm.setFloat(46, ca.getParcial9());
      objcallstm.setFloat(47, ca.getPonderacion9());
      objcallstm.setInt(48, ca.getFaltas9());
      objcallstm.setDate(49, null);
      objcallstm.setInt(50, ca.getId_usuario9());
      
      objcallstm.setFloat(51, ca.getParcial10());
      objcallstm.setFloat(52, ca.getPonderacion10());
      objcallstm.setInt(53, ca.getFaltas10());
      objcallstm.setDate(54, null);
      objcallstm.setInt(55, ca.getId_usuario10());
      
      objcallstm.setFloat(56,ca.getTotal());
       objcallstm.setFloat(57,ca.getId_tipo());
      
       int r=objcallstm.executeUpdate();
       if(r>0)
           band=true;
       else
           band=false;
       db.Desconectar();
      return band;
    
    
    
  }
  
  
  
  /*Metodo para obtener la lista de alumnos inscritos al submodulo*/
  
  public ArrayList<CalificacionesSubmodulo> getAlumnosAsignatura(int id_asignatura, int id_oferta_academica) throws SQLException, ClassNotFoundException
    {
      ArrayList<CalificacionesSubmodulo> lista=new ArrayList<CalificacionesSubmodulo>();
      ArrayList<UnidadAprendizaje> listaUnidad=this.getUnidadesAprendizaje(id_asignatura);//Obtenemos las unidades de aprendizaje del submodulo
      if(db.Conectar())
                {
                   sql="call get_alumnos_submodulos(?)";
                   objcallstm= db.conexion.prepareStatement(sql) ;
   
                   objcallstm.setInt(1, id_oferta_academica);                   
                    
                    ResultSet rs=objcallstm.executeQuery();
                    int no=1;
                    while(rs.next())
                    {
                      CalificacionesSubmodulo reg=this.rellenarCalificaciones(rs, no);
                      reg.setUnidadaprendizaje(listaUnidad);
                      lista.add(reg);
                      no++;
                    }
                }
      return lista;
    }
  
  private CalificacionesSubmodulo rellenarCalificaciones(ResultSet rs, int no) throws SQLException
    {
    CalificacionesSubmodulo califi=new CalificacionesSubmodulo();
    califi.setId_calificacion(rs.getInt("id_calificacion"));
    califi.setId_inscripcion(rs.getInt("id_inscripcion"));
    califi.setId_alumno(rs.getInt("id_alumno"));
    califi.setId_asignatura(rs.getInt( "id_asignatura"));
    califi.setId_oferta_academica(rs.getInt("id_oferta_academica"));
    califi.setNo(no);
    califi.setNombreCompleto(rs.getString("ape_paterno")+ " " + rs.getString("ape_materno")+" "+ rs.getString("nombre"));
    califi.setMatricula(rs.getString("matricula"));
    
    
    califi.setParcial1(rs.getFloat("parcial1"));
    califi.setPonderacion1(rs.getFloat("ponderacion1"));
    califi.setFaltas1(rs.getInt("faltas1"));
    califi.setId_usuario1(rs.getInt("id_usuario1")); //Fecha no se si se debe buscar
    if(rs.getDate("fecha_pa1")!=null)
        califi.setFecha_pa1(rs.getDate("fecha_pa1"));
    else
        califi.setFecha_pa1(null);
    
    
    
    
    califi.setParcial2(rs.getFloat("parcial2"));
    califi.setPonderacion2(rs.getFloat("ponderacion2"));
    califi.setFaltas2(rs.getInt("faltas2"));
    califi.setId_usuario2(rs.getInt("id_usuario2"));
    
    califi.setParcial3(rs.getFloat("parcial3"));
    califi.setPonderacion3(rs.getFloat("ponderacion3"));
    califi.setFaltas3(rs.getInt("faltas3"));
    califi.setId_usuario3(rs.getInt("id_usuario3"));
    
    
    califi.setParcial4(rs.getFloat("parcial4"));
    califi.setPonderacion4(rs.getFloat("ponderacion4"));
    califi.setFaltas4(rs.getInt("faltas4"));
    califi.setId_usuario4(rs.getInt("id_usuario4"));
    
    califi.setParcial5(rs.getFloat("parcial5"));
    califi.setPonderacion5(rs.getFloat("ponderacion5"));
    califi.setFaltas5(rs.getInt("faltas5"));
    califi.setId_usuario5(rs.getInt("id_usuario5"));
    
    califi.setParcial6(rs.getFloat("parcial6"));
    califi.setPonderacion6(rs.getFloat("ponderacion6"));
    califi.setFaltas6(rs.getInt("faltas6"));
    califi.setId_usuario6(rs.getInt("id_usuario6"));
    
    califi.setParcial7(rs.getFloat("parcial7"));
    califi.setPonderacion7(rs.getFloat("ponderacion7"));
    califi.setFaltas7(rs.getInt("faltas7"));
    califi.setId_usuario7(rs.getInt("id_usuario7"));
    
   califi.setParcial8(rs.getFloat("parcial8"));
   califi.setPonderacion8(rs.getFloat("ponderacion8"));
    califi.setFaltas8(rs.getInt("faltas8"));
    califi.setId_usuario8(rs.getInt("id_usuario8"));
    
    
    califi.setParcial9(rs.getFloat("parcial9"));
    califi.setPonderacion9(rs.getFloat("ponderacion9"));
    califi.setFaltas9(rs.getInt("faltas9"));
    califi.setId_usuario9(rs.getInt("id_usuario9"));
    
    califi.setParcial10(rs.getFloat("parcial10"));
    califi.setPonderacion10(rs.getFloat("ponderacion10"));
    califi.setFaltas10(rs.getInt("faltas10"));
    califi.setId_usuario10(rs.getInt("id_usuario10"));
    califi.setTotal(rs.getFloat("total"));
    
    califi.setId_tipo(rs.getInt("id_tipo"));
    //System.out.println(califi.toString());
    return califi;
    }
  
  
  /*Se utiliza para obtener las unidades de aprendizaje de un submodulo especifico*/
  private ArrayList<UnidadAprendizaje> getUnidadesAprendizaje(int id_asignatura) throws SQLException, ClassNotFoundException
  {
   ArrayList<UnidadAprendizaje> listaUnidades=new ArrayList<UnidadAprendizaje>();
   this.db.Conectar();
    sql="call get_unidades_calificar(?)";
    objcallstm= db.conexion.prepareStatement(sql) ;
    objcallstm.setInt(1, id_asignatura);                   
                    
    ResultSet rs=objcallstm.executeQuery();
                   
                    while(rs.next())
                    {
                      UnidadAprendizaje u=new UnidadAprendizaje();
                      u.setIdUnidadAprendizaje(rs.getInt("id_unidad_aprendizaje"));
                      u.setIdSubmodulo(rs.getInt("id_submodulo"));//Es el equivalente a la asignatura
                      u.setIdModulo(rs.getInt("id_modulo"));
                      u.setClave(rs.getString("clave"));
                      u.setDescripcion(rs.getString( "descripcion"));
                      u.setFactorPonderacion(rs.getFloat("factor_ponderacion"));
                      //System.out.println("Factor de ponderación:"+u.getFactorPonderacion()+ u.getClave());
                      listaUnidades.add(u);
                      
                    }
   
   this.db.Desconectar();
   return listaUnidades;
  }
  
  public ModeloCalificacionesSubModulos getModeloCalificionesSubmodulos(ArrayList<CalificacionesSubmodulo> lista)
  {ModeloCalificacionesSubModulos dm=null;
      if(lista!=null)
      {
       
        String []columnas=this.getColumnasModelo();
   
   
        dm=new ModeloCalificacionesSubModulos(columnas);
   
        for(int j=0;j<lista.size();j++)
        {
           dm.agregarCalificaciones(lista.get(j));
        }
      }
       
   return dm;
  }
  
  private String [] getColumnasModelo()
  {
      String[] columnas={"No","Nombre","Matricula",
      "UA-1","F.P","CUP-1","FA-1",
      "UA-2","F.P","CUP-2","FA-2",
      "UA-3","F.P","CUP-3","FA-3",
      "UA-4","F.P","CUP-4","FA-4",
      "UA-5","F.P","CUP-5","FA-5",
      "UA-6","F.P","CUP-6","FA-6",
      "UA-7","F.P","CUP-7","FA-7",
      "UA-8","F.P","CUP-8","FA-8",
      "UA-9","F.P","CUP-9","FA-9",
      "UA-10","F.P","CUP-10","FA-10","Tipo","Total",
      };
   
   
   
   
  
   return columnas;
  }

 public boolean updateCalificacionesSubmodulos(ArrayList<CalificacionesSubmodulo> lista, int unidad) throws SQLException, ClassNotFoundException
 {
    boolean exito=false;
    
    sql="{call set_registro_calificaciones_submodulos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,"
            + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      db.Conectar();
      db.begin();//Comienza la transacción
      for(int i=0;i<lista.size();i++)
      {
          CalificacionesSubmodulo ca=lista.get(i);
      objcallstm=db.conexion.prepareStatement(sql);
      objcallstm.setInt(1, ca.getId_calificacion());
      objcallstm.setInt(2, ca.getId_alumno());
      objcallstm.setInt(3, ca.getId_inscripcion());
      objcallstm.setInt(4, ca.getId_oferta_academica());
      objcallstm.setInt(5, ca.getId_asignatura());
      
      objcallstm.setFloat(6, ca.getParcial1());
      objcallstm.setFloat(7, ca.getPonderacion1());
      objcallstm.setInt(8, ca.getFaltas1());
      objcallstm.setDate(9, null);
      objcallstm.setInt(10, ca.getId_usuario1());
      
      
      
      objcallstm.setFloat(11, ca.getParcial2());
      objcallstm.setFloat(12, ca.getPonderacion2());
      objcallstm.setInt(13, ca.getFaltas2());
      objcallstm.setDate(14, null);
      objcallstm.setInt(15, ca.getId_usuario2());
      
      objcallstm.setFloat(16, ca.getParcial3());
      objcallstm.setFloat(17, ca.getPonderacion3());
      objcallstm.setInt(18, ca.getFaltas3());
      objcallstm.setDate(19, null);
      objcallstm.setInt(20, ca.getId_usuario3());
      
      objcallstm.setFloat(21, ca.getParcial4());
      objcallstm.setFloat(22, ca.getPonderacion4());
      objcallstm.setInt(23, ca.getFaltas4());
      objcallstm.setDate(24, null);
      objcallstm.setInt(25, ca.getId_usuario4());
      
      objcallstm.setFloat(26, ca.getParcial5());
      objcallstm.setFloat(27, ca.getPonderacion5());
      objcallstm.setInt(28, ca.getFaltas5());
      objcallstm.setDate(29, null);
      objcallstm.setInt(30, ca.getId_usuario5());
      
      objcallstm.setFloat(31, ca.getParcial6());
      objcallstm.setFloat(32, ca.getPonderacion6());
      objcallstm.setInt(33, ca.getFaltas6());
      objcallstm.setDate(34, null);
      objcallstm.setInt(35, ca.getId_usuario6());
      
      objcallstm.setFloat(36, ca.getParcial7());
      objcallstm.setFloat(37, ca.getPonderacion7());
      objcallstm.setInt(38, ca.getFaltas7());
      objcallstm.setDate(39, null);
      objcallstm.setInt(40, ca.getId_usuario7());
      
      objcallstm.setFloat(41, ca.getParcial8());
      objcallstm.setFloat(42, ca.getPonderacion8());
      objcallstm.setInt(43, ca.getFaltas8());
      objcallstm.setDate(44, null);
      objcallstm.setInt(45, ca.getId_usuario8());
      
      objcallstm.setFloat(46, ca.getParcial9());
      objcallstm.setFloat(47, ca.getPonderacion9());
      objcallstm.setInt(48, ca.getFaltas9());
      objcallstm.setDate(49, null);
      objcallstm.setInt(50, ca.getId_usuario9());
      
      objcallstm.setFloat(51, ca.getParcial10());
      objcallstm.setFloat(52, ca.getPonderacion10());
      objcallstm.setInt(53, ca.getFaltas10());
      objcallstm.setDate(54, null);
      objcallstm.setInt(55, ca.getId_usuario10());
      
      objcallstm.setFloat(56,ca.getTotal());
      objcallstm.setFloat(57,ca.getId_tipo());
      objcallstm.setFloat(58,unidad);//Unidad a Actualizar
      int r=objcallstm.executeUpdate();
      if(r>0)
          exito=true;
      else
      {
         exito=false;
         break;
      }
      }
      if(exito)
          this.db.commit();
      else
          this.db.rollback();
      this.db.Desconectar();
    return exito;
 }
}
