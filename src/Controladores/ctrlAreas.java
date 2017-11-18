/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import Entidades.Areas;

/**
 *
 * @author leonel
 */
public class ctrlAreas {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  public ctrlAreas(){
    db = new Mysql();
    
  }
   
  public ArrayList<Areas> getAreas(int id_area) throws SQLException, ClassNotFoundException {
    ArrayList<Areas> areas = new ArrayList<Areas>();    
    Areas area;
    ResultSet rs;    
    db.Conectar();
    sql = "{call get_Areas(?)}";
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_area);
    rs = cs.executeQuery();
    while (rs.next()) {
      area = rellenaArea(rs);
      areas.add(area);
    }
    
    cs.close();
    db.Desconectar();
    return areas;
  }
  
    public DefaultComboBoxModel getComboAreas(ArrayList<Areas> lista) throws SQLException {
        Areas area = new Areas();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        area.setIdArea(0);
        area.setDescripcion("Selecciona una area");
        modelo.addElement(area);
        for (int i=0; i<lista.size();i++) {
          area = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new Areas (area.getIdArea(), area.getDescripcion()));
        }
        return modelo;
    }
        
  private Areas rellenaArea(ResultSet resultSet) throws SQLException {
    Areas area = new Areas();
    area.setIdArea(resultSet.getInt("id_area"));
    area.setDescripcion(resultSet.getString("descripcion"));
    return area;
   }
  
}