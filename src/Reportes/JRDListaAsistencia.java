/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Entidades.Alumnos;
import Entidades.ReporteHistorialAcademico;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Last Develop
 */
public class JRDListaAsistencia  implements JRDataSource {
private ArrayList<Alumnos> listaOferta=new ArrayList<Alumnos>();
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
       
        return valor;
    }
    
public void addRegistroReporte(Alumnos al)
{
    this.listaOferta.add(al);
}

    
}
