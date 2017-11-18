/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilerias;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 *
 * @author Last Develop
 */
public class ArchivoUtils {
    public String archivo="";
    public String host="";
    
    private String rutadestino=""; 
    
    public ArchivoUtils() {
        Configuracion conf = new Configuracion();     
     
    
         
    host = conf.getPropiedad("servidor.host");
    
    rutadestino="\\\\"+host+"\\imagenes";            
    //puerto = conf.getPropiedad("servidor.puerto");
    }
    
    	public boolean FileCopy(String origen, String name) {
          boolean exito=false;
		String destino=rutadestino;
                    if (this.existeDirectorio(destino))
                    {
                    
                         destino=rutadestino+"\\"+name;
                         
                       if(!this.existeDirectorio(name))
                       {
                         
			exito=this.copiarArchivo(origen, destino);
                       }
                    }
                    else
                    {
                        
                       if(this.crearDirectorio())
                       {
                           
                           destino=rutadestino+"\\"+name;
                           
                         if(!this.existeDirectorio(destino))
                         {
                             
                           
                            exito=this.copiarArchivo(origen, destino);
                           
                         }
                       }
                       
                    }
                        
		
		
                return exito;
	}
 public boolean existeDirectorio(String path)
 {
     boolean existe=false;
    File file=new File( path);
    if (file.exists())
        existe=true;
    return existe;
 }
 public boolean crearDirectorio()
 {
    File file=new File(this.rutadestino);
    if(file.mkdir())
        return true;
    else
        return false;
 }
 public boolean copiarArchivo(String origen, String destino)
 {
     boolean copiado=false;
  try {
                    
			FileInputStream fis = new FileInputStream(origen); 
                        FileOutputStream fos = new FileOutputStream(destino); 
                        FileChannel canalFuente = fis.getChannel(); 
                        FileChannel canalDestino = fos.getChannel(); 
                        canalFuente.transferTo(0, canalFuente.size(), canalDestino); 
                         
                        fis.close(); 
                        fos.close(); 
                        copiado=true;
                        
		} catch(IOException e) {
			System.err.println("Hubo un error de entrada/salida!!!" + e.getMessage());
		}
  return copiado;
    
 }

 public boolean eliminarArchivo(String eliminar)
 {
     boolean status=false;
   if(archivo.length()>0)
   {
       String rutaeliminar=this.rutadestino+"\\"+eliminar;
      // System.out.println(rutaeliminar);
    File arch=new File(rutaeliminar);
     status=arch.delete();
        
   }
   return status;
 }
}
