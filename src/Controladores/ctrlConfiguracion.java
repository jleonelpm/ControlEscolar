/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidades.Configuracion;

/**
 *
 * @author Last Develop
 */
public class ctrlConfiguracion {
private Mysql objmysql=new Mysql();
private PreparedStatement objcallstm;
   
public String setConfiguracion(Configuracion conf) throws SQLException, ClassNotFoundException
    {
        String msj="";
        if(objmysql.Conectar())
        {
                   String sql="call set_configuracion(?,?,?,?,?)";
                   objcallstm= objmysql.conexion.prepareStatement(sql) ;
   
                   objcallstm.setInt(1, conf.getId_configuracion());                   
                    objcallstm.setString(2, conf.getSubdirectorenlace());
                    objcallstm.setString(3, conf.getDirectortecnico());
                    objcallstm.setInt(4,conf.getId_ciclo());
                    objcallstm.setString(5,conf.getActivo());
                     int filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                    if(filas>0)
                    {
                        msj="Éxito en la Operación";
                    }
                    else
                        msj="Error en la operación";
                        
                    
        }
        
            
            
        return msj;
    }
    
public ArrayList<Configuracion> getListaConfiguracion(int id_configuracion) throws SQLException, ClassNotFoundException
{
 ArrayList<Configuracion> listaConfiguracion=new ArrayList<Configuracion>();
 if(this.objmysql.Conectar())
 {
      String sql="call get_configuracion(?)";
      objcallstm= objmysql.conexion.prepareStatement(sql) ;
      objcallstm.setInt(1, id_configuracion);                   
      ResultSet rs= objcallstm.executeQuery();
      while(rs.next())
      {
          Configuracion cs=new Configuracion();
         cs.setId_configuracion( rs.getInt("id_configuracion"));
         cs.setDirectortecnico(rs.getString("directoroperativo"));
         cs.setSubdirectorenlace(rs.getString("subdirectorenlace"));
         cs.setActivo(rs.getString("activo"));
         cs.setId_ciclo(rs.getInt("id_ciclo"));
         cs.setCiclo(rs.getString("periodo"));
         listaConfiguracion.add(cs);
      }
 }
 else
     listaConfiguracion=null;
 return listaConfiguracion;
}
public DefaultTableModel getConfiguraciones(ArrayList<Configuracion> listaConfiguracion)    
{
    
    DefaultTableModel dm=new DefaultTableModel();
    String []columnas={"Clave","Subdirector de Enlace Operativo","Director Técnico","Perido","Activo"};
   
    dm.setColumnIdentifiers(columnas);
    if(listaConfiguracion.size()>0)
    {
        for(int i=0;i<listaConfiguracion.size();i++)
        {
        Configuracion ce=listaConfiguracion.get(i);
        dm.addRow(new Object[]{String.valueOf( ce.getId_configuracion()),ce.getSubdirectorenlace(),ce.getDirectortecnico(),ce.getCiclo(),ce.getActivo()});
        }
            
    }
    else
    {
        dm=null;
    }
    return dm;
    
}

public Configuracion getConfiguracion(int id_ciclo) throws SQLException, ClassNotFoundException
{
    Configuracion cs=new Configuracion();
  if(this.objmysql.Conectar())
  {
       String sql="call get_configuracionciclo(?)";
      objcallstm= objmysql.conexion.prepareStatement(sql) ;
      objcallstm.setInt(1, id_ciclo);                   
      ResultSet rs= objcallstm.executeQuery();
      while(rs.next())
      {
          
         cs.setId_configuracion( rs.getInt("id_configuracion"));
         cs.setDirectortecnico(rs.getString("directoroperativo"));
         cs.setSubdirectorenlace(rs.getString("subdirectorenlace"));
         cs.setActivo(rs.getString("activo"));
         cs.setId_ciclo(rs.getInt("id_ciclo"));
         
       
      }
  }
  else
  {
      cs=null;
  }
  return cs;
}
public String eliminarConfiguracion(int id_configuracion) throws SQLException, ClassNotFoundException
{
  String msj="";
        if(objmysql.Conectar())
        {
                   String sql="call delete_configuracion(?)";
                   objcallstm= objmysql.conexion.prepareStatement(sql) ;
   
                   objcallstm.setInt(1,id_configuracion);                   
                    
                     int filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                    if(filas>0)
                        msj="Éxito en la operación";
                    else
                        msj="Error en la operación";
                           
        }
  
  
  return msj;
}

    
}
