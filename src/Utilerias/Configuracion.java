package Utilerias;
import java.io.FileInputStream; 
import java.io.FileOutputStream;
import java.io.IOException; 
import java.util.Properties;

public class Configuracion{
  
   private static String ARCHIVO =  "config.dat";
   private Properties propiedades;
   
   public Configuracion(String Archivo){
        ARCHIVO = Archivo;        
        inicializar();
   }
   
   public Configuracion(){
     inicializar();
   }
   
   public void inicializar(){
       propiedades = new Properties();
       
       try{ 
         FileInputStream archivo = new FileInputStream(ARCHIVO);
         //Abrimos el archivo
         propiedades.load( archivo ); 
       }catch(Exception e){
         System.out.println("Error al abrir archivo");
       }
   }
   
   public String getPropiedad(String propiedad){
      return propiedades.getProperty( propiedad );
   }
   
   public void setPropiedad(String propiedad, String dato){
     try { 
        propiedades.setProperty( propiedad , dato );
        propiedades.store(new FileOutputStream(ARCHIVO), null); //para que los cambios se alacenen en archivo
     } catch (IOException e) {
       System.out.println("Error al cambiar la propiedad");
     }
   }
 
}