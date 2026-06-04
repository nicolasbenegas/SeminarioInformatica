package clinicgest.dao;

import clinicgest.model.Turno;

import java.time.LocalDate;
import java.util.List;

/**
 * Interfaz "TurnoDAO"
 * Acceso a datos - Interfaz
 * Capa -> DAO
 */
public interface TurnoDAO
        extends GenericDAO<Turno> {

    List<Turno> buscarPorFecha(
            LocalDate fecha);
}