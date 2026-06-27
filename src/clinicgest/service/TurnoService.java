package clinicgest.service;

import clinicgest.dao.TurnoDAO;
import clinicgest.dao.impl.TurnoDAOImpl;
import clinicgest.exception.TurnoException;
import clinicgest.model.EstadoTurno;
import clinicgest.model.Turno;

import java.util.List;

/**
 * Clase "TurnoService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class TurnoService {

	//Atributos
    private final TurnoDAO dao;

	//Métodos
    public TurnoService() {

        dao = new TurnoDAOImpl();
    }

    public void asignarTurno(
            Turno turno)
            throws TurnoException {

        if (turno == null) {

            throw new TurnoException(
                    "Turno inválido");
        }

        if (turno.getPaciente() == null) {

            throw new TurnoException(
                    "Debe seleccionar paciente");
        }

        if (turno.getProfesional() == null) {

            throw new TurnoException(
                    "Debe seleccionar profesional");
        }

        dao.guardar(turno);
    }

    public void cancelarTurno(
            int id)
            throws TurnoException {

        Turno turno =
                dao.buscarPorId(id);

        if (turno == null) {

            throw new TurnoException(
                    "Turno inexistente");
        }

        turno.setEstado(
                EstadoTurno.CANCELADO);

        dao.actualizar(turno);
    }

    public List<Turno> listarTurnos() {

        return dao.listarTodos();
    }

    public Turno buscarPorId(
            int id) {

        return dao.buscarPorId(id);
    }
}