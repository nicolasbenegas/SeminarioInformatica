package clinicgest.view;

/**
 * Clase "MenuAdministrador"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class MenuAdministrador {

	//Atributos
    private final MenuUsuarios menuUsuarios;
    private final MenuEspecialidades menuEspecialidades;
    private final MenuProfesionales menuProfesionales;
	private final MenuReportes menuReportes;

	//Métodos

    //Método encargado de Menú Administrador.
    public MenuAdministrador() {

        menuUsuarios =
                new MenuUsuarios();

        menuEspecialidades =
                new MenuEspecialidades();

        menuProfesionales =
                new MenuProfesionales();
		
		menuReportes =
        new MenuReportes();
    }

    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== ADMINISTRADOR =====");

            System.out.println(
                    "1 - Usuarios");

            System.out.println(
                    "2 - Especialidades");

            System.out.println(
                    "3 - Profesionales");

            System.out.println(
                    "4 - Reportes");

            System.out.println(
                    "0 - Cerrar sesión");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:

                    menuUsuarios.mostrar();
                    break;

                case 2:

                    menuEspecialidades.mostrar();
                    break;

                case 3:

                    menuProfesionales.mostrar();
                    break;

                case 4:

                    menuReportes.mostrar();
                    break;
            }

        } while (opcion != 0);
    }
}