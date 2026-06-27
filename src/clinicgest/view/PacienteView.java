package clinicgest.view;

import clinicgest.model.Paciente;

/**
 * Clase "PacienteView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class PacienteView {

	//Métodos
    public Paciente cargarPaciente() {

        System.out.println(
                "\n===== ALTA PACIENTE =====");

        String dni =
                ConsolaUtils.leerTexto(
                        "DNI (99 cancelar): ");

        if (dni.equals("99")) {

            return null;
        }

        Paciente paciente =
                new Paciente();

        paciente.setDni(dni);

        paciente.setNombre(
                ConsolaUtils.leerTexto(
                        "Nombre: "));

        paciente.setApellido(
                ConsolaUtils.leerTexto(
                        "Apellido: "));

        paciente.setSexo(
                ConsolaUtils.leerTexto(
                        "Sexo: "));

        paciente.setEmail(
                ConsolaUtils.leerTexto(
                        "Email: "));

        paciente.setContacto(
                ConsolaUtils.leerTexto(
                        "Teléfono: "));

        paciente.setCalle(
                ConsolaUtils.leerTexto(
                        "Calle: "));

        paciente.setNumeroCalle(
                ConsolaUtils.leerEntero(
                        "Número: "));

        paciente.setBarrio(
                ConsolaUtils.leerTexto(
                        "Barrio: "));

        paciente.setLocalidad(
                ConsolaUtils.leerTexto(
                        "Localidad: "));

        return paciente;
    }
}