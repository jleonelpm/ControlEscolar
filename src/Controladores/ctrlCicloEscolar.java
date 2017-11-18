/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import Entidades.CicloEscolar;

/**
 *
 * @author leonel
 */
public class ctrlCicloEscolar {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  public ctrlCicloEscolar(){
    db = new Mysql();
  }
  
  public int guardarCiclo(CicloEscolar ce) throws SQLException, ClassNotFoundException {    
    java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("yyyy-MM-dd");    
    sql = "{call set_ciclo(?,?,?,?,?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);

    cs.setInt(1, ce.getIdCiclo());
    cs.setString(2, ce.getPeriodo());    
    cs.setString(3, formato.format(ce.getFechaInicial()));
    cs.setString(4, formato.format(ce.getFechaFinal()));
    cs.setString(5, ce.getActivo());        
    cs.setString(6, formato.format(ce.getFechaParcial1()));
    cs.setString(7, formato.format(ce.getFechaParcial2()));
    cs.setString(8, formato.format(ce.getFechaParcial3()));        
    cs.setShort(9, ce.getTipo());    
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;
  }

  public int activarCiclo(CicloEscolar ce) throws SQLException, ClassNotFoundException {    
    sql = "{call activate_ciclo(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, ce.getIdCiclo());

    int r = cs.executeUpdate();
    cs.close();   
    db.Desconectar();
    return r;
  }
  
  public ArrayList<CicloEscolar> getCiclos(int id_ciclo) throws SQLException, ClassNotFoundException {
    ArrayList<CicloEscolar> ciclos = new ArrayList<CicloEscolar>();    
    CicloEscolar ciclo;
    ResultSet rs;    
    sql = "{call get_ciclos(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    
    cs.setInt(1, id_ciclo);
    rs = cs.executeQuery();
    while (rs.next()) {
      ciclo = rellenaCurso(rs);
      ciclos.add(ciclo);
    }
    cs.close();
    db.Desconectar();
    return ciclos;
  }
  
/*ESTE METODO ES DE JORGE POOL PARA EL PROCESO DE INSCRIPCION*/
 /*Este metodo 2-02 se agrego para cargar el ciclo en la inscripcion jorge pool cen*/
  public CicloEscolar getCicloActivoInscripcion() throws SQLException, ClassNotFoundException
  {
      CicloEscolar ciclo=null;
    ResultSet rs;    
    sql = "{call get_ciclo_activo()}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    
    rs = cs.executeQuery();
    while (rs.next()) {
      ciclo = rellenaCurso(rs);
      
    }
    cs.close();
    db.Desconectar();
    return ciclo;
  }





  public CicloEscolar getCicloActivo() throws SQLException, ClassNotFoundException {
    CicloEscolar ciclo=null;
    ResultSet rs;    
    sql = "{call get_ciclo_activo()}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    rs = cs.executeQuery();
    while (rs.next()) {
      ciclo = rellenaCurso(rs);
    }
    cs.close();
    db.Desconectar();
    return ciclo;
  }

  
    public DefaultTableModel getCiclos(ArrayList<CicloEscolar> lstCiclos) throws SQLException {
        CicloEscolar ciclo = new CicloEscolar();
        java.text.SimpleDateFormat formato = new java.text.SimpleDateFormat("dd-MM-yyyy");

        String[] columNames = {"Clave","Periodo","Tipo","Inicio","Fin","Activo","Parcial1","Parcial2","Parcial3"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);
          
          for (int i=0; i<lstCiclos.size();i++) {
              ciclo = lstCiclos.get(i);
              modelo.addRow(new Object[] {
                ciclo.getIdCiclo(), 
                ciclo.getPeriodo(), 
                ciclo.getTipo(),
                formato.format(ciclo.getFechaInicial()), 
                formato.format(ciclo.getFechaFinal()), 
                msgActivo(ciclo.getActivo()),
                formato.format(ciclo.getFechaParcial1()),
                formato.format(ciclo.getFechaParcial2()),
                formato.format(ciclo.getFechaParcial3()) } ); 
              //System.out.println(ciclo.getFechaInicial());
              //System.out.println(formato.format(ciclo.getFechaInicial()));              
          }

          return modelo;

    }
    
    public DefaultComboBoxModel getComboCiclos(ArrayList<CicloEscolar> lista) throws SQLException {
        CicloEscolar ciclo = new CicloEscolar();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();        
          //modelo.setColumnIdentifiers(columNames);
        ciclo.setIdCiclo(0);
        ciclo.setPeriodo("Selecciona un ciclo escolar");
        modelo.addElement(ciclo);
        for (int i=0; i<lista.size();i++) {
          ciclo = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new CicloEscolar (ciclo.getIdCiclo(),ciclo.getPeriodo()));
          //  }
        }
          return modelo;
    }
    
    public int deleteCiclo(int id_ciclo) throws SQLException, ClassNotFoundException{
    sql = "{call delete_ciclo(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_ciclo);
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;      
    }

   
  private CicloEscolar rellenaCurso(ResultSet resultSet) throws SQLException {
    CicloEscolar ciclo = new CicloEscolar();
    ciclo.setIdCiclo(resultSet.getInt("id_ciclo"));
    ciclo.setPeriodo(resultSet.getString("periodo"));
    ciclo.setTipo(resultSet.getShort("tipo"));    
    ciclo.setFechaInicial(resultSet.getString("fecha_inicial"));
    ciclo.setFechaFinal(resultSet.getString("fecha_final"));
    ciclo.setActivo(resultSet.getString("activo"));        
    ciclo.setFechaParcial1(resultSet.getString("fecha_parcial1"));
    ciclo.setFechaParcial2(resultSet.getString("fecha_parcial2"));
    ciclo.setFechaParcial3(resultSet.getString("fecha_parcial3"));
    return ciclo;
   }
  
  private String msgActivo(String a) {
    if ("A".equals(a)) {
      return "Si";
    }else{
      return "No";
    }
  }
  
}