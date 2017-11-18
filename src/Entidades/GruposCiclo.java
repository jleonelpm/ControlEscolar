/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class GruposCiclo{
    private Integer idGrupoCiclo;
    private Integer idCiclo;
    private Integer idGeneracion;
    private Integer idCarrera;
    private Integer idPlan;    
    private Integer idGrupo;    
    private Short semestre;
    private String turno;
    private String status;
    private String modalidad;
    

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }
    
    private CicloEscolar ciclo;
    private Generaciones generacion;
    private Carreras carrera;
    private Planes plan;
    private Grupos grupo;

    public GruposCiclo() {
    }

    public GruposCiclo(Integer idGrupoCiclo) {
        this.idGrupoCiclo = idGrupoCiclo;
    }

    public Integer getIdGrupoCiclo() {
        return idGrupoCiclo;
    }

    public void setIdGrupoCiclo(Integer idGrupoCiclo) {
        this.idGrupoCiclo = idGrupoCiclo;
    }

    public Integer getIdGeneracion() {
        return idGeneracion;
    }

    public void setIdGeneracion(Integer idGeneracion) {
        this.idGeneracion = idGeneracion;
    }
        
    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public Integer getIdCiclo() {
        return idCiclo;
    }

    public void setIdCiclo(Integer idCiclo) {
        this.idCiclo = idCiclo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public Generaciones getGeneracion() {
        return generacion;
    }

    public void setGeneracion(Generaciones generacion) {
        this.generacion = generacion;
    }
        
    public Carreras getCarrera() {
        return carrera;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }

    public CicloEscolar getCiclo() {
        return ciclo;
    }

    public void setCiclo(CicloEscolar ciclo) {
        this.ciclo = ciclo;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Planes getPlan() {
        return plan;
    }

    public void setPlan(Planes plan) {
        this.plan = plan;
    }
    
    public Short getSemestre() {
        return semestre;
    }

    public void setSemestre(Short semestre) {
        this.semestre = semestre;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
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
        hash += (idGrupoCiclo != null ? idGrupoCiclo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GruposCiclo)) {
            return false;
        }
        GruposCiclo other = (GruposCiclo) object;
        if ((this.idGrupoCiclo == null && other.idGrupoCiclo != null) || (this.idGrupoCiclo != null && !this.idGrupoCiclo.equals(other.idGrupoCiclo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.semestre.toString() +"-"+this.getGrupo().getGrupo()+"-"+this.grupo.getModalidad()+"-"+this.getTurno();
    }

    public GruposCiclo(int id_grupoCiclo, Short semestre, Grupos grupo,String modalidad,String turno, int id_ciclo) {
        this.semestre = semestre;
        this.grupo = grupo;
        this.modalidad=modalidad;
        this.turno=turno;
        this.idGrupoCiclo=id_grupoCiclo;
        this.idCiclo=id_ciclo;
    }
    
}
