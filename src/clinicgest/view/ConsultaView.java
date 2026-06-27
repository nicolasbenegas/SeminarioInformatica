package clinicgest.view;

import clinicgest.model.Consulta;
import clinicgest.model.Paciente;
import clinicgest.model.ProfesionalSalud;

/**
 * Clase "ConsultaView"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class ConsultaView {

    public Consulta cargarConsulta() {

        Consulta consulta =
                new Consulta();

        String dni =
                ConsolaUtils.leerTexto(
                        "DNI paciente: ");

        Paciente paciente =
                new Paciente();

        paciente.setDni(dni);

        consulta.setPaciente(
                paciente);

        String matricula =
                ConsolaUtils.leerTexto(
                        "Matrícula profesional: ");

        ProfesionalSalud profesional =
                new ProfesionalSalud();

        profesional.setMatricula(
                matricula);

        consulta.setProfesional(
                profesional);

        consulta.setMotivoConsulta(
                ConsolaUtils.leerTexto(
                        "Motivo consulta: "));

        consulta.setObservaciones(
                ConsolaUtils.leerTexto(
                        "Observaciones: "));

        return consulta;
    }

}