package clinicgest.dao.impl;

import clinicgest.dao.TurnoDAO;
import clinicgest.model.Turno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase "TurnoDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class TurnoDAOImpl
        implements TurnoDAO {

    private static final List<Turno>
            turnos =
            new ArrayList<>();

    @Override
    public void guardar(
            Turno turno) {

        turnos.add(turno);
    }

    @Override
    public void actualizar(
            Turno turno) {

    }

    @Override
    public void eliminar(
            int id) {

        turnos.removeIf(
                t -> t.getId() == id);
    }

    @Override
    public Turno buscarPorId(
            int id) {

        return turnos.stream()
                .filter(
                        t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Turno> buscarPorFecha(
            LocalDate fecha) {

        return turnos.stream()
                .filter(
                        t -> t.getFecha()
                                .equals(fecha))
                .collect(
                        Collectors.toList());
    }

    @Override
    public List<Turno>
    listarTodos() {

        return turnos;
    }
}