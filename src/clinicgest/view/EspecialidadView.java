package clinicgest.view;

import clinicgest.model.Especialidad;

/**
 * Clase "EspecialidadView"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class EspecialidadView {

	//Métodos
    public Especialidad
    cargarEspecialidad() {

        Especialidad especialidad =
                new Especialidad();

        especialidad.setNombre(
                ConsolaUtils.leerTexto(
                        "Nombre: "));

        especialidad.setDescripcion(
                ConsolaUtils.leerTexto(
                        "Descripción: "));

        return especialidad;
    }
}