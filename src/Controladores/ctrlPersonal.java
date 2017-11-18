/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import Entidades.Personal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Entidades.NivelesAcademico;
import Entidades.Puestos;
import Utilerias.ImageUtils;
import java.awt.image.BufferedImage;

/**
 *
 * @author Last Develop
 */
public class ctrlPersonal {
  private Controladores.Mysql objmysql=new Controladores.Mysql();
  private PreparedStatement objcallstm;
  private ArrayList<Personal> listapersonal;
  public int  setPersonal(Personal persona) throws SQLException, ClassNotFoundException
  {
   int filas=0;
   if(persona!=null)
   {
            
                if(objmysql.Conectar())
                {
                   objcallstm= objmysql.conexion.prepareStatement("call set_personal(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)") ;
                   objcallstm.setInt(1, persona.getIdPersonal());                   
                    objcallstm.setString(2, persona.getFolio());
                    objcallstm.setString(3,persona.getApePaterno());
                    objcallstm.setString(4,persona.getApeMaterno());
                    objcallstm.setString(5, persona.getNombre());
                    objcallstm.setString(6, persona.getCurp());
                    objcallstm.setString(7,persona.getRfc());
                    objcallstm.setString(8,String.valueOf( persona.getSexo()));
                    objcallstm.setString(9,persona.getEmail());
                    objcallstm.setString(10,persona.getTelefono());
                    objcallstm.setString(11,persona.getCelular());
                   
                     if(persona.getFechaNcto()!=null)
                    objcallstm.setDate(12,Date.valueOf( persona.getFechaNcto().toString() ));         
                     else
                         objcallstm.setDate(12,null);  
                     
                    objcallstm.setString(13,persona.getCarrera());
                    objcallstm.setString(14,persona.getEspecialidad());
                    objcallstm.setString(15,persona.getEspecialidad());
                    objcallstm.setString(16,persona.getCedulaPro());
                    objcallstm.setString(17,persona.getInstitucion());
                    objcallstm.setString(18,String.valueOf(persona.getFrenteGrupo()));
                    objcallstm.setString(19,String.valueOf(persona.getEstado(persona.getEstado())));
                   
                    if(persona.getIdPersonal()>0)//Registro Modificado
                    {
                        if(persona.getFoto().length()>0)
                     {
                        String ruta=persona.getFoto();
                         BufferedImage bfm= ImageUtils.loadImage(ruta); //Cargamos en el buffer
                                 
                           /*IMPORTANTE LA URL DEBE SER DEL ARCHIVO CONFIGURACION*/
                         Utilerias.Configuracion conf=new Utilerias.Configuracion();
                         ruta=conf.getPropiedad("servidor.host");   
                         
                         persona.setFoto(persona.generarNombreFoto()+".jpg");
                          ruta="\\\\"+ruta+"\\imagenes\\personal\\"+persona.getFoto();
                          bfm= ImageUtils.resize(bfm, 95, 114);
                         ImageUtils.saveImage(bfm, ruta);
                         objcallstm.setString(20,persona.getFoto());
                     }
                     else
                     {
                        objcallstm.setString(20,"");
                     }
                    }
                    
                    else //Registro nuevo
                    {
                     if(persona.getFoto().length()>0)
                     {
                        String ruta=persona.getFoto();
                         BufferedImage bfm= ImageUtils.loadImage(ruta); //Cargamos en el buffer
                                 
                           /*IMPORTANTE LA URL DEBE SER DEL ARCHIVO CONFIGURACION*/
                         Utilerias.Configuracion conf=new Utilerias.Configuracion();
                          ruta=conf.getPropiedad("servidor.host");   
                         
                         persona.setFoto(persona.generarNombreFoto()+".jpg");
                          ruta="\\\\"+ruta+"\\imagenes\\personal\\"+persona.getFoto();
                          bfm= ImageUtils.resize(bfm, 95, 114);
                         ImageUtils.saveImage(bfm, ruta);
                         objcallstm.setString(20,persona.getFoto());
                     }
                     else
                     {
                        objcallstm.setString(20,"");
                     }
                            
                    }
                    
                    
                    
                    
                    
                    
                    
                    objcallstm.setInt(21,persona.getPuestos().getIdPuesto());
                    objcallstm.setInt(22,persona.getNivelesAcademico().getIdNivel());         
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
            
      
    
   }
  
  }
   return filas;
  }
  
 
  public ArrayList<Personal> getPersonal(Personal persona)
  {
    this.listapersonal=new ArrayList<Personal>();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_personal(?)") ;                                                       
                   objcallstm.setInt(1, persona.getIdPersonal());
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    
                    Personal objpersonal=this.LlenarLista(rs);
   
                    this.listapersonal.add(objpersonal);
                                     
                   }
                   rs.close();
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
      return this.listapersonal; 
  }
  
  
  /*Retorna un solo profesor Sirve en Calificaciones*/
  public Personal getProfesor(Personal persona)
  {
    Personal profesor=new Personal();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_personal(?)") ;                                                       
                   objcallstm.setInt(1, persona.getIdPersonal());
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    
                   profesor=this.LlenarLista(rs);
   
                   
                                     
                   }
                   rs.close();
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
      return profesor; 
  }
  
  
  public DefaultComboBoxModel getModeloCombo(ArrayList<Personal> lista)
{
    Personal personal = new Personal();
    DefaultComboBoxModel dm=new DefaultComboBoxModel();
        personal.setIdPersonal(0);
        personal.setNombre("Selecciona un Personal");
        personal.setApePaterno("");
        personal.setApeMaterno("");
        dm.addElement(personal);
    
   
 for(int i=0;i<lista.size();i++)
 {
   dm.addElement(lista.get(i));
 }
 return dm;
}
  
   public ArrayList<Personal> getFiltroPersonal(String criterio,String campo)
  {
      
    this.listapersonal=new ArrayList<Personal>();
   int caso;
            try {
                if(objmysql.Conectar())
                {
                    String filtro=criterio;   //this.getCriterioBusqueda(criterio, campo);
                   if(filtro!=null)
                   {
                       if(campo.equals("nombre"))
                       {
                           caso=1;
                       }
                       else
                           caso=2;
                    String sql="call get_filtro_personal(?,?)";
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;   
                   
                
                   objcallstm.setInt(1, caso);
                   objcallstm.setString(2,criterio);
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    
                    Personal objpersonal=this.LlenarLista(rs);
   
                    this.listapersonal.add(objpersonal);
                                     
                   }
                   
                   rs.close();
                   }
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
      return this.listapersonal; 
  }
  
  private String getCriterioBusqueda(String criterio, String campo)
  {
  
   String busqueda=null;
   if(campo.equals("Nombre"))
       busqueda="nombre = "+criterio;
   if(campo.equals("Folio"))
       busqueda="folio = "+criterio ;
   return busqueda;
  }
   
 private Personal LlenarLista(ResultSet rs)
 {
     Personal objpersonal=null;
        try {
            objpersonal=new Personal();
            
                               objpersonal.setIdPersonal(rs.getInt("id_personal"));
                               objpersonal.setFolio(rs.getString("folio"));
                               objpersonal.setNombre(rs.getString("nombre"));
                               objpersonal.setApePaterno(rs.getString("ape_paterno"));
                               objpersonal.setApeMaterno(rs.getString("ape_materno"));
                               objpersonal.setCurp(rs.getString("curp"));
                               objpersonal.setRfc(rs.getString("rfc"));
                               objpersonal.setSexo(rs.getString("sexo"));
                               objpersonal.setEmail(rs.getString("email"));
                               objpersonal.setFechaNcto(rs.getDate("fecha_ncto"));
                               objpersonal.setTelefono(rs.getString("telefono"));
                               objpersonal.setCelular(rs.getString("celular"));
                               objpersonal.setCarrera(rs.getString("carrera"));
                               objpersonal.setEspecialidad(rs.getString("especialidad"));
                               objpersonal.setPerfil(rs.getString("perfil"));
                               objpersonal.setCedulaPro(rs.getString("cedula_pro"));
                               objpersonal.setInstitucion(rs.getString( "institucion"));
                               objpersonal.setFrenteGrupo(rs.getString("frente_grupo"));
                               objpersonal.setEstado(rs.getString("estado"));
                               objpersonal.setFoto(rs.getString("foto"));
                               
                               Puestos objpuesto =new Puestos();
                               
                               objpuesto.setDescripcion(rs.getString("puesto")); //Error en descripcion
                               objpuesto.setIdPuesto(rs.getInt("id_puesto"));
                              
                                   objpersonal.setPuestos(objpuesto);
                               NivelesAcademico  objnivel=new NivelesAcademico();
                               
                               objnivel.setDescripcion(rs.getString("descripcion"));
                               objnivel.setIdNivel(rs.getInt("id_nivel"));
                               
                               objpersonal.setNivelesAcademico(objnivel);
                               
        } catch (SQLException ex) {
            Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
        }
 return objpersonal;
 }
 
 
  public DefaultTableModel getPersonal(ArrayList<Personal> lista)
  {
   DefaultTableModel dm=new DefaultTableModel();
   String []columnas={"ID","Folio","Nombre","Ape. Paterno","Ape. Materno","Nivel","Puesto","Frente grupo","Sexo","Fecha ncto."};
   
    dm.setColumnIdentifiers(columnas);
 
   for(int i=0;i<lista.size();i++)
   {
    Personal ce=lista.get(i);
    dm.addRow(new Object[]{String.valueOf(ce.getIdPersonal()), String.valueOf( ce.getFolio()),ce.getNombre(),ce.getApePaterno(),ce.getApeMaterno(),ce.getNivelesAcademico().getDescripcion(),ce.getPuestos().getDescripcion(),ce.getFrenteGrupo(),ce.getSexo(),ce.getFechaNcto()});
   }
  
  return dm;
  }
  
  public Personal getPersonal(Personal persona,ArrayList<Personal> lista)
  {
    Personal nivel=null;
      for(int i=0;i<lista.size();i++)
      {
       if(lista.get(i).getFolio().equals(persona.getFolio()))
       {
           
        nivel=lista.get(i);
        i=lista.size();
        
       }
       
      }
      
   return nivel; 
  
  }

public int deletePersonal(Personal persona)
{
 int filas=0;
   if(persona!=null)
   {
            try {
                if(objmysql.Conectar())
                {
                   objcallstm= objmysql.conexion.prepareStatement("call delete_personal(?)") ;
                   objcallstm.setInt(1, persona.getIdPersonal());                   
                   
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
      
    
   }
   return filas;
}


/*******07-05-2012 OJO SIRVE EN EL CAMPO DE LOS REDIS********/

public Personal getDatosReporte(String puesto) throws SQLException, ClassNotFoundException
{
    Personal personal=new Personal();
                if(objmysql.Conectar())
                {
                   objcallstm= objmysql.conexion.prepareStatement("call get_personalreporte(?)") ;
                   objcallstm.setString(1, puesto);  
                   ResultSet rs=objcallstm.executeQuery();
                   while (rs.next())
                   {
                    personal.setIdPersonal(rs.getInt("id_personal"));
                    personal.setNombre(rs.getString( "nombre"));
                    personal.setApeMaterno(rs.getString("ape_materno"));
                    personal.setApePaterno(rs.getString( "ape_paterno"));
                    personal.setNombrecompleto();
                   }
                    
                }
                else
                    return null;
    
     return personal;    
     
}


}
