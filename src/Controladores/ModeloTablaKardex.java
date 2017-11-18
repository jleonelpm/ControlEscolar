/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Entidades.Kardex;
import Entidades.OfertaAcademica;

/**
 *
 * @author Last Develop
 */
public class ModeloTablaKardex extends AbstractTableModel{
private ArrayList<Kardex> listaKardex=new ArrayList<Kardex>();
private String[] columnas;

    public ModeloTablaKardex(String[] columnas) {
        this.columnas = columnas;
    }
    
    
    
    @Override
    public int getRowCount() {
       return listaKardex.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    public void agregarKardex(Kardex kardex)
{
      listaKardex.add(kardex);
      int index=listaKardex.size()-1;
      this.fireTableRowsInserted(index, index);
}
public ArrayList<Kardex> getListaKardex()
{
 return this.listaKardex;
}


    
    public void ofertaTokardex(ArrayList<OfertaAcademica> listaOferta,int id_alumno, int id_ciclo, int id_carrera)
    {
     for (int i=0;i<listaOferta.size();i++)
     {
            OfertaAcademica ofertaSeleccionada= listaOferta.get(i);
           int id_asignatura= ofertaSeleccionada.getIdAsignatura();
           int id_semestre=   ofertaSeleccionada.getAsignatura().getSemestre();
           int id_oferta=ofertaSeleccionada.getIdOfertaAcademica();
           
           String asignatura=ofertaSeleccionada.getAsignatura().getNombre();
           Kardex kardex=new Kardex();
           kardex.setSeleccionado(true);
           kardex.setId_kardex(0);
           kardex.setId_ciclo(id_ciclo);
           kardex.setId_alumno(id_alumno);
           kardex.setId_asignatura(id_asignatura);
           kardex.setId_personal(0);//Importante debe ser creado con la sesion o con la asignatura
           kardex.setId_oferta(id_oferta);
           kardex.setPromedio(0);
           kardex.setId_carrera(id_carrera);
           kardex.setId_acreditacion(0);
           kardex.setSemestre(ofertaSeleccionada.getAsignatura().getSemestre());
           kardex.setStatus("A");
           kardex.setNombreasignatura(asignatura);
           this.agregarKardex(kardex);
     }
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kardex kardex=this.listaKardex.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return kardex.isSeleccionado();
            case 1:return kardex.getNombreasignatura();
            case 2:return kardex.getPromedio();
           case 3:return kardex.getId_acreditacion();
            default:return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex)
        {
            case 0: return Boolean.class;
            case 1: return String.class;
            case 2: return Float.class;
            case 3: return Integer.class;
            default:return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0 || columnIndex==2||columnIndex==3)
            return true;
        else
            return false;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        Kardex kardex=(Kardex) listaKardex.get(rowIndex);
        try{
            
            switch (columnIndex) {
                
                case 0:
                    kardex.setSeleccionado((Boolean) aValue);
                    break;
                case 2:
                    kardex.setPromedio((Float) aValue);
                    break;
                case 3:
                    kardex.setId_acreditacion((Integer) aValue);
         
}
        fireTableCellUpdated(rowIndex, columnIndex);
        }
        catch(ClassCastException ex){
        ex.printStackTrace();
        }
    }
    
     public void addOfertaAcademica(Kardex oferta)
    {
       this.listaKardex.add(oferta);
      int index=this.listaKardex.size()-1;
      this.fireTableRowsInserted(index, index);
    }
    
}
