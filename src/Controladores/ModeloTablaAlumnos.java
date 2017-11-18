/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Alumnos;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Last Develop
 */
public class ModeloTablaAlumnos extends AbstractTableModel{

    private ArrayList<Alumnos> lista =new ArrayList<Alumnos>();
    private String [] columnas;

    public ModeloTablaAlumnos(String[] columnas) {
        this.columnas = columnas;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
         Alumnos oferta=(Alumnos) lista.get(rowIndex);
        try{
            
            switch (columnIndex) {
                case 0: oferta.setIdAlumno((Integer) aValue);
                break;
                case 1: oferta.setMatricula((String) aValue);
                break;
                case 2:
                    oferta.setApePaterno((String) aValue);
                    break;
                case 3:
                    oferta.setApeMaterno((String) aValue);
                    break;
                case 4:
                    oferta.setNombre((String) aValue);
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
        return this.lista.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Alumnos ofertaacademica=this.lista.get(rowIndex);
        switch(columnIndex)
        {
            case 0:return ofertaacademica.getIdAlumno();
            case 1:return ofertaacademica.getMatricula();
            case 2:return ofertaacademica.getApePaterno();
            case 3:return ofertaacademica.getApeMaterno();
            case 4: return ofertaacademica.getNombre();
            
            default:return null;
        }
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex)
        {
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return String.class;
            case 4: return String.class;
            default:return null;
        }
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        
            return false;
    }

 @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

   
    
    public void addAlumnoInscrito(Alumnos oferta)
    {
       lista.add(oferta);
      int index=lista.size()-1;
      this.fireTableRowsInserted(index, index);
    }

    public ArrayList<Alumnos> getListaInscritos()
    {
     return this.lista;
    }
    
    public Alumnos getAlumnoInscrito(int pos)
    {
        return lista.get(pos);
    }
    
    
}
