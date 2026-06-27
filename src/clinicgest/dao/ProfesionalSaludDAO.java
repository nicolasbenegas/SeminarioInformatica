package clinicgest.dao;

import clinicgest.model.ProfesionalSalud;

import java.util.List;

/**
 * Clase "ProfesionalSaludDAO"
 * Contrato de acceso a datos
 * Capa -> DAO
 */
public interface ProfesionalSaludDAO {

    void guardar(
            ProfesionalSalud profesional);

    void actualizar(
            ProfesionalSalud profesional);

    void eliminar(
            int id);

    ProfesionalSalud buscarPorId(
            int id);

    ProfesionalSalud buscarPorMatricula(
            String matricula);

    List<ProfesionalSalud>
    listarTodos();
}