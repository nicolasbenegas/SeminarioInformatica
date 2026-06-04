package clinicgest.view;

/**
 * Clase "MenuRecepcionista"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuRecepcionista {

    private final MenuTurnos menuTurnos;

	//Métodos
    public MenuRecepcionista() {

        menuTurnos =
                new MenuTurnos();
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

        System.out.println(
                "\nMódulo Pacientes");

        System.out.println(
                "Pendiente ampliar CRUD completo");

        ConsolaUtils.pausar();
    }
}