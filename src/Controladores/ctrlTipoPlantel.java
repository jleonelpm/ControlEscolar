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
import javax.swing.DefaultComboBoxModel;
import Entidades.TipoPlantel;

/**
 *
 * @author Last Develop
 */
public class ctrlTipoPlantel {

    private Controladores.Mysql objmysql=new Controladores.Mysql();
    private PreparedStatement objcallstm;
    private ArrayList<TipoPlantel> listaTipoPlantel;
    public int setTipoPlantel(TipoPlantel tipoplantel)
    {
      int filas=0;
   if(tipoplantel!=null)
   {
       
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= objmysql.conexion.prepareStatement("call set_tipoplantel(?,?,?,?)") ;
                   objcallstm.setString(1, tipoplantel.getClave());
                   objcallstm.setString(2,tipoplantel.getPlantel());
                   objcallstm.setString(3,tipoplantel.getUnidad_administrativa());
                   objcallstm.setInt(4,tipoplantel.getClave_unidad());
                       

                   filas=objcallstm.executeUpdate();
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlTipoPlantel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlTipoPlantel.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    
        }
   
    return filas;
  }
  public ArrayList<TipoPlantel> getTipoPlantel()
  {
   this.listaTipoPlantel=new ArrayList<TipoPlantel>();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= objmysql.conexion.prepareStatement("call get_tipo_plantel()") ;                                                       
                   ResultSet rs=objcallstm.executeQuery();
                    while(rs.next())
                   {
                   TipoPlantel tipo= this.RellenarDatos(rs) ;
                   this.listaTipoPlantel.add(tipo);
                           
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlTipoPlantel.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlTipoPlantel.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   return this.listaTipoPlantel;
  }
  
  public TipoPlantel RellenarDatos(ResultSet rs) throws SQLException
  {
     
                    TipoPlantel tipo=new TipoPlantel();
                    tipo.setClave(rs.getString("clave"));
                    tipo.setPlantel(rs.getString("plantel"));
                    tipo.setUnidad_administrativa(rs.getString("unidad_administrativa"));
                    tipo.setClave_unidad(rs.getShort("clave_unidad"));
                    tipo.setAbreviatura(rs.getString("abreviatura"));
                    return tipo;
  }
  
public DefaultComboBoxModel getModeloCombo(ArrayList<TipoPlantel> lista)
{
 
 DefaultComboBoxModel dm=new DefaultComboBoxModel();
   
 for(int i=0;i<lista.size();i++)
 {
   dm.addElement(lista.get(i));
 }
 return dm;
}


    
  
}
