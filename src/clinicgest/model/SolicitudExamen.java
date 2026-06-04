package clinicgest.model;

import java.time.LocalDateTime;

/**
 * Clase "SolicitudExamen"
 * Paquete de modelo de objetos y datos.
 */
public class SolicitudExamen {

    //Atributos
    private int id;

    private LocalDateTime fecha;

    private String tipoExamen;

    private String descripcion;

    private String indicaciones;

    private String estado;

	//Constructor
    public SolicitudExamen() {

        fecha = LocalDateTime.now();

        estado = "PENDIENTE";
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(
            LocalDateTime fecha) {

        this.fecha = fecha;
    }


    public String getTipoExamen() {
        return tipoExamen;
    }

    public void setTipoExamen(
            String tipoExamen) {

        this.tipoExamen =
                tipoExamen;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(
            String descripcion) {

        this.descripcion =
                descripcion;
    }


    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(
            String indicaciones) {

        this.indicaciones =
                indicaciones;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(
            String estado) {

        this.estado = estado;
    }

    public void marcarPendiente() {

        estado = "PENDIENTE";
    }

    public void marcarRealizado() {

        estado = "REALIZADO";
    }

    public void cancelar() {

        estado = "CANCELADO";
    }

    public boolean estaPendiente() {

        return estado.equals(
                "PENDIENTE");
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return tipoExamen +
                " [" + estado + "]";
    }
}