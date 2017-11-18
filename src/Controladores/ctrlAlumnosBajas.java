/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Alumnos;
import Entidades.AlumnosBajas;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Last Develop
 */
public class ctrlAlumnosBajas {
        Mysql db;
    String sql = "";
    PreparedStatement cs = null;

    public ctrlAlumnosBajas() {
        this.db = new Mysql();
    }
    
    public boolean setBaja(AlumnosBajas al) throws SQLException, ClassNotFoundException
    {
        
      boolean exito=false;
       sql = "{call set_alumnos_bajas(?,?,?,?,?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, al.getId_baja());
        cs.setInt(2,al.getAlumno().getIdAlumno());
        cs.setInt(3,al.getUsuario().getId_usuario());
        cs.setInt(4,al.getCiclo().getIdCiclo());
        cs.setString(5, al.getCodigobaja());
        cs.setString(6, al.getTipobaja());
        cs.setString(7, al.getObservaciones()); //La fecha esta por el sistema
        int r=cs.executeUpdate();
        if(r>0)
            exito=true;
      return exito;
    }
    
    public ArrayList<Alumnos> getAlumnos(String criterio,String campo) throws SQLException, ClassNotFoundException
    {
        ArrayList<Alumnos> listAlumnos=new ArrayList<Alumnos>();
        ResultSet rs=null;
        //System.out.println("Entro");
        sql = "{call get_alumnos_activos(?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setString(1, criterio);
         cs.setString(2, campo);
        rs=cs.executeQuery();
        
      while(rs.next())
                   {
                       //System.out.println("Entro en el rs");
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
                   
                    
                    
                    
                    
                    listAlumnos.add(objalumno);
    }
      return listAlumnos;
    }   
    
    
    public DefaultTableModel getTablaAlumnos(ArrayList<Alumnos> lista)
  {
   DefaultTableModel dm=new DefaultTableModel();
   String []columnas={"Clave","Matricula","Nombre","Ape. Paterno","Ape. Materno"};
   
    dm.setColumnIdentifiers(columnas);
   
   for(int i=0;i<lista.size();i++)
   {
       //System.out.println("Entro en la lista de dm");
    Alumnos ce=lista.get(i);
    //System.out.println(ce.toString() );
    dm.addRow(new Object[]{
         String.valueOf( ce.getIdAlumno()), 
        ce.getMatricula(),
        ce.getNombre(),
        ce.getApePaterno(),
        ce.getApeMaterno()});
   }
  
  return dm;
  }
}
