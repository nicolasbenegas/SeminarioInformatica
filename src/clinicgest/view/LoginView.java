package clinicgest.view;

/**
 * Clase "LoginView"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class LoginView {

	//Métodos

    //Método encargado de mostrar Menú.
    public void mostrarMenu() {

        System.out.println(
                "\n===== CLINICGEST =====");

        System.out.println(
                "1 - Iniciar sesión");

        System.out.println(
                "0 - Salir");
    }

     //Método encargado de solicitar Opción.
    public int solicitarOpcion() {

        return ConsolaUtils.leerEntero(
                "Opción: ");
    }

    //Método encargado de solicitar Usuario.
    public String solicitarUsuario() {

        return ConsolaUtils.leerTexto(
                "Usuario: ");
    }

    //Método encargado de solicitar Clave.
    public String solicitarClave() {

        return ConsolaUtils.leerTexto(
                "Clave: ");
    }
}