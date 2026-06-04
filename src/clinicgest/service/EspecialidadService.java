package clinicgest.service;

import clinicgest.dao.EspecialidadDAO;
import clinicgest.dao.impl.EspecialidadDAOImpl;
import clinicgest.exception.ValidacionException;
import clinicgest.model.Especialidad;

import java.util.List;

/**
 * Clase "EspecialidadService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class EspecialidadService {

	//Atributos
    private final EspecialidadDAO dao;

	//Métodos
    public EspecialidadService() {

        dao =
                new EspecialidadDAOImpl();
    }

    public void registrarEspecialidad(
            Especialidad especialidad)
            throws ValidacionException {

        if (especialidad == null) {

            throw new ValidacionException(
                    "Especialidad inválida");
        }

        dao.guardar(especialidad);
    }

    public List<Especialidad>
    listarEspecialidades() {

        return dao.listarTodos();
    }
}