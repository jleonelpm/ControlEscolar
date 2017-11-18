/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import Entidades.NivelesAcademico;

/**
 *
 * @author Last Develop
 */
public class ctrlNivelesAcademico {
  private Controladores.Mysql objmysql=new Controladores.Mysql();
  private PreparedStatement objcallstm;  
  private ArrayList<NivelesAcademico> listaNivelesAcademico=null;
  public ArrayList<NivelesAcademico> getNivelesAcademico()
  {
   
      this.listaNivelesAcademico=new ArrayList<NivelesAcademico>();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_niveles_academico()") ;                                                       
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    NivelesAcademico nivelacademico=new NivelesAcademico();
                    nivelacademico.setIdNivel(rs.getInt("id_nivel"));
                    nivelacademico.setDescripcion(rs.getString("descripcion"));
                    this.listaNivelesAcademico.add(nivelacademico);
                    
                    
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlNivelesAcademico.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlTipoPlantel.class.getName()).log(Level.SEVERE, null, ex);
            }
      return listaNivelesAcademico;
  }
  
  public NivelesAcademico getNivelAcademico(ArrayList<NivelesAcademico> lista, NivelesAcademico objbuscar)
  {
      NivelesAcademico nivel=null;
      for(int i=0;i<lista.size();i++)
      {
       if(lista.get(i).getDescripcion().equals(objbuscar.getDescripcion()))
       {
        nivel=lista.get(i);
        i=lista.size();
       }
      }
      
   return nivel; 
  }
  
  
  public DefaultComboBoxModel getComboModelo(ArrayList<NivelesAcademico> lista)
  {
    DefaultComboBoxModel modelo=new DefaultComboBoxModel();
    for(int i=0;i<lista.size();i++)
    {
     modelo.addElement(lista.get(i).getDescripcion());
    }
    return modelo;
  }
}
