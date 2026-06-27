package clinicgest.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase "Consulta"
 * Paquete de modelo de objetos y datos.
 */
public class Consulta {

    //Atributos
	private int id;

    private LocalDateTime fechaHora;

    private String motivoConsulta;

    private String observaciones;

    private Paciente paciente;

    private ProfesionalSalud profesional;

    private Turno turno;

    private List<Diagnostico> diagnosticos;

    private RecetaMedica receta;

    private List<SolicitudExamen> solicitudesExamen;

	//Constructor
    public Consulta() {

        fechaHora = LocalDateTime.now();

        diagnosticos = new ArrayList<>();

        solicitudesExamen =
                new ArrayList<>();
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(
            LocalDateTime fechaHora) {

        this.fechaHora = fechaHora;
    }


    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(
            String motivoConsulta) {

        this.motivoConsulta =
                motivoConsulta;
    }


    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(
            String observaciones) {

        this.observaciones =
                observaciones;
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


    public Turno getTurno() {
        return turno;
    }

    public void setTurno(
            Turno turno) {

        this.turno = turno;
    }


    public List<Diagnostico>
    getDiagnosticos() {

        return diagnosticos;
    }

    public void setDiagnosticos(
            List<Diagnostico> diagnosticos) {

        this.diagnosticos =
                diagnosticos;
    }


    public RecetaMedica getReceta() {
        return receta;
    }

    public void setReceta(
            RecetaMedica receta) {

        this.receta = receta;
    }


    public List<SolicitudExamen>
    getSolicitudesExamen() {

        return solicitudesExamen;
    }

    public void setSolicitudesExamen(
            List<SolicitudExamen> solicitudesExamen) {

        this.solicitudesExamen =
                solicitudesExamen;
    }

    public void agregarDiagnostico(
            Diagnostico diagnostico) {

        diagnosticos.add(diagnostico);
    }

    public void agregarExamen(
            SolicitudExamen examen) {

        solicitudesExamen.add(examen);
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
	public String toString() {

    StringBuilder sb =
            new StringBuilder();

    sb.append("\n");
    sb.append("===============================================\n");
    sb.append("                CONSULTA\n");
    sb.append("===============================================\n");

    sb.append(String.format(
            "ID Consulta  : %d%n",
            id));

    sb.append(String.format(
            "Paciente     : %s%n",
            paciente != null
                    ? paciente.getNombreCompleto()
                    : "N/D"));

    sb.append(String.format(
            "Profesional  : %s%n",
            profesional != null
                    ? profesional.getNombreCompleto()
                    : "N/D"));

    sb.append(String.format(
            "Fecha        : %s%n",
            fechaHora != null
                    ? fechaHora.toLocalDate()
                            + " "
                            + fechaHora.toLocalTime()
                    : "N/D"));

    sb.append("\n");

    sb.append("Motivo:\n");
    sb.append(motivoConsulta != null
            ? motivoConsulta
            : "");
    sb.append("\n\n");

    sb.append("Observaciones:\n");
    sb.append(observaciones != null
            ? observaciones
            : "");
    sb.append("\n");

    sb.append("===============================================\n");

    return sb.toString();
	}
}