/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import Entidades.CicloEscolar;
import Entidades.OfertaAcademica;

/**
 *
 * @author Last Develop
 */
public class ReporteCiclos implements JRDataSource  {
private ArrayList<CicloEscolar> listaOferta=new ArrayList<CicloEscolar>();
private int indiceAsignaturaActual = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceAsignaturaActual < listaOferta.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor=null;
        
        if("perido".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getPeriodo();
        }
        if("id_ciclo".equals(jrf.getName()))
        {
          valor=listaOferta.get(indiceAsignaturaActual).getIdCiclo();
        }
        return valor;
    }
    
    public void addOfertaAcademica(CicloEscolar ofertaacademica)
{
    this.listaOferta.add(ofertaacademica);
}

}
