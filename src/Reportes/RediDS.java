/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import java.util.ArrayList;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import Entidades.Alumnos;

/**
 *
 * @author Last Develop
 */
public class RediDS implements JRDataSource  {
private ArrayList<Alumnos> listaAlumnos=new ArrayList<Alumnos>();
private int indiceAlumnos = -1;

    @Override
    public boolean next() throws JRException {
        return ++indiceAlumnos < listaAlumnos.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Object valor=null;
        
        if("nombres".equals(jrf.getName()))
        {
          valor=listaAlumnos.get(indiceAlumnos).getNombrecompleto();
        }
        
        if("matricula".equals(jrf.getName()))
        {
          valor=listaAlumnos.get(indiceAlumnos).getMatricula();
        }
       if("h".equals(jrf.getName()))
        {
            if(listaAlumnos.get(indiceAlumnos).getSexo()=='M')
                valor="X";
            else
                valor="";
        }
        if("m".equals(jrf.getName()))
        {
            if(listaAlumnos.get(indiceAlumnos).getSexo()=='F')
            valor="X";
            else
                valor="";
        }
        
        if("edad".equals(jrf.getName()))
        {
            valor=String.valueOf( listaAlumnos.get(indiceAlumnos).getEdad());
        }
        if("plantel".equals(jrf.getName()))
        {
            valor=listaAlumnos.get(indiceAlumnos).getSecundariaProcedencia();
        }
        if("observaciones".equals(jrf.getName()))
        {
            valor=String.valueOf( listaAlumnos.get(indiceAlumnos).getModo_ingreso());
        }
        
        
        return valor;
    }
    
    public void addOfertaAcademica(Alumnos al)
{
    this.listaAlumnos.add(al);
}

}
