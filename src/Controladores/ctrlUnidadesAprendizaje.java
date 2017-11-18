/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import Entidades.Asignaturas;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidades.Modulos;
import Entidades.UnidadAprendizaje;



/**
 *
 * @author leonel
 */
public class ctrlUnidadesAprendizaje {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  
  
  public ctrlUnidadesAprendizaje(){
    db = new Mysql();
  }
  
  public int setUnidadAprendizaje(UnidadAprendizaje unidad) throws SQLException, ClassNotFoundException {    
    sql = "{call set_unidad_aprendizaje(?,?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);

    cs.setInt(1, unidad.getIdUnidadAprendizaje());
    cs.setInt(2, unidad.getIdSubmodulo());                  
    cs.setInt(3, unidad.getIdModulo()); 
    cs.setString(4, unidad.getClave());        
    cs.setString(5, unidad.getDescripcion());        
    cs.setFloat(6, unidad.getFactorPonderacion());            
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }
       
  public ArrayList<UnidadAprendizaje> getUnidadesAprendizaje(int idUnidadAprendizaje, int idSubmodulo, int idModulo, int opcion) throws SQLException, ClassNotFoundException {
    ArrayList<UnidadAprendizaje> unidades = new ArrayList<UnidadAprendizaje>();    
    UnidadAprendizaje unidad;
    ResultSet rs;    
    sql = "{call get_unidades_aprendizaje(?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, idUnidadAprendizaje);
    cs.setInt(2, idSubmodulo);    
    cs.setInt(3, idModulo);    
    cs.setInt(4, opcion);        
    rs = cs.executeQuery();
    while (rs.next()) {
      unidad = rellenaUnidadAprendizaje(rs);
      unidades.add(unidad);
    }
    cs.close();
    db.Desconectar();
    return unidades;
  }
  
  
  
    //Devuelve un Objeto DefaultTableMoldel con información de una Lista de arreglos
    //Esto es útil para almacenarlo en una tabla
    public DefaultTableModel getUnidadesAprendizaje(ArrayList<UnidadAprendizaje> lstUnidadesAprendizaje) throws SQLException {
        //Carreras carrera = new Carreras();
        UnidadAprendizaje unidad = new UnidadAprendizaje();         

        String[] columNames = {"id_unidad_aprendizaje","Clave","Descripcion", "F. Ponderacion"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lstUnidadesAprendizaje.size();i++) {
              unidad = lstUnidadesAprendizaje.get(i);
              modelo.addRow(new Object[] {
                unidad.getIdUnidadAprendizaje(),
                unidad.getClave(),                
                unidad.getDescripcion(), 
                unidad.getFactorPonderacion(),
              } );                
          }

          return modelo;
    }
    
  public int deleteUnidadAprendizaje(int id_unidad_aprendizaje) throws SQLException, ClassNotFoundException {    
    sql = "{call delete_unidad_aprendizaje(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_unidad_aprendizaje);
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;
  }

    
  private UnidadAprendizaje rellenaUnidadAprendizaje(ResultSet resultSet) throws SQLException {
    UnidadAprendizaje unidad = new UnidadAprendizaje();
    Asignaturas submodulo = new Asignaturas();
    Modulos modulo = new Modulos();

    unidad.setIdUnidadAprendizaje(resultSet.getInt("id_unidad_aprendizaje"));

    //Submódulo de la UA
    unidad.setIdSubmodulo(resultSet.getInt("id_submodulo"));
    if (resultSet.getString("submodulo")!=null) {    
        submodulo.setNombre(resultSet.getString("submodulo"));
    }else{
        submodulo.setNombre("");
    }
    unidad.setSubmodulo(submodulo);            
    
    //Módulo de la UA
    unidad.setIdModulo(resultSet.getInt("id_modulo"));
    if (resultSet.getString("modulo")!=null) {    
        submodulo.setNombre(resultSet.getString("modulo"));
    }else{
        submodulo.setNombre("");
    }
    unidad.setModulo(modulo);            
    
    
    unidad.setClave(resultSet.getString("clave"));
    unidad.setDescripcion(resultSet.getString("descripcion"));    
    unidad.setFactorPonderacion(resultSet.getFloat("factor_ponderacion"));    
        
    return unidad;
   }
  
}