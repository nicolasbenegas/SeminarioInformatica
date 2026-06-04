package clinicgest.controller;

import clinicgest.exception.ValidacionException;
import clinicgest.model.Especialidad;
import clinicgest.service.EspecialidadService;

import java.util.List;

/**
 * Clase "EspecialidadController"
 * Control y coordinación
 * Capa -> Controller
 */
public class EspecialidadController {

	//Atributos
    private final EspecialidadService service;

	//Métodos
    public EspecialidadController() {

        service = new EspecialidadService();
    }

    public void registrarEspecialidad(
            Especialidad especialidad)
            throws ValidacionException {

        service.registrarEspecialidad(
                especialidad);
    }

    public List<Especialidad>
    listarEspecialidades() {

        return service.listarEspecialidades();
    }
}