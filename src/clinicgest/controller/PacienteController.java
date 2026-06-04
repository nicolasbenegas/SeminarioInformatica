package clinicgest.controller;

import clinicgest.exception.ValidacionException;
import clinicgest.model.Paciente;
import clinicgest.service.PacienteService;

import java.util.List;

/**
 * Clase "PacienteController"
 * Control y coordinación
 * Capa -> Controller
 */
public class PacienteController {

	//Atributos
    private final PacienteService service;

	//Métodos
    public PacienteController() {

        service = new PacienteService();
    }

    public void registrarPaciente(
            Paciente paciente)
            throws ValidacionException {

        service.registrarPaciente(
                paciente);
    }

    public Paciente buscarPorDni(
            String dni) {

        return service.buscarPorDni(dni);
    }

    public List<Paciente>
    listarPacientes() {

        return service.listarPacientes();
    }
}