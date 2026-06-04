package clinicgest.view;

import clinicgest.model.Consulta;
import clinicgest.model.Paciente;

/**
 * Clase "HistoriaClinicaView"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class HistoriaClinicaView {

	//Métodos
    public void mostrar(
            Paciente paciente) {

        System.out.println(
                "\n===== HISTORIA CLÍNICA =====");

        if (paciente == null) {

            System.out.println(
                    "Paciente inexistente");

            return;
        }

        if (paciente.getHistoriaClinica()
                == null) {

            System.out.println(
                    "Sin historia clínica");

            return;
        }

        for (Consulta consulta :
                paciente
                        .getHistoriaClinica()
                        .getConsultas()) {

            System.out.println(
                    consulta);
        }
    }
}