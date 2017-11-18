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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import Entidades.Alumnos;
import Entidades.CicloEscolar;
import Entidades.Grupos;
import Utilerias.ImageUtils;
import java.awt.image.BufferedImage;


/**
 *
 * @author Last Develop
 */
public class ctrlAlumnos {
    private ArrayList<Alumnos> listaalumnos;
    private Mysql objmysql=new Mysql();
    private PreparedStatement objcallstm;
    
    public int setAlumnos(Alumnos alumno)throws SQLException, ClassNotFoundException
    {
    
     int filas=0;
   if(alumno!=null)
   {
            
                if(objmysql.Conectar())
                {
                   String sql="call set_alumnos(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                   objcallstm= objmysql.conexion.prepareStatement(sql) ;
   
                   objcallstm.setInt(1, alumno.getIdAlumno());                   
                    objcallstm.setString(2, alumno.getMatricula());
                    objcallstm.setString(3, alumno.getNombre());
                    objcallstm.setString(4,alumno.getApePaterno());
                    objcallstm.setString(5,alumno.getApeMaterno());
                               
                    
                    
                    objcallstm.setString(6, alumno.getDireccion());
                     if(alumno.getFechaNcto()!=null)
                     {
                    objcallstm.setDate(7,Date.valueOf( alumno.getFechaNcto().toString()));       
                     }
                     else
                         objcallstm.setDate(7,null);       
                         
                    objcallstm.setString(8,String.valueOf(alumno.getSexo()));
                    objcallstm.setString(9, alumno.getEstadoCivil());
                    objcallstm.setString(10, alumno.getCurp());
                    objcallstm.setString(11, alumno.getLugarNcto());
                    objcallstm.setString(12,alumno.getTelefono());                 
                    if(alumno.getIdAlumno()>0) // Si va a modificar
                    {
                         if(alumno.getFotografia().length()>0)
                        {
                            //Toda la ruta debe traer getFotografia
                            String ruta=alumno.getFotografia();
                         BufferedImage bfm= ImageUtils.loadImage(ruta); //Cargamos en el buffer
                           //System.out.println("Ruata antes"+ruta);      
                            /*IMPORTANTE LA URL DEBE SER DEL ARCHIVO CONFIGURACION*/
                         Utilerias.Configuracion conf=new Utilerias.Configuracion();
                          ruta=conf.getPropiedad("servidor.host");
                         
                         
                         alumno.setFotografia(alumno.generarNombreFoto()+".jpg");
                         
                         //System.out.println("Nombre Generado:"+  alumno.getFotografia());
                          ruta="\\\\"+ruta+"\\imagenes\\"+alumno.getFotografia();
                          bfm= ImageUtils.resize(bfm, 95, 114);
                         ImageUtils.saveImage(bfm, ruta);
                         objcallstm.setString(13,alumno.getFotografia());
                        }
                        else
                             objcallstm.setString(13,"");
                    }
                    else
                    {
                    if(alumno.getFotografia().length()>0)
                        {
                            //Toda la ruta debe traer getFotografia
                            String ruta=alumno.getFotografia();
                         BufferedImage bfm= ImageUtils.loadImage(ruta); //Cargamos en el buffer
                                 
                           /*IMPORTANTE LA URL DEBE SER DEL ARCHIVO CONFIGURACION*/
                         Utilerias.Configuracion conf=new Utilerias.Configuracion();
                          ruta=conf.getPropiedad("servidor.host");   
                         
                         alumno.setFotografia(alumno.generarNombreFoto()+".jpg");
                          ruta="\\\\"+ruta+"\\imagenes\\"+alumno.getFotografia();
                          bfm= ImageUtils.resize(bfm, 95, 114);
                         ImageUtils.saveImage(bfm, ruta);
                         objcallstm.setString(13,alumno.getFotografia());
                        }
                      else //si no trae fotografia, se pasa empty
                    { 
                          objcallstm.setString(13,"");
                    }
                    }
                    
                    objcallstm.setString(13,alumno.getFotografia());
                    objcallstm.setString(14,alumno.getTutor());
                    objcallstm.setString(15,alumno.getBeca());
                    
                    objcallstm.setString(16,alumno.getEstadoToSql());
                    

                    objcallstm.setString(17,alumno.getFichaMedica());
                    objcallstm.setString(18,alumno.getSecundariaProcedencia());                    
                    objcallstm.setFloat(19,alumno.getPromedioSecundaria());
                    
                    if(alumno.getFechaBaja()!=null)
                    {
                    objcallstm.setDate(20,Date.valueOf(alumno.getFechaBaja().toString()));
                    }
                    else
                    {
                    objcallstm.setDate(20,null);
                    }


                        
                    objcallstm.setString(21,alumno.getMotivoBaja());

                    if(alumno.getFechaIngreso()!=null)
                        objcallstm.setDate(23,Date.valueOf( alumno.getFechaIngreso().toString()));
                    else
                          objcallstm.setDate(23,null); //Fecha Ingreso
                    if(alumno.getFechaEgreso()!=null)
                    {
                    objcallstm.setDate(22,Date.valueOf( alumno.getFechaEgreso().toString()));
                    }
                    else
                        objcallstm.setDate(22,null); //Fecha Egreso
                    
                    objcallstm.setString(24, String.valueOf( alumno.getRepetidor()));
                    
                    
                    objcallstm.setString(25, alumno.getFolio_certificado());
                    
                    objcallstm.setString(26, String.valueOf(alumno.getModo_ingreso()));
                    
                    objcallstm.setString(27, String.valueOf(alumno.getTitulado()));
                    
                    filas=objcallstm.executeUpdate();
                    objmysql.Desconectar();
                   
                }
      
    
   }
   return filas;
    }
    
    public ArrayList<Alumnos> getPersonal(Alumnos alumno)
  {
    this.listaalumnos=new ArrayList<Alumnos>();
   
            try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_alumnos(?)") ;                                                       
                   objcallstm.setInt(1, alumno.getIdAlumno());
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    Alumnos objalumno=new Alumnos();
                   objalumno.setIdAlumno(rs.getInt("id_alumno"));
                   objalumno.setMatricula(rs.getString( "matricula"));
                   
                   
                   
                   
                   objalumno.setNombre(rs.getString("nombre"));
                   objalumno.setApePaterno(rs.getString("ape_paterno"));
                   objalumno.setApeMaterno(rs.getString("ape_materno"));
                   objalumno.setDireccion(rs.getString("direccion"));
                   if(rs.getDate("fecha_ncto")!=null)
                    objalumno.setFechaNcto(rs.getDate("fecha_ncto"));
                   
                       
                   objalumno.setSexo(rs.getString("sexo"));
                   objalumno.setEstadoCivil(rs.getString("estado_civil"));
                   objalumno.setCurp(rs.getString("curp"));
                   objalumno.setLugarNcto(rs.getString("lugar_ncto"));
                   objalumno.setTelefono(rs.getString("telefono"));
                   objalumno.setFotografia(rs.getString("fotografia"));
                   objalumno.setTutor(rs.getString("tutor"));
                   objalumno.setBeca(rs.getString("beca"));
                   objalumno.setSqlToEstado(rs.getString("estado"));
                   objalumno.setFichaMedica(rs.getString("ficha_medica"));
                   objalumno.setSecundariaProcedencia(rs.getString("secundaria_procedencia"));
                   objalumno.setPromedioSecundaria(rs.getFloat("promedio_secundaria"));
                   objalumno.setMotivoBaja(rs.getString("motivo_baja"));
                   objalumno.setFechaBaja(rs.getDate("fecha_baja"));
                   objalumno.setFechaEgreso(rs.getDate("fecha_egreso"));
                   objalumno.setFechaIngreso(rs.getDate("fecha_ingreso"));
                   objalumno.setRepetidor(rs.getString("repetidor"));
                   
                   objalumno.sqlToModoIngreso(rs.getString("modo_ingreso"));
                   
                   objalumno.setFolio_certificado(rs.getString("folio_certificado"));
                   
                   objalumno.sqlToTitulado(rs.getString("titulado"));
                   
                    
                    
                    
                    
                    this.listaalumnos.add(objalumno);
                                     
                   }
                   rs.close();
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
      return this.listaalumnos; 
  }
   
  public DefaultTableModel getPersonal(ArrayList<Alumnos> lista)
  {
   DefaultTableModel dm=new DefaultTableModel();
   String []columnas={"Clave","Matricula","Nombre","Ape. Paterno","Ape. Materno", "Direccion"};
   
    dm.setColumnIdentifiers(columnas);
   
   for(int i=0;i<lista.size();i++)
   {
    Alumnos ce=lista.get(i);
    dm.addRow(new Object[]{String.valueOf( ce.getIdAlumno()),String.valueOf( ce.getMatricula()),ce.getNombre(),ce.getApePaterno(),ce.getApeMaterno(), ce.getDireccion()});
   }

  return dm;
  }
  
  public Alumnos getPersonal(Alumnos objalumno,ArrayList<Alumnos> lista)
  {
    Alumnos alumno=null;
      for(int i=0;i<lista.size();i++)
      {
       if(lista.get(i).getIdAlumno()==objalumno.getIdAlumno())
       {
        alumno=lista.get(i);
        i=lista.size();
       }
      }
      
   return alumno; 
  
  }
  
  
  public Alumnos getAlumno(Alumnos al) //Trae un solo alumno
  {
      Alumnos objalumno=null;
       try {
                if(objmysql.Conectar())
                {
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_alumnos(?)") ;                                                       
                   objcallstm.setInt(1, al.getIdAlumno());
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                     objalumno=new Alumnos();
                   objalumno.setIdAlumno(rs.getInt("id_alumno"));
                   objalumno.setMatricula(rs.getString( "matricula"));
                   
                   
                   
                   objalumno.setNombre(rs.getString("nombre"));
                   objalumno.setApePaterno(rs.getString("ape_paterno"));
                   objalumno.setApeMaterno(rs.getString("ape_materno"));
                   objalumno.setDireccion(rs.getString("direccion"));
                   objalumno.setFechaNcto(rs.getDate("fecha_ncto"));
                   objalumno.setSexo(rs.getString("sexo"));
                   objalumno.setEstadoCivil(rs.getString("estado_civil"));
                   objalumno.setCurp(rs.getString("curp"));
                   objalumno.setLugarNcto(rs.getString("lugar_ncto"));
                   objalumno.setTelefono(rs.getString("telefono"));
                   objalumno.setFotografia(rs.getString("fotografia"));
                   objalumno.setTutor(rs.getString("tutor"));
                   objalumno.setBeca(rs.getString("beca"));
                   objalumno.setSqlToEstado(rs.getString("estado"));
                   objalumno.setFichaMedica(rs.getString("ficha_medica"));
                   objalumno.setSecundariaProcedencia(rs.getString("secundaria_procedencia"));
                   objalumno.setPromedioSecundaria(rs.getFloat("promedio_secundaria"));
                   objalumno.setMotivoBaja(rs.getString("motivo_baja"));
                   objalumno.setFechaBaja(rs.getDate("fecha_baja"));
                   objalumno.setFechaEgreso(rs.getDate("fecha_egreso"));
                   objalumno.setFechaIngreso(rs.getDate("fecha_ingreso"));
                   objalumno.setRepetidor(rs.getString("repetidor"));
                   
                   objalumno.sqlToModoIngreso(rs.getString("modo_ingreso"));
                   
                   objalumno.setFolio_certificado(rs.getString("folio_certificado"));
                   
                   objalumno.sqlToTitulado(rs.getString("titulado"));
                   
                    
                    
                    
                    
                   
                                     
                   }
                   rs.close();
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               
                Logger.getLogger(ctrlPersonal.class.getName()).log(Level.SEVERE, null, ex);
            }
      return objalumno; 
      
  }
  
  
  public ArrayList<Alumnos> getFiltroPersonal(String campo, String criterio) throws SQLException, ClassNotFoundException
  {
    this.listaalumnos=new ArrayList<Alumnos>();
   
           
                if(objmysql.Conectar())
                {
                  String sql="call get_filtro_alumnos(?,?)";      
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;                                                       
                   objcallstm.setString(2,campo ); //Es el tipo de filto
                   objcallstm.setString(1,criterio );
                   //System.out.println(campo);
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    Alumnos objalumno=new Alumnos();
                   objalumno.setIdAlumno(rs.getInt("id_alumno"));
                   objalumno.setMatricula(rs.getString( "matricula"));
                   
                   
                   
                   
                   objalumno.setNombre(rs.getString("nombre"));
                   objalumno.setApePaterno(rs.getString("ape_paterno"));
                   objalumno.setApeMaterno(rs.getString("ape_materno"));
                   objalumno.setDireccion(rs.getString("direccion"));
                   objalumno.setFechaNcto(rs.getDate("fecha_ncto"));
                   objalumno.setSexo(rs.getString("sexo"));
                   objalumno.setEstadoCivil(rs.getString("estado_civil"));
                   objalumno.setCurp(rs.getString("curp"));
                   objalumno.setLugarNcto(rs.getString("lugar_ncto"));
                   objalumno.setTelefono(rs.getString("telefono"));
                   objalumno.setFotografia(rs.getString("fotografia"));
                   objalumno.setTutor(rs.getString("tutor"));
                   objalumno.setBeca(rs.getString("beca"));
                   objalumno.setEstado(rs.getString("estado"));
                   objalumno.setFichaMedica(rs.getString("ficha_medica"));
                   objalumno.setSecundariaProcedencia(rs.getString("secundaria_procedencia"));
                   objalumno.setPromedioSecundaria(rs.getFloat("promedio_secundaria"));
                   objalumno.setMotivoBaja(rs.getString("motivo_baja"));
                   objalumno.setFechaBaja(rs.getDate("fecha_baja"));
                   objalumno.setFechaEgreso(rs.getDate("fecha_egreso"));
                   objalumno.setFechaIngreso(rs.getDate("fecha_ingreso"));
                   objalumno.setRepetidor(rs.getString("repetidor"));
                    
                    
                    
                    
                    this.listaalumnos.add(objalumno);
                                     
                   }
                   
                   rs.close();
                   objmysql.Desconectar(); 
                }
            
      return this.listaalumnos; 
  }
   
    public ArrayList<Alumnos> getBuscarAlumnos(Alumnos alumno,String campo)
  {
    this.listaalumnos=new ArrayList<Alumnos>();
  
            try {
                if(objmysql.Conectar())
                {
                    ctrlCicloEscolar ctrlciclo=new ctrlCicloEscolar();
                    CicloEscolar cicloactivo=ctrlciclo.getCicloActivoInscripcion();
                    if(cicloactivo!=null)
                      
                    
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_buscar_alumnos(?,?,?)") ;                                                       
                   objcallstm.setString(1, alumno.getNombre());
                   objcallstm.setString(2, campo);
                   objcallstm.setInt(3,cicloactivo.getIdCiclo());
                   ResultSet rs=objcallstm.executeQuery();
                   while(rs.next())
                   {
                    Alumnos objalumno=new Alumnos();
                   objalumno.setIdAlumno(rs.getInt("id_alumno"));
                   objalumno.setMatricula(rs.getString( "matricula"));
                   objalumno.setNombre(rs.getString("nombre"));
                   objalumno.setApePaterno(rs.getString("ape_paterno"));
                   objalumno.setApeMaterno(rs.getString("ape_materno"));
                   objalumno.setRepetidor(rs.getString("repetidor"));
                    this.listaalumnos.add(objalumno);
                                     
                   }
                   rs.close();
                   objmysql.Desconectar(); 
                   
                }
            } catch (SQLException ex) {
               
                Logger.getLogger(ctrlAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
               
                Logger.getLogger(ctrlAlumnos.class.getName()).log(Level.SEVERE, null, ex);
            }
      return this.listaalumnos; 
  }
  
  /*ESTE MÉTODO NO SE ESTA UTILIZANDO*/
    public int get_filas(int id_alumno) throws SQLException, ClassNotFoundException
    {
     int filas=0;
      
   
           
                if(objmysql.Conectar())
                {
                    //OJO: NO EXISTE EL PROCEDIMIENTO ALMACENADO
                  String sql="call get_tipo_inscripcion(?,?)";      
                   
                   
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement(sql) ;                                                       
                   objcallstm.setInt(1,id_alumno );
                   //objcallstm.registerOutParameter(2, java.sql.Types.INTEGER);

                   objcallstm.execute();
                   
                   
                    
                   objmysql.Desconectar(); 
                }
            
      
     return filas;
    }
    
    public Alumnos get_alumno_inscripcion(int id_alumno,int filas) throws SQLException, ClassNotFoundException
    {
        Alumnos alumno=null;    
        if(objmysql.Conectar())
                {                
                   objcallstm= (PreparedStatement) objmysql.conexion.prepareStatement("call get_alumno_inscribir(?,?)") ;                                                       
                   objcallstm.setInt(1, id_alumno);
                   objcallstm.setInt(2, filas);
                    ResultSet rs=objcallstm.executeQuery();
                    if(filas==0)
                    {
                   while(rs.next())
                   {
                     alumno=new Alumnos();
                     alumno.setIdAlumno(rs.getInt("id_alumno"));
                     alumno.setMatricula(rs.getString( "matricula"));
                     alumno.setNombre(rs.getString("nombre"));
                     alumno.setApePaterno(rs.getString("ape_paterno"));
                     alumno.setApeMaterno(rs.getString("ape_materno"));
                     alumno. setSqlToEstado(rs.getString("estado"));
                    
                                     
                   }
                   rs.close();
                   }
                    else
                    {
                        while(rs.next())
                        {
                            alumno=new Alumnos();
                            alumno.setIdAlumno(rs.getInt("id_alumno"));
                            alumno.setMatricula(rs.getString( "matricula"));
                            alumno.setNombre(rs.getString("nombre"));
                            alumno.setApePaterno(rs.getString("ape_paterno"));
                            alumno.setApeMaterno(rs.getString("ape_materno"));
                            alumno.setEstado(rs.getString("estado"));
                    
                          }
                    }
                   objmysql.Desconectar();
                 }
      return alumno;
    }
public boolean setInscripcion(DefaultTableModel dfTablaModel, Alumnos alumno, Grupos grupo, CicloEscolar ciclo) throws SQLException, ClassNotFoundException
  {
      boolean bandera=true;
            int registros = dfTablaModel.getRowCount();
            int columnas = dfTablaModel.getColumnCount();
            int id_asignatura=0;
            int semestre=0;
            int id_ciclo=ciclo.getIdCiclo();
            int id_grupo_ciclo=grupo.getIdGrupo();
            int id_alumno=alumno.getIdAlumno();
            
        Object obj;
        Boolean bol;
        
        int i, j;
       for (i = 0; i < registros; i++) 
       {
           for (j = 0; j < columnas; j++) 
           {
                obj = dfTablaModel.getValueAt(i, j);
                if (obj instanceof Boolean) 
                {
                    bol = (Boolean) obj;
                    if (bol.booleanValue()) {
                        
                        id_asignatura = (Integer)  dfTablaModel.getValueAt(i, 3);
                        semestre =  (Short) dfTablaModel.getValueAt(i, 4);
                         int r= this.InsertarInscripcion(id_ciclo, id_alumno, id_asignatura, semestre, id_grupo_ciclo);
                         if(r<=0)
                         {
                             bandera=false;
                             i=registros;
                         }
                    }
                }

            }

        }
            
            
         return bandera;
        }

/*ESTE MÉTODO NO SE ESTA UTILIZANDO*/
public int InsertarInscripcion(int id_ciclo,int id_alumno,int id_asignatura, int semestre,int id_grupo_ciclo) throws SQLException, ClassNotFoundException
{int r=0;
                 if(objmysql.Conectar())
                {
                    //OJO: NO EXISTE EL PROCEDIMIENTO ALMACENADO
                   String sql="call set_inscripcion(?,?,?,?,?)";
                   objcallstm= objmysql.conexion.prepareStatement(sql) ;
                   
                   objcallstm.setInt(1, id_ciclo);                   
                   objcallstm.setInt(2, id_alumno);                   
                   objcallstm.setInt(3, id_asignatura);    
                   objcallstm.setInt(4,semestre);                   
                   objcallstm.setInt(5, id_grupo_ciclo);
                   System.out.println(id_ciclo + "-"+id_alumno+"-"+id_asignatura+"-"+semestre+"-"+id_grupo_ciclo);
                     r = objcallstm.executeUpdate();
                    objcallstm.close();
                    objmysql.Desconectar();
                    
                }
 return r;
}

}
