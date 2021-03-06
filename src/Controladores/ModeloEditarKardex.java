/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import Entidades.Kardex;


/**
 *
 * @author Last Develop
 */
public class ModeloEditarKardex extends AbstractTableModel{
private ArrayList<Kardex> listaKardex=new ArrayList<Kardex>();
private String[] columnas;

    public ModeloEditarKardex(String[] columnas) {
        this.columnas = columnas;
    }

  
    
    
    
    @Override
    public int getRowCount() {
       return listaKardex.size();
    }

    @Override
    public int getColumnCount() {
        return this.columnas.length;
    }

    public void agregarKardex(Kardex kardex)
{
      listaKardex.add(kardex);
      int index=listaKardex.size()-1;
      this.fireTableRowsInserted(index, index);
}
public ArrayList<Kardex> getListaKardex()
{
 return this.listaKardex;
}


    
    
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Kardex kardex=this.listaKardex.get(rowIndex);
        switch(columnIndex)
        {
           // case 0:return kardex.isSeleccionado();
            case 0:return kardex.getNombreasignatura();
            case 1:return kardex.getSemestre();
            case 2:return kardex.getPromedio();
           case 3:return kardex.getId_acreditacion();
            default:return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        switch(columnIndex)
        {
            //case 0: return Boolean.class;
            case 0: return String.class;
            case 1: return Integer.class;
            case 2: return Float.class;
            case 3: return Integer.class;
            default:return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(columnIndex==0 || columnIndex==2||columnIndex==3)
            return true;
        else
            return false;
    }

    @Override
    public String getColumnName(int column) {
        return this.columnas[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
        Kardex kardex=(Kardex) listaKardex.get(rowIndex);
        try{
            
            switch (columnIndex) {
                
               // case 0:
                 //   kardex.setSeleccionado((Boolean) aValue);
                  //  break;
                case 2:
                    kardex.setPromedio((Float) aValue);
                    if(kardex.getPromedio()>=6)
                        kardex.setAcreditado("S");
                    else
                        kardex.setAcreditado("N");
                    break;
                case 3:
                    kardex.setId_acreditacion((Integer) aValue);
         
}
        fireTableCellUpdated(rowIndex, columnIndex);
        }
        catch(ClassCastException ex){
        ex.printStackTrace();
        }
    }
    
     public void addOfertaAcademica(Kardex oferta)
    {
       this.listaKardex.add(oferta);
      int index=this.listaKardex.size()-1;
      this.fireTableRowsInserted(index, index);
    }
     
     public void removeAllRows()
     {
      if( this.getRowCount()>0)
      {
       for(int i=this.getRowCount();i>0;i--)   
       {
       this.removeRow(i);
       }
      }
     }
     public void removeRow(int row)
    {           
        fireTableRowsDeleted(row, row);
    }


}
