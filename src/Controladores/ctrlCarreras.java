/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import Entidades.Carreras;

/**
 *
 * @author leonel
 */
public class ctrlCarreras {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  public ctrlCarreras(){
    db = new Mysql();
  }
  
  public int setCarrera(Carreras carrera) throws SQLException, ClassNotFoundException {    
    sql = "{call set_carrera(?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, carrera.getIdCarrera());
    cs.setString(2, carrera.getClave());
    cs.setString(3, carrera.getNombre()); 
    cs.setString(4, carrera.getEstado());
     cs.setString(5, carrera.getNooficio());
    int r = cs.executeUpdate();
    
    cs.close();    
    db.Desconectar();
    return r;
  }
  
  public int deleteCarrera(int id_carrera) throws SQLException, ClassNotFoundException {    
    sql = "{call delete_carrera(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_carrera);
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }
  
  public ArrayList<Carreras> getCarreras(int id_carrera) throws SQLException, ClassNotFoundException {
      ArrayList<Carreras> carreras = new ArrayList<Carreras>();    
      Carreras carrera;
      ResultSet rs;    

    
      sql = "{call get_carreras(?)}";
      db.Conectar();
      cs = db.conexion.prepareStatement(sql);
      cs.setInt(1, id_carrera);
      rs = cs.executeQuery();
      while (rs.next()) {
        carrera = rellenaCarrera(rs);
        carreras.add(carrera);
      }
        cs.close();
        db.Desconectar();
      
            return carreras;
   }
  
  
  
  
  
    public DefaultTableModel getCarreras(ArrayList<Carreras> lista) throws SQLException {
        Carreras carrera = new Carreras();         

        String[] columNames = {"ID","Clave","Nombre","No Oficio "};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lista.size();i++) {
              carrera = lista.get(i);
              modelo.addRow(new Object[] {
                carrera.getIdCarrera(),                                 
                carrera.getClave(), 
                carrera.getNombre(), 
                carrera.getNooficio()
              } );
          }

          return modelo;

    }

    public DefaultComboBoxModel getComboCarreras(ArrayList<Carreras> lista) throws SQLException {
        Carreras carrera = new Carreras();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        carrera.setIdCarrera(0);
        carrera.setNombre("Selecciona una carrera");
        modelo.addElement(carrera);
        for (int i=0; i<lista.size();i++) {
          carrera = lista.get(i);
          
          modelo.addElement(new Carreras (carrera.getIdCarrera(), carrera.getNombre()));
          
        }
        
        return modelo;
    }
   
  private Carreras rellenaCarrera(ResultSet resultSet) throws SQLException {
    Carreras carrera = new Carreras();
    carrera.setIdCarrera(resultSet.getInt("id_carrera"));
    carrera.setClave(resultSet.getString("clave"));
    carrera.setNombre(resultSet.getString("nombre"));
    carrera.setEstado(resultSet.getString("status"));        
    carrera.setNooficio(resultSet.getString("num_oficio"));
    return carrera;
   }
  /*ESTE METODO SIVER PARA DEVOLVER UNA CARRERA EN REPORTE*/
  public Carreras getCarreraReporte(int id_carrera) throws SQLException, ClassNotFoundException {
     Carreras carrera = new Carreras();    
      
      ResultSet rs;    

    
      sql = "{call get_carreras(?)}";
      db.Conectar();
      cs = db.conexion.prepareStatement(sql);
      cs.setInt(1, id_carrera);
      rs = cs.executeQuery();
      while (rs.next()) {
        carrera = rellenaCarrera(rs);
        
      }
        cs.close();
        db.Desconectar();
      
            return carrera;
   }
}