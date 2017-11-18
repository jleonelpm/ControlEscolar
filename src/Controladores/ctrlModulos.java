/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Entidades.Carreras;
import Entidades.Modulos;



/**
 *
 * @author leonel
 */
public class ctrlModulos {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  
  
  public ctrlModulos(){
    db = new Mysql();
  }
  
  public int setModulo(Modulos modulo) throws SQLException, ClassNotFoundException {    
    sql = "{call set_modulo(?,?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);

    cs.setInt(1, modulo.getIdModulo());
    cs.setInt(2, modulo.getIdCarrera());                  
    cs.setString(3, modulo.getModulo()); 
    cs.setString(4, modulo.getClave());        
    cs.setString(5, modulo.getDescripcion());        
    cs.setInt(6, modulo.getHoras());            
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }
       
  public ArrayList<Modulos> getModulos(int idModulo, int idCarrera) throws SQLException, ClassNotFoundException {
    ArrayList<Modulos> modulos = new ArrayList<Modulos>();    
    Modulos modulo;
    ResultSet rs;    
    sql = "{call get_modulos(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, idModulo);
    cs.setInt(2, idCarrera);    
    rs = cs.executeQuery();
    while (rs.next()) {
      modulo = rellenaModulo(rs);
      modulos.add(modulo);
    }
    cs.close();
    db.Desconectar();
    return modulos;
  }
  
  public Object [][] getSubModulos(int idModulo, int idCarrera, int opcion) throws SQLException, ClassNotFoundException{
    Object[][] submodulos=null;      
    ResultSet rs;    
    sql = "{call get_submodulos(?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, idModulo);
    cs.setInt(2, idCarrera);    
    cs.setInt(3, opcion);        
    rs = cs.executeQuery();
    rs.last();                  
    int registros = rs.getRow(); //Cantidad de Registros o filas que aparecen en la tabla.
    if (registros > 0) {
        submodulos = new String[registros][5];           
        rs.first();
        int i = 0;    
        submodulos[i][0] = rs.getString("id_asignatura");
        submodulos[i][1] = rs.getString("carrera");
        submodulos[i][2] = rs.getString("modulo");
        submodulos[i][3] = rs.getString("submodulo");        
        submodulos[i][4] = rs.getString("cantidad_unidades");

        i++;
        while (i<registros) {
            rs.next();
            submodulos[i][0] = rs.getString("id_asignatura");
            submodulos[i][1] = rs.getString("carrera");
            submodulos[i][2] = rs.getString("modulo");
            submodulos[i][3] = rs.getString("submodulo");        
            submodulos[i][4] = rs.getString("cantidad_unidades");
            i++;
        }
    }
    cs.close();
    db.Desconectar();
    return submodulos;      
  }
  
  
    //Devuelve un Objeto DefaultTableMoldel con información de una Lista de arreglos
    //Esto es útil para almacenarlo en una tabla
    public DefaultTableModel getModulos(ArrayList<Modulos> lstModulos) throws SQLException {
        //Carreras carrera = new Carreras();
        Modulos modulo = new Modulos();         

        String[] columNames = {"id_modulo","Modulo","Clave","id_carrera","Carrera","Descripcion", "Horas"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lstModulos.size();i++) {
              modulo = lstModulos.get(i);
              modelo.addRow(new Object[] {
                modulo.getIdModulo(),
                modulo.getModulo(),                
                modulo.getClave(),                
                modulo.getIdCarrera(),
                modulo.getCarrera().getNombre(),                 
                modulo.getDescripcion(), 
                modulo.getHoras(),
              } );                
          }

          return modelo;
    }
    
    //Genera un Combo Model con información de Grupo, Carrera y Generación
    public DefaultComboBoxModel getComboModulos(ArrayList<Modulos> lista) throws SQLException {
        Modulos modulo = new Modulos();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        modulo.setIdModulo(0);
        modulo.setModulo("");
        modulo.setDescripcion("Selecciona un modulo");
        modelo.addElement(modulo);
        for (int i=0; i<lista.size();i++) {
          modulo = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new Modulos (modulo.getIdModulo(), modulo.getModulo(), modulo.getDescripcion()));
        }
        return modelo;
    }
    
  
  public int deleteModulo(int id_modulo) throws SQLException, ClassNotFoundException {    
    sql = "{call delete_modulo(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_modulo);
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;
  }

    
  private Modulos rellenaModulo(ResultSet resultSet) throws SQLException {
    Modulos modulo = new Modulos();
    Carreras carrera = new Carreras();    

    modulo.setIdModulo(resultSet.getInt("id_modulo"));

    //Carrera del Modulo
    modulo.setIdCarrera(resultSet.getInt("id_carrera"));
    if (resultSet.getString("carrera")!=null) {    
        carrera.setNombre(resultSet.getString("carrera"));
    }else{
        carrera.setNombre("");
    }
    modulo.setCarrera(carrera);            
    
    modulo.setModulo(resultSet.getString("modulo"));
    modulo.setClave(resultSet.getString("clave"));
    modulo.setDescripcion(resultSet.getString("descripcion"));    
    modulo.setHoras(resultSet.getInt("horas"));    
        
    return modulo;
   }
  
}