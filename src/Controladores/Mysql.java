/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.mysql.jdbc.Connection;
import java.sql.*;
import java.sql.SQLException;
import Utilerias.Configuracion;

/**
 *
 * @author Last Develop
 */
public class Mysql {
    
   private String bd = "dbcontrol_cbta87";
    //private String bd = "dbcontrol_beta";
  // private String usuario = "root";
   //private String password = "root";
  private String usuario = "cbta_user";
  private String password = "thechange6818";
   private String url;
   private String host;
   private String puerto;
    
  public Connection conexion=null;
  
  public boolean Conectar() throws SQLException, ClassNotFoundException
  {
    Configuracion conf = new Configuracion();     
     
    boolean estado=false;
         
    host = conf.getPropiedad("servidor.host");
    puerto = conf.getPropiedad("servidor.puerto");

    url = "jdbc:mysql://" + host + ":"+ puerto +"/"+bd;

    Class.forName("com.mysql.jdbc.Driver");
    conexion=(Connection) DriverManager.getConnection(url,usuario,password);
    if(conexion!=null) {
        estado=true;
    }else{
        estado=true;
    }

    return estado;
 
  }//fin del método conectar
  
  
  public boolean Desconectar() throws SQLException
  {
      conexion.close();
   if(conexion==null)
       return true;
   else
       return false;
  }

  public void begin() throws SQLException{
      if (conexion.getAutoCommit()) {
        conexion.setAutoCommit(false);
      }
  }
  
  public void commit() throws SQLException {
    if (!conexion.getAutoCommit()) {      
        conexion.commit();
        conexion.setAutoCommit(true);
    }
  }

  public void rollback() throws SQLException {
    if (!conexion.getAutoCommit()) {            
        conexion.rollback();
        conexion.setAutoCommit(true);
    }
  }
  
}
