/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Entidades;
import Entidades.Escuelas;
import Entidades.Personal;
import Entidades.TipoPlantel;
/**
 *
 * @author Last Develop
 */
public class ctrlEscuela {
  private Controladores.Mysql objmysql=new Controladores.Mysql();
  private PreparedStatement objcallstm;
  
  public int setEscuela(Escuelas escuela) throws SQLException, ClassNotFoundException
  {
      int filas=0;
   if(escuela!=null)
   {
            
                if(objmysql.Conectar())
                {
                    String sql="call set_escuela(?,?,?,?,?,?,?,?,?,?,?)";
                    objcallstm=objmysql.conexion.prepareStatement(sql) ;
                    objcallstm.setInt(1, escuela.getIdEscuela());
                    objcallstm.setString(2, escuela.getNombre());
                    objcallstm.setString(3, escuela.getNumero());                    
                    objcallstm.setString(4,escuela.getDireccion());
                    objcallstm.setString(5,escuela.getClaveCt());
                    objcallstm.setString(6, escuela.getTelefono());
                    objcallstm.setString(7, escuela.getCorreo());
                    objcallstm.setString(8,escuela.getLogotipo());
                    objcallstm.setString(9,escuela.getTipoPlantel().getClave());
                    objcallstm.setString(10,escuela.getLugarEntidad().getClave());
                    objcallstm.setInt(11,escuela.getDirector().getIdPersonal());

                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
            
      
    
   }
   return filas;
  }
   
 public Escuelas getEscuelas()
 {
     Escuelas escuela=null;
    try {
                if(objmysql.Conectar())
                {
                   
                   String sql="call get_escuela()";
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;                                                       
                  
                   
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                     escuela=new Escuelas();
                    escuela.setClaveCt(rs.getString("clave_ct"));
                    escuela.setNombre(rs.getString("nombre"));
                    escuela.setIdEscuela(rs.getInt("id_escuela"));
                    escuela.setNumero(rs.getString("numero_plantel"));
                    escuela.setDireccion(rs.getString( "direccion"));
                    
                   
                    
                    Entidades entidad=new Entidades();
                    entidad.setClave(rs.getString("id_entidad"));
                    entidad.setEntidad(rs.getString("entidad"));
                    
                    
                    escuela.setLugarEntidad(entidad);
                    
                    escuela.setClaveCt(rs.getString("clave_ct"));
                    escuela.setCorreo(rs.getString("correo"));
                    escuela.setTelefono(rs.getString("telefono"));
                    escuela.setLogotipo(rs.getString("logotipo"));
                    
                    TipoPlantel tipo=new TipoPlantel();
                    
                    tipo.setClave(rs.getString("clave"));
                    tipo.setClave_unidad(rs.getShort("clave_unidad"));
                    tipo.setPlantel(rs.getString("plantel"));
                    tipo.setUnidad_administrativa("unidad_administrativa");
                    tipo.setAbreviatura("abreviatura");
                    escuela.setTipoPlantel(tipo);
                    
                    Personal director=new Personal();
                    director.setIdPersonal(rs.getInt("id_personal"));
                    director.setNombre(rs.getString("director"));
                    director.setApePaterno(rs.getString("ape_paterno"));
                    director.setApePaterno(rs.getString("ape_materno"));
                    director.setFolio(rs.getString("folio"));
                    
                    
                    escuela.setDirector(director);
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               System.out.println(ex.getMessage());
                Logger.getLogger(ctrlEscuela.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                 System.out.println(ex.getMessage());
                Logger.getLogger(ctrlEscuela.class.getName()).log(Level.SEVERE, null, ex);
            }
      return escuela;
     
         
 }
}
