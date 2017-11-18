/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

public class Asignaturas {

    private Integer idAsignatura;
    private String clave;
    private Short semestre;
    private String nombre;
    private String descripcion;
    private Short creditos;
    private Short horas;
    private Short componente;
    private Integer idCarrera;
    private String estado;
    private Integer idArea;
    private Integer idPlan;
    private String opcional;
    private String modulo;
    private Integer idModulo;
    private Short cantidadUnidades;
    private Float coeficientePonderacion;
    private Carreras carrera;
    private Planes plan;
    private OfertaAcademica ofertaacademica;
    private Modulos objModulo;

    public OfertaAcademica getOfertaacademica() {
        return ofertaacademica;
    }

    public void setOfertaacademica(OfertaAcademica ofertaacademica) {
        this.ofertaacademica = ofertaacademica;
    }
    private Areas area;

    public Asignaturas() {
    }

    public Asignaturas(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public Asignaturas(Integer idAsignatura, String nombre) {
        this.idAsignatura = idAsignatura;
        this.nombre = nombre;
    }

    public Asignaturas(Integer idAsignatura, int idArea) {
        this.idAsignatura = idAsignatura;
        this.idArea = idArea;
    }

    /*Constructor que me sirve jorge pool */
    public Asignaturas(Integer idAsignatura, String clave, String nombre, OfertaAcademica ofertaacademica) {
        this.idAsignatura = idAsignatura;
        this.clave = clave;
        this.nombre = nombre;
        this.ofertaacademica = ofertaacademica;
    }

    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Short getSemestre() {
        return semestre;
    }

    public void setSemestre(Short semestre) {
        this.semestre = semestre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Short getCreditos() {
        return creditos;
    }

    public void setCreditos(Short creditos) {
        this.creditos = creditos;
    }

    public Short getHoras() {
        return horas;
    }

    public void setHoras(Short horas) {
        this.horas = horas;
    }

    public Short getComponente() {
        return componente;
    }

    public void setComponente(Short componente) {
        this.componente = componente;
    }

    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getIdArea() {
        return idArea;
    }

    public void setIdArea(Integer idArea) {
        this.idArea = idArea;
    }

    public Integer getIdPlan() {
        return idPlan;
    }

    public void setIdPlan(Integer idPlan) {
        this.idPlan = idPlan;
    }

    public String getOpcional() {
        return opcional;
    }

    public void setOpcional(String opcional) {
        this.opcional = opcional;
    }

    public Short getCantidadUnidades() {
        return cantidadUnidades;
    }

    public void setCantidadUnidades(Short cantidadUnidades) {
        this.cantidadUnidades = cantidadUnidades;
    }

    public Float getCoeficientePonderacion() {
        return coeficientePonderacion;
    }

    public void setCoeficientePonderacion(Float coeficientePonderacion) {
        this.coeficientePonderacion = coeficientePonderacion;
    }

    public Integer getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(Integer idModulo) {
        this.idModulo = idModulo;
    }

    public Areas getArea() {
        return area;
    }

    public Carreras getCarrera() {
        return carrera;
    }

    public Planes getPlan() {
        return plan;
    }

    public void setArea(Areas area) {
        this.area = area;
    }

    public void setCarrera(Carreras carrera) {
        this.carrera = carrera;
    }

    public void setPlan(Planes plan) {
        this.plan = plan;
    }

    public Modulos getObjModulo() {
        return objModulo;
    }

    public void setObjModulo(Modulos objModulo) {
        this.objModulo = objModulo;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAsignatura != null ? idAsignatura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Asignaturas)) {
            return false;
        }
        Asignaturas other = (Asignaturas) object;
        if ((this.idAsignatura == null && other.idAsignatura != null) || (this.idAsignatura != null && !this.idAsignatura.equals(other.idAsignatura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre;
    }
}