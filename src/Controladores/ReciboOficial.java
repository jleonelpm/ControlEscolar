/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.awt.*;
import java.awt.print.*;
import javax.swing.table.TableModel;
import Entidades.Recibo;

public class ReciboOficial implements Printable {
    
    private Recibo recibo;
    private TableModel partidas;
    
    public ReciboOficial(Recibo recibo, TableModel partidas){
        this.recibo = recibo;
        this.partidas = partidas;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws
            PrinterException {
        //Font font = new Font("Courier New", Font.PLAIN, 10);        
        Font font = new Font(Font.MONOSPACED, Font.PLAIN, 10);
        g.setFont(font);

        
        if (page > 0) { /* We have only one page, and 'page' is zero-based */
            return NO_SUCH_PAGE;
        }

        /* User (0,0) is typically outside the imageable area, so we must
         * translate by the X and Y values in the PageFormat to avoid clipping
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());

        /* Now we perform our rendering */
        g.drawString(recibo.getApepat(), 100, 100);
        g.drawString(recibo.getApemat(), 100, 110);
        g.drawString(recibo.getNombre(), 100, 120);        
        
        for (int i=0; i<partidas.getRowCount(); i++ ){
            String col1, col2, col3;                       
            
            col1 = partidas.getValueAt(i, 0).toString();
            col2 = String.format("%10.2f",Float.parseFloat(partidas.getValueAt(i, 1).toString()));
            col3 = String.format("%10.2f",Float.parseFloat(partidas.getValueAt(i, 2).toString()));
            
            int y = 120 + (i+1)*10; //Posición Y
            
            g.drawString(col1, 100, y);                    
            g.drawString(col2, 200, y);                    
            g.drawString(col3, 300, y);                                
            
        }

        return PAGE_EXISTS;
    }

    public String alinearDerecha(String cad, int size){
        int s,i;
        String nuevaCad="";
        s = size - cad.length();
        
        for (i=1; i<=s; i++){
            nuevaCad += "_";
        }
        
        nuevaCad += cad;
        
        return nuevaCad;
    }
    
}