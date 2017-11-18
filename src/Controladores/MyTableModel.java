/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author leonel
 * 
 * Esta clase se emplea para hacer que el JTable sea de solo lectura.
 */


public class MyTableModel extends DefaultTableModel { 
    
    public MyTableModel (Object [] [] data, Object [] columns) { 
        super (data, columns); 
    }
       
    @Override
    public boolean isCellEditable (int row, int column) { 
        return false; 
    }
}