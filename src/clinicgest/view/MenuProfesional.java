package clinicgest.view;

/**
 * Clase "MenuProfesional"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuProfesional {

    private final MenuConsultas menuConsultas;

	//Métodos
	
    //Método encargado de Menú Profesional.
    public MenuProfesional() {

        menuConsultas =
                new MenuConsultas();
    }

    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== PROFESIONAL =====");

            System.out.println(
                    "1 - Consultas");

            System.out.println(
                    "2 - Historia Clínica");

            System.out.println(
                    "0 - Cerrar sesión");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:

                    menuConsultas.mostrar();
                    break;

                case 2:

                    System.out.println(
                            "Historia clínica");

                    ConsolaUtils.pausar();
                    break;
            }

        } while (opcion != 0);
    }
}