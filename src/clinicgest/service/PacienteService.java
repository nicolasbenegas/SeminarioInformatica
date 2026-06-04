package clinicgest.service;

import clinicgest.dao.PacienteDAO;
import clinicgest.dao.impl.PacienteDAOImpl;
import clinicgest.exception.ValidacionException;
import clinicgest.model.HistoriaClinica;
import clinicgest.model.Paciente;

import java.time.LocalDate;
import java.util.List;

/**
 * Clase "PacienteService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class PacienteService {

	//Atributos
    private final PacienteDAO dao;

	//Métodos
    public PacienteService() {

        dao = new PacienteDAOImpl();
    }

    public void registrarPaciente(
            Paciente paciente)
            throws ValidacionException {

        validarPaciente(paciente);

        if (paciente.getHistoriaClinica() == null) {

            HistoriaClinica historia =
                    new HistoriaClinica();

            historia.setFechaCreacion(
                    LocalDate.now());

            paciente.setHistoriaClinica(
                    historia);
        }

        dao.guardar(paciente);
    }

    public Paciente buscarPorDni(
            String dni) {

        return dao.buscarPorDni(dni);
    }

    public List<Paciente> listarPacientes() {

        return dao.listarTodos();
    }

    private void validarPaciente(
            Paciente paciente)
            throws ValidacionException {

        if (paciente == null) {

            throw new ValidacionException(
                    "Paciente inválido");
        }

        if (paciente.getDni() == null
                || paciente.getDni().isBlank()) {

            throw new ValidacionException(
                    "Debe ingresar DNI");
        }

        if (paciente.getNombre() == null
                || paciente.getNombre().isBlank()) {

            throw new ValidacionException(
                    "Debe ingresar nombre");
        }

        if (paciente.getApellido() == null
                || paciente.getApellido().isBlank()) {

            throw new ValidacionException(
                    "Debe ingresar apellido");
        }
    }
}