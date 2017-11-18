/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author leonel
 */
public class JCheckBoxCellRenderer extends JCheckBox implements TableCellRenderer {
  //protected JCheckBox checkBox;
  Border noFocusBorder;
  Border focusBorder;

  public JCheckBoxCellRenderer() {
      
    super();
    //checkBox = new JCheckBox();      
    setOpaque(true);
    setBorderPainted(true);
    setHorizontalAlignment(SwingConstants.CENTER);
    setVerticalAlignment(SwingConstants.CENTER);
  }
  

  public Component getTableCellRendererComponent(JTable table, Object value,
                                                 boolean isSelected,
                                                 boolean hasFocus,
                                                 int row, int column) {

      
      
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    }
    else {
      setForeground(table.getForeground());
      setBackground(table.getBackground());
    }

    if (hasFocus) {
      if (focusBorder == null) {
        focusBorder = UIManager.getBorder("Table.focusCellHighlightBorder");
      }
      setBorder(focusBorder);
    }
    else {
      if (noFocusBorder == null) {
        noFocusBorder = new EmptyBorder(1, 1, 1, 1);
      }
      setBorder(noFocusBorder);
    }
    if (value instanceof Boolean) {
        setSelected(((Boolean)value).booleanValue());
    }else if (value instanceof String){
        if ("S".equals(value)){
            setSelected(true);
        }else{
            setSelected(false);
        }
    }
    //setSelected(Boolean.TRUE.equals(value));
    //setSelected((value != null && ((Boolean) value).booleanValue()));

    return this;
  }
  
  public Object getCellEditorValue() {  
    //return Boolean.valueOf(checkBox.isSelected());  
    return Boolean.valueOf(isSelected());
  }    
} 
