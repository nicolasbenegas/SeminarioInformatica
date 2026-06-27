package clinicgest.service;

import clinicgest.dao.ConsultaDAO;
import clinicgest.dao.impl.ConsultaDAOImpl;
import clinicgest.exception.ValidacionException;
import clinicgest.model.*;

import java.util.List;

/**
 * Clase "ConsultaService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class ConsultaService {

	//Atributos
    private final ConsultaDAO dao;

	//Métodos
    public ConsultaService() {

        dao = new ConsultaDAOImpl();
    }

    public void registrarConsulta(
            Consulta consulta)
            throws ValidacionException {

        if (consulta == null) {

            throw new ValidacionException(
                    "Consulta inválida");
        }

        dao.guardar(consulta);

        if (consulta.getPaciente() != null
                && consulta.getPaciente()
                .getHistoriaClinica() != null) {

            consulta.getPaciente()
                    .getHistoriaClinica()
                    .agregarConsulta(consulta);
        }
    }
	
	public void agregarTexto(
        int idConsulta,
        String titulo,
        String texto) {

    dao.agregarTexto(
            idConsulta,
            titulo,
            texto);
	}
	
	public void actualizarConsulta(Consulta consulta) {

    dao.actualizar(consulta);
	}

    public void agregarDiagnostico(
            Consulta consulta,
            Diagnostico diagnostico)
            throws ValidacionException {

        if (consulta == null
                || diagnostico == null) {

            throw new ValidacionException(
                    "Datos inválidos");
        }

        consulta.agregarDiagnostico(
                diagnostico);
    }

    public void generarReceta(
            Consulta consulta,
            RecetaMedica receta)
            throws ValidacionException {

        if (consulta == null
                || receta == null) {

            throw new ValidacionException(
                    "Datos inválidos");
        }

        consulta.setReceta(receta);
    }

    public void solicitarExamen(
            Consulta consulta,
            SolicitudExamen examen)
            throws ValidacionException {

        if (consulta == null
                || examen == null) {

            throw new ValidacionException(
                    "Datos inválidos");
        }

        consulta.agregarExamen(examen);
    }

	public void guardarDiagnostico(
        int consultaId,
        String descripcion) {

    dao.guardarDiagnostico(
            consultaId,
            descripcion);
	}

	public void guardarReceta(
        int consultaId,
        String medicamentos,
        String indicaciones) {

    dao.guardarReceta(
            consultaId,
            medicamentos,
            indicaciones);
	}

	public void guardarSolicitudExamen(
        int consultaId,
        String tipoExamen,
        String descripcion) {

    dao.guardarSolicitudExamen(
            consultaId,
            tipoExamen,
            descripcion);
	}
	
    public List<Consulta> listarConsultas() {

        return dao.listarTodos();
    }

    public Consulta buscarPorId(
            int id) {

        return dao.buscarPorId(id);
    }
	
	public List<Consulta> buscarPorDniPaciente(
        String dni) {

    return dao.buscarPorDniPaciente(
            dni);
	}
}