/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import Entidades.Puestos;

/**
 *
 * @author Last Develop
 */
public class ctrlPuestos {
  private Controladores.Mysql objmysql=new Controladores.Mysql();
  private PreparedStatement objcallstm;  
  private ArrayList<Puestos> listapuestos=null;
  
  public int setPuestos(Puestos puesto)
  {
        int filas=0;
   if(puesto!=null)
   {
            try {
                if(objmysql.Conectar())
                {
                   objcallstm=objmysql.conexion.prepareStatement("CALL set_puestos(?,?)");
                   objcallstm.setInt(1, puesto.getIdPuesto());
                    objcallstm.setString(2, puesto.getDescripcion());
                    
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPuestos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ctrlPuestos.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    
   }
   return filas;
  }
  
  public int deletePuesto(Puestos puesto)
  {
   int filas=0;
   if(puesto!=null)
   {
            try {
                if(objmysql.Conectar())
                {
                   objcallstm=objmysql.conexion.prepareStatement("CALL delete_puestos(?)");
                   objcallstm.setInt(1, puesto.getIdPuesto());
                    
                    
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPuestos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ctrlPuestos.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    
   }
   return filas;
  }
  
  public ArrayList<Puestos> getPuestos()
  {
   
      this.listapuestos=new ArrayList<Puestos>();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_puestos()") ;                                                       
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    Puestos puesto=new Puestos();
                    puesto.setIdPuesto(rs.getInt("id_puesto"));
                    puesto.setDescripcion(rs.getString("descripcion"));
                    this.listapuestos.add(puesto);
                                     
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlPuestos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlPuestos.class.getName()).log(Level.SEVERE, null, ex);
            }
      return this.listapuestos;
  }
  
  public Object[][] getPuestos(ArrayList<Puestos> lista)
  {
   
   Object[][] data = new String[lista.size()][2];  
   for(int i=0;i<lista.size();i++)
   {
    data[i][0]=String.valueOf(lista.get(i).getIdPuesto());
    data[i][1]=lista.get(i).getDescripcion();
   }
   
   return data;
  }
  
  public Puestos getPuestos(ArrayList<Puestos> lista,Puestos objbuscar)
  {
    Puestos puesto=null;
      for(int i=0;i<lista.size();i++)
      {
       if(lista.get(i).getDescripcion().equals(objbuscar.getDescripcion()))
       {
        puesto=lista.get(i);
        i=lista.size();
       }
      }
      
   return puesto; 
  }
  
  
  
  
  
  
}
