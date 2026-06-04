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

    public List<Consulta> listarConsultas() {

        return dao.listarTodos();
    }

    public Consulta buscarPorId(
            int id) {

        return dao.buscarPorId(id);
    }
}