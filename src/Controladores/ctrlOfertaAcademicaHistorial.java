/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Entidades.Asignaturas;
import Entidades.CicloEscolar;
import Entidades.Grupos;
import Entidades.Kardex;
import Entidades.Modulos;
import Entidades.OfertaAcademica;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Last Develop
 */
public class ctrlOfertaAcademicaHistorial extends ctrlOfertaAcademica {
    private ArrayList<OfertaAcademica> listaofertaactualizada;
    
    

    public ArrayList<Kardex> getOfertaCicloGrupo(Grupos grupo,CicloEscolar ciclo) throws SQLException, ClassNotFoundException
    {
      ArrayList<Kardex> listaofertakardex=new ArrayList<Kardex>();
      
      ArrayList<OfertaAcademica> listaoferta=null;
      
      listaoferta=this.getOfertaAcademica(grupo.getIdGrupo(), 1); //traemos la oferta del grupo;
      
     if(listaoferta!=null && listaoferta.size()>0)
     {
      //System.out.println("Dimension de la oferta antes"+listaoferta.size());
      
      ctrlGrupos ctrlgrupos=new ctrlGrupos();
     
      ArrayList<Grupos> listagrupos=ctrlgrupos.getGrupos(grupo.getIdGrupo(), 0, 0, 0, 8);
      
      grupo=listagrupos.get(0);
     
      if(grupo.getSemestre()>1) //Debmos buscar el id_modulo, 
      {
       Asignaturas as=this.getAsignaturasModulo(listaoferta); //Recuperamos la asignatura que es modulo
         if(as!=null)
         {
        Modulos mod=this.getModuloOferta(as);//Recuperamos el modulo
        listaofertakardex=this.getConvertirOfertaHistorial(this.listaofertaactualizada, mod);
         }
        
       
       
      }
      else
      {
      listaofertakardex=this.getConvertirOfertaHistorial(listaoferta, null);
      }
              
      for(int i=0;i<listaofertakardex.size();i++) 
      {
       listaofertakardex.get(i).setSemestre( grupo.getSemestre());
       listaofertakardex.get(i).setId_ciclo(ciclo.getIdCiclo());
       
      }
     }
     else
         listaofertakardex=null;
     
      return listaofertakardex;
    }
    private ArrayList<Kardex> getConvertirOfertaHistorial(ArrayList<OfertaAcademica> listaofertaacademica,Modulos mod )
    {
     ArrayList<Kardex> listaofertakardex=new ArrayList<Kardex>();
     for(int i=0;i<listaofertaacademica.size();i++)
     {
       Kardex ka=new Kardex();
       ka.setId_kardex(0);
       ka.setId_ciclo(0);
       ka.setId_alumno(0);
       ka.setId_asignatura(listaofertaacademica.get(i).getIdAsignatura());
       //System.out.println(listaofertaacademica.get(i).getIdOfertaAcademica());
       ka.setId_oferta_academica(listaofertaacademica.get(i).getIdOfertaAcademica());
       ka.setNombreasignatura(listaofertaacademica.get(i).getAsignatura().getNombre());
       ka.setModulo("N");
       ka.setAcreditado("N");
       ka.setId_escala(0);
       ka.setPromedio(0);
       ka.setStatus("A");
       listaofertakardex.add(ka);
     }
     if(mod!=null)
     {
      Kardex modu=new Kardex();
      modu.setId_alumno(0);
      modu.setId_kardex(0);
      modu.setId_ciclo(0);
      modu.setModulo("S");
      modu.setId_asignatura(mod.getIdModulo());
      modu.setId_asignatura(mod.getIdModulo());
      modu.setNombreasignatura(mod.getDescripcion());
      modu.setAcreditado("N");
      modu.setId_escala(0);
      modu.setPromedio(0);
      modu.setStatus("A");
      listaofertakardex.add(modu);
     }
     
     return listaofertakardex;
    }
    
    private Asignaturas getAsignaturasModulo(ArrayList<OfertaAcademica> listaoferta)
    {
        this.listaofertaactualizada=new ArrayList<OfertaAcademica>();
        Asignaturas as=null;
        
       for(int i=0;i<listaoferta.size();i++)   
       {
        
        if(listaoferta.get(i).getAsignatura().getModulo().equals("S"))//Aqui esta tronado, no trare si es modulo en la oferta
        {
           
            
             as=new Asignaturas();
             as.setIdAsignatura(listaoferta.get(i).getIdAsignatura());
             
            
        }
        else
        {
         this.listaofertaactualizada.add(listaoferta.get(i));//solo añadimos los que no son modulos
        }
       }
         
         
        return as;
    }
    
    private Modulos getModuloOferta(Asignaturas as) throws SQLException, ClassNotFoundException
    {
      Modulos mod=null;
      ctrlAsignaturas ctrlasignaturas=new ctrlAsignaturas();
    if(as!=null)
    {
      
      ArrayList<Asignaturas> listaasignaturas=ctrlasignaturas.getAsignaturas(as.getIdAsignatura(), 0, 0, 0, 9);
      
      
    
      
      if(listaasignaturas!=null)
      {
        mod=new Modulos();
        mod.setIdModulo(listaasignaturas.get(0).getIdModulo());
        ctrlModulos ctrlmodulos=new ctrlModulos();
        
        ArrayList<Modulos> listamodulos=ctrlmodulos.getModulos(mod.getIdModulo(), 0);
        
        if(listamodulos!=null)
            mod=listamodulos.get(0);
      }
    }
    
      return mod;
    }

    
     /*Método para asignar la carga académica a la Tabla de inscripciones*/
  
  public ModeloTablaKardex getModeloOfertaHistorial(ArrayList<Kardex> listahistorial)
  {
      String []columnas={"Seleccionar","Asignatura","Promedio","Forma Acreditación"};
   ModeloTablaKardex modelo=new ModeloTablaKardex(columnas);
   for(int i=0;i<listahistorial.size();i++)
   {
       //System.out.println(listaoferta.get(i).getAsignatura().getNombre());
       listahistorial.get(i).setSeleccionado(true); //Para que este seleccionado la asignatura oferta academica
    modelo.addOfertaAcademica(listahistorial.get(i));
   }
   return modelo;
  }
}
