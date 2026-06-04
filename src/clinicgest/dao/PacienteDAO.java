package clinicgest.dao;

import clinicgest.model.Paciente;

/**
 * Interfaz "PacienteDAO"
 * Acceso a datos - Interfaz
 * Capa -> DAO
 */
public interface PacienteDAO
        extends GenericDAO<Paciente> {

    Paciente buscarPorDni(String dni);
}