/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Entidades.Calificaciones;

/**
 *
 * @author Last Develop
 */
public class ModeloCalificaciones extends AbstractTableModel {
private ArrayList<Calificaciones> listaCalificaciones=new ArrayList<Calificaciones>();
private String[] columnas;

    public ModeloCalificaciones(String[] columnas ) {
        this.columnas = columnas;
    }



public void agregarCalificaciones(Calificaciones calificacion)
{
      listaCalificaciones.add(calificacion);
      int index=listaCalificaciones.size()-1;
      this.fireTableRowsInserted(index, index);
}
public ArrayList<Calificaciones> getListaCalificaciones()
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
        Calificaciones calificacion=(Calificaciones) this.listaCalificaciones.get(rowIndex);
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
                return calificacion.getFaltas1();
            case 5:
                return calificacion.getId_tipo1();
             case 6:
                return calificacion.getParcial2();
            case 7:
                return calificacion.getFaltas2();
            case 8:
                return calificacion.getId_tipo2();
           case 9:
                return calificacion.getParcial3();
            case 10:
                return calificacion.getFaltas3();
            case 11:
                return calificacion.getId_tipo3();
           case 12:
                return calificacion.getPromedio();
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
            case 4: return Integer.class;
            case 5: return Integer.class;
            case 6: return Float.class;
            case 7: return Integer.class;
            case 8: return Integer.class;
            case 9: return Float.class;
            case 10: return Integer.class;
           
            case 11: return Integer.class;
             case 12: return Float.class; 
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
       
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex>2 && columnIndex!=12)
            return true;
         else
            return false;
                    
        
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Calificaciones calificacion=(Calificaciones) listaCalificaciones.get(rowIndex);
        try{
            
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
                   calificacion.setPromedio();
                   break;
                case 4:
                   calificacion.setFaltas1(((Integer) aValue).intValue());
                
                break;
                    case 5:
                   
                   calificacion.setId_tipo1(((Integer) aValue).intValue());
                   
                   break;
                case 6:
                   
                   calificacion.setParcial2(((Float) aValue).floatValue());
                   calificacion.setPromedio();
                   break;
                case 7:
                   calificacion.setFaltas2(((Integer) aValue).intValue());
                
                break;
                    case 8:
                   
                   calificacion.setId_tipo2(((Integer) aValue).intValue());
                   
                   break;
                        
            case 9:
                   
                   calificacion.setParcial3(((Float) aValue).floatValue());
                    calificacion.setPromedio();
                   break;
                case 10:
                   calificacion.setFaltas3(((Integer) aValue).intValue());
                
                break;
               case 11:
                   
                   calificacion.setId_tipo3(((Integer) aValue).intValue());
                   
                   
              
                   
                   break;
              case 12:
                  calificacion.setPromedio();
                   
                   break;
}
        fireTableCellUpdated(rowIndex, columnIndex);
        }
        catch(ClassCastException ex){
        ex.printStackTrace();
        }
           
    }
    
    
    
}
