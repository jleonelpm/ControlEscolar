/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Entidades.Personal;
import Entidades.Puestos;
import Entidades.Usuarios;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Last Develop
 */
public class ctrlUsuarios {
    private Mysql objmysql=new Mysql();
    private PreparedStatement objcallstm;
    private Personal personalautorizado=null;
    private Usuarios usuario=null;
    public ctrlUsuarios() {
    }
    
 public boolean getAutentificar(Usuarios usuario) throws SQLException, ClassNotFoundException   
 {
   boolean autorizado=false;
   
   if(objmysql.Conectar())
   {
       String sql="{CALL get_validar(?,?)}";
       objcallstm=objmysql.conexion.prepareStatement(sql);
       objcallstm.setString(1, usuario.getUsuario());
       objcallstm.setString(2, usuario.getPassword());
       ResultSet rs=objcallstm.executeQuery();
       while(rs.next())
       {
        autorizado=true;
        Personal personal=new Personal();
        personal.setNombre(rs.getString("nombre"));
        personal.setApePaterno(rs.getString("ape_paterno"));
        personal.setApeMaterno(rs.getString("ape_materno"));
        personal.setIdPersonal(rs.getInt("id_personal"));
        this.personalautorizado=personal;
        
        
        Usuarios user = new Usuarios();
        user.setId_usuario(rs.getInt("id_usuario"));
        user.setUsuario(rs.getString("login"));
   
        //System.out.println("El id del usuario es:" + user.getId_usuario());
        
        this.usuario = user;
        
       }
       objmysql.Conectar();
       
   }
   
   return autorizado;
 }
 
 public Personal getPersonalAutorizado()
 {
  
  return this.personalautorizado;
 }
 
 public Usuarios getDatosUsuario()
 {
     return this.usuario;
}

 public int setUsuario(Usuarios usuario) throws SQLException, ClassNotFoundException {    
    String sql = "{call set_usuario(?,?,?,?,?)}";
    objmysql.Conectar();
    objcallstm = objmysql.conexion.prepareStatement(sql);
    objcallstm.setInt(1, usuario.getId_usuario());
    objcallstm.setString(2, usuario.getUsuario()); 
    objcallstm.setString(3, usuario.getPassword());    
    objcallstm.setInt(4, usuario.getPersonal().getIdPersonal());    
    objcallstm.setString(5, usuario.getActivo());        
    int r = objcallstm.executeUpdate();
    objcallstm.close();
    objmysql.Desconectar();
    return r;
  }
  
  public ArrayList<Usuarios> getUsuarios(int id_usuario) throws SQLException, ClassNotFoundException {
    ArrayList<Usuarios> listaUsuarios = new ArrayList<Usuarios>();    
    Usuarios usuario;
    ResultSet rs;    
    String sql = "{call get_usuarios(?)}";
    objmysql.Conectar();
    objcallstm = objmysql.conexion.prepareStatement(sql);
    objcallstm.setInt(1, id_usuario);
    rs = objcallstm.executeQuery();
    while (rs.next()) {
      usuario = rellenaUsuario(rs);
      listaUsuarios.add(usuario);
    }
    objcallstm.close();
    objmysql.Desconectar();
    return listaUsuarios;
  }
  
    public DefaultTableModel getUsuarios(ArrayList<Usuarios> lstUsuarios) throws SQLException {
        //Carreras carrera = new Carreras();
        Usuarios usuario = new Usuarios();         

        String[] columNames = {"id_usuario","Usuario","id_personal","Personal","Activo"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lstUsuarios.size();i++) {
              usuario = lstUsuarios.get(i);
              String p = null;
              if (usuario.getPersonal().getIdPersonal()==0) {
                  p = "Ninguno";
              }else{
                  p =usuario.getPersonal().getNombre() + " " + usuario.getPersonal().getApePaterno();
              }
              modelo.addRow(new Object[] {
                usuario.getId_usuario(),                                 
                usuario.getUsuario(), 
                usuario.getPersonal().getIdPersonal(),                                                                 
                p,
                usuario.getActivo()
              } );                
          }

          return modelo;
    }
      
  private Usuarios rellenaUsuario(ResultSet resultSet) throws SQLException {
    Usuarios usuario = new Usuarios();
    Personal personal = new Personal();
    usuario.setId_usuario(resultSet.getInt("id_usuario"));
    usuario.setUsuario(resultSet.getString("login"));
    usuario.setActivo(resultSet.getString("activo"));
    
    personal.setIdPersonal(resultSet.getInt("id_personal"));
    personal.setNombre(resultSet.getString("nombre"));
    personal.setApePaterno(resultSet.getString("ape_paterno"));
    personal.setApePaterno(resultSet.getString("ape_materno"));    
    
    usuario.setPersonal(personal);
    return usuario;
   }
  
  /*mETODO PARA REGISTRAR CALIFICACIONES MAESTRO*/
  
   public Usuarios getUsuarioMaestro(int id_usuario) throws SQLException, ClassNotFoundException {
    
    Usuarios usuario=null;
    ResultSet rs;    
    String sql = "{call get_usuario_maestro(?)}";
    objmysql.Conectar();
    objcallstm = objmysql.conexion.prepareStatement(sql);
    objcallstm.setInt(1, id_usuario);
    rs = objcallstm.executeQuery();
    while (rs.next()) {
   usuario = new Usuarios();
    Personal personal = new Personal();
    usuario.setId_usuario(rs.getInt("id_usuario"));
    usuario.setUsuario(rs.getString("login"));
    usuario.setActivo(rs.getString("activo"));
    
    personal.setIdPersonal(rs.getInt("id_personal"));
    personal.setNombre(rs.getString("personal"));
    
    
    Puestos p=new Puestos();
    p.setDescripcion(rs.getString("descripcion"));
    p.setIdPuesto(rs.getInt("id_puesto"));
    personal.setPuestos(p);
    usuario.setPersonal(personal);
    }
    objcallstm.close();
    objmysql.Desconectar();
    return usuario;  
    }
  
  
}