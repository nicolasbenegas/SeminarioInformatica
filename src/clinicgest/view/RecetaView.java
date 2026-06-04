package clinicgest.view;

import clinicgest.model.RecetaMedica;

/**
 * Clase "RecetaView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class RecetaView {

	//Métodos
    public RecetaMedica
    cargarReceta() {

        RecetaMedica receta =
                new RecetaMedica();

        receta.setMedicamentos(
                ConsolaUtils.leerTexto(
                        "Medicamentos: "));

        receta.setIndicaciones(
                ConsolaUtils.leerTexto(
                        "Indicaciones: "));

        return receta;
    }
}