/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Entidades.Planes;


/**
 *
 * @author leonel
 */
public class ctrlPlanes {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  
  
  public ctrlPlanes(){
    db = new Mysql();
  }
  
  public int setPlan(Planes plan) throws SQLException, ClassNotFoundException {    
    sql = "{call set_plan(?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, plan.getIdPlan());
    cs.setString(2, plan.getDescripcion()); 
    cs.setString(3, plan.getEstado());    
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }
  
  public ArrayList<Planes> getPlanes(int id_plan) throws SQLException, ClassNotFoundException {
    ArrayList<Planes> planes = new ArrayList<Planes>();    
    Planes plan;
    ResultSet rs;    
    sql = "{call get_planes(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_plan);
    rs = cs.executeQuery();
    while (rs.next()) {
      plan = rellenaPlan(rs);
      planes.add(plan);
    }
    cs.close();
    db.Desconectar();
    return planes;
  }
  
    public DefaultTableModel getPlanes(ArrayList<Planes> lstPlanes) throws SQLException {
        //Carreras carrera = new Carreras();
        Planes plan = new Planes();         

        String[] columNames = {"Clave","Descripcion"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lstPlanes.size();i++) {
              plan = lstPlanes.get(i);
              modelo.addRow(new Object[] {
                plan.getIdPlan(),                                 
                plan.getDescripcion() 
              } );                
          }

          return modelo;
    }
  
    public DefaultComboBoxModel getComboPlanes(ArrayList<Planes> lista) throws SQLException {
        Planes plan = new Planes();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        plan.setIdPlan(0);
        plan.setDescripcion("Selecciona un plan");
        modelo.addElement(plan);
        for (int i=0; i<lista.size();i++) {
          plan = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new Planes (plan.getIdPlan(), plan.getDescripcion()));
        }
        return modelo;
    }
    
    
  public int deletePlan(int id_plan) throws SQLException, ClassNotFoundException {    
    sql = "{call delete_plan(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_plan);
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }

    
  private Planes rellenaPlan(ResultSet resultSet) throws SQLException {
    Planes plan = new Planes();

    plan.setIdPlan(resultSet.getInt("id_plan"));
    plan.setDescripcion(resultSet.getString("descripcion"));
    plan.setEstado(resultSet.getString("estado"));
    
    return plan;
   }
  
}