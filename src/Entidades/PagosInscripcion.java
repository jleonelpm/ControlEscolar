/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Last Develop
 */
public class PagosInscripcion {
private int id_pago_inscripcion;
private int id_ciclo;
private String fecha;
private int id_alumno;
private int id_usuario;
private String pagado;

    public String getPagado() {
        return pagado;
    }

    public void setPagado(String pagado) {
        this.pagado = pagado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public int getId_ciclo() {
        return id_ciclo;
    }

    public void setId_ciclo(int id_ciclo) {
        this.id_ciclo = id_ciclo;
    }

    public int getId_pago_inscripcion() {
        return id_pago_inscripcion;
    }

    public void setId_pago_inscripcion(int id_pago_inscripcion) {
        this.id_pago_inscripcion = id_pago_inscripcion;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }


}
