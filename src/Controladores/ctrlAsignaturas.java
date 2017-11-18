/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import Entidades.Areas;
import Entidades.Asignaturas;
import Entidades.Carreras;
import Entidades.Modulos;
import Entidades.OfertaAcademica;
import Entidades.Planes;

/**
 *
 * @author leonel
 */
public class ctrlAsignaturas {

    Mysql db;
    String sql = "";
    PreparedStatement cs = null;

    public ctrlAsignaturas() {
        db = new Mysql();
    }

    public int setAsignatura(Asignaturas asignatura) throws SQLException, ClassNotFoundException {
        sql = "{call set_asignatura(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, asignatura.getIdAsignatura());
        cs.setString(2, asignatura.getClave());
        cs.setShort(3, asignatura.getSemestre());
        cs.setString(4, asignatura.getNombre());
        cs.setString(5, asignatura.getDescripcion());
        cs.setShort(6, asignatura.getCreditos());
        cs.setShort(7, asignatura.getHoras());
        cs.setShort(8, asignatura.getComponente());
        cs.setInt(9, asignatura.getIdCarrera());
        cs.setString(10, asignatura.getEstado());
        cs.setInt(11, asignatura.getIdPlan());
        cs.setInt(12, asignatura.getIdArea());
        cs.setString(13, asignatura.getOpcional());
        cs.setString(14, asignatura.getModulo());
        cs.setInt(15, asignatura.getIdModulo());
        cs.setShort(16, asignatura.getCantidadUnidades());
        cs.setFloat(17, asignatura.getCoeficientePonderacion());

        int r = cs.executeUpdate();
        cs.close();
        db.Desconectar();
        return r;  //Retorna 0 (cero) si no fue realizada la operación
    }

    public ArrayList<Asignaturas> getAsignaturas(int id_asignatura, int id_carrera, int id_plan, int id_area, int opcion) throws SQLException, ClassNotFoundException {
        ArrayList<Asignaturas> Asignaturas = new ArrayList<Asignaturas>();
        Asignaturas asignatura;
        ResultSet rs;
        sql = "{call get_asignaturas(?,?,?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, id_asignatura);
        cs.setInt(2, id_carrera);
        cs.setInt(3, id_plan);
        cs.setInt(4, id_area);
        cs.setInt(5, opcion);        
        rs = cs.executeQuery();
        while (rs.next()) {
            asignatura = rellenaAsignatura(rs);
            Asignaturas.add(asignatura);
        }
        cs.close();
        db.Desconectar();
        return Asignaturas;
    }
    
    public ArrayList<Asignaturas> getAsignaturas(int id_carrera, int semestre) throws SQLException, ClassNotFoundException {
        ArrayList<Asignaturas> Asignaturas = new ArrayList<Asignaturas>();
        Asignaturas asignatura;
        ResultSet rs;
        sql = "{call get_asignaturas_ofertar(?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, id_carrera);
        cs.setInt(2, semestre);
        rs = cs.executeQuery();
        while (rs.next()) {
            asignatura = rellenaAsignatura(rs);
            Asignaturas.add(asignatura);
        }
        cs.close();
        db.Desconectar();
        return Asignaturas;
    }
    

    public DefaultTableModel getAsignaturas(ArrayList<Asignaturas> lstAsignaturas) throws SQLException {
        Asignaturas asignatura = new Asignaturas();

        String[] columNames = {"IdAsignatura", "Plan", "Componente","Clave", "Nombre", "Semestre", "Carrera", "Area"};

        // se colocan los datos en la tabla
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.setColumnIdentifiers(columNames);

        for (int i = 0; i < lstAsignaturas.size(); i++) {
            asignatura = lstAsignaturas.get(i);
            
            String componente = "";
            
            if (asignatura.getComponente()==1){
                componente = "Formación Básica";
            }else if (asignatura.getComponente()==2){
                componente = "Formación Propedéutica";
            }else if (asignatura.getComponente()==3){
                componente = "Formación Profesional";
            }
            
            
            modelo.addRow(new Object[]{
                        asignatura.getIdAsignatura(),
                        asignatura.getPlan().getDescripcion(),
                        componente,
                        asignatura.getClave(),
                        asignatura.getNombre(),
                        asignatura.getSemestre(),
                        asignatura.getCarrera().getNombre(),
                        asignatura.getArea().getDescripcion()
                    });

        }
        return modelo;
    }

    //Genera un Combo Model con información de Grupo, Carrera y Generación
    public DefaultListModel getListAsignaturas(ArrayList<Asignaturas> lista) throws SQLException {
        Asignaturas asignatura = new Asignaturas();
        //Object[] m = lista.toArray();
        DefaultListModel modelo = new DefaultListModel();
        //modelo.addElement(m);
        //modelo.setColumnIdentifiers(columNames);
        for (int i = 0; i < lista.size(); i++) {
            asignatura = lista.get(i);
            //modelo.addElement(lista.get(i).getNombre());
            modelo.addElement(new Asignaturas(asignatura.getIdAsignatura(), asignatura.getNombre()));
        }
        return modelo;
    }

    public int deleteAsignatura(int id_asignatura) throws SQLException, ClassNotFoundException {
        sql = "{call delete_asignatura(?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, id_asignatura);
        int r = cs.executeUpdate();
        cs.close();
        db.Desconectar();
        return r;
    }

    private Asignaturas rellenaAsignatura(ResultSet resultSet) throws SQLException {
        Asignaturas asignatura = new Asignaturas();
        Carreras carrera = new Carreras();
        Planes plan = new Planes();
        Areas area = new Areas();
        Modulos modulo = new Modulos();

        asignatura.setIdAsignatura(resultSet.getInt("id_asignatura"));
        asignatura.setClave(resultSet.getString("clave"));
        asignatura.setSemestre(resultSet.getShort("semestre"));
        asignatura.setNombre(resultSet.getString("nombre"));
        asignatura.setDescripcion(resultSet.getString("descripcion"));
        asignatura.setCreditos(resultSet.getShort("creditos"));
        asignatura.setHoras(resultSet.getShort("horas"));
        asignatura.setComponente(resultSet.getShort("componente"));

        asignatura.setIdCarrera(resultSet.getInt("id_carrera"));
        carrera.setNombre(resultSet.getString("carrera"));
        asignatura.setCarrera(carrera);

        asignatura.setEstado(resultSet.getString("estado"));


        asignatura.setIdPlan(resultSet.getInt("id_plan"));
        plan.setDescripcion(resultSet.getString("plan"));
        asignatura.setPlan(plan);

        asignatura.setIdArea(resultSet.getInt("id_area"));
        area.setDescripcion(resultSet.getString("area"));
        asignatura.setArea(area);

        asignatura.setOpcional(resultSet.getString("opcional"));

        asignatura.setModulo(resultSet.getString("modulo"));
        asignatura.setIdModulo(resultSet.getInt("id_modulo"));
        modulo.setDescripcion(resultSet.getString("descripcion_modulo"));
        asignatura.setObjModulo(modulo);
        asignatura.setCantidadUnidades(resultSet.getShort("cantidad_unidades"));
        asignatura.setCoeficientePonderacion(resultSet.getFloat("coeficiente_ponderacion"));

        return asignatura;
    }

    /*ESTE METODO ME SIRVE PARA CREAR EL KARDEX*/
    public ArrayList<Asignaturas> getAsignaturasKardex(int id_carrera, int id_plan, int semestre) throws SQLException, ClassNotFoundException {
        ArrayList<Asignaturas> Asignaturas = new ArrayList<Asignaturas>();
        Asignaturas asignatura;
        ResultSet rs;
        sql = "{call get_asignaturas_semestre(?,?,?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);

        cs.setInt(1, id_carrera);
        cs.setInt(2, id_plan);
        cs.setInt(3, semestre);
        rs = cs.executeQuery();
        while (rs.next()) {
            //System.out.println("Entro en el ciclo del while");
            asignatura = rellenaAsignaturaCursada(rs);
            Asignaturas.add(asignatura);
        }
        cs.close();
        db.Desconectar();
        return Asignaturas;
    }

    /*******************13.02-12 ME SIRVE EN CALIFICACIONES*********************/
    /***************************VERIFCAR ESTE M�TODO QUE CARGA LAS ASIGNATURAS**/
    public ArrayList<Asignaturas> getAsignaturas(int id_grupo_ciclo) throws SQLException, ClassNotFoundException {
        ArrayList<Asignaturas> Asignaturas = new ArrayList<Asignaturas>();
        Asignaturas asignatura;
        ResultSet rs;
        sql = "{call get_asignaturas_grupo(?)}";
        db.Conectar();
        cs = db.conexion.prepareStatement(sql);
        cs.setInt(1, id_grupo_ciclo);

        rs = cs.executeQuery();
        while (rs.next()) {
            asignatura = this.rellenaAsignaturaCalificar(rs);
            Asignaturas.add(asignatura);
        }
        cs.close();
        db.Desconectar();
        return Asignaturas;
    }

    /****************METODO COMBO PARA CALIFICACIONES*************************************/
    public DefaultComboBoxModel getComboGrupos(ArrayList<Asignaturas> lista) throws SQLException {
        Asignaturas asignatura = new Asignaturas();
        //Object[] m = lista.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        //modelo.addElement(m);
        //modelo.setColumnIdentifiers(columNames);
        if (lista != null) {
            asignatura.setIdAsignatura(0);

            asignatura.setNombre("Selecciona una Asignatura");
            asignatura.setOfertaacademica(null);
            modelo.addElement(asignatura);
            for (int i = 0; i < lista.size(); i++) {
                asignatura = lista.get(i);
                //modelo.addElement(lista.get(i).getNombre());
                modelo.addElement(new Asignaturas(asignatura.getIdAsignatura(), asignatura.getClave(), asignatura.getNombre(), asignatura.getOfertaacademica()));
            }
        } else {
            modelo = null;
        }
        return modelo;
    }

    public DefaultTableModel seleccionarAsignaturas(ArrayList<Asignaturas> lstAsignaturas) throws SQLException {
        Asignaturas asignatura = new Asignaturas();

        //String[] columNames = {"Cargar","Clave","Nombre","Semestre", "Cred", "Hrs", "Categor�a", "Carrera", "Plan", "Area"};  
        String[] columNames = {"Cargar", "Id Plan", "Id Carrera", "Id Asignatura", "Semestre", "Clave", "Nombre"};
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new ModeloTablaAsignaturas();
        modelo.setColumnIdentifiers(columNames);
        if (lstAsignaturas != null) {
            for (int i = 0; i < lstAsignaturas.size(); i++) {

                asignatura = lstAsignaturas.get(i);
                modelo.addRow(new Object[]{true,
                            asignatura.getIdPlan(),
                            asignatura.getIdCarrera(),
                            asignatura.getIdAsignatura(),
                            asignatura.getSemestre(),
                            asignatura.getClave(),
                            asignatura.getNombre()});

            }
        }



        return modelo;
    }

    public DefaultTableModel AsignaturasKardex(ArrayList<Asignaturas> lstAsignaturas) throws SQLException {
        Asignaturas asignatura = new Asignaturas();

        //String[] columNames = {"Cargar","Clave","Nombre","Semestre", "Cred", "Hrs", "Categor�a", "Carrera", "Plan", "Area"};  
        String[] columNames = {"Cargar", "Id Asignatura", "Semestre", "Clave", "Nombre", "Promedio"};
        // se colocan los datos en la tabla
        DefaultTableModel modelo = new ModeloTablaAsignaturas();
        modelo.setColumnIdentifiers(columNames);
        if (lstAsignaturas != null) {
            for (int i = 0; i < lstAsignaturas.size(); i++) {

                asignatura = lstAsignaturas.get(i);
                modelo.addRow(new Object[]{true,
                            asignatura.getIdAsignatura(),
                            asignatura.getSemestre(),
                            asignatura.getClave(),
                            asignatura.getNombre(), ""});

            }
        }



        return modelo;
    }

    private Asignaturas rellenaAsignaturaCursada(ResultSet resultSet) throws SQLException {

        Asignaturas asignatura = new Asignaturas();



        asignatura.setIdAsignatura(resultSet.getInt("id_asignatura"));

        asignatura.setIdPlan(resultSet.getInt("id_plan"));

        asignatura.setIdCarrera(resultSet.getInt("id_carrera"));
        asignatura.setSemestre(resultSet.getShort("semestre"));
        asignatura.setNombre(resultSet.getString("nombre"));
        asignatura.setCreditos(resultSet.getShort("creditos"));
        asignatura.setHoras(resultSet.getShort("horas"));
        asignatura.setClave(resultSet.getString("clave"));
        asignatura.setComponente(resultSet.getShort("componente"));

//System.out.println(asignatura.getIdAsignatura()+"-"+ asignatura.getIdCarrera()+"-"+asignatura.getIdPlan()+"-"+asignatura.getSemestre()
        //      +"-"+asignatura.getComponente()+"-"+asignatura.getHoras()+"-"+asignatura.getClave());







        return asignatura;
    }

    private Asignaturas rellenaAsignaturaCalificar(ResultSet resultSet) throws SQLException {

        Asignaturas asignatura = new Asignaturas();



        asignatura.setIdAsignatura(resultSet.getInt("id_asignatura"));

        asignatura.setNombre(resultSet.getString("nombre"));
        asignatura.setClave(resultSet.getString("clave"));

        OfertaAcademica oferta = new OfertaAcademica();
        oferta.setIdAsignatura(resultSet.getInt("id_asignatura"));
        oferta.setIdGrupo(resultSet.getInt("id_grupo"));
        oferta.setIdOfertaAcademica(resultSet.getInt("id_oferta_academica"));
        oferta.setIdPersonal(resultSet.getInt("id_personal"));
        asignatura.setOfertaacademica(oferta);

        return asignatura;
    }
}