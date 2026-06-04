package clinicgest.view;

import clinicgest.controller.PacienteController;
import clinicgest.controller.ProfesionalController;
import clinicgest.controller.TurnoController;
import clinicgest.exception.TurnoException;
import clinicgest.model.Paciente;
import clinicgest.model.ProfesionalSalud;
import clinicgest.model.Turno;

/**
 * Clase "MenuTurnos"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuTurnos {

    private final TurnoController turnoController;
    private final PacienteController pacienteController;
    private final ProfesionalController profesionalController;
    private final TurnoView turnoView;

	//Métodos
    public MenuTurnos() {

        turnoController =
                new TurnoController();

        pacienteController =
                new PacienteController();

        profesionalController =
                new ProfesionalController();

        turnoView =
                new TurnoView();
    }

    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== GESTIÓN DE TURNOS =====");

            System.out.println(
                    "1 - Asignar turno");

            System.out.println(
                    "2 - Cancelar turno");

            System.out.println(
                    "3 - Listar turnos");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:
                    asignarTurno();
                    break;

                case 2:
                    cancelarTurno();
                    break;

                case 3:
                    listarTurnos();
                    break;
            }

        } while (opcion != 0);
    }

    private void asignarTurno() {

        try {

            String dni =
                    ConsolaUtils.leerTexto(
                            "DNI paciente: ");

            Paciente paciente =
                    pacienteController
                            .buscarPorDni(dni);

            if (paciente == null) {

                System.out.println(
                        "Paciente inexistente");

                return;
            }

            String matricula =
                    ConsolaUtils.leerTexto(
                            "Matrícula profesional: ");

            ProfesionalSalud profesional =
                    profesionalController
                            .buscarPorMatricula(
                                    matricula);

            if (profesional == null) {

                System.out.println(
                        "Profesional inexistente");

                return;
            }

            Turno turno =
                    turnoView.cargarTurno();

            turno.setPaciente(
                    paciente);

            turno.setProfesional(
                    profesional);

            turnoController
                    .asignarTurno(turno);

            System.out.println(
                    "Turno asignado.");

        } catch (TurnoException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void cancelarTurno() {

        try {

            int id =
                    ConsolaUtils.leerEntero(
                            "ID turno: ");

            turnoController
                    .cancelarTurno(id);

            System.out.println(
                    "Turno cancelado.");

        } catch (TurnoException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void listarTurnos() {

        turnoController
                .listarTurnos()
                .forEach(System.out::println);

        ConsolaUtils.pausar();
    }
}