/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;
import java.util.Date;
import java.util.logging.Level;

public class CicloEscolar {
  private Integer idCiclo;
  private String periodo;
  private Date fechaInicial;
  private Date fechaFinal;
  private String activo;  
  private Date fechaParcial1;
  private Date fechaParcial2;
  private Date fechaParcial3;
  private Short tipo;
  
  SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");  
  
  public CicloEscolar() {
  }

  public CicloEscolar(Integer idCiclo) {
    this.idCiclo = idCiclo;
  }

  public CicloEscolar(Integer idCiclo, String periodo) {
    this.idCiclo = idCiclo;
    this.periodo = periodo;
  }

  
  public Integer getIdCiclo() {
    return idCiclo;
  }

  public void setIdCiclo(Integer idCiclo) {
    this.idCiclo = idCiclo;
  }

  public String getPeriodo() {
    return periodo;
  }

  public void setPeriodo(String periodo) {
     
    this.periodo = periodo;
    
  }

  public Date getFechaInicial() {
    return fechaInicial;
  }

  public Date getFechaFinal() {
    return fechaFinal;
  }

  public String getActivo() {
    return activo;
  }

  public void setActivo(String activo) {
    this.activo = activo;
  } 
  

    public void setFechaInicial(String fechaInicial) {
      //La fecha debe venir con el formato año/mes/dia
      //Ejemplo 2011/01/30      
        try {
          if(fechaInicial!=null)
          {           
            String f[] = fechaInicial.split("-");
            this.fechaInicial = formato.parse(fecha(fechaInicial));   
          }
          else
              this.fechaInicial=null;
           
        } catch (Exception ex) {
            Logger.getLogger(CicloEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setFechaFinal(String fechaFinal) {
        try {
          if(fechaFinal!=null)
          {           
            String f[] = fechaFinal.split("-");
            this.fechaFinal = formato.parse(fecha(fechaFinal));
          }
          else
              this.fechaFinal=null;
           
        } catch (Exception ex) {
            Logger.getLogger(CicloEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String fecha(String f) {
      //Debe retornar una fecha con formato de año/mes/dia
      String f1[] = f.split("-");
      
      if (f1[0].length()==4){
        return f;
      }else{
        //el formato está en dia/mes/año, por lo tanto hay que convertir
        return f1[2]+"-"+f1[1]+"-"+f1[0];
      }
    }

    public Date getFechaParcial1() {
        return fechaParcial1;
    }

    public void setFechaParcial1(String fechaParcial1) {
        try {
          if(fechaParcial1!=null)
          {           
            String f[] = fechaParcial1.split("-");
            this.fechaParcial1 = formato.parse(fecha(fechaParcial1));
          }
          else
              this.fechaParcial1=null;
           
        } catch (Exception ex) {
            Logger.getLogger(CicloEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Date getFechaParcial2() {
        return fechaParcial2;
    }

    public void setFechaParcial2(String fechaParcial2) {
        try {
          if(fechaParcial1!=null)
          {           
            String f[] = fechaParcial2.split("-");
            this.fechaParcial2 = formato.parse(fecha(fechaParcial2));
          }
          else
              this.fechaParcial2=null;
           
        } catch (Exception ex) {
            Logger.getLogger(CicloEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Date getFechaParcial3() {
        return fechaParcial3;
    }

    public void setFechaParcial3(String fechaParcial3) {
        try {
          if(fechaParcial3!=null)
          {           
            String f[] = fechaParcial3.split("-");
            this.fechaParcial3 = formato.parse(fecha(fechaParcial3));
          }
          else
              this.fechaParcial3=null;
           
        } catch (Exception ex) {
            Logger.getLogger(CicloEscolar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Short getTipo() {
        return tipo;
    }

    public void setTipo(Short tipo) {
        this.tipo = tipo;
    }
    
    

  @Override
  public String toString() {
    return periodo;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final CicloEscolar other = (CicloEscolar) obj;
    if (this.idCiclo != other.idCiclo && (this.idCiclo == null || !this.idCiclo.equals(other.idCiclo))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int hash = 5;
    hash = 11 * hash + (this.idCiclo != null ? this.idCiclo.hashCode() : 0);
    return hash;
  }
    
    
    
}