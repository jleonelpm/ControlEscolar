/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import Entidades.OfertaAcademica;

/**
 *
 * @author Last Develop
 */
public class AsignaturasJasperDS implements JRDataSource  {
private ArrayList<OfertaAcademica> listaOferta=new ArrayList<OfertaAcademica>();
private int indiceAsignaturaActual = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceAsignaturaActual < listaOferta.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor=null;
        
        if("clave".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getAsignatura().getClave();
        }
        if("nombre".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getAsignatura().getNombre();
        }
        return valor;
    }
    
    public void addOfertaAcademica(OfertaAcademica ofertaacademica)
{
    this.listaOferta.add(ofertaacademica);
}

}
