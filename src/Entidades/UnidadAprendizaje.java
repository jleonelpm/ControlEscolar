/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author leonel
 */
public class UnidadAprendizaje {
    
    private int idUnidadAprendizaje;
    private int idSubmodulo;
    private int idModulo;
    private String clave;
    private String descripcion;
    private float factorPonderacion;
    
    private Modulos modulo;
    private Asignaturas submodulo;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getFactorPonderacion() {
        return factorPonderacion;
    }

    public void setFactorPonderacion(float factorPonderacion) {
        this.factorPonderacion = factorPonderacion;
    }

    public int getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(int idModulo) {
        this.idModulo = idModulo;
    }

    public int getIdSubmodulo() {
        return idSubmodulo;
    }

    public void setIdSubmodulo(int idSubmodulo) {
        this.idSubmodulo = idSubmodulo;
    }

    public int getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(int idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public Modulos getModulo() {
        return modulo;
    }

    public void setModulo(Modulos modulo) {
        this.modulo = modulo;
    }

    public Asignaturas getSubmodulo() {
        return submodulo;
    }

    public void setSubmodulo(Asignaturas submodulo) {
        this.submodulo = submodulo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UnidadAprendizaje other = (UnidadAprendizaje) obj;
        if (this.idUnidadAprendizaje != other.idUnidadAprendizaje) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idUnidadAprendizaje;
        return hash;
    }

    @Override
    public String toString() {
        return "UnidadesAprendizaje{" + "descripcion=" + descripcion + '}';
    }
    
    
}
