/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class OfertaAcademica {
    private Integer idOfertaAcademica;
    private Integer idGrupo;
    private Integer idAsignatura;
    private Integer idPersonal;    
    private Integer idPlan;
    private Grupos grupo;
    private Asignaturas asignatura;
    private Personal personal;
    
    
    
    
    
    
    /*ACTUALIZA EL ARCHIVO INSCRIPCIONES SE REQUIER*/
    private boolean seleccionado;
    private String recursamiento; //determina si la asignatura es de recursamiento en la oferta para la inscripcion...    

    public String getRecursamiento() {
        return recursamiento;
    }

    public void setRecursamiento(String recursamiento) {
        this.recursamiento = recursamiento;
    }
    public boolean isSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }
    
    

    public OfertaAcademica() {
        
    }

    public OfertaAcademica(Integer idOfertaAcademica) {
        this.idOfertaAcademica = idOfertaAcademica;
    }
    
    public OfertaAcademica(Integer idOfertaAcademica, Asignaturas asignatura) {
        this.idOfertaAcademica = idOfertaAcademica;
        this.asignatura = asignatura;
    }
    

    public Integer getIdOfertaAcademica() {
        return idOfertaAcademica;
    }

    public void setIdOfertaAcademica(Integer idOfertaAcademica) {
        this.idOfertaAcademica = idOfertaAcademica;
    }

    public Asignaturas getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignaturas asignatura) {
        this.asignatura = asignatura;
    }

    public Grupos getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupos grupo) {
        this.grupo = grupo;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupoCiclo) {
        this.idGrupo = idGrupoCiclo;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }
        
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertaAcademica != null ? idOfertaAcademica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OfertaAcademica)) {
            return false;
        }
        OfertaAcademica other = (OfertaAcademica) object;
        if ((this.idOfertaAcademica == null && other.idOfertaAcademica != null) || (this.idOfertaAcademica != null && !this.idOfertaAcademica.equals(other.idOfertaAcademica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.asignatura.getNombre();
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }
}
