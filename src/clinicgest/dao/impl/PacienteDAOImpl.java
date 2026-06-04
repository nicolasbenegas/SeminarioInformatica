package clinicgest.dao.impl;

import clinicgest.dao.PacienteDAO;
import clinicgest.model.Paciente;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "PacienteDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class PacienteDAOImpl
        implements PacienteDAO {

    private static final List<Paciente>
            pacientes =
            new ArrayList<>();

    @Override
    public void guardar(
            Paciente paciente) {

        pacientes.add(paciente);
    }

    @Override
    public void actualizar(
            Paciente paciente) {

    }

    @Override
    public void eliminar(
            int id) {

        pacientes.removeIf(
                p -> p.getId() == id);
    }

    @Override
    public Paciente buscarPorId(
            int id) {

        return pacientes.stream()
                .filter(
                        p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public Paciente buscarPorDni(
            String dni) {

        return pacientes.stream()
                .filter(
                        p -> p.getDni()
                                .equals(dni))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Paciente>
    listarTodos() {

        return pacientes;
    }
}