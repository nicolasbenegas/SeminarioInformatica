package clinicgest;

import clinicgest.config.DatosIniciales;
import clinicgest.controller.LoginController;
import clinicgest.exception.LoginException;
import clinicgest.model.RolUsuario;
import clinicgest.model.UsuarioSistema;
import clinicgest.view.LoginView;
import clinicgest.view.MenuAdministrador;
import clinicgest.view.MenuProfesional;
import clinicgest.view.MenuRecepcionista;

/**
 * Clase del sistema ClinicGest.
 * Esta clase representa una entidad o componente principal del sistema.
 */
public class Main {

    private static final LoginController
            loginController =
            new LoginController();

    private static final LoginView
            loginView =
            new LoginView();


    //Método principal del sistema (main).
    public static void main(String[] args) {

        //Carga de datos provisorios para el prototipo
		DatosIniciales.cargar();

        boolean salir = false;

        while (!salir) {

            try {

                loginView.mostrarMenu();

                int opcion =
						loginView.solicitarOpcion();

                switch (opcion) {

                    case 1:

                        iniciarSesion();
                        break;

                    case 0:

                        salir = true;
                        break;
                }

            } catch (Exception e) {

                System.out.println(
                        "Opción inválida");
            }
        }

        System.out.println(
                "\nSistema finalizado.");
    }

    //Comenzar con el inicio de sesion
	private static void iniciarSesion() {

        try {

            String usuario =
                    loginView
                            .solicitarUsuario();

            String clave =
                    loginView
                            .solicitarClave();

            UsuarioSistema usuarioSistema =
                    loginController.login(
                            usuario,
                            clave);

            if (usuarioSistema == null) {

                System.out.println(
                        "Usuario o clave incorrectos.");

                return;
            }

            RolUsuario rol =
                    usuarioSistema.getRol();

            /*
			 * Segun el rol del tipo de usuario se carga
			 * el menu correspondiente.
			 */
			switch (rol) {

                case ADMINISTRADOR:

                    new MenuAdministrador()
                            .mostrar();

                    break;

                case RECEPCIONISTA:

                    new MenuRecepcionista()
                            .mostrar();

                    break;

                case PROFESIONAL:

                    new MenuProfesional()
                            .mostrar();

                    break;
            }

        } catch (LoginException e) {

            System.out.println(
                    e.getMessage());
        }
    }
}