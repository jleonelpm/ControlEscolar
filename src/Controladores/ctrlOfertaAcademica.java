/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;
import java.sql.*;
import java.util.ArrayList;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import Entidades.*;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author leonel
 */
public class ctrlOfertaAcademica {
  
  Mysql db;
  String sql = "";
  PreparedStatement cs =  null;
  
  
  
  public ctrlOfertaAcademica(){
    db = new Mysql();    
  }
  
  public int setOfertaAcademica(OfertaAcademica oferta, int opcion) throws SQLException, ClassNotFoundException {    
    sql = "{call set_oferta_academica(?,?,?,?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, oferta.getIdOfertaAcademica());    
    cs.setInt(2, oferta.getIdGrupo());
    cs.setInt(3, oferta.getIdAsignatura());
    cs.setInt(4, oferta.getIdPersonal());    
    cs.setInt(5, opcion);

    int r = cs.executeUpdate();
    cs.close();
    //db.Desconectar();
    return r;  //Retorna 0 (cero) si no fue realizada la operación
  }
  
  
  public boolean setOfertaAcademica(TableModel tabla) throws SQLException, ClassNotFoundException{
      boolean band = true;
      db.Conectar();
      db.begin();
      for (int i=0; i<=tabla.getRowCount()-1; i++) {
          Object valor;
          valor = tabla.getValueAt(i, 4);
          if (valor != null) {
            //ctrlOfertaAcademica carga = new ctrlOfertaAcademica();          
            OfertaAcademica oferta = new OfertaAcademica(); 
            oferta.setIdOfertaAcademica(Integer.parseInt(tabla.getValueAt(i, 0).toString()));
            oferta.setIdGrupo(0);
            oferta.setIdAsignatura(0);
            oferta.setIdPersonal(Integer.parseInt(tabla.getValueAt(i, 4).toString()));
            int result = this.setOfertaAcademica(oferta, 1);
            if (result <= 0) {
              band = false;
              break;
            }// fin de if (result > 0)     
          //}
          } //fin de ¿Guardar los cambios?
      }  
      if (band){
          db.commit();
      }else{
          db.rollback();
      }
      db.Desconectar();        
    return band;
  }  
  public ArrayList<OfertaAcademica> getOfertaAcademica(int id_grupo, int opcion) throws SQLException, ClassNotFoundException {
    ArrayList<OfertaAcademica> ofertas = new ArrayList<OfertaAcademica>();    
    OfertaAcademica oferta;
    ResultSet rs;    
    sql = "{call get_oferta_academica(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_grupo);
    cs.setInt(2, opcion);    
    rs = cs.executeQuery();
    while (rs.next()) {
      oferta = rellenaOfertaAcademica(rs);
      ofertas.add(oferta);
    }
    cs.close();
    db.Desconectar();
    return ofertas;
  }
  
  public Object [][] getCargaAcademicaDocentes() throws SQLException, ClassNotFoundException{
    Object[][] carga_academica=null;      
    ResultSet rs;    
    sql = "{call get_carga_academica_docentes()}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    rs = cs.executeQuery();
    rs.last();                  
    int registros = rs.getRow(); //Cantidad de Registros o filas que aparecen en la tabla.
    if (registros > 0) {
        carga_academica = new String[registros][7];           
        rs.first();
        int i = 0;    
        carga_academica[i][0] = rs.getString("id_oferta_academica");
        
        if (rs.getInt("id_carrera")==0) {
            carga_academica[i][1] = "BACHILLERATO TECNOLOGICO";
        }else{
            carga_academica[i][1] = rs.getString("carrera");
        }

        carga_academica[i][2] = rs.getString("grupo");
        carga_academica[i][3] = rs.getString("asignatura");
        carga_academica[i][4] = rs.getString("id_personal");        
        carga_academica[i][5] = rs.getString("docente");
        carga_academica[i][6] = "...";
        i++;
        while (i<registros) {
            rs.next();
            carga_academica[i][0] = rs.getString("id_oferta_academica");
            
            if (rs.getInt("id_carrera")==0) {
                carga_academica[i][1] = "BACHILLERATO TECNOLOGICO";
            }else{
                carga_academica[i][1] = rs.getString("carrera");
            }

            carga_academica[i][2] = rs.getString("grupo");
            carga_academica[i][3] = rs.getString("asignatura");
            carga_academica[i][4] = rs.getString("id_personal");        
            carga_academica[i][5] = rs.getString("docente");
            carga_academica[i][6] = "...";
            i++;
        }
    }
    cs.close();
    db.Desconectar();
    return carga_academica;      
  }
      
    public DefaultTableModel getOfertaAcademica(ArrayList<OfertaAcademica> lstOfertaAcademica) throws SQLException {
        OfertaAcademica oferta = new OfertaAcademica();         

        String[] columNames = {"Id","idGrupo", "Asignatura / Módulo", "Personal"};  
               
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
          modelo.setColumnIdentifiers(columNames);

          for (int i=0; i<lstOfertaAcademica.size();i++) {
              oferta = lstOfertaAcademica.get(i);
              modelo.addRow(new Object[] {
                oferta.getIdOfertaAcademica(),
                oferta.getIdGrupo(),                
                oferta.getAsignatura().getNombre(),
                oferta.getPersonal().getNombre()});
          }
          return modelo;
    }
    
    //Genera un Combo Model con información de Grupo, Carrera y Generación
    public DefaultListModel getListOfertaAcademica(ArrayList<OfertaAcademica> lista) throws SQLException {
        OfertaAcademica oferta = new OfertaAcademica();
        //Object[] m = lista.toArray();
        DefaultListModel modelo = new DefaultListModel();    
        //modelo.addElement(m);
         //modelo.setColumnIdentifiers(columNames);
        for (int i=0; i<lista.size();i++) {
          oferta = lista.get(i);
          //modelo.addElement(lista.get(i).getNombre());
          modelo.addElement(new OfertaAcademica (oferta.getIdOfertaAcademica(), oferta.getAsignatura()));
        }
        return modelo;
    }
    
    
  public int deleteOfertaAcademica(int id_oferta_academica) throws SQLException, ClassNotFoundException {    
    sql = "{call delete_oferta_academica(?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_oferta_academica);
    int r = cs.executeUpdate();
    cs.close(); 
    db.Desconectar();
    return r;
  }
 
  //Eliminar este método
  private OfertaAcademica rellenaOfertaAcademica(ResultSet resultSet, int prueba) throws SQLException {
    OfertaAcademica oferta = new OfertaAcademica();
    Asignaturas asignatura = new Asignaturas();   
    
    oferta.setIdOfertaAcademica(resultSet.getInt("id_oferta_academica"));
    
    //oferta.setIdGrupoCiclo(resultSet.getInt("id_grupo_ciclo"));
    //grupo.se.setNombre(resultSet.getString("carrera"));
    //oferta.setCarrera(grupo);
    
    oferta.setIdAsignatura(resultSet.getInt("id_asignatura"));        
    asignatura.setNombre(resultSet.getString("asignatura"));    
    oferta.setAsignatura(asignatura);

    //El nombre del docente se almacena en la BD como:
    //Apellido paterno, materno y nombre.
    //Aquí se muestra en un solo campo todo el nombre del docente.
    
//    oferta.setIdPersonal(resultSet.getInt("id_personal"));
//    personal.setNombre(resultSet.getString("docente"));
//    oferta.setPersonal(personal);
        
    return oferta;
   }
  
 private OfertaAcademica rellenaOfertaAcademica(ResultSet resultSet) throws SQLException {
    OfertaAcademica oferta = new OfertaAcademica();
    Asignaturas asignatura = new Asignaturas();   
    
    oferta.setIdOfertaAcademica(resultSet.getInt("id_oferta_academica"));
    
    //oferta.setIdGrupoCiclo(resultSet.getInt("id_grupo_ciclo"));
    //grupo.se.setNombre(resultSet.getString("carrera"));
    //oferta.setCarrera(grupo);
    
    oferta.setIdAsignatura(resultSet.getInt("id_asignatura"));     
    asignatura.setIdAsignatura(resultSet.getInt("id_asignatura"));
    asignatura.setNombre(resultSet.getString("asignatura"));   
    asignatura.setClave(resultSet.getString("clave"));
    asignatura.setCreditos(resultSet.getShort("creditos"));
    asignatura.setSemestre(resultSet.getShort("semestre"));
    asignatura.setModulo(resultSet.getString("modulo"));
    /*EL CAMPO MÓDULO SIRVE PARA INDICAR QUE TIPO DE ASIGNATURA ES SI CORRESPONDE A UN MODULO O
     ES UN ASIGNATURA DEL PLAN*/
    
    
    
    oferta.setAsignatura(asignatura);

    //El nombre del docente se almacena en la BD como:
    //Apellido paterno, materno y nombre.
    //Aquí se muestra en un solo campo todo el nombre del docente.
    
//    oferta.setIdPersonal(resultSet.getInt("id_personal"));
//    personal.setNombre(resultSet.getString("docente"));
//    oferta.setPersonal(personal);
        
    return oferta;
   }
 
  /*Método para asignar la carga académica a la Tabla de inscripciones*/
  
  public ModeloOfertaAsignaturas getOfertaInscripcion(ArrayList<OfertaAcademica> listaoferta)
  {
      String []columnas={"Seleccionar","Clave","Asignatura","Creditos","Semestre"};
   ModeloOfertaAsignaturas modelo=new ModeloOfertaAsignaturas(columnas);
   for(int i=0;i<listaoferta.size();i++)
   {
       //System.out.println(listaoferta.get(i).getAsignatura().getNombre());
       listaoferta.get(i).setSeleccionado(true); //Para que este seleccionado la asignatura oferta academica
    modelo.addOfertaAcademica(listaoferta.get(i));
   }
   return modelo;
  }
  
  /*Traer la carga academica con las asignaturas del grupo y las de recursamiento
   *mañana debo empezar aqui.....
   */
  public ArrayList<OfertaAcademica> getOfertaAcademica(Grupos grupo,int id_alumno,int asignaturas_reprobadas,int modulos_reprobadas) throws SQLException, ClassNotFoundException 
  {
    ArrayList<OfertaAcademica> ofertas = new ArrayList<OfertaAcademica>();    
    OfertaAcademica oferta;
    ResultSet rs;    
    sql = "{call get_oferta_academica(?,?)}"; /*Traemos la ofertaAcademica del grupo que le corresponde*/
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, grupo.getIdGrupo());
   cs.setInt(2, 1); 
    rs = cs.executeQuery();
    while (rs.next()) {
      oferta = rellenaOfertaAcademica(rs);
      ofertas.add(oferta);
    }
    cs.close();
    db.Desconectar();
    
    
    
     /*Ver si esta asignatura esta en la oferta academica*/
     ArrayList<OfertaAcademica> listaofertagrupo=ofertas;
     
     
      ArrayList<Asignaturas> listaasignaturasReprobadas=new ArrayList<Asignaturas>();
       
      
        if(asignaturas_reprobadas>0)
        {
            listaasignaturasReprobadas=  this.getListaAsignaturasReprobadas(grupo.getIdGrupo(), id_alumno,1);
            listaofertagrupo=this.getActualizarOfertAcademica(listaofertagrupo, listaasignaturasReprobadas);//Validamos que las reprobadas no estan o si estan en la oferta
        }
        if(modulos_reprobadas>0)
        {
            listaasignaturasReprobadas=  this.getListaAsignaturasReprobadas(grupo.getIdGrupo(), id_alumno,2); //Traemos modulos y submodulos repronados
            listaofertagrupo=this.getActualizarOfertAcademica(listaofertagrupo, listaasignaturasReprobadas); //Actualizamos la oferta
        }
     /*Buscamos mas oferta de reprobadas en la ofertaacademica, pero no debe ser del grupo, pero si del ciclo activo*/
     
     ctrlCicloEscolar ctrlcicloescolar=new ctrlCicloEscolar();
     CicloEscolar cicloescolar=  ctrlcicloescolar.getCicloActivo();
     cicloescolar=ctrlcicloescolar.getCicloActivo();
    
     ArrayList<OfertaAcademica> ofertas_ciclo = new ArrayList<OfertaAcademica>();    
    
    sql = "{call get_oferta_reprobadas(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, grupo.getIdGrupo());
    cs.setInt(2, cicloescolar.getIdCiclo());    
    rs = cs.executeQuery();
    while (rs.next()) {
      oferta = rellenaOfertaAcademica(rs);
      ofertas_ciclo.add(oferta);
    }
    cs.close();
    db.Desconectar();
     
    for(int i=0;i<ofertas_ciclo.size();i++) //La agregamos para recursamiento
    {
        for(int j=0;j<listaasignaturasReprobadas.size();j++ )
      if(ofertas_ciclo.get(i).getAsignatura().getIdAsignatura()==listaasignaturasReprobadas.get(j).getIdAsignatura())
      {
          ofertas_ciclo.get(i).setRecursamiento("S");
          listaofertagrupo.add(ofertas_ciclo.get(i));
      }
    }
    
    
    
    
    return ofertas;
  }
  
  /*Oferta Academica de reprobadas que se ofertan y puede recursar*/
  private ArrayList<Asignaturas> getListaAsignaturasReprobadas(int id_grupo,int id_alumno,int opcion) throws SQLException, ClassNotFoundException
  {
     
     ctrlKardex ctrlkardex=new ctrlKardex();
     
     ArrayList<Asignaturas> listaasignaturas= ctrlkardex.getAsignaturasReprobadas(id_alumno, opcion);
        return listaasignaturas;
  }
  
  
  private ArrayList<OfertaAcademica> getActualizarOfertAcademica(ArrayList<OfertaAcademica> listaofertagrupo,ArrayList<Asignaturas> listaasignaturas)
  {
      for(int j=0;j<listaasignaturas.size();j++)
    {
     for(int i=0;i<listaofertagrupo.size();i++) //La oferta debe ser Repetidor si el Id_asignatura es igual al de la oferta
     {
         if(listaofertagrupo.get(i).getIdAsignatura()==listaasignaturas.get(j).getIdAsignatura())
         {
            listaofertagrupo.get(i).setRecursamiento("S");
          
         } //La asignatura es de recursamiento
         else
         {
          listaofertagrupo.get(i).setRecursamiento("N");//La asignatura no es recursamiento...
          
         }
             
     }
    }//fin del for j
      return listaofertagrupo;
  
  }  
  
  /*28 DE JUNIO SE AGREGO ESTE METODO PARA CARGAR LAS ASIGNATURAS EN UN COMBOBOX*/
  
  public DefaultComboBoxModel getAsignaturasGrupo(ArrayList<OfertaAcademica> lista)
  {
  DefaultComboBoxModel dm=new DefaultComboBoxModel();
  OfertaAcademica oferta = new OfertaAcademica();
  oferta.setIdOfertaAcademica(0);
  Asignaturas as=new Asignaturas();
  as.setNombre("Seleccione una asignatura");
  oferta.setAsignatura(as);
  dm.addElement(as);
  for(int i=0;i<lista.size();i++)
  {
  dm.addElement(new OfertaAcademica( lista.get(i).getIdOfertaAcademica(), lista.get(i).getAsignatura()));
  }
  return dm;
  
   
  }
  
  /*ESTE METODO SIRVE PARA OBTENER EL PERSONAL QUE IMPARTE UNA ASIGNATURA ESPECIFICADA
   POR SU GRUPO Y ASIGNATURA*/
  
  public Personal getPersonalAsignatura(int id_grupo,int id_asignatura) throws SQLException, ClassNotFoundException
  {
      ResultSet rs;
    sql = "{call get_profesor_asignatura(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_grupo);
    cs.setInt(2, id_asignatura);    
    rs = cs.executeQuery();
    int id_personal=0;
    while (rs.next()) {
      id_personal= rs.getInt("id_personal");
    }
    
    ctrlPersonal ctrlpersonal=new ctrlPersonal();
    Personal persona=new Personal();
  if(id_personal!=0)
  {
    persona.setIdPersonal(id_personal);
    persona= ctrlpersonal.getProfesor(persona);
  }
  else
  {
   persona=null;
  }
    cs.close();
    db.Desconectar();
  return persona;
  }
  /*30 DE JULIO 2012 PARA TRAER ASIGNATURAS QUE SE PUEDEN ADELANTA O RECURSAR USA EM METODO GET_MAS_OFERTA_aCADEMICA*/
  
  
  public ArrayList<OfertaAcademica> getMasOfertaAcademica(int id_alumno) throws SQLException, ClassNotFoundException {
    ArrayList<OfertaAcademica> ofertas = new ArrayList<OfertaAcademica>();    
    OfertaAcademica oferta;
    ResultSet rs;    
    ctrlCicloEscolar ctrlciclo=new ctrlCicloEscolar();
    CicloEscolar c=    ctrlciclo.getCicloActivo();
    sql = "{call get_mas_oferta_academica(?,?)}";
    db.Conectar();
    cs = db.conexion.prepareStatement(sql);
    cs.setInt(1, id_alumno);
    cs.setInt(2, c.getIdCiclo());    
    rs = cs.executeQuery();
    while (rs.next()) {
      oferta = rellenaOfertaAcademica(rs);
      ofertas.add(oferta);
    }
    cs.close();
    db.Desconectar();
    return ofertas;
  }
  
 
}