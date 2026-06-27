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

    StringBuilder sb =
            new StringBuilder();

    sb.append("\n");
    sb.append("===============================================\n");
    sb.append("               TURNO MÉDICO\n");
    sb.append("===============================================\n");

    sb.append(String.format(
            "Fecha        : %s%n",
            fecha));

    sb.append(String.format(
            "Hora         : %s%n",
            hora));

    sb.append(String.format(
        "Paciente     : %s%n",
        paciente != null
                ? paciente.getNombreCompleto()
                : "N/D"));

	sb.append(String.format(
        "DNI          : %s%n",
        paciente != null
                ? paciente.getDni()
                : "N/D"));

    sb.append(String.format(
            "Profesional  : %s%n",
            profesional != null
                    ? profesional.getNombreCompleto()
                    : "N/D"));

    sb.append(String.format(
            "Matrícula    : %s%n",
            profesional != null
                    ? profesional.getMatricula()
                    : "N/D"));

    sb.append(String.format(
            "Especialidad : %s%n",
            profesional != null
                    && profesional.getEspecialidad() != null
                    ? profesional.getEspecialidad().getNombre()
                    : "N/D"));

    sb.append(String.format(
            "Estado       : %s%n",
            estado));

    sb.append("===============================================\n");

    return sb.toString();
	}
}