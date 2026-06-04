package clinicgest.view;

import clinicgest.model.Diagnostico;

/**
 * Clase "DiagnosticoView"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class DiagnosticoView {

	//Métodos
    public Diagnostico
    cargarDiagnostico() {

        Diagnostico diagnostico =
                new Diagnostico();

        diagnostico.setDescripcion(
                ConsolaUtils.leerTexto(
                        "Diagnóstico: "));

        diagnostico.setTratamiento(
                ConsolaUtils.leerTexto(
                        "Tratamiento: "));

        diagnostico.setIndicaciones(
                ConsolaUtils.leerTexto(
                        "Indicaciones: "));

        return diagnostico;
    }
}