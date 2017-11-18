/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author leonel
 */

import javax.swing.JFrame;
import Formularios.frmSesion;
import Utilerias.Contenedor;

public class CE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        frmSesion frmsesion=new frmSesion(null,true);
        //frmsesion.setSize(500, 200);
        frmsesion.setLocationRelativeTo(null);
        
        


        frmsesion.setVisible(true);    }
}
