/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import Entidades.DetallePagos;

/**
 *
 * @author leonel
 */
public class ctrlDetallePagos {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  public ctrlDetallePagos(){
    db = new Mysql();
  }
  
  public int guardarDetallePago(DetallePagos dp) throws SQLException, ClassNotFoundException {    
    sql = "{call set_pago(?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, dp.getIdPago());
    cs.setString(2, dp.getIdCuenta());    
    cs.setInt(3, dp.getCantidad());
    cs.setFloat(4, dp.getImporte());
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;
  }
 
  public ArrayList<DetallePagos> getDetallePagos(int id_pago) throws SQLException, ClassNotFoundException {
    ArrayList<DetallePagos> detalles = new ArrayList<DetallePagos>();    
    DetallePagos detalle;
    ResultSet rs;    
    sql = "{call get_pagos(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_pago);
    rs = cs.executeQuery();
    while (rs.next()) {
      detalle = rellenaDetallePago(rs);
      detalles.add(detalle);
    }
    cs.close();
    db.Desconectar();
    
    
    return detalles;
  }
  
    public DefaultTableModel getDetallePagos(ArrayList<DetallePagos> lstDetallePagos) throws SQLException {
        DetallePagos detalle = new DetallePagos();

        String[] columNames = {"Clave","Periodo","Inicio","Fin","Activo"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          
          for (int i=0; i<lstDetallePagos.size();i++) {
              detalle = lstDetallePagos.get(i);
              modelo.addRow(new Object[] {
                detalle.getIdPago(), 
                detalle.getIdCuenta(),                 
                detalle.getCantidad(),
                detalle.getImporte()});
              //System.out.println(Pago.getFechaInicial());
              //System.out.println(formato.format(Pago.getFechaInicial()));              
          }

          return modelo;

    }
       
  private DetallePagos rellenaDetallePago(ResultSet resultSet) throws SQLException {
    DetallePagos detalle = new DetallePagos();
    detalle.setIdPago(resultSet.getInt("id_pago"));
    detalle.setIdCuenta(resultSet.getString("id_cuenta"));
    detalle.setCantidad(resultSet.getShort("cantidad"));    
    detalle.setImporte(resultSet.getFloat("importe"));
    return detalle;
   }
  
}