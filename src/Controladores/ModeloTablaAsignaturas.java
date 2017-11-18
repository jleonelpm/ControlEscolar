/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Last Develop
 */
public class ModeloTablaAsignaturas extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int col) {
        boolean editar=false;
         
           if((col==0) || (col==5)){
                editar=true;
            }
        
        return editar;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        super.setValueAt(aValue, row, column);
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        //4 es el indice de la columna del check
            if (columnIndex == 0) {
                return Boolean.class;
            } else {
                return super.getColumnClass(columnIndex);
            }

    }
    
    
}
