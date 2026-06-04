package clinicgest.controller;

import clinicgest.exception.ValidacionException;
import clinicgest.model.ProfesionalSalud;
import clinicgest.service.ProfesionalSaludService;

import java.util.List;

/**
 * Clase "ProfesionalController"
 * Control y coordinación
 * Capa -> Controller
 */
public class ProfesionalController {

	//Atributos
    private final ProfesionalSaludService service;

	//Métodos
    public ProfesionalController() {

        service =
                new ProfesionalSaludService();
    }

    public void registrar(
            ProfesionalSalud profesional)
            throws ValidacionException {

        service.registrar(profesional);
    }

    public List<ProfesionalSalud>
    listar() {

        return service.listar();
    }

    public ProfesionalSalud buscarPorMatricula(
            String matricula) {

        return service.buscarPorMatricula(
                matricula);
    }
}