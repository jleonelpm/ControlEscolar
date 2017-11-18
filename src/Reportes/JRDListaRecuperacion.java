/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Entidades.Alumnos;
import Entidades.AlumnosRecuperacion;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Last Develop
 */
public class JRDListaRecuperacion  implements JRDataSource {
private ArrayList<AlumnosRecuperacion> listaOferta=new ArrayList<AlumnosRecuperacion>();
private int indiceAsignaturaActual = -1;
    @Override
    public boolean next() throws JRException {
        return ++indiceAsignaturaActual < listaOferta.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
         Object valor=null;
        
      
        if("falumno".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getNombre();
        }
        if("fparcial1".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getParcial1();
        }
        if("fparcial2".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getParcial2();
        }
        if("fparcial3".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getParcial3();
        }
        if("fdescripcion".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getDescripcion();
        }
       
        return valor;
    }
    
public void addRegistroReporte(AlumnosRecuperacion al)
{
    this.listaOferta.add(al);
}

    
}
