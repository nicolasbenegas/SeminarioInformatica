package clinicgest.service;

import clinicgest.dao.ProfesionalSaludDAO;
import clinicgest.dao.impl.ProfesionalSaludDAOImpl;
import clinicgest.exception.ValidacionException;
import clinicgest.model.ProfesionalSalud;

import java.util.List;

/**
 * Clase "ProfesionalSaludService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class ProfesionalSaludService {

    //Atributos
    private final ProfesionalSaludDAO dao;

    //Métodos
    public ProfesionalSaludService() {

        dao =
                new ProfesionalSaludDAOImpl();
    }

    public void registrar(
            ProfesionalSalud profesional)
            throws ValidacionException {

        if (profesional == null) {

            throw new ValidacionException(
                    "Profesional inválido");
        }

        if (profesional.getMatricula() == null
                || profesional.getMatricula().isBlank()) {

            throw new ValidacionException(
                    "Debe ingresar matrícula");
        }

        dao.guardar(profesional);
    }

    public List<ProfesionalSalud>
    listar() {

        return dao.listarTodos();
    }

    public ProfesionalSalud buscarPorMatricula(
            String matricula) {

        return dao.buscarPorMatricula(
                matricula);
    }

    public ProfesionalSalud buscarPorId(
            int id) {

        return dao.buscarPorId(id);
    }

    public void actualizar(
            ProfesionalSalud profesional) {

        dao.actualizar(
                profesional);
    }

    public void eliminar(
            int id) {

        dao.eliminar(id);
    }
}