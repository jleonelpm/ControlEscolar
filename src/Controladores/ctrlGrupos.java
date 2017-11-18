/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import Entidades.Carreras;
import Entidades.Grupos;
import Entidades.Generaciones;
import Entidades.Planes;
import Entidades.Areas;
import Entidades.CicloEscolar;

/**
 *
 * @author leonel
 */
public class ctrlGrupos {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  
  
  public ctrlGrupos(){
    db = new Mysql();
  }
  
  public int setGrupo(Grupos grupo) throws SQLException, ClassNotFoundException {    
    sql = "{call set_grupo(?,?,?,?,?,?,?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);

    cs.setInt(1, grupo.getIdGrupo());
    cs.setInt(2, grupo.getIdGeneracion());    
    cs.setInt(3, grupo.getIdCarrera());                
    cs.setInt(4, grupo.getIdPlan());                    
    cs.setString(5, grupo.getGrupo()); 
    cs.setString(6, grupo.getModalidad());        
    cs.setString(7, grupo.getClave());        
    cs.setInt(8, grupo.getSemestre());        
    cs.setString(9, grupo.getTurno());            
    cs.setInt(10, grupo.getIdArea());
    cs.setInt(11, grupo.getIdCiclo());
    int r = cs.executeUpdate();
    cs.close();
    db.Desconectar();
    return r;
  }
       
  public ArrayList<Grupos> getGrupos(int idGrupo, int idGeneracion, int idCarrera, int idPlan, int opcion) throws SQLException, ClassNotFoundException {
    ArrayList<Grupos> grupos = new ArrayList<Grupos>();    
    Grupos grupo;
    ResultSet rs;    
    sql = "{call get_grupos(?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, idGrupo);
    cs.setInt(2, idGeneracion);        
    cs.setInt(3, idCarrera);
    cs.setInt(4, idPlan);    
    cs.setInt(5, opcion);    
    rs = cs.executeQuery();
    while (rs.next()) {
      grupo = rellenaGrupo(rs);
      grupos.add(grupo);
    }
    cs.close();
    db.Desconectar();
    return grupos;
  }
  
  public Grupos getGrupos(int idGrupo) throws SQLException, ClassNotFoundException {
    Grupos grupo=null;
    ResultSet rs;    
    sql = "{call get_grupos(?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, idGrupo);
    cs.setInt(2, 0);        
    cs.setInt(3, 0);
    cs.setInt(4, 0);    
    cs.setInt(5, 8);    
    rs = cs.executeQuery();
    while (rs.next()) {
      grupo = rellenaGrupo(rs);
    }
    cs.close();
    db.Desconectar();
    return grupo;
  }
  
  
  public int getGrupoValidar(Grupos grupo) throws SQLException, ClassNotFoundException {
    ResultSet rs;    
    sql = "{call get_grupo_validar(?,?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, grupo.getIdGeneracion());
    cs.setInt(2, grupo.getIdPlan());        
    cs.setInt(3, grupo.getIdCarrera());
    cs.setInt(4, grupo.getSemestre());    
    cs.setString(5, grupo.getGrupo());    
    cs.setInt(6, grupo.getIdArea());        
    rs = cs.executeQuery();
    int cont = 0;
    while (rs.next()) {
         cont = rs.getInt("cantidad");
    }
    cs.close();
    db.Desconectar();
    return cont;
  }
  
    
    //Devuelve un Objeto DefaultTableMoldel con información de una Lista de arreglos
    //Esto es útil para almacenarlo en una tabla
    public DefaultTableModel getGrupos(ArrayList<Grupos> lstGrupos) throws SQLException {
        //Carreras carrera = new Carreras();
        Grupos grupo = new Grupos();         

        String[] columNames = {"Idgrupo","Semestre","Grupo","Turno","Modalidad", "Generacion", "Carrera","Plan","Area"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          for (int i=0; i<lstGrupos.size();i++) {
              grupo = lstGrupos.get(i);
              modelo.addRow(new Object[] {
                grupo.getIdGrupo(),
                grupo.getSemestre(),
                grupo.getGrupo(), 
                grupo.getTurno(),
                grupo.getModalidad(),                
                grupo.getGeneracion().getNombre(),
                grupo.getCarrera().getNombre(), 
                grupo.getPlan().toString(),
                grupo.getArea().getDescripcion()
              } );                
          }

          return modelo;
    }
    
    //Genera un Combo Model con información de Grupo, Carrera y Generación
    public DefaultComboBoxModel getComboGruposGeneracion(ArrayList<Grupos> lista) throws SQLException {
        Grupos grupo = new Grupos();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        grupo.setIdGrupo(0);
        grupo.setGrupo("Selecciona un grupo");
        modelo.addElement(grupo);
        for (int i=0; i<lista.size();i++) {
          grupo = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new Grupos (grupo.getIdGrupo(), grupo.getCarrera().getNombre() + " Generacion " + grupo.getGeneracion().getNombre() +  " Grupo " + grupo.getGrupo()));
        }
        return modelo;
    }
      
  public int deleteGrupo(int id_grupo) throws SQLException, ClassNotFoundException {    
    sql = "{call delete_grupo(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_grupo);
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;
  }

    
  private Grupos rellenaGrupo(ResultSet resultSet) throws SQLException {
    Grupos grupo = new Grupos();
    Generaciones generacion = new Generaciones();
    Carreras carrera = new Carreras();    
    Planes plan = new Planes();
    Areas area = new Areas();
    CicloEscolar ciclo = new CicloEscolar();

    grupo.setIdGrupo(resultSet.getInt("id_grupo"));

    //Generacion del Grupo
    grupo.setIdGeneracion(resultSet.getInt("id_generacion"));
    if (resultSet.getString("generacion")!=null) {
    generacion.setNombre(resultSet.getString("generacion"));
    grupo.setGeneracion(generacion);
    }

    //Carrera del Grupo
    grupo.setIdCarrera(resultSet.getInt("id_carrera"));
    if (resultSet.getString("carrera")!=null) {    
        carrera.setNombre(resultSet.getString("carrera"));
    }else{
        carrera.setNombre("");
    }
    grupo.setCarrera(carrera);            
    //Plan de Estudios
    grupo.setIdPlan(resultSet.getInt("id_plan"));    
    if (resultSet.getString("plan")!=null) {    
        plan.setDescripcion(resultSet.getString("plan"));
    }else{
        plan.setDescripcion("");
    }
    grupo.setPlan(plan);
    
    //Areas de Estudio
    grupo.setIdArea(resultSet.getInt("id_area"));    
    if (resultSet.getString("area_propedeutica")!=null) {    
        area.setDescripcion(resultSet.getString("area_propedeutica"));
    }else{
        area.setDescripcion("");
    }
        
    grupo.setArea(area);            
    
    //Areas de Estudio
    grupo.setIdCiclo(resultSet.getInt("id_ciclo"));    
    if (resultSet.getString("ciclo_escolar")!=null) {    
        ciclo.setPeriodo(resultSet.getString("ciclo_escolar"));
    }else{
        ciclo.setPeriodo("");
    }
        
    grupo.setCiclo(ciclo);
    
    
    grupo.setSemestre(resultSet.getInt("semestre"));
    grupo.setGrupo(resultSet.getString("grupo"));
    grupo.setTurno(resultSet.getString("turno"));    
    grupo.setModalidad(resultSet.getString("modalidad"));    
    grupo.setClave(resultSet.getString("clave"));
        
    return grupo;
   }
  
  
/*TRAER LOS GRUPOS PARA INSCRIPCIONES*/
   /*COMBOBOX PARA INSCRIPCIONES---Jorge Manuel Pool Cen*/
    
    public DefaultComboBoxModel getComboGruposInscripciones(ArrayList<Grupos> lista)
    {
        Grupos grupo = new Grupos();
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();  
        
         grupo.setIdGrupo(0);
        grupo.setGrupo("Selecciona un grupo");
        modelo.addElement(grupo);
        for (int i=0; i<lista.size();i++) 
        {
          grupo = lista.get(i);
        //System.out.println(grupo.getIdGrupo() + "Se" + grupo.getSemestre());
          modelo.addElement(new Grupos (grupo.getIdGrupo(),"Semestre: " + grupo.getSemestre() +"-"+"Grupo: " +  grupo.getGrupo()+"-"+ grupo.getCarrera().getNombre()));
        }
        
        return modelo;
    }
  
  public ArrayList<Grupos> getGruposInscripciones(int opcion) throws SQLException, ClassNotFoundException {
    ArrayList<Grupos> grupos = new ArrayList<Grupos>();    
    Grupos grupo;
    ResultSet rs;    
    sql = "{call get_grupos_inscripciones(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
     cs.setInt(1, opcion);//Si es de primer semestre o mayores a primersemestre //inscripcion o reinscripcion
    rs = cs.executeQuery();
    while (rs.next()) {
      grupo = rellenaGrupoInscripciones(rs);
      grupos.add(grupo);
    }
    cs.close();
    db.Desconectar();
    return grupos;
  }
  
  /*RELLENAR GRUPOS PARA INSCRIPCIONES*/
   private Grupos rellenaGrupoInscripciones(ResultSet resultSet) throws SQLException {
    Grupos grupo = new Grupos();
   
    Carreras carrera = new Carreras();    
   
    
    CicloEscolar ciclo = new CicloEscolar();

    grupo.setIdGrupo(resultSet.getInt("id_grupo"));

    
    

    //Carrera del Grupo
    grupo.setIdCarrera(resultSet.getInt("id_carrera"));
    if (resultSet.getString("carrera")!=null) {    
        carrera.setNombre(resultSet.getString("carrera"));
    }else{
        carrera.setNombre("Bachillerato Tecnológico");
    }
    grupo.setCarrera(carrera);            
    
    
    
    
    grupo.setIdCiclo(resultSet.getInt("id_ciclo"));    
    if (resultSet.getString("ciclo_escolar")!=null) {    
        ciclo.setPeriodo(resultSet.getString("ciclo_escolar"));
    }else{
        ciclo.setPeriodo("");
    }
        
    grupo.setCiclo(ciclo);
    
    
    grupo.setSemestre(resultSet.getInt("semestre"));
    grupo.setGrupo(resultSet.getString("grupo"));
    grupo.setTurno(resultSet.getString("turno"));    
    grupo.setModalidad(resultSet.getString("modalidad"));    
    grupo.setClave(resultSet.getString("clave"));
        
    return grupo;
   }  
  
   /*Se agrego para generar la lista de grupos de un ciclo determinado para generar 
    listas de asistencia se usas en frmGenerarListasAsistencia*/
   public  ArrayList<Grupos> getGruposListasAsistencia (int id_ciclo) throws SQLException, ClassNotFoundException
   {
     ArrayList<Grupos> grupos = new ArrayList<Grupos>();    
    Grupos grupo;
    ResultSet rs;    
    sql = "{call get_grupos_listas(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
     cs.setInt(1, id_ciclo);//Si es de primer semestre o mayores a primersemestre //inscripcion o reinscripcion
    rs = cs.executeQuery();
    while (rs.next()) {
      grupo = rellenaGrupoInscripciones(rs);
      grupos.add(grupo);
    }
    cs.close();
    db.Desconectar();
    return grupos;
   
   }
   
}