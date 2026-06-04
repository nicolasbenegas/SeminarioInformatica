package clinicgest.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase "Turno"
 * Paquete de modelo de objetos y datos.
 */
public class Turno {

    //Atributos
    private int id;

    private LocalDate fecha;

    private LocalTime hora;

    private EstadoTurno estado;

    private Paciente paciente;

    private ProfesionalSalud profesional;

	//Constructor
    public Turno() {

        estado =
                EstadoTurno.PENDIENTE;
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(
            LocalDate fecha) {

        this.fecha = fecha;
    }


    public LocalTime getHora() {
        return hora;
    }

    public void setHora(
            LocalTime hora) {

        this.hora = hora;
    }


    public EstadoTurno getEstado() {
        return estado;
    }

    public void setEstado(
            EstadoTurno estado) {

        this.estado = estado;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(
            Paciente paciente) {

        this.paciente = paciente;
    }


    public ProfesionalSalud getProfesional() {
        return profesional;
    }

    public void setProfesional(
            ProfesionalSalud profesional) {

        this.profesional =
                profesional;
    }

    public void confirmar() {

        estado =
                EstadoTurno.CONFIRMADO;
    }

    public void cancelar() {

        estado =
                EstadoTurno.CANCELADO;
    }

    public boolean estaConfirmado() {

        return estado ==
                EstadoTurno.CONFIRMADO;
    }

    public boolean estaCancelado() {

        return estado ==
                EstadoTurno.CANCELADO;
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return "Turno{" +
                "fecha=" + fecha +
                ", hora=" + hora +
                ", paciente=" +
                (paciente != null
                        ? paciente.getNombreCompleto()
                        : "N/D") +
                ", estado=" + estado +
                '}';
    }
}