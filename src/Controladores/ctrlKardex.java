/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Entidades.Asignaturas;
import Entidades.Carreras;
import Entidades.DatosAcademicosReinscripcion;
import Entidades.Kardex;
import Entidades.OfertaAcademica;
import Entidades.ReporteHistorialAcademico;
import java.sql.Types;

/**
 *
 * @author Last Develop
 */
public class ctrlKardex {
    
 Mysql db;
  String sql = "";
  PreparedStatement cs =  null;

    public ctrlKardex() {
         db = new Mysql();
    }
  
  
public boolean getExisteKardex(int id_alumno) throws SQLException, ClassNotFoundException
{
    sql = "{call get_existe_filas_kardex(?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
      r=rs.getInt(1);
     }
    
    cs.close();   
    db.Desconectar();
    if(r>0)
        return true;
    else
        return false;
 }

public int getCantidadReprobadas(int tipo_componente, int id_alumno) throws SQLException, ClassNotFoundException
{
    ResultSet rs;
    int r=0;
    if(this.getExisteKardex(id_alumno))
    {
    sql = "{call get_total_reprobadas(?,?)}";
    db.Conectar();
    cs =  db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2, tipo_componente);
    rs=cs.executeQuery();
    while(rs.next())   
    {
     r=rs.getInt(1);
    }
    
    cs.close();   
    db.Desconectar();
    }
    else
        r=0;
    return r;
}
 
public int[] getDatosUltimoSemestreCursado(int id_alumno) throws SQLException, ClassNotFoundException
{
  int maxsemestre=0;
  int maxciclo=0;
  int id_carrera=0;
   sql = "{call get_max_semestre_kardex(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
         
       maxsemestre=rs.getInt("max_semestre");
       
       
       
     }
    
    cs.close();   
    db.Desconectar();
    int []datos={maxsemestre};
            
  return datos;
  
}
public int getUltimoSemestreCursado(int id_alumno) throws SQLException, ClassNotFoundException
{
  int maxsemestre=0;
  
    sql = "{call get_ultimo_semestre_cursado(?)}";
    db.Conectar();
    cs =  db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
   // System.out.println("entro donde debe ser");
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
         
       maxsemestre=rs.getInt("max_semestre");
       
      // System.out.println("entro donde debe ser");
     }
    
    cs.close();   
    db.Desconectar();
    
            
  return maxsemestre;
  
}

/*ESTE METODO TRAE LA OFERTA DE ASIGNATURAS REPROBADAS 
 * PARA VERIFICAR SI ESTAN EN LA OFERTA ACademica del ciclo
 * opcion 1: son asignaturas, opcion 2 son modulos reprobados*/

public ArrayList<Asignaturas> getAsignaturasReprobadas(int id_alumno,int opcion) throws SQLException, ClassNotFoundException
{
  ArrayList<Asignaturas> listareprobadas=new ArrayList<Asignaturas>();
  sql = "{call get_reprobadas_kardex(?,?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2, opcion);
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
         
       Asignaturas asignatura=new Asignaturas();
       asignatura.setIdAsignatura(rs.getInt("id_asignatura"));
       asignatura.setClave(rs.getString("clave"));
       asignatura.setNombre(rs.getString("nombre"));
       asignatura.setDescripcion(rs.getString("descripcion"));
       asignatura.setSemestre(rs.getShort("semestre"));
       asignatura.setIdPlan(rs.getInt( "id_plan"));
       listareprobadas.add(asignatura);
     }
    
    cs.close();   
    db.Desconectar();
    
            
  return listareprobadas;
}
/*22-junio-2012 ya esta listo nada mas falta que se actualice el sistema....*/
public boolean setAsignaturasKardex(ArrayList<Kardex> listakardex) throws SQLException, ClassNotFoundException, NumberFormatException
{
 int  r=0;
 boolean exito=true;
  if(listakardex.size()>0)
  {
      
      db.Conectar();
      
   for(int i=0;i<listakardex.size();i++)
   {
    
          sql = "{call get_id_escala(?)}";
            
           cs = (PreparedStatement) db.conexion.prepareStatement(sql);
            
            cs.setFloat(1, listakardex.get(i).getPromedio());
    
    
     ResultSet rs   = cs.executeQuery();
     int id_escala=0;
     while (rs.next())
     {
         id_escala=rs.getInt("id_escala");
      }
     
     listakardex.get(i).setId_escala(id_escala);
    
     
    
 
   
   }//fin del for
   db.Desconectar();
   db.Conectar();
   db.begin();
   
   for(int i=0;i<listakardex.size();i++)
   {
          //System.out.println(listakardex.get(i));
        sql = "{call set_asignatura_historial(?,?,?,?,?,?,?,?,?,?,?,?)}"; 
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, listakardex.get(i).getId_kardex());
        cs.setInt(2, listakardex.get(i).getId_ciclo());
        cs.setInt(3, listakardex.get(i).getId_alumno());
        cs.setInt(4, listakardex.get(i).getId_asignatura());
        cs.setInt(5, listakardex.get(i).getId_oferta_academica());
        cs.setInt(6, listakardex.get(i).getId_escala());
        cs.setInt(7, listakardex.get(i).getSemestre());
        cs.setInt(8, listakardex.get(i).getId_acreditacion());
        cs.setFloat(9, listakardex.get(i).getPromedio());
        cs.setString(10, listakardex.get(i).getStatus());
        cs.setString(11, listakardex.get(i).getAcreditado());
        cs.setString(12, listakardex.get(i).getModulo());
         r= cs.executeUpdate();
        if(r>0)
            
            exito=true;
        else
        {
            exito=false;
            break;
        }      
   }//Fin del for donde se deben insertar las asignaturas al kardex
  }//Fin del model.count>0
  
   if (exito){
            db.commit();
            }
        else{
            db.rollback();
            }
    db.Desconectar(); 
  
  return exito;
}//Fin del metodo

public ModeloTablaKardex getCastOfertToKardex(ArrayList<OfertaAcademica> listaOferta,int id_alumno,int id_ciclo,int id_carrera)
{
    String []columnas={"Seleccionar","Asignatura","Promedio","Tipo Acreditacion"};
   ModeloTablaKardex modelo=new ModeloTablaKardex(columnas);
   modelo.ofertaTokardex(listaOferta, id_alumno, id_ciclo, id_carrera);
   return modelo;
} 


/**ESTE METODO TRAE EL HISOTORIAL DEL ALUMNO/
 * 23 DE JUNIO 2012...TRAE DE UN SEMESTRE ESPECIFICO O DE TODO
 */
public ArrayList<Kardex> getHistorialKardex(int id_alumno,int semestre) throws SQLException, ClassNotFoundException
{
  ArrayList<Kardex>  listaHistorial=new ArrayList<Kardex>();
  ArrayList<Kardex>  listaauxiliar=null;
  int maxsemestre=this.getUltimoSemestreCursado(id_alumno); //Sabemos si es el ultimo semestre cursado
  if(maxsemestre==1 || semestre==1)
  {
      
      if(this.getHistorialAsignaturas(id_alumno, semestre)!=null)
      {
            listaHistorial=this.getHistorialAsignaturas(id_alumno, semestre);
            //System.out.println("Debiste Entrar aqui por que no es nulo");
      }
  }
  if(semestre==0 && maxsemestre>1) //Traer todo el Historial
  {
    for(int i=1;i<=maxsemestre;i++) //Tremos todo el historial desde el primer semestre hasta el ultimo semestre cursado
    {
        listaauxiliar=this.getHistorialAsignaturas(id_alumno, i);
        if(listaauxiliar!=null)
        {
        for(int j=0;j<listaauxiliar.size();j++) //ciclo para la lista de asignaturas
        {
         listaHistorial.add(listaauxiliar.get(j));
        }
        if(i>1)// entonces verificamos el modulo que exista
        {
            Kardex modulo=this.getHistorialModulo(id_alumno, i);
                    if(modulo!=null)
                    { 
                        listaHistorial.add(modulo);
                    
                    }
        }
      
    }
    }
  }
  if(semestre>1)//Un Semestre en especifico
  {
   listaauxiliar=this.getHistorialAsignaturas(id_alumno, semestre);
   for(int j=0;j<listaauxiliar.size();j++) //ciclo para la lista de asignaturas
        {
         listaHistorial.add(listaauxiliar.get(j));
        }
        Kardex modulo=this.getHistorialModulo(id_alumno, semestre);
                    if(modulo!=null)
                    { 
                        listaHistorial.add(modulo);
                    
                    }
  }
    
  
 
 return listaHistorial;
}
private Kardex getHistorialModulo(int id_alumno, int semestre) throws SQLException, ClassNotFoundException
{ 
  Kardex modulo=null;
    sql = "{call get_historial_modulos_alumnos(?,?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2,semestre);
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
         modulo=new Kardex();
         modulo=rellenarModulo(rs);
     }
     return modulo;
}

private Kardex rellenarModulo(ResultSet rs) throws SQLException
{
  Kardex kardex=new Kardex();
  
  kardex.setId_kardex(rs.getInt("id_historial"));
  kardex.setPromedio(rs.getFloat("promedio"));
  kardex.setNombreasignatura(rs.getString("descripcion"));
  kardex.setSemestre(rs.getShort("semestre"));
  kardex.setId_acreditacion(rs.getInt("id_acreditacion"));
  kardex.setModulo(rs.getString("modulo"));
  kardex.setId_asignatura(rs.getInt("id_modulo"));
  kardex.setId_alumno(rs.getInt("id_alumno"));
  kardex.setId_ciclo(rs.getInt("id_ciclo"));
  kardex.setId_oferta_academica(rs.getInt("id_oferta_academica"));
  kardex.setId_escala(rs.getInt("id_escala"));
  
  kardex.setStatus(rs.getString("status"));
  
  return kardex;
}

private ArrayList<Kardex> getHistorialAsignaturas(int id_alumno,int semestre) throws SQLException, ClassNotFoundException
{
    ArrayList<Kardex> listaHistorial=new ArrayList<Kardex>();
 sql = "{call get_historial_alumno(?,?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2,semestre);
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
       listaHistorial.add(this.rellenarKardex(rs));
     }
     return listaHistorial;
}


private Kardex rellenarKardex(ResultSet rs) throws SQLException
{
  Kardex kardex=new Kardex();
  
  kardex.setId_kardex(rs.getInt("id_historial"));
  kardex.setPromedio(rs.getFloat("promedio"));
  kardex.setNombreasignatura(rs.getString("nombre"));
  kardex.setSemestre(rs.getShort("semestre"));
  kardex.setId_acreditacion(rs.getInt("id_acreditacion"));
  kardex.setModulo(rs.getString("modulo"));
  kardex.setId_asignatura(rs.getInt("id_asignatura"));
  kardex.setId_alumno(rs.getInt("id_alumno"));
  kardex.setId_ciclo(rs.getInt("id_ciclo"));
  
  kardex.setId_oferta_academica(rs.getInt("id_oferta_academica"));
  kardex.setId_escala(rs.getInt("id_escala"));
  
  kardex.setStatus(rs.getString("status"));
  return kardex;
}





/*eSTE METODO SIRVE PARA TRAER UNA TABLA COMPLETA DEL HISTORIAL 23-JUN*/
 public ModeloEditarKardex getModeloTablaHistorial(ArrayList<Kardex> listahistorial)
  {
      String []columnas={"Asignatura","Semestre","Promedio","Forma Acreditación"};
   ModeloEditarKardex modelo=new ModeloEditarKardex(columnas);
   for(int i=0;i<listahistorial.size();i++)
   {
       //System.out.println(listaoferta.get(i).getAsignatura().getNombre());
       listahistorial.get(i).setSeleccionado(true); //Para que este seleccionado la asignatura oferta academica
    modelo.addOfertaAcademica(listahistorial.get(i));
   }
   return modelo;
  }




/*19-06-2012 OBTNER LOS DATOS DE LA CARRERA Y SEMESTRE CURSADO
 SE UTILIZA EN REINSCRIPCION
 
 */
public DatosAcademicosReinscripcion getDatosAcademicos(int id_alumno) throws SQLException, ClassNotFoundException
{
 DatosAcademicosReinscripcion dai=new DatosAcademicosReinscripcion();
 sql = "{call get_datos_academicos_reinscripcion(?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    
    int r=0;
     ResultSet rs   = cs.executeQuery();
     while (rs.next())
     {
         


            dai.setCarrera(rs.getString("carrera"));
             dai.setSemestre(rs.getInt("semestre"));
            // System.out.println(dai.getCarrera() );   
         
        
     }
    
    cs.close();   
    db.Desconectar();
    
            
  return dai;
}

public int getCantidadAsignaturasReprobados(int id_alumno, int opcion) throws SQLException, ClassNotFoundException
{ /*opcion 1 es modulso reprobadas, 2 es asignaturas reprobados*/
    ResultSet rs;
    int r=0;
    if(this.getExisteKardex(id_alumno))
    {
    sql = "{call get_total_reprobadas(?,?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2, opcion);
    rs=cs.executeQuery();
    while(rs.next())   
    {
     r=rs.getInt(1);
    }
    
    cs.close();   
    db.Desconectar();
    }
    else
        r=0;
    return r;
}

public Carreras getCarreraAlumno(int semestre) throws SQLException, ClassNotFoundException
{
    ResultSet rs;
    Carreras ca=null;
    sql = "{call get_carrera_alumno(?)}";
    db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, semestre);
    
    rs=cs.executeQuery();
    while(rs.next())   
    {
        ca=new Carreras();
        ca.setNombre(  rs.getString("nombre"));
        ca.setIdCarrera(rs.getInt( "id_carrera"));
        ca.setNooficio(rs.getString("num_oficio"));
    }
    
    cs.close();   
    db.Desconectar();
    return ca;
}


public ArrayList<ReporteHistorialAcademico> getReporteHistorialAcademico(int id_alumno) throws SQLException, ClassNotFoundException
{
  ArrayList<ReporteHistorialAcademico> reporte=new ArrayList<ReporteHistorialAcademico>();
    int maxsemestre=this.getUltimoSemestreCursado(id_alumno);
    if(maxsemestre==1) //Solo hay un semestre y no usamos la opcion 2; opcion 1 tiene solo asignatura;
    {
      sql = "{call get_historial_academico_alumno(?,?,?)}"; //id_alumno,in_semestre,in_opcion
     db.Conectar();
    cs = (PreparedStatement) db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2,maxsemestre);
    cs.setInt(3,1);
    int r=0;
     ResultSet rs   = cs.executeQuery();
     ReporteHistorialAcademico registro=null;
     while (rs.next())
     {
         registro=this.getRegistroHistorial(rs);
        reporte.add(registro);
     }
     db.Desconectar();
    }
    else
    {
     for(int i=1;i<=maxsemestre;i++)
     {
        sql = "{call get_historial_academico_alumno(?,?,?)}"; //id_alumno,in_semestre,in_opcion
         db.Conectar();
        cs = (PreparedStatement) db.conexion.prepareStatement(sql);
        cs.setInt(1, id_alumno);
        cs.setInt(2,i);
        cs.setInt(3,1);
        
        ResultSet rs   = cs.executeQuery();
        ReporteHistorialAcademico registro=null;
        while (rs.next())
        {
         registro=this.getRegistroHistorial(rs);
        reporte.add(registro);
        }
        
        if(i>1)
        {
         
         
        cs = (PreparedStatement) db.conexion.prepareStatement(sql);
        cs.setInt(1, id_alumno);
        cs.setInt(2,i);
        cs.setInt(3,2);
          rs   = cs.executeQuery();
        
        while (rs.next())
        {
            
         registro=this.getRegistroHistorial(rs);
         
         reporte.add(registro);
        }
        }
        
     
     }//Traemos todo los datos
    }
    db.Desconectar();
    return reporte;
}

private ReporteHistorialAcademico getRegistroHistorial(ResultSet rs) throws SQLException
{
  ReporteHistorialAcademico registro=new ReporteHistorialAcademico();
  registro.setNombreasignatura(rs.getString("nombre"));
  registro.setPromedio(rs.getFloat("promedio"));
  registro.setSemestre(rs.getInt("semestre"));
  registro.setLetras(rs.getString("letras"));
  registro.setAcreditacion(rs.getString( "descripcion"));
  return registro;
}


public int setCierreSemestre() throws SQLException, ClassNotFoundException
{
 int registros=0;
  sql = "{call set_cierre_semestre()}"; //Esta cerrando en la tabla historial, falta actualizar
   db.Conectar();
   cs = (PreparedStatement) db.conexion.prepareStatement(sql);
   ResultSet rs=cs.executeQuery();
   
    
     while(rs.next())
     {
      registros=rs.getInt("registros");
     }
     
     
     sql = "{call set_cierre_modulos()}"; //Esta cerrando en la tabla historial, falta actualizar
   
   cs = (PreparedStatement) db.conexion.prepareStatement(sql);
   
   
     rs=cs.executeQuery();
     while(rs.next())
     {
      registros+=rs.getInt("registros");
     }
     db.Desconectar();
    
 
 
 return registros;
}

}
