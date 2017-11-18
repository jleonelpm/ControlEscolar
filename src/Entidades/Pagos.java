/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Pagos {
  private Integer idPago;
  private Date fechaPago;
  private String observaciones;
  private Integer idAlumno;
  private Integer idUsuario;
  private Alumnos alumno;
  private Usuarios usuario;
  private Float importeTotal;
  private String status;
  SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");    
  
  public Pagos() {
  }

  public Pagos(Integer idPago) {
    this.idPago = idPago;
  }

  public Integer getIdPago() {
    return idPago;
  }

  public void setIdPago(Integer idPago) {
    this.idPago = idPago;
  }

  public Date getFecha() {
    return fechaPago;
  }

    public void setFecha(String fechaPago) {
      //La fecha debe venir con el formato año/mes/dia
      //Ejemplo 2011/01/30      
        try {
          if(fechaPago!=null)
          {           
            String f[] = fechaPago.split("-");
            this.fechaPago = formato.parse(fecha(fechaPago));   
          }
          else
              this.fechaPago=null;
           
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
    
  public String getObservaciones() {
    return observaciones;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }

  public Alumnos getAlumno() {
    return alumno;
  }

  public void setAlumno(Alumnos alumno) {
    this.alumno = alumno;
  }

  public Integer getIdAlumno() {
    return idAlumno;
  }

  public void setIdAlumno(Integer idAlumno) {
    this.idAlumno = idAlumno;
  }

  public Integer getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(Integer idUsuario) {
    this.idUsuario = idUsuario;
  }

  public Usuarios getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuarios usuario) {
    this.usuario = usuario;
  }

    public Float getImporteTotal() {
        return importeTotal;
    }

    public void setImporteTotal(Float importeTotal) {
        this.importeTotal = importeTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
  
  @Override
  public int hashCode() {
    int hash = 0;
    hash += (idPago != null ? idPago.hashCode() : 0);
    return hash;
  }

  @Override
  public boolean equals(Object object) {
    // TODO: Warning - this method won't work in the case the id fields are not set
    if (!(object instanceof Pagos)) {
      return false;
    }
    Pagos other = (Pagos) object;
    if ((this.idPago == null && other.idPago != null) || (this.idPago != null && !this.idPago.equals(other.idPago))) {
      return false;
    }
    return true;
  }

  @Override
  public String toString() {
    return "sice.Entidades.Pagos[ idPago=" + idPago + " ]";
  }
  
}