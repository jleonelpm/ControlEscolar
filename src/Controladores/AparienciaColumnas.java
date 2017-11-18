/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author Last Develop
 */
public class AparienciaColumnas extends JLabel implements TableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel etiqueta = new JLabel();
         if (isSelected) 
             etiqueta.setBackground (Color.DARK_GRAY);
         else
             etiqueta.setBackground (Color.ORANGE);

         if (value instanceof String)
         {
                 etiqueta.setOpaque(true);
                 etiqueta.setText((String)value);
         }
         
         /*if (value instanceof Float)
         {
             int valor = ((Float)value).intValue();
             if (valor < 0)
                etiqueta.setBackground(Color.WHITE);
             else
                 etiqueta.setBackground(Color.red);
             etiqueta.setToolTipText (Float.toString (valor));
         }*/
         
         return etiqueta;

    }

    

    
}
