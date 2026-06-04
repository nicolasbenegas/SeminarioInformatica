package clinicgest.controller;

import clinicgest.exception.TurnoException;
import clinicgest.model.Turno;
import clinicgest.service.TurnoService;

import java.util.List;

/**
 * Clase "TurnoController"
 * Control y coordinación
 * Capa -> Controller
 */
public class TurnoController {

	//Atributos
    private final TurnoService service;

	//Métodos
    public TurnoController() {

        service = new TurnoService();
    }

    public void asignarTurno(
            Turno turno)
            throws TurnoException {

        service.asignarTurno(turno);
    }

    public void cancelarTurno(
            int id)
            throws TurnoException {

        service.cancelarTurno(id);
    }

    public Turno buscarPorId(
            int id) {

        return service.buscarPorId(id);
    }

    public List<Turno>
    listarTurnos() {

        return service.listarTurnos();
    }
}