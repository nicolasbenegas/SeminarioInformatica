package clinicgest.view;

import clinicgest.controller.UsuarioController;
import clinicgest.exception.ValidacionException;
import clinicgest.model.UsuarioSistema;

/**
 * Clase "MenuUsuarios"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuUsuarios {

    private final UsuarioController controller;
    private final UsuarioView view;


	//Métodos

    //Método encargado de Menú Usuarios.
    public MenuUsuarios() {

        controller = new UsuarioController();
        view = new UsuarioView();
    }

     //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== GESTIÓN DE USUARIOS =====");

            System.out.println(
                    "1 - Crear usuario");

            System.out.println(
                    "2 - Listar usuarios");

            System.out.println(
                    "3 - Eliminar usuario");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:
                    crearUsuario();
                    break;

                case 2:
                    listarUsuarios();
                    break;

                case 3:
                    eliminarUsuario();
                    break;
            }

        } while (opcion != 0);
    }

    private void crearUsuario() {

        try {

            UsuarioSistema usuario =
                    view.cargarUsuario();

            controller.registrarUsuario(
                    usuario);

            System.out.println(
                    "Usuario registrado.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void listarUsuarios() {

        controller.listarUsuarios()
                .forEach(System.out::println);

        ConsolaUtils.pausar();
    }

    private void eliminarUsuario() {

        int id =
                ConsolaUtils.leerEntero(
                        "ID usuario: ");

        controller.eliminarUsuario(id);

        System.out.println(
                "Usuario eliminado.");

        ConsolaUtils.pausar();
    }
}