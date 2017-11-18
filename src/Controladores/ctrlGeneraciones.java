/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import Entidades.Generaciones;

/**
 *
 * @author leonel
 */
public class ctrlGeneraciones {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  public ctrlGeneraciones(){
    db = new Mysql();
  }
  
  public int setGeneracion(Generaciones generacion) throws SQLException, ClassNotFoundException {    
    sql = "{call set_carrera(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, generacion.getIdGeneracion());
    cs.setString(2, generacion.getNombre()); 
    int r = cs.executeUpdate();
    
    cs.close();    
    db.Desconectar();
    return r;
  }
  
  public ArrayList<Generaciones> getGeneraciones(int id_generacion) throws SQLException, ClassNotFoundException {
      ArrayList<Generaciones> generaciones = new ArrayList<Generaciones>();    
      Generaciones generacion;
      ResultSet rs;    

    
      sql = "{call get_generaciones(?)}";
      db.Conectar();
      cs = db.conexion.prepareStatement(sql);
      cs.setInt(1, id_generacion);
      rs = cs.executeQuery();
      while (rs.next()) {
        generacion = rellenaGeneracion(rs);
        generaciones.add(generacion);
      }
        cs.close();
        db.Desconectar();
      
            return generaciones;
   }
  
  
    public DefaultTableModel getGeneraciones(ArrayList<Generaciones> lista) throws SQLException {
        Generaciones generacion = new Generaciones();         

        String[] columNames = {"ID","Nombre"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lista.size();i++) {
              generacion = lista.get(i);
              modelo.addRow(new Object[] {
                generacion.getIdGeneracion(),                                 
                generacion.getNombre() 
              } );
          }

          return modelo;

    }

    public DefaultComboBoxModel getComboGeneraciones(ArrayList<Generaciones> lista) throws SQLException {
        Generaciones generacion = new Generaciones();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        generacion.setIdGeneracion(0);
        generacion.setNombre("Selecciona una generacion");
        modelo.addElement(generacion);
        for (int i=0; i<lista.size();i++) {
          generacion = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new Generaciones (generacion.getIdGeneracion(), generacion.getNombre()));
        }
        return modelo;
    }
   
  private Generaciones rellenaGeneracion(ResultSet resultSet) throws SQLException {
    Generaciones generacion = new Generaciones();
    generacion.setIdGeneracion(resultSet.getInt("id_generacion"));
    generacion.setNombre(resultSet.getString("nombre"));
    generacion.setStatus(resultSet.getString("status"));        
    return generacion;
   }
  
  
  /*MÉTODO QUE SIRVE PARA OBTNER LA GENRACION DEL REPORTE REDI*/
  
  public Generaciones getGeneracionReporte(int id_grupo_ciclo) throws SQLException, ClassNotFoundException
  {
   Generaciones generacion =new Generaciones();
   if(this.db.Conectar())
   {
       String sql1="{call get_generacionreporte(?)}";
        this.cs=db.conexion.prepareStatement(sql1);
        cs.setInt(1, id_grupo_ciclo);
        ResultSet rs=cs.executeQuery();
        while(rs.next())
        {
          generacion=this.rellenaGeneracion(rs);
        }
         db.Desconectar();       
   }
   else
       generacion=null;
   return generacion;
  }
  
}