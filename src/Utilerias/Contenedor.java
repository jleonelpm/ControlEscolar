/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

/**
 *
 * @author Last Develop
 */
public class Contenedor extends Container {
    
public ImageIcon icono ;

    public Contenedor() {
        String ruta=System.getProperty("user.dir");
        String archivo=ruta+"\\src\\Imagenes\\fondo1.jpg";
        icono=new ImageIcon(archivo);
    }


// Redefinición del método paint()
    @Override
 public void paint (Graphics g)
 {
// Borramos todo y lo pintamos del color de fondo por defecto.
 Rectangle r = g.getClipBounds();
 g.setColor(this.getBackground());
 g.fillRect (r.x, r.y, r.width, r.height);

// Pintamos la imagen
 g.drawImage (icono.getImage(), 0,0,this);

// Hacemos que se pinten los botones dentro de este contenedor
 super.paint(g);
 }
    
}
