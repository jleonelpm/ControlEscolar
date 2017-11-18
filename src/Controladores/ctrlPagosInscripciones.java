/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.PagosInscripcion;
import java.sql.*;
import java.sql.SQLException;

/**
 *
 * @author Last Develop
 */
public class ctrlPagosInscripciones {
    
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;

    public ctrlPagosInscripciones() {
        this.db = new Mysql();
    }
  
 
  
  public boolean setPagoInscripcion(PagosInscripcion pagoinscripcion) throws SQLException, ClassNotFoundException
  {
      boolean band=true;
      sql = "{call set_pago_inscripcion(?,?,?,?,?)} ";
       db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1,pagoinscripcion.getId_pago_inscripcion());
        cs.setInt(2, pagoinscripcion.getId_ciclo());
        cs.setInt(3,pagoinscripcion.getId_alumno());    
        cs.setInt(4,pagoinscripcion.getId_usuario());
        cs.setString(5, pagoinscripcion.getPagado());
        int r=cs.executeUpdate();
                if(r>0)
                    band=true;
                else
                    band=false;
       db.Desconectar();
      
      return band;
  }
}
