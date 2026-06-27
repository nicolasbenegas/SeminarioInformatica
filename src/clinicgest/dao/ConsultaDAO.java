package clinicgest.dao;

import java.util.List;
import clinicgest.model.Consulta;

/**
 * Interfaz "ConsultaDAO"
 * Acceso a datos - Interfaz
 * Capa -> DAO
 */
public interface ConsultaDAO
        extends GenericDAO<Consulta> {
			
	void agregarTexto(
        int idConsulta,
        String titulo,
        String texto);
		
	void guardarDiagnostico(
        int consultaId,
        String descripcion);

	void guardarReceta(
        int consultaId,
        String medicamentos,
        String indicaciones);

	void guardarSolicitudExamen(
        int consultaId,
        String tipoExamen,
        String descripcion);
		
	List<Consulta> buscarPorDniPaciente(
        String dni);
}