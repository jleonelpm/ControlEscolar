/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.OfertaAcademica;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Last Develop
 */
public class ModeloOfertaAsignaturas extends AbstractTableModel{
    private ArrayList<OfertaAcademica> listaoferta=new ArrayList<OfertaAcademica>();
    private String []columnas;

    public ModeloOfertaAsignaturas(String[] columnas) {
        this.columnas = columnas;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
         OfertaAcademica oferta=(OfertaAcademica) listaoferta.get(rowIndex);
        try{
            
            switch (columnIndex) {
                case 0: oferta.setSeleccionado ((Boolean) aValue);
                break;
                case 1: oferta.getAsignatura().setClave((String) aValue);
                break;
                case 2:
                    oferta.getAsignatura().setNombre((String) aValue);
                    break;
               
                    
         
}
        fireTableCellUpdated(rowIndex, columnIndex);
        }
        catch(ClassCastException ex){
        ex.printStackTrace();
        }
        
    }
    
    


    @Override
    public int getRowCount() {
        return listaoferta.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
     OfertaAcademica ofertaacademica=this.listaoferta.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return ofertaacademica.isSeleccionado();
            case 1:return ofertaacademica.getAsignatura().getClave();
            case 2:return ofertaacademica.getAsignatura().getNombre();
            case 3:return ofertaacademica.getAsignatura().getCreditos();
            case 4: return ofertaacademica.getAsignatura().getSemestre();
            
            default:return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex)
        {
            case 0: return Boolean.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Short.class;
            case 4: return Short.class;
            default:return null;
        }
    }
@Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0)
        {
            
            return true;
            
        }
        else
            return false;
    }

 @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

   
    
    public void addOfertaAcademica(OfertaAcademica oferta)
    {
       listaoferta.add(oferta);
      int index=listaoferta.size()-1;
      this.fireTableRowsInserted(index, index);
    }

    public ArrayList<OfertaAcademica> getListaOfertaAcademica()
    {
     return this.listaoferta;
    }
    
    public OfertaAcademica getElementoOfertaAcademica(int pos)
    {
        return listaoferta.get(pos-1);
    }
    
    
    
}
