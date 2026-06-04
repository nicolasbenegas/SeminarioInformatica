package clinicgest.view;

import clinicgest.model.Consulta;

/**
 * Clase "ConsultaView"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class ConsultaView {

	//Métodos
    public Consulta cargarConsulta() {

        Consulta consulta =
                new Consulta();

        consulta.setMotivoConsulta(
                ConsolaUtils.leerTexto(
                        "Motivo consulta: "));

        consulta.setObservaciones(
                ConsolaUtils.leerTexto(
                        "Observaciones: "));

        return consulta;
    }
}