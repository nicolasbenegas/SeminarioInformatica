package clinicgest.view;

import clinicgest.model.ProfesionalSalud;

/**
 * Clase "ProfesionalView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class ProfesionalView {

	//Métodos
    public ProfesionalSalud
    cargarProfesional() {

        System.out.println(
                "\n===== ALTA PROFESIONAL =====");

        ProfesionalSalud profesional =
                new ProfesionalSalud();

        profesional.setDni(
                ConsolaUtils.leerTexto(
                        "DNI: "));

        profesional.setNombre(
                ConsolaUtils.leerTexto(
                        "Nombre: "));

        profesional.setApellido(
                ConsolaUtils.leerTexto(
                        "Apellido: "));

        profesional.setMatricula(
                ConsolaUtils.leerTexto(
                        "Matrícula: "));

        profesional.setEmail(
                ConsolaUtils.leerTexto(
                        "Email: "));

        return profesional;
    }
}