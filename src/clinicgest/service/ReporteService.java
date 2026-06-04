package clinicgest.service;

import clinicgest.dao.ConsultaDAO;
import clinicgest.dao.PacienteDAO;
import clinicgest.dao.ReporteDAO;
import clinicgest.dao.TurnoDAO;
import clinicgest.dao.impl.ConsultaDAOImpl;
import clinicgest.dao.impl.PacienteDAOImpl;
import clinicgest.dao.impl.ReporteDAOImpl;
import clinicgest.dao.impl.TurnoDAOImpl;
import clinicgest.model.Reporte;

/**
 * Clase "ReporteService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class ReporteService {

	//Atributos
    private final PacienteDAO pacienteDAO;
    private final TurnoDAO turnoDAO;
    private final ConsultaDAO consultaDAO;
    private final ReporteDAO reporteDAO;

	//Métodos
    public ReporteService() {

        pacienteDAO =
                new PacienteDAOImpl();

        turnoDAO =
                new TurnoDAOImpl();

        consultaDAO =
                new ConsultaDAOImpl();

        reporteDAO =
                new ReporteDAOImpl();
    }

    public Reporte generarReportePacientes() {

        Reporte reporte =
                new Reporte();

        reporte.setTipo(
                "PACIENTES");

        reporte.setContenido(
                "Total pacientes: "
                        + pacienteDAO
                        .listarTodos()
                        .size());

        reporteDAO.guardar(reporte);

        return reporte;
    }

    public Reporte generarReporteTurnos() {

        Reporte reporte =
                new Reporte();

        reporte.setTipo(
                "TURNOS");

        reporte.setContenido(
                "Total turnos: "
                        + turnoDAO
                        .listarTodos()
                        .size());

        reporteDAO.guardar(reporte);

        return reporte;
    }

    public Reporte generarReporteConsultas() {

        Reporte reporte =
                new Reporte();

        reporte.setTipo(
                "CONSULTAS");

        reporte.setContenido(
                "Total consultas: "
                        + consultaDAO
                        .listarTodos()
                        .size());

        reporteDAO.guardar(reporte);

        return reporte;
    }
}