/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.TableModel;
import Entidades.*;
import javax.swing.table.DefaultTableModel;
import Controladores.PermisosTableModel;

/**
 *
 * @author leonel
 */
public class ctrlPermisosUsuario {

    Mysql db;
    String sql = "";
    PreparedStatement cs = null;

    public ctrlPermisosUsuario() {
        db = new Mysql();
    }

    public int setUsuario(Usuarios usuario) throws SQLException, ClassNotFoundException {
        sql = "{call set_usuario(?,?,?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, usuario.getId_usuario());
        cs.setString(2, usuario.getUsuario());
        cs.setString(3, usuario.getPassword());
        cs.setInt(4, usuario.getPersonal().getIdPersonal());
        cs.setString(5, usuario.getActivo());

        int r = cs.executeUpdate();
        cs.close();
        //db.Desconectar();
        return r;  //Retorna 0 (cero) si no fue realizada la operación
    }

    public boolean setPermisos(TableModel tabla, int id_usuario) throws SQLException, ClassNotFoundException {
        boolean band = true;
        db.Conectar();
        db.begin();
        for (int i = 0; i <= tabla.getRowCount() - 1; i++) {
            sql = "{call set_permisos_usuario(?,?,?)}";
            db.Conectar();
            cs = db.conexion.prepareStatement(sql);
            cs.setInt(1, id_usuario); //id_usuario   
            cs.setInt(2, Integer.parseInt(tabla.getValueAt(i, 0).toString())); //clave permiso
            Boolean activo = Boolean.parseBoolean(tabla.getValueAt(i, 2).toString()); 
            if (activo){
                cs.setString(3,"S"); //Activo o Inactivo                
            }else{
                cs.setString(3,"N"); //Activo o Inactivo                
            }
            

            int result = cs.executeUpdate();

            if (result <= 0) {
                band = false;
                break;
            }// fin de if (result > 0)     
            //}
        } //fin de ¿Guardar los cambios?


        if (band) {
            db.commit();
        } else {
            db.rollback();
        }
        db.Desconectar();
        return band;
    }

    public Object[][] getPermisos(int id_usuario) throws SQLException, ClassNotFoundException {
        Object[][] permisos = null;
        ResultSet rs;
        sql = "{call get_permisos_usuario(?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, id_usuario);
        cs.setInt(2, 0);
        cs.setInt(3, 0); //
        rs = cs.executeQuery();
        rs.last();
        int registros = rs.getRow(); //Cantidad de Registros o filas que aparecen en la tabla.
        if (registros > 0) {
            permisos = new String[registros][3];
            rs.first();
            int i = 0;

            permisos[i][0] = rs.getString("id_permiso");
            permisos[i][1] = rs.getString("descripcion");
            permisos[i][2] = rs.getString("permitido");
            i++;

            while (i < registros) {
                rs.next();
                permisos[i][0] = rs.getString("id_permiso");
                permisos[i][1] = rs.getString("descripcion");
                permisos[i][2] = rs.getString("permitido");
                i++;
            }
        }
        cs.close();
        db.Desconectar();
        return permisos;
    }

    //Retorna PermisosTableModel para generar checkbox
    public PermisosTableModel getPermisos(Object[][] lstPermisos) throws SQLException {

        String[] columNames = {"id_permiso", "Descripción", "permitido"};
        PermisosTableModel modelo = new PermisosTableModel();
        modelo.setColumnIdentifiers(columNames);

        for (int i = 0; i < lstPermisos.length; i++) {
            Boolean activado = false;
            //Es necesario pasar un valor booleano en la columna permitido
            //Para que el checkbox aparezca seleccionado o deseleccionado
            if ("S".equals(lstPermisos[i][2])) {
                activado = true;
            } else {
                activado = false;
            }

            System.out.println(lstPermisos[i][2]);

            modelo.addRow(new Object[]{
                        lstPermisos[i][0],
                        lstPermisos[i][1],
                        activado});

        }




        return modelo;
    }

    public boolean permitido(int id_usuario, int id_permiso) throws SQLException, ClassNotFoundException {
        //ArrayList<CicloEscolar> ciclos = new ArrayList<CicloEscolar>();    
        //CicloEscolar ciclo;
        ResultSet rs;
        sql = "{call get_permisos_usuario(?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, id_usuario);
        cs.setInt(2, id_permiso);
        cs.setInt(3, 1); //
        rs = cs.executeQuery();
        int result = 0;
        int i = 0;
        while (rs.next()) {
            result = rs.getInt("result");
            i++;
        }

        cs.close();
        db.Desconectar();

        if (result > 0) {
            return true;
        } else {
            return false;
        }

    }
}