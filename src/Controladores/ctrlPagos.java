/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Entidades.Alumnos;
import Entidades.DetallePagos;
import Entidades.Pagos;
import Entidades.Usuarios;


/**
 *
 * @author leonel
 */
public class ctrlPagos {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  public ctrlPagos(){
    db = new Mysql();
  }
  
  public boolean setPago(Pagos p, TableModel tabla) throws SQLException, ClassNotFoundException {    
    java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");    
    sql = "{call set_pago(?,?,?,?,?,?,?)} ";
    boolean band = true;        
    
    db.Conectar();
    db.begin(); //Iniciamos la transacción
    
    //Encabezado del pago
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, p.getIdPago());
    cs.setString(2, formato.format(p.getFecha()));
    cs.setString(3, p.getObservaciones());    
    cs.setInt(4, p.getIdAlumno());
    cs.setInt(5, p.getIdUsuario());
    cs.setFloat(6, p.getImporteTotal());
    
    ctrlCicloEscolar ciclo = new ctrlCicloEscolar();
   
    cs.setInt(7, ciclo.getCicloActivo().getIdCiclo());
    
    //cs.setString("in_status", p.getStatus());        
    
    ResultSet rs = cs.executeQuery();
    
    int id_pago = -1;
    
    if (rs.next()) {
        //El ultimo registro agregado, fue resuelto modificando el procedimiento almacenado
        id_pago= rs.getInt(1);
    }

    
    cs.close();

    if (id_pago > -1 ) {
        //Detalles del Pago
        for (int i=0; i<=tabla.getRowCount()-1; i++) {
            Object valor;
            valor = tabla.getValueAt(i, 0);
            if (valor != null) {
                //ctrlDetallePagos  = new ctrlDetallePagos();          
                DetallePagos partida = new DetallePagos(); 
                partida.setIdPago(id_pago);
                partida.setIdCuenta(tabla.getValueAt(i, 0).toString());
                partida.setImporte(Float.parseFloat(tabla.getValueAt(i, 2).toString()));
                partida.setCantidad(Short.parseShort(tabla.getValueAt(i, 3).toString()));
                int result = this.guardarDetallePago(partida);
                if (result <= 0) {
                    band = false;
                    break;
                }// fin de if (result > 0)     
            //}
            } //fin de ¿Guardar los cambios?
        }  
        
    }else{
        band = false;
    }
    
    if (band){
        db.commit();
    }else{
        db.rollback();
    }
    db.Desconectar();        
    return band;    
    
  }
   
  public int cancelarPago(int id_pago, String observaciones) throws SQLException, ClassNotFoundException {    
    sql = "{call cancelar_pago(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);

    cs.setInt(1, id_pago);
    cs.setString(2, observaciones);    
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }

  
  public ArrayList<Pagos> getPagos(int id_pago) throws SQLException, ClassNotFoundException {
    ArrayList<Pagos> pagos = new ArrayList<Pagos>();    
    Pagos pago;
    ResultSet rs;    
    sql = "{call get_pagos(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_pago);
    rs = cs.executeQuery();
    while (rs.next()) {
      pago = rellenaPago(rs);
      pagos.add(pago);
    }
    cs.close();
    db.Desconectar();
    return pagos;
  }
  
    public DefaultTableModel getPagos(ArrayList<Pagos> lstPagos) throws SQLException {
        Pagos pago = new Pagos();
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd-MM-yyyy");

        String[] columNames = {"id_pago","Fecha","id_alumno","Alumno","Importe","id_personal","Realizado","status"};  
        
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          
          for (int i=0; i<lstPagos.size();i++) {
              pago = lstPagos.get(i);
              String status;
              if ( "A".equals(pago.getStatus()))
                  status = "Activo";
              else
                  status = "Cancelado";
              
              modelo.addRow(new Object[] {
                pago.getIdPago(), 
                formato.format(pago.getFecha()), 
                //pago.getObservaciones(),
                pago.getIdAlumno(),
                pago.getAlumno().getNombre(),
                pago.getImporteTotal(),
                pago.getIdUsuario(),
                pago.getUsuario().getUsuario(),
                status
              });
          }

          return modelo;

    }
    
   
    public int deletPago(int id_pago) throws SQLException, ClassNotFoundException{
    sql = "{call delete_Pago(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_pago);
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;      
    }


  private Pagos rellenaPago(ResultSet resultSet) throws SQLException {
    Pagos pago = new Pagos();
    Alumnos alumno = new Alumnos();
    Usuarios usuario = new Usuarios();
    pago.setIdPago(resultSet.getInt("id_pago"));
    pago.setFecha(resultSet.getString("fecha"));
    pago.setObservaciones(resultSet.getString("observaciones"));
    
    pago.setIdAlumno(resultSet.getInt("id_alumno"));
    pago.setAlumno(alumno);
    alumno.setNombre(resultSet.getString("alumno"));
    
    pago.setIdUsuario(resultSet.getInt("id_usuario"));    
    pago.setUsuario(usuario);
    usuario.setUsuario(resultSet.getString("usuario"));
    
    pago.setImporteTotal(resultSet.getFloat("importe_total"));
    pago.setStatus(resultSet.getString("status"));
    return pago;
   }
  
  
    //  Métodos relacionados con el detalle de los pagos
  
  public int guardarDetallePago(DetallePagos dp) throws SQLException, ClassNotFoundException {    
    sql = "{call set_detalle_pago(?,?,?,?)}";
    //db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, dp.getIdPago());
    cs.setString(2, dp.getIdCuenta());    
    cs.setShort(3, dp.getCantidad());
    cs.setFloat(4, dp.getImporte());
    int r = cs.executeUpdate();
    cs.close(); 
    //db.Desconectar();
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

        String columNames[] = {"Clave", "Concepto","Importe","Cantidad","Subtotal"};
               
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