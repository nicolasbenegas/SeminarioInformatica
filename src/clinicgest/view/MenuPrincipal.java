package clinicgest.view;

/**
 * Clase "MenuPrincipal"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuPrincipal {

	//Métodos
    public int mostrar() {

        System.out.println("\n========================");
        System.out.println("      CLINICGEST");
        System.out.println("========================");

        System.out.println("1 - Administrador");
        System.out.println("2 - Recepcionista");
        System.out.println("3 - Profesional");
        System.out.println("0 - Salir");

        return ConsolaUtils.leerEntero(
                "Opción: ");
    }
}