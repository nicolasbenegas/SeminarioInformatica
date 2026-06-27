package clinicgest.controller;

import clinicgest.model.Reporte;
import clinicgest.service.ReporteService;

/**
 * Clase "ReporteController"
 * Control y coordinación
 * Capa -> Controller
 */
public class ReporteController {

	//Atributos
    private final ReporteService service;

	//Métodos
    public ReporteController() {

        service = new ReporteService();
    }

    public Reporte generarReportePacientes() {

        return service.generarReportePacientes();
    }

    public Reporte generarReporteTurnos() {

        return service.generarReporteTurnos();
    }

    public Reporte generarReporteConsultas() {

        return service.generarReporteConsultas();
    }
}