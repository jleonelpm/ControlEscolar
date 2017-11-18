/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Carreras;
import Entidades.CicloEscolar;
import Entidades.Grupos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Last Develop
 */
public class ctrlGruposHistorialAcademico extends ctrlGrupos{
    
    public ArrayList<Grupos> getGruposporCiclo(int id_ciclo) throws SQLException, ClassNotFoundException
    {
      ArrayList<Grupos> grupos = new ArrayList<Grupos>();    
    Grupos grupo;
    ResultSet rs;    
    sql = "{call get_grupos_historial_academico(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_ciclo);//Si es de primer semestre o mayores a primersemestre //inscripcion o reinscripcion
    rs = cs.executeQuery();
    while (rs.next()) {
      grupo =this.rellenaGrupoInscripciones(rs);
      grupos.add(grupo);
    }
    cs.close();
    db.Desconectar();
    return grupos;
    }
     /*RELLENAR GRUPOS PARA ofertar en un ciclo determinado*/
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
}
