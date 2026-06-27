package clinicgest.controller;

import clinicgest.exception.ValidacionException;
import clinicgest.model.Consulta;
import clinicgest.model.Diagnostico;
import clinicgest.model.RecetaMedica;
import clinicgest.model.SolicitudExamen;
import clinicgest.service.ConsultaService;

import java.util.List;

/**
 * Clase "ConsultaController"
 * Control y coordinación
 * Capa -> Controller
 */
public class ConsultaController {

	//Atributos
    private final ConsultaService service;

	//Métodos
    public ConsultaController() {

        service =
                new ConsultaService();
    }

    public void registrarConsulta(
            Consulta consulta)
            throws ValidacionException {

        service.registrarConsulta(
                consulta);
    }
	
	public void actualizarConsulta(Consulta consulta) {

    service.actualizarConsulta(consulta);
	}
	
	public void agregarTexto(
        int idConsulta,
        String titulo,
        String texto) {

    service.agregarTexto(
            idConsulta,
            titulo,
            texto);
	}

    public void agregarDiagnostico(
            Consulta consulta,
            Diagnostico diagnostico)
            throws ValidacionException {

        service.agregarDiagnostico(
                consulta,
                diagnostico);
    }

    public void generarReceta(
            Consulta consulta,
            RecetaMedica receta)
            throws ValidacionException {

        service.generarReceta(
                consulta,
                receta);
    }

    public void solicitarExamen(
            Consulta consulta,
            SolicitudExamen examen)
            throws ValidacionException {

        service.solicitarExamen(
                consulta,
                examen);
    }

    public Consulta buscarPorId(
            int id) {

        return service.buscarPorId(id);
    }

	public void guardarDiagnostico(
        int consultaId,
        String descripcion) {

    service.guardarDiagnostico(
            consultaId,
            descripcion);
	}

	public void guardarReceta(
        int consultaId,
        String medicamentos,
        String indicaciones) {

    service.guardarReceta(
            consultaId,
            medicamentos,
            indicaciones);
	}

	public void guardarSolicitudExamen(
        int consultaId,
        String tipoExamen,
        String descripcion) {

    service.guardarSolicitudExamen(
            consultaId,
            tipoExamen,
            descripcion);
	}

    public List<Consulta>
    listarConsultas() {

        return service.listarConsultas();
    }
	
	public List<Consulta> buscarPorDniPaciente(
        String dni) {

    return service.buscarPorDniPaciente(
            dni);
	}
}