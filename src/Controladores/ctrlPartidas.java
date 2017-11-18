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
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import Entidades.Partidas;

/**
 *
 * @author Last Develop
 */
public class ctrlPartidas {
     private Controladores.Mysql objmysql=new Controladores.Mysql();
  private PreparedStatement objcallstm;  
  private ArrayList<Partidas> listaPartidas=null;
  
  
   public int  setPartidas(Partidas partida,int op) throws SQLException, ClassNotFoundException
  {
   int filas=0;
   if(partida!=null)
   {
           
                if(objmysql.Conectar())
                {
                   String sql="call set_partidas(?,?,?,?,?)";
                    objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;
                    System.out.println(partida.getIdCuenta());
                    
                   objcallstm.setString(1,partida.getIdCuenta());
                   objcallstm.setString(2,partida.getDescripcion());
                   
                   
                   objcallstm.setFloat(3,partida.getImporte());
                   
                   objcallstm.setString(4,partida.getIdGrupo());
                   objcallstm.setInt(5,op);
                   
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
            
      
    
   }
   return filas;
  }
  
   
   public int deletePartidas(Partidas partida)
   {
    int filas=0;
   if(partida!=null)
   {
            try {
                if(objmysql.Conectar())
                {
                   String sql="call delete_partidas(?)";
                    objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;
                   objcallstm.setString(1,partida.getIdCuenta());
                   
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPartidas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                
                Logger.getLogger(ctrlPartidas.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    
   }
   return filas;
   }
   public ArrayList<Partidas> getGruposPartidas(String id_grupo)
   {
       ArrayList<Partidas> grupos=new ArrayList<Partidas>();
    try {
                if(objmysql.Conectar())
                {
                   
                   String sql="call get_grupos_partidas(?)";
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;                                                       
                  
                   objcallstm.setString(1, id_grupo);
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    Partidas partida=new Partidas();
                    partida.setIdCuenta(rs.getString("id_cuenta"));
                    partida.setDescripcion(rs.getString("descripcion"));
                    partida.setIdGrupo(rs.getString("id_grupo"));
                    partida.setImporte(rs.getFloat("importe"));
                    grupos.add(partida);
                    
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlPartidas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlPartidas.class.getName()).log(Level.SEVERE, null, ex);
            }
      return grupos;
     
         
   }

   
   
   
   public DefaultTreeModel getGrupos(ArrayList<Partidas> lista)
   {
       Partidas ra=new Partidas();
       ra.setIdCuenta("0");
       ra.setDescripcion("Lista Partidas");
       DefaultMutableTreeNode raiz=new DefaultMutableTreeNode(ra);
       DefaultTreeModel arbol=new DefaultTreeModel(raiz);
       ArrayList<Partidas> subpartida=null;
       for(int i=0;i<lista.size();i++)
       {
         subpartida=this.getGruposPartidas(lista.get(i).getIdCuenta());
         
         DefaultMutableTreeNode padre=new DefaultMutableTreeNode(lista.get(i));
         arbol.insertNodeInto(padre,raiz, i);
         for(int j=0;j<subpartida.size();j++)
        {
            DefaultMutableTreeNode nodo=new DefaultMutableTreeNode(subpartida.get(j));
           
           
            arbol.insertNodeInto(nodo, padre, j);
        }
       
       }
       return arbol;
       
   }
   
   public DefaultComboBoxModel getModeloCombo(ArrayList<Partidas> lista)
   {
       DefaultComboBoxModel dm=new DefaultComboBoxModel();
       Partidas aux=new Partidas();
       aux.setIdCuenta("0");
       aux.setDescripcion("Ninguna");
       aux.setImporte(0);
       dm.addElement(aux);
    for(int i=0;i<lista.size();i++)   
    {
    dm.addElement(lista.get(i));
    }
     return dm;  
   }
}
