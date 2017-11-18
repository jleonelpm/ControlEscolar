/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Inscripciones;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Last Develop
 */
public class ModeloEditarInscripcion extends AbstractTableModel {
private String []columnas;
private ArrayList<Inscripciones> lista=null;

    public ModeloEditarInscripcion(String[] columnas) {
        this.columnas = columnas;
        lista=new ArrayList<Inscripciones>();
    }

    

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inscripciones ins=this.lista.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return ins.getId_inscripcion();
            case 1:return ins.getAsignatura();
            case 2:return ins.getId_oferta_academica();
            
            
            default:return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
       Inscripciones oferta=(Inscripciones) this.lista.get(rowIndex);
        try{
            
            switch (columnIndex) {
                case 0: oferta.setId_inscripcion((Integer) aValue);
                break;
                case 1: oferta.setAsignatura((String) aValue);
                break;
                
               
                    
         
}
        fireTableCellUpdated(rowIndex, columnIndex);
        }
        catch(ClassCastException ex){
        ex.printStackTrace();
        }

    }
    public void addOfertaAcademica(Inscripciones oferta)
    {
       lista.add(oferta);
      int index=lista.size()-1;
      this.fireTableRowsInserted(index, index);
    }

    public ArrayList<Inscripciones> getListaOfertaAcademica()
    {
     return this.lista;
    }
    
    public Inscripciones getElementoOfertaAcademica(int pos)
    {
        return lista.get(pos);
    }
    public void removeRow(int pos)
    {
        this.lista.remove(pos);
        fireTableRowsDeleted(pos,pos);
    }
    
}
