/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

/**
 *
 * @author Last Develop
 */
import java.awt.AlphaComposite;  
import java.awt.Color;  
import java.awt.Graphics2D;  
import java.awt.Image;
import java.awt.RenderingHints;  
import java.awt.image.BufferedImage;  
import java.io.File;  
import java.io.IOException;  
import javax.imageio.ImageIO;  

public class ImageUtils {  
private int ancho=95;
private int alto=114;
    /** 
17.     * Carga una variable BufferedImage desde un archivo tipo imagen 
18.     * 
19.     * @param pathname la ruta en el disco del archivo de la imagen 
20.     *  
21.     * @return BufferedImage con la imagen cargada desde el archivo 
22.     */  
   public static BufferedImage loadImage(String pathname) {  
        BufferedImage bufim = null;  
        try {  
            
           File f=new File(pathname);
                   if(f.exists())
                   {
                    bufim = ImageIO.read(new File(pathname));  
                   }
        } catch (Exception e) { 
            
            System.out.println(e.getMessage() +" -"+ pathname);
        }  
        return bufim;  
    }  
  
  public static Image setImageinImagePanel(String url, int alto, int ancho){
//Inicializamos nuestra variable.
  Image imagen = null;
  BufferedImage buf=ImageUtils.loadImage(url);
 //Obtenemos la imagen a partir de la url proporcionada.
  if(buf!=null)
  {
  
    imagen =ImageUtils.resize(buf, ancho,alto);
  }
//Obtenemos el ancho y alto del panel el caul no servira para redimen---
//sionar a la imagen.
 
 
 
 return imagen;
 }//Fin metodo: setImageinImagePanel.
 
    /** 
34.     * Redimensiona una imagen BufferedImage 
35.     * 
36.     * @param bufferedImage la imagen que se desea redimensionar 
37.     * @param newW el nuevo ancho que se desea redimensionar 
38.     * @param newH el nuevo alto que se desea redimensionar 
39.     * 
40.     * @return BufferedImage redimensionada 
41.     */  
    public static BufferedImage resize(BufferedImage bufferedImage, int newW, int newH) {  
        int w = bufferedImage.getWidth();  
       int h = bufferedImage.getHeight();  
       
       
        BufferedImage bufim = new BufferedImage(newW, newH, bufferedImage.getType());  
        Graphics2D g = bufim.createGraphics();  
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
       g.drawImage(bufferedImage, 0, 0, newW, newH, 0, 0, w, h, null);  
        g.dispose();  
        return bufim;  
    }  
  
    /** 
54.     * Rota una imagen BufferedImage 
55.     * 
56.     * @param bufferedImage la imagen que se desea rotar 
57.     * @param angle los grados que se desea rotar 
58.     * 
59.     * @return BufferedImage rotada 
60.     */  
    public static BufferedImage rotate(BufferedImage bufferedImage, int angle) {  
        int w = bufferedImage.getWidth();  
        int h = bufferedImage.getHeight();  
        BufferedImage bufim = new BufferedImage(w, h, bufferedImage.getType());  
        Graphics2D g = bufim.createGraphics();  
        g.rotate(Math.toRadians(angle), w / 2, h / 2);  
        g.drawImage(bufferedImage, null, 0, 0);  
        return bufim;  
   }  
    /** 
72.     * Guarda una BufferedImage al disco en formato ".png" o ".jpg" 
73.     * 
74.     * @param bufferedImage la imagen que se desea guardar 
75.     * @param pathname la ruta del archivo en el cual se desea guardar la imagen incluyendo el nombre del archivo y su formato 
76.     */  
  public static void saveImage(BufferedImage bufferedImage, String pathname) {  
        try {  
            String format = (pathname.endsWith(".png")) ? "png" : "jpg";  
            ImageIO.write(bufferedImage, format, new File(pathname));  
        } catch (IOException e) {  
        }  
    }  
  
    /** 
87.     * Le aplica la transparencia seleccionada a una BufferedImage 
88.     * 
89.     * @param bufferedImage la imagen que se desea hacer transparente algun color 
90.     * @param transparency variable tipo <code>float</code> entre el rango 0.0 - 1.0 que indica el porcentaje de transparencia 
91.     * 
92.     * @return BufferedImage con el porcentaje de transparencia seleccionada 
93.     */  
    public static BufferedImage makeTranslucentImage(BufferedImage bufferedImage, float transparency) {  
        BufferedImage bufim = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TRANSLUCENT);  
       Graphics2D g = bufim.createGraphics();  
        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency));  
        g.drawImage(bufferedImage, null, 0, 0);  
        g.dispose();  
       return bufim;  
    }  
  
    /** 
104.     * Hace que el color seleccionado sea transparente en un BufferedImage 
105.     * 
106.     * @param bufferedImage la imagen que se desea hacer transparente algun color 
107.     * @param color el color que se desea hacer transparente 
108.     * 
109.     * @return BufferedImage con el color seleccionado transparente 
110.     */  
   public static BufferedImage makeColorTransparent(BufferedImage bufferedImage, Color color) {  
        BufferedImage bufim = new BufferedImage(bufferedImage.getWidth(), bufferedImage.getHeight(), BufferedImage.TYPE_INT_ARGB);  
        Graphics2D g = bufim.createGraphics();  
        g.setComposite(AlphaComposite.Src);  
        g.drawImage(bufferedImage, null, 0, 0);  
        g.dispose();  
        for (int i = 0; i < bufim.getHeight(); i++) {  
            for (int j = 0; j < bufim.getWidth(); j++) {  
                if (bufim.getRGB(j, i) == color.getRGB()) {  
                    bufim.setRGB(j, i, 0x8F1C1C);  
               }  
            }  
       }  
        return bufim;  
   }  
  
    /** 
128.     * Corta una BufferedImage en filas y/o columnas del mismo tamaño 
129.     * 
130.     * @param bufferedImage la imagen que se desea cortar 
131.     * @param rows el numero filas en las que se desea cortar la imagen 
132.     * @param cols el numero de columnas en las que se desea cortar la image 
133.     * 
134.     * @return BufferedImare[] devuelve un arreglo tipo BufferedImage con las imagenes cortadas de la imagen original 
135.     */  
    public static BufferedImage[] splitImage(BufferedImage bufferedImage, int rows, int cols) {  
        int w = bufferedImage.getWidth() / cols;  
        int h = bufferedImage.getHeight() / rows;  
        int num = 0;  
        BufferedImage imgs[] = new BufferedImage[w * h];  
        for (int y = 0; y < rows; y++) {  
            for (int x = 0; x < cols; x++) {  
                imgs[num] = new BufferedImage(w, h, bufferedImage.getType());  
                // Tell the graphics to draw only one block of the image  
                Graphics2D g = imgs[num].createGraphics();  
                g.drawImage(bufferedImage, 0, 0, w, h, w * x, h * y, w * x + w, h * y + h, null);  
                g.dispose();  
               num++;  
           }  
        }  
        return imgs;  
    }  
  
    /** 
155.     * Gira una imagen en sentido vertival 
156.     * 
157.     * @param bufferedImage la imagen que se desea girar 
158.     * 
159.     * @return BufferedImage es la imagen girada 
160.     */  
    public static BufferedImage flipVertical(BufferedImage bufferedImage) {  
        int w = bufferedImage.getWidth();  
        int h = bufferedImage.getHeight();  
        BufferedImage bufim = new BufferedImage(w, h, bufferedImage.getColorModel().getTransparency());  
        Graphics2D g = bufim.createGraphics();  
        g.drawImage(bufferedImage, 0, 0, w, h, 0, h, w, 0, null);  
        g.dispose();  
        return bufim;  
    }  
  
    /** 
172.     * Gira una imagen en sentido horizontal 
173.     * 
174.     * @param bufferedImage la imagen que se desea girar 
175.     * 
176.     * @return BufferedImage es la imagen girada 
177.     */  
    public static BufferedImage flipHorizontal(BufferedImage bufferedImage) {  
        int w = bufferedImage.getWidth();  
        int h = bufferedImage.getHeight();  
        BufferedImage bufim = new BufferedImage(w, h, bufferedImage.getType());  
        Graphics2D g = bufim.createGraphics();  
        g.drawImage(bufferedImage, 0, 0, w, h, w, 0, 0, h, null);  
        g.dispose();  
       return bufim;  
    }  
}  
