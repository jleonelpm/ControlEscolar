/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Asignaturas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidades.Calificaciones;
import Entidades.Carreras;
import Entidades.Grupos;
import Entidades.OfertaAcademica;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Last Develop
 */
public class ctrlCalificaciones {
    private Mysql objmysql=new Mysql();
    private PreparedStatement objcallstm;
    private String sql="";
    public ctrlCalificaciones() {
    }
    
    public boolean updateCalificaciones(ArrayList<Calificaciones> listaCalificaciones, int bimestre) throws SQLException, ClassNotFoundException
    {  
        int r=0;
        boolean exito=true;
        objmysql.Conectar();
        objmysql.begin();
        sql="{call set_registro_calificaciones(?,?,?,?,?,?,?)} ";
        objcallstm=objmysql.conexion.prepareStatement(sql);
        for(int i=0;i<listaCalificaciones.size();i++)
        {
        Calificaciones calificaciones=listaCalificaciones.get(i);
         
         
         switch(bimestre)
         {
             case 1:
                 objcallstm.setInt(1,calificaciones.getId_calificacion());
                 objcallstm.setFloat(2, calificaciones.getParcial1());                   
                 objcallstm.setInt(3,calificaciones.getFaltas1());
                 objcallstm.setInt(4,calificaciones.getId_tipo1());
                 objcallstm.setInt(5,calificaciones.getId_usuario1());
                 objcallstm.setInt(6,bimestre);
                 objcallstm.setFloat(7,calificaciones.getPromedio());
                 break;
                 
             case 2:
                 objcallstm.setInt(1,calificaciones.getId_calificacion());
                 objcallstm.setFloat(2, calificaciones.getParcial2());                   
                 objcallstm.setInt(3,calificaciones.getFaltas2());
                 objcallstm.setInt(4,calificaciones.getId_tipo2());
                 objcallstm.setInt(5,calificaciones.getId_usuario2());
                 objcallstm.setInt(6,bimestre);
                 objcallstm.setFloat(7,calificaciones.getPromedio());
                 break;
             case 3:
                 objcallstm.setInt(1,calificaciones.getId_calificacion());
                 objcallstm.setFloat(2, calificaciones.getParcial3());                   
                 objcallstm.setInt(3,calificaciones.getFaltas3());
                 objcallstm.setInt(4,calificaciones.getId_tipo3());
                 objcallstm.setInt(5,calificaciones.getId_usuario3());
                 
                 objcallstm.setInt(6,bimestre);
                 objcallstm.setFloat(7,calificaciones.getPromedio());
                 break;
         }
       
         
         
         
         
         r=objcallstm.executeUpdate();
         if(r>0)
             exito=true;
         else
         {
          exito=false;
          break;
         }
         
        }
        if(exito)
        {
        objmysql.commit();
        }
        else
        {
         objmysql.rollback();
        }
         return exito;
    
    }
    
    public ArrayList<Calificaciones> getAlumnosAsignatura(int id_asignatura, int id_oferta_academica) throws SQLException, ClassNotFoundException
    {
      ArrayList<Calificaciones> lista=new ArrayList<Calificaciones>();
      if(objmysql.Conectar())
                {
                   sql="call get_alumnos_asignatura(?,?)";
                   objcallstm= objmysql.conexion.prepareStatement(sql) ;
   
                   objcallstm.setInt(1, id_asignatura);                   
                    objcallstm.setInt(2,id_oferta_academica);
                    ResultSet rs=objcallstm.executeQuery();
                    int no=1;
                    while(rs.next())
                    {
                      Calificaciones reg=this.rellenarCalificaciones(rs, no);
                      lista.add(reg);
                      no++;
                    }
                }
      return lista;
    }
    
    private Calificaciones rellenarCalificaciones(ResultSet rs, int no) throws SQLException
    {
    Calificaciones califi=new Calificaciones();
    califi.setId_calificacion(rs.getInt("id_calificacion"));
    califi.setId_inscripcion(rs.getInt("id_inscripcion"));
    califi.setNo(no);
    califi.setNombreCompleto( rs.getString("nombre"),rs.getString("ape_paterno"),rs.getString("ape_materno"));
    califi.setMatricula(rs.getString("matricula"));
    califi.setId_alumno(rs.getInt("id_alumno"));
    califi.setParcial1(rs.getFloat("parcial1"));
    califi.setFaltas1(rs.getInt("faltas1"));
    califi.setId_tipo1(rs.getInt("id_tipo1"));
    califi.setId_usuario1(rs.getInt("id_usuario1"));
    califi.setParcial2(rs.getFloat("parcial2"));
    califi.setFaltas2(rs.getInt("faltas2"));
    califi.setId_tipo2(rs.getInt("id_tipo2"));
    califi.setId_usuario2(rs.getInt("id_usuario2"));
    califi.setParcial3(rs.getFloat("parcial3"));
    califi.setFaltas3(rs.getInt("faltas3"));
    califi.setId_tipo3(rs.getInt("id_tipo3"));
    califi.setId_usuario3(rs.getInt("id_usuario3"));
    califi.setPromedio(rs.getFloat("promedio"));
    
    
    
   
    
    //System.out.println(califi.toString());
    return califi;
    }
    
    
    public ModeloCalificaciones getModeloTabla(ArrayList<Calificaciones> lista)
    {
     String []Columnas   ={"No","Nombre","Matricula","Bi 1","Fa 1","Tipo 1","Bi 2","Fa 2","Tipo 2","Bi 3","Fa 3","Tipo 3","Promedio"};
     ModeloCalificaciones modelo=new ModeloCalificaciones(Columnas);
     
      for (int i=0;i<lista.size();i++)
      {
       modelo.agregarCalificaciones(lista.get(i));
      }
     return modelo;
    }
    public boolean setCalificaciones(Calificaciones ca) throws SQLException, ClassNotFoundException
    {
      boolean band=true;
      sql="{call set_calificacion(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
      objmysql.Conectar();
      objcallstm=objmysql.conexion.prepareStatement(sql);
      objcallstm.setInt(1, ca.getId_calificacion());
      objcallstm.setInt(2, ca.getId_alumno());
      objcallstm.setInt(3, ca.getId_inscripcion());
      objcallstm.setInt(4, ca.getId_oferta_academica());
      objcallstm.setInt(5, ca.getId_asignatura());
      
      objcallstm.setFloat(6, ca.getParcial1());
      objcallstm.setInt(7, ca.getFaltas1());
      objcallstm.setDate(8, null);
      objcallstm.setInt(9, ca.getId_tipo1());
      objcallstm.setInt(10, ca.getId_usuario1());
      
      
      
       objcallstm.setFloat(11, ca.getParcial2());
      objcallstm.setInt(12, ca.getFaltas2());
      objcallstm.setDate(13, null);
      objcallstm.setInt(14, ca.getId_tipo2());
      objcallstm.setInt(15, ca.getId_usuario2());
      
       objcallstm.setFloat(16, ca.getParcial3());
      objcallstm.setInt(17, ca.getFaltas3());
      objcallstm.setDate(18, null);
      objcallstm.setInt(19, ca.getId_tipo3());
      objcallstm.setInt(20, ca.getId_usuario3());
      
       objcallstm.setFloat(21, ca.getPromedio());
       int r=objcallstm.executeUpdate();
       if(r>0)
           band=true;
       else
           band=false;
       objmysql.Desconectar();
      return band;
    }
    
    
    /*30-06-2012  trae la oferta academica de los maestros*/
    
    public ArrayList<OfertaAcademica> getCargaAcademicaMaestro(int id_profesor) throws SQLException, ClassNotFoundException
    {
      ArrayList<OfertaAcademica> lista=new ArrayList<OfertaAcademica>();
      objmysql.Conectar();
                
      sql="call get_asignatura_profesor(?)";
      objcallstm= objmysql.conexion.prepareStatement(sql) ;
      objcallstm.setInt(1, id_profesor);                   
      ResultSet rs=objcallstm.executeQuery();
                    
                    while(rs.next())
                    {
                      OfertaAcademica ofe=new OfertaAcademica();
                      ofe.setIdOfertaAcademica(rs.getInt("id_oferta_academica"));
                      Grupos g=new Grupos();
                      g.setIdGrupo(rs.getInt("id_grupo"));
                      g.setGrupo(rs.getString("grupo"));
                      
                      ofe.setGrupo(g);
                      
                      ofe.setIdGrupo(rs.getInt("id_grupo"));
                      
                      Asignaturas as=new Asignaturas();
                      as.setIdAsignatura(rs.getInt("id_asignatura"));
                      as.setNombre(rs.getString("asignatura"));
                      as.setModulo(rs.getString("modulo"));
                      as.setIdModulo(rs.getInt("id_modulo"));
                      
                  //  System.out.print(as.getNombre());   
                     // ofe.setAsignatura(as);  
                      Carreras ca=new Carreras();
                      if(rs.getInt("id_carrera")>0)
                      {
                      ca.setIdCarrera(rs.getInt("id_carrera"));
                      ca.setNombre(rs.getString("carrera"));
                      }
                      else
                      {
                      ca.setIdCarrera(0);
                      ca.setNombre("BACHILLERATO TECNOLÓGICO");
                      }
                      as.setCarrera(ca);
                      ofe.setAsignatura(as);
                      lista.add(ofe);
                    }
                objmysql.Desconectar();
      
      return lista;
    }
    
    public DefaultComboBoxModel getCombCargaDocente(int id_profesor) throws SQLException, ClassNotFoundException
    {
       ArrayList<OfertaAcademica> lista=this.getCargaAcademicaMaestro(id_profesor);
       DefaultComboBoxModel dm=new DefaultComboBoxModel();
       OfertaAcademica of=new OfertaAcademica();
       of.setIdOfertaAcademica(0);
       Asignaturas as=new Asignaturas();
       as.setIdAsignatura(0);
       as.setNombre("Selecciones una Asignatura");
       of.setAsignatura(as);
       dm.addElement(new OfertaAcademica(of.getIdOfertaAcademica(),of.getAsignatura()));
       
       if(lista.size()>0)
       {
           //System.out.println("Entro");
        for(int i=0;i<lista.size();i++)
        {
            OfertaAcademica o=new OfertaAcademica(lista.get(i).getIdOfertaAcademica(),lista.get(i).getAsignatura());
            dm.addElement(o);
        }
       }
       return dm;
    }
    
}
