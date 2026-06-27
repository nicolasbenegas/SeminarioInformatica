package clinicgest.view;

import clinicgest.model.SolicitudExamen;

/**
 * Clase "SolicitudExamenView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class SolicitudExamenView {

	//Métodos
    public SolicitudExamen
    cargarExamen() {

        SolicitudExamen examen =
                new SolicitudExamen();

        examen.setTipoExamen(
                ConsolaUtils.leerTexto(
                        "Tipo examen: "));

        examen.setDescripcion(
                ConsolaUtils.leerTexto(
                        "Descripción: "));

        examen.setIndicaciones(
                ConsolaUtils.leerTexto(
                        "Indicaciones: "));

        return examen;
    }
}