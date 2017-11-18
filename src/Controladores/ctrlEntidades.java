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
import Entidades.Entidades;

/**
 *
 * @author Last Develop
 */
public class ctrlEntidades {
    
       private Controladores.Mysql objmysql=new Controladores.Mysql();
    private PreparedStatement objcallstm;
    private ArrayList<Entidades> entidades;

    public ArrayList<Entidades> getListaEntidades()
    {
    this.entidades=new ArrayList<Entidades>();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_entidades()") ;                                                       
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    Entidades entidad=new Entidades();
                    entidad.setClave(rs.getString("id_entidad"));
                    entidad.setEntidad(rs.getString("entidad"));
                    
                    this.entidades.add(entidad);
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlEntidades.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlEntidades.class.getName()).log(Level.SEVERE, null, ex);
            }
   
   return this.entidades;
    }
    
    public DefaultComboBoxModel getModeloCombo(ArrayList<Entidades> lista)
    {
    DefaultComboBoxModel dm=new DefaultComboBoxModel();
        for(int i=0;i<lista.size();i++)
        {
        dm.addElement(lista.get(i));
        }
        return dm;
    }
    
    
}
