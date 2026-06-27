package clinicgest.view;

import clinicgest.controller.PacienteController;
import clinicgest.model.Paciente;

/**
 * Clase "MenuRecepcionista"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuRecepcionista {

    private final MenuTurnos menuTurnos;

    private final PacienteController
            pacienteController;

    //Métodos
    public MenuRecepcionista() {

        menuTurnos =
                new MenuTurnos();

        pacienteController =
                new PacienteController();
    }

    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== RECEPCIONISTA =====");

            System.out.println(
                    "1 - Pacientes");

            System.out.println(
                    "2 - Turnos");

            System.out.println(
                    "0 - Cerrar sesión");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:

                    menuPacientes();
                    break;

                case 2:

                    menuTurnos.mostrar();
                    break;
            }

        } while (opcion != 0);
    }

    private void menuPacientes() {

        int opcion;

        do {

            System.out.println(
                    "\n===== PACIENTES =====");

            System.out.println(
                    "1 - Listar pacientes");

            System.out.println(
                    "2 - Buscar por DNI");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils
                            .leerEntero(
                                    "Opción: ");

            switch (opcion) {

                case 1:

                    listarPacientes();
                    break;

                case 2:

                    buscarPaciente();
                    break;
            }

        } while (opcion != 0);
    }

    private void listarPacientes() {

    System.out.println(
            "\n===== LISTA DE PACIENTES =====");

    for (Paciente p :
            pacienteController
                    .listarPacientes()) {

        System.out.println(p);
    }

    ConsolaUtils.pausar();
	}

    private void buscarPaciente() {

        String dni =
                ConsolaUtils
                        .leerTexto(
                                "DNI: ");

        Paciente p =
                pacienteController
                        .buscarPorDni(
                                dni);

        if (p == null) {

            System.out.println(
                    "\nPaciente no encontrado");

        } else {

            System.out.println(
                    "\n===== PACIENTE =====");

            System.out.println(
                    "Nombre: "
                            + p.getNombre()
                            + " "
                            + p.getApellido());

            System.out.println(
                    "Email: "
                            + p.getEmail());

            System.out.println(
                    "Contacto: "
                            + p.getContacto());

            System.out.println(
                    "Localidad: "
                            + p.getLocalidad());
        }

        ConsolaUtils.pausar();
    }
}