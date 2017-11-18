/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import Entidades.ReporteHistorialAcademico;
import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Last Develop
 */
public class JRDHistorialAcademicoAlumno  implements JRDataSource {
private ArrayList<ReporteHistorialAcademico> listaOferta=new ArrayList<ReporteHistorialAcademico>();
private int indiceAsignaturaActual = -1;
    @Override
    public boolean next() throws JRException {
        return ++indiceAsignaturaActual < listaOferta.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
         Object valor=null;
        
        if("f_asignatura".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getNombreasignatura();
        }
        if("f_promedio".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getPromedio();
        }
        if("f_semestre".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getSemestre();
        }
        if("f_letras".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getLetras();
        }
        if("f_acreditacion".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getAcreditacion();
        }
        return valor;
    }
    
public void addRegistroReporte(ReporteHistorialAcademico ofertaacademica)
{
    this.listaOferta.add(ofertaacademica);
}

    
}
