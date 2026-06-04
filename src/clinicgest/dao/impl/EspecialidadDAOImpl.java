package clinicgest.dao.impl;

import clinicgest.dao.EspecialidadDAO;
import clinicgest.model.Especialidad;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "EspecialidadDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class EspecialidadDAOImpl
        implements EspecialidadDAO {

    private static final List<Especialidad>
            especialidades =
            new ArrayList<>();

    @Override
    public void guardar(
            Especialidad especialidad) {

        especialidades.add(
                especialidad);
    }

    @Override
    public void actualizar(
            Especialidad especialidad) {

    }

    @Override
    public void eliminar(
            int id) {

        especialidades.removeIf(
                e -> e.getId() == id);
    }

    @Override
    public Especialidad buscarPorId(
            int id) {

        return especialidades.stream()
                .filter(
                        e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Especialidad>
    listarTodos() {

        return especialidades;
    }
}