package clinicgest.view;

import clinicgest.model.Turno;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase "TurnoView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class TurnoView {

	//Métodos
    public Turno cargarTurno() {

        Turno turno =
                new Turno();

        turno.setFecha(
                LocalDate.parse(
                        ConsolaUtils.leerTexto(
                                "Fecha (AAAA-MM-DD): ")));

        turno.setHora(
                LocalTime.parse(
                        ConsolaUtils.leerTexto(
                                "Hora (HH:mm): ")));

        return turno;
    }
}