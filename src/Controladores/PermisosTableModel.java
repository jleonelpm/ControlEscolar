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
public class PermisosTableModel extends DefaultTableModel {

    @Override
    public boolean isCellEditable(int row, int col) {
        //Desactivamos todas las celdas
        boolean editar=false;
        //Activamos las celdas de la columna 2
        if((col==2)){
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
        
        
        if (columnIndex == 2) {
            //Esta operación permite especificar la columna como booleana
            //Y automáticamente Java Genera un CheckBox
            return Boolean.class;
        } else {
            return super.getColumnClass(columnIndex);
        }

    }
    
    
}
