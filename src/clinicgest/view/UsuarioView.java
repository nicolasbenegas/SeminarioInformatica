package clinicgest.view;

import clinicgest.model.RolUsuario;
import clinicgest.model.UsuarioSistema;

/**
 * Clase "UsuarioView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class UsuarioView {

	//Métodos
    public UsuarioSistema cargarUsuario() {

        UsuarioSistema usuario =
                new UsuarioSistema();

        usuario.setUsuario(
                ConsolaUtils.leerTexto(
                        "Usuario: "));

        usuario.setClave(
                ConsolaUtils.leerTexto(
                        "Clave: "));

        System.out.println(
                "\nRol:");

        System.out.println(
                "1 - Administrador");

        System.out.println(
                "2 - Recepcionista");

        System.out.println(
                "3 - Profesional");

        int opcion =
                ConsolaUtils.leerEntero(
                        "Opción: ");

        switch (opcion) {

            case 1:

                usuario.setRol(
                        RolUsuario.ADMINISTRADOR);

                break;

            case 2:

                usuario.setRol(
                        RolUsuario.RECEPCIONISTA);

                break;

            case 3:

                usuario.setRol(
                        RolUsuario.PROFESIONAL);

                break;
        }

        return usuario;
    }
}