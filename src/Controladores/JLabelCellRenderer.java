/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author leonel
 */
public class JLabelCellRenderer implements TableCellRenderer {


    
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,boolean hasFocus, int row, int column) {

        JLabel campoTexto;        
        NumberFormat formatter = new DecimalFormat("#,##0.00");
        
        campoTexto = new JLabel();
        campoTexto.setBorder(null);
        campoTexto.setHorizontalAlignment(SwingConstants.RIGHT);
        Double c = Double.parseDouble(value.toString());
        //campoTexto.setValue(new Double(value.toString()));
        //String t = campoTexto.getValue().toString();
        campoTexto.setText(formatter.format(c));            

        
        
        //campoTexto.setBorder(BorderFactory.createEmptyBorder()); 
        //NumberFormat formatter = new DecimalFormat("#0.000");          
        //campoTexto.setValue(new Float(value));        
                
        return campoTexto;
        
    }
    
}
