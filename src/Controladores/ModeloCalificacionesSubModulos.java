/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Entidades.CalificacionesSubmodulo;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author Last Develop
 */
public class ModeloCalificacionesSubModulos extends AbstractTableModel {
private ArrayList<CalificacionesSubmodulo> listaCalificaciones=new ArrayList<CalificacionesSubmodulo>();
private String[] columnas;

    public ModeloCalificacionesSubModulos(String[] columnas ) {
        this.columnas = columnas;
    }



public void agregarCalificaciones(CalificacionesSubmodulo calificacion)
{
      listaCalificaciones.add(calificacion);
      int index=listaCalificaciones.size()-1;
      this.fireTableRowsInserted(index, index);
}
public ArrayList<CalificacionesSubmodulo> getListaCalificaciones()
{
 return this.listaCalificaciones;
}



    @Override
    public int getRowCount() {
       return this.listaCalificaciones.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         NumberFormat formatter = new DecimalFormat("#0.0000"); //Para que muestre los 4 decimales
         float suma=0;
        CalificacionesSubmodulo calificacion=(CalificacionesSubmodulo) this.listaCalificaciones.get(rowIndex);
        switch(columnIndex)
        {
            case 0: 
                return calificacion.getNo();
                   
            case 1: 
                return calificacion.getNombreCompleto();
            case 2:
                return calificacion.getMatricula();
            case 3:
                return calificacion.getParcial1();
            case 4:
               return formatter.format(calificacion.getUnidadaprendizaje().get(0).getFactorPonderacion());
                
            case 5: 
                
                     return formatter.format(calificacion.getPonderacion1() );
               
             case 6:
               return  calificacion.getFaltas1();
                 
           case 7:
                return calificacion.getParcial2();
            case 8:
                 if(calificacion.getUnidadaprendizaje().size()>=2)
                    return formatter.format(calificacion.getUnidadaprendizaje().get(1).getFactorPonderacion());
                 else
                     return 0;
            case 9: 
                
                        return formatter.format(calificacion.getPonderacion2());
                
             case 10:
               return  calificacion.getFaltas2();
             case 11:
                return calificacion.getParcial3();
            case 12:
                  if(calificacion.getUnidadaprendizaje().size()>=3)
                        return formatter.format(calificacion.getUnidadaprendizaje().get(2).getFactorPonderacion());
                   else
                      return 0;
                
            case 13: 
               
               
                        
               
                    return formatter.format(calificacion.getPonderacion3());
               
             case 14:
               return  calificacion.getFaltas3();
                 
            case 15:
                return calificacion.getParcial4();
            case 16:
                 if(calificacion.getUnidadaprendizaje().size()>=4)
               return formatter.format(calificacion.getUnidadaprendizaje().get(3).getFactorPonderacion());
                else
                     return 0;
                       
                
            case 17: 
               
                    return formatter.format(calificacion.getPonderacion4());
               
                   
             case 18:
               return  calificacion.getFaltas4();
          
            case 19:
                return calificacion.getParcial5();
            case 20:
                 if(calificacion.getUnidadaprendizaje().size()>=5)
               return formatter.format(calificacion.getUnidadaprendizaje().get(4).getFactorPonderacion());
                else
                     return 0;
            case 21: 
                if(calificacion.getParcial5()>=6)
                {
                  calificacion.setPonderacion5(calificacion.getParcial5()*calificacion.getUnidadaprendizaje().get(4).getFactorPonderacion());
                   if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 && calificacion.getParcial4()>=6
                           && calificacion.getParcial5()>=6)
                    {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+ 
                                calificacion.getPonderacion4()+calificacion.getPonderacion5();
                     calificacion.setTotal(suma);
                    }
                    else
                    {
                     calificacion.setTotal(0);
                        
                    }  
                        return formatter.format(calificacion.getPonderacion5());
                }
              else
                { //calificacion.setTotal(0);
                  return 0;
                }  
                   
             case 22:
               return  calificacion.getFaltas5();
            
             case 23:
                return calificacion.getParcial6();
            case 24:
                 if(calificacion.getUnidadaprendizaje().size()>=6)
               return formatter.format(calificacion.getUnidadaprendizaje().get(5).getFactorPonderacion());
                else
                     return 0;
            case 25: 
                if(calificacion.getParcial6()>=6)
                {
                    calificacion.setPonderacion6(calificacion.getParcial6()*calificacion.getUnidadaprendizaje().get(5).getFactorPonderacion());
                    if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 && calificacion.getParcial4()>=6
                           && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6)
                    {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+ 
                             calificacion.getPonderacion4()+calificacion.getPonderacion5()+ calificacion.getPonderacion6();
                     calificacion.setTotal(suma);
                    }
                    else
                    {
                     calificacion.setTotal(0);
                        
                    }  
                        return formatter.format(calificacion.getPonderacion6());
                }
                else
                { //calificacion.setTotal(0);
                  return 0;
                }  
                   
             case 26:
               return  calificacion.getFaltas6();     
              case 27:
                return calificacion.getParcial7();
            case 28:
                 if(calificacion.getUnidadaprendizaje().size()>=7)
               return formatter.format(calificacion.getUnidadaprendizaje().get(6).getFactorPonderacion());
                else
                     return 0;
            case 29: 
                if(calificacion.getParcial7()>=6)
                {
                    calificacion.setPonderacion7(calificacion.getParcial7()*calificacion.getUnidadaprendizaje().get(6).getFactorPonderacion());
                   if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 && calificacion.getParcial4()>=6
                           && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 && calificacion.getParcial7()>=6)
                    {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+ 
                             calificacion.getPonderacion4()+calificacion.getPonderacion5()+ calificacion.getPonderacion6()+calificacion.getPonderacion7();
                     calificacion.setTotal(suma);
                    }
                    else
                    {
                     calificacion.setTotal(0);
                        
                    }  
                        return formatter.format(calificacion.getPonderacion7());
                }
               else
                { //calificacion.setTotal(0);
                  return 0;
                }  
                   
             case 30:
               return  calificacion.getFaltas7();     
             
            case 31:
                return calificacion.getParcial8();
            case 32:
                 if(calificacion.getUnidadaprendizaje().size()>=8)
               return formatter.format(calificacion.getUnidadaprendizaje().get(7).getFactorPonderacion());
                else
                     return 0;
                
            case 33: 
                if(calificacion.getParcial8()>=6)
                {
                    calificacion.setPonderacion8(calificacion.getParcial8()*calificacion.getUnidadaprendizaje().get(7).getFactorPonderacion());
                    if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 && calificacion.getParcial4()>=6
                           && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 && calificacion.getParcial7()>=6
                            && calificacion.getParcial8()>=6)
                    {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+ 
                             calificacion.getPonderacion4()+calificacion.getPonderacion5()+ calificacion.getPonderacion6()+
                             calificacion.getPonderacion7() + calificacion.getPonderacion8();
                     calificacion.setTotal(suma);
                    }
                    else
                    {
                     calificacion.setTotal(0);
                        
                    }  
                        return formatter.format(calificacion.getPonderacion8());
                }
                else
                { //calificacion.setTotal(0);
                  return 0;
                }  
                   
             case 34:
               return  calificacion.getFaltas8();       
             case 35:
                return calificacion.getParcial9();
            case 36:
                 if(calificacion.getUnidadaprendizaje().size()>=9)
               return formatter.format(calificacion.getUnidadaprendizaje().get(8).getFactorPonderacion());
                else
                     return 0;
            case 37: 
                if(calificacion.getParcial9()>=6)
                {
                    calificacion.setPonderacion9(calificacion.getParcial9()*calificacion.getUnidadaprendizaje().get(8).getFactorPonderacion());
                     if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 && calificacion.getParcial4()>=6
                           && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 && calificacion.getParcial7()>=6
                            && calificacion.getParcial8()>=6 && calificacion.getParcial9()>=6)
                    {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+ 
                             calificacion.getPonderacion4()+calificacion.getPonderacion5()+ calificacion.getPonderacion6()+
                             calificacion.getPonderacion7() + calificacion.getPonderacion8()+calificacion.getPonderacion9();
                     calificacion.setTotal(suma);
                    }
                    else
                    {
                     calificacion.setTotal(0);
                        
                    }  
                        return formatter.format(calificacion.getPonderacion9());
                }
                else
                { //calificacion.setTotal(0);
                  return 0;
                }  
                   
             case 38:
               return  calificacion.getFaltas9();          
             
               case 39:
                return calificacion.getParcial10();
            case 40:
                 if(calificacion.getUnidadaprendizaje().size()>=10)
                    return formatter.format(calificacion.getUnidadaprendizaje().get(9).getFactorPonderacion());
                else
                     return 0;
                
            case 41: 
                if(calificacion.getParcial10()>=6)
                {
                    calificacion.setPonderacion10(calificacion.getParcial10()*calificacion.getUnidadaprendizaje().get(9).getFactorPonderacion());
                      if(calificacion.getPonderacion1()>0 && calificacion.getPonderacion2()>0 && calificacion.getPonderacion3()>0 && calificacion.getPonderacion4()>0
                           && calificacion.getPonderacion5()>0 && calificacion.getPonderacion6()>0 && calificacion.getPonderacion7()>0
                            && calificacion.getPonderacion8()>0 && calificacion.getPonderacion9()>0 && calificacion.getPonderacion10()>0)
                    {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+ 
                             calificacion.getPonderacion4()+calificacion.getPonderacion5()+ calificacion.getPonderacion6()+
                             calificacion.getPonderacion7() + calificacion.getPonderacion8()+calificacion.getPonderacion9()+
                             calificacion.getPonderacion10();
                     calificacion.setTotal(suma);
                    }
                    else
                    {
                     calificacion.setTotal(0);
                        
                    }  
                        return formatter.format(calificacion.getPonderacion10());
                }
                else
                { //calificacion.setTotal(0);
                  return 0;
                }  
                   
             case 42:
               return  calificacion.getFaltas10();    
             
             case 43:
                 return calificacion.getId_tipo();
              case 44:
                 return calificacion.getTotal();
            default:
                return null;
        
        }
        
        //return calificacion;
    }
    
    

    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Float.class;
            case 4: return Float.class;
            case 5: return Float.class;
            case 6: return Integer.class;
            case 7: return Float.class;
            case 8: return Float.class;
            case 9: return Float.class;    
            case 10: return Integer.class;
            case 11: return Float.class;
            case 12: return Float.class;
            case 13: return Float.class;
            case 14: return Integer.class;
            case 15: return Float.class;
            case 16: return Float.class;
            case 17: return Float.class;
            case 18: return Integer.class;
            case 19: return Float.class;
            case 20: return Float.class;
            case 21: return Float.class;
            case 22: return Integer.class;
            case 23: return Float.class;
            case 24: return Float.class;
            case 25: return Float.class;
            case 26: return Integer.class;
            case 27: return Float.class;
            case 28: return Float.class;
            case 29: return Float.class;
            case 30: return Integer.class;
            case 31: return Float.class;
            case 32: return Float.class;
            case 33: return Float.class;
            case 34: return Integer.class;
            case 35: return Float.class;
            case 36: return Float.class;
            case 37: return Float.class;
            case 38: return Integer.class;
            case 39: return Float.class;
            case 40: return Float.class;
            case 41: return Float.class;
            case 42: return Integer.class;
            case 43: return Integer.class;
            case 44: return Float.class;
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
       
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        switch(columnIndex)
        {
            case 0:
            case 1:
            case 2:
            case 4://fp
            case 5://vp
                return false;
            case 3: //es el pa1
            case 6:  //faltas 1
            case 7:
            case 10:
            case 11:
            case 14:
            case 15:
            case 18:
            case 19:
            case 22:
            case 23:
            case 26:
            case 27:
            case 30:
            case 31:
            case 34:
            case 35:
            case 38:
            case 39:
            case 42:
            case 43:
                return true;
            default:
                return false;
        }
        
                    
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        CalificacionesSubmodulo calificacion=(CalificacionesSubmodulo) listaCalificaciones.get(rowIndex);
        try{
            float suma=0;
            switch (columnIndex) {
                case 0:
                    calificacion.setNo((Integer) aValue);
                    
                    break;
                case 1:
                    calificacion.setNombreCompleto((String) aValue);
                    break;
                case 2:
                    calificacion.setMatricula((String) aValue);
                    break;
                case 3:
                   calificacion.setParcial1(((Float) aValue).floatValue());
                   calificacion.setPonderacion1(calificacion.getParcial1()* calificacion.getUnidadaprendizaje().get(0).getFactorPonderacion());
                   if(calificacion.getParcial1()>=6)
                   {
                    suma =calificacion.getPonderacion1();
                    calificacion.setTotal(suma);
                   }
                   else
                   {
                   calificacion.setTotal(0);
                   }
                   break;
                    
                case 6:
                   calificacion.setFaltas1(((Integer) aValue).intValue());
                   break;
                case 7:
                        calificacion.setParcial2(((Float) aValue).floatValue());
                        if(calificacion.getParcial2()>=6)
                        {
                            calificacion.setPonderacion2(calificacion.getParcial2()* calificacion.getUnidadaprendizaje().get(1).getFactorPonderacion());
                            if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 )
                            {
                            suma=calificacion.getPonderacion1()+calificacion.getPonderacion2();
                            calificacion.setTotal(suma);
                            }
                            else
                            {
                            calificacion.setTotal(0);
                            }
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                        break;
                case 10:
                        calificacion.setFaltas2(((Integer) aValue).intValue());
                        break;
                case 11:
                     calificacion.setParcial3(((Float) aValue).floatValue());
                     
                      if(calificacion.getParcial3()>=6)
                     {
                        calificacion.setPonderacion3(calificacion.getParcial3()*calificacion.getUnidadaprendizaje().get(2).getFactorPonderacion());
                        if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6)
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3();
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                     }
                      else
                      {
                      calificacion.setTotal(0);
                      }
                      
                          
                     break;
                case 14:
                     calificacion.setFaltas3(((Integer) aValue).intValue());
                      break;
                case 15:
                     calificacion.setParcial4(((Float) aValue).floatValue());
                     if(calificacion.getParcial4()>=6)
                     {
                     calificacion.setPonderacion4(calificacion.getParcial4()* calificacion.getUnidadaprendizaje().get(3).getFactorPonderacion());
                        if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 && calificacion.getParcial4()>=6)
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+calificacion.getPonderacion4();
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                     }
                     else
                     {
                      calificacion.setTotal(0);
                     }
                     break;
                case 18:
                   calificacion.setFaltas4(((Integer) aValue).intValue());
                   break;
               case 19:
                   
                    calificacion.setParcial5(((Float) aValue).floatValue()); 
                    if(calificacion.getParcial5()>=6)
                    {
                        calificacion.setPonderacion5(calificacion.getParcial5()* calificacion.getUnidadaprendizaje().get(4).getFactorPonderacion());
                        if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 
                           && calificacion.getParcial4()>=6  && calificacion.getParcial5()>=6 )
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+
                             calificacion.getParcial4()+calificacion.getParcial5() ;
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                    }
                    else
                    {
                     calificacion.setTotal(0);
                    }
                   break;
              case 22:
                   calificacion.setFaltas5(((Integer) aValue).intValue());
                   break;
              case 23:
                    calificacion.setParcial6(((Float) aValue).floatValue());
                    
                     if(calificacion.getParcial6()>=6)
                    {
                        calificacion.setPonderacion6(calificacion.getParcial6()* calificacion.getUnidadaprendizaje().get(5).getFactorPonderacion());
                        if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 
                           && calificacion.getParcial4()>=6  && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 )
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+
                             calificacion.getPonderacion4()+calificacion.getPonderacion5()+calificacion.getPonderacion6() ;
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                    }
                    else
                    {
                     calificacion.setTotal(0);
                    }
                    
                    
                   break;
              case 26:
                   calificacion.setFaltas6(((Integer) aValue).intValue());
                   break;
              case 27:
                    calificacion.setParcial7(((Float) aValue).floatValue()); 
                     if(calificacion.getParcial7()>=6)
                    {
                    calificacion.setPonderacion7(calificacion.getParcial7()* calificacion.getUnidadaprendizaje().get(6).getFactorPonderacion());
                      if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 
                           && calificacion.getParcial4()>=6  && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 
                            && calificacion.getParcial7()>=6  )
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+
                             calificacion.getPonderacion4()+calificacion.getPonderacion5() + 
                                calificacion.getPonderacion6()
                             +calificacion.getPonderacion7();
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                    }
                    else
                     {
                     calificacion.setTotal(0);
                     }
                   break;
              case 30:
                   calificacion.setFaltas7(((Integer) aValue).intValue());
                   break;
              case 31:
                    calificacion.setParcial8(((Float) aValue).floatValue()); 
                    if(calificacion.getParcial8()>=6)
                    {
                    calificacion.setPonderacion8(calificacion.getParcial8()* calificacion.getUnidadaprendizaje().get(7).getFactorPonderacion());
                        if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 
                           && calificacion.getParcial4()>=6  && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 
                            && calificacion.getParcial7()>=6 && calificacion.getParcial8()>=6 )
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+
                             calificacion.getPonderacion4()+calificacion.getPonderacion5() + 
                                calificacion.getPonderacion6()
                             +calificacion.getPonderacion7()+calificacion.getPonderacion8() ;
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                    }
                    else
                    {
                     calificacion.setTotal(0);
                    }
                   break;
              case 34:
                   calificacion.setFaltas8(((Integer) aValue).intValue());
                   break;
              case 35:
                    calificacion.setParcial9(((Float) aValue).floatValue());  
                    if(calificacion.getParcial9()>=6)
                    {
                    calificacion.setPonderacion9(calificacion.getParcial9()* calificacion.getUnidadaprendizaje().get(8).getFactorPonderacion());
                    if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 
                           && calificacion.getParcial4()>=6  && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 
                            && calificacion.getParcial7()>=6 && calificacion.getParcial8()>=6 && calificacion.getParcial9()>=6 )
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+
                             calificacion.getPonderacion4()+calificacion.getPonderacion5() + 
                                calificacion.getPonderacion6()
                             +calificacion.getPonderacion7()+calificacion.getPonderacion8()+calificacion.getPonderacion9() ;
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                    }
                    else
                    {
                     calificacion.setTotal(0);
                    }
                   break;
              case 38:
                   calificacion.setFaltas9(((Integer) aValue).intValue());
                   break;
              case 39:
                    calificacion.setParcial10(((Float) aValue).floatValue());   
                     if(calificacion.getParcial10()>=6)
                    {
                    calificacion.setPonderacion10(calificacion.getParcial10()* calificacion.getUnidadaprendizaje().get(9).getFactorPonderacion());
                     if(calificacion.getParcial1()>=6 && calificacion.getParcial2()>=6 && calificacion.getParcial3()>=6 
                           && calificacion.getParcial4()>=6  && calificacion.getParcial5()>=6 && calificacion.getParcial6()>=6 
                            && calificacion.getParcial7()>=6 && calificacion.getParcial8()>=6 && calificacion.getParcial9()>=6 &&
                             
                            calificacion.getParcial10()>=6 )
                        {
                        suma=calificacion.getPonderacion1()+calificacion.getPonderacion2()+calificacion.getPonderacion3()+
                             calificacion.getPonderacion4()+calificacion.getPonderacion5() + 
                                calificacion.getPonderacion6()
                             +calificacion.getPonderacion7()+calificacion.getPonderacion8()+calificacion.getPonderacion9()+calificacion.getPonderacion10();
                        calificacion.setTotal(suma);
                        }
                        else
                        {
                        calificacion.setTotal(0);
                        }
                    }
                     else
                     {
                     calificacion.setTotal(0);
                     }
                   break;
              case 42:
                   calificacion.setFaltas10(((Integer) aValue).intValue());
                   break;
              case 43:
                      calificacion.setId_tipo(((Integer) aValue).intValue());
                  break;
             
}
        fireTableCellUpdated(rowIndex, columnIndex);
        }
        catch(ClassCastException ex){
        ex.printStackTrace();
        }
           
    }
    
    
    
}
