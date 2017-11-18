/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Grupos {
  private Integer idGrupo;
  private Integer idGeneracion;
  private Integer idCarrera;    
  private Integer idPlan;
  private String grupo; 
  private String modalidad;
  private String clave;
  private Integer semestre;
  private String turno;

  
  private Generaciones generacion;  
  private Carreras carrera;
  private Planes plan;
  
  private Integer idArea;
  private Areas area;

  private Integer idCiclo;
  private CicloEscolar ciclo;
  

  public Grupos() {
  }

  public Grupos(Integer idGrupo) {
    this.idGrupo = idGrupo;
  }

  public Grupos(int idGrupo, String grupo) {
    this.idGrupo = idGrupo;
    this.grupo= grupo;
  }
  
  public Integer getIdGrupo() {
    return idGrupo;
  }

  public void setIdGrupo(Integer idGrupo) {
    this.idGrupo = idGrupo;
  }

  public String getGrupo() {
    return grupo;
  }

  public void setGrupo(String grupo) {
    this.grupo = grupo;
  }

  public String getModalidad() {
    return modalidad;
  }

  public void setModalidad(String modalidad) {
    this.modalidad = modalidad;
  }

  public Generaciones getGeneracion() {
    return generacion;
  }
  
  public void setGeneracion(Generaciones generacion) {
    this.generacion = generacion;
  }

    public Integer getIdGeneracion() {
        return idGeneracion;
    }

    public void setIdGeneracion(Integer idGeneracion) {
        this.idGeneracion = idGeneracion;
    }
    

  public Carreras getCarrera() {
    return carrera;
  }

  public void setCarrera(Carreras carrera) {
    this.carrera = carrera;
  }

  public Integer getIdCarrera() {
    return idCarrera;
  }


  public void setIdCarrera(Integer idCarrera) {
    this.idCarrera = idCarrera;
  }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Planes getPlan() {
        return plan;
    }

    public void setPlan(Planes plan) {
        this.plan = plan;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Areas getArea() {
        return area;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public CicloEscolar getCiclo() {
        return ciclo;
    }

    public void setCiclo(CicloEscolar ciclo) {
        this.ciclo = ciclo;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    @Override
    public String toString() {
        return grupo;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Grupos other = (Grupos) obj;
        if (this.idGrupo != other.idGrupo && (this.idGrupo == null || !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + (this.idGrupo != null ? this.idGrupo.hashCode() : 0);
        return hash;
    }

    
}
