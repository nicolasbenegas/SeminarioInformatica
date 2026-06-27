package clinicgest.view;

import java.util.Scanner;

/**
 * Clase "ConsolaUtils"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class ConsolaUtils {

    //Atributos
    private static final Scanner scanner =
            new Scanner(System.in);

	//Métodos
	
	//Método encargado de leer Texto.
    public static String leerTexto(
            String mensaje) {

        System.out.print(mensaje);

        return scanner.nextLine();
    }

    //Método encargado de leer Entero.
    public static int leerEntero(
            String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Integer.parseInt(
                        scanner.nextLine());

            } catch (Exception e) {

                System.out.println(
                        "Ingrese un número válido.");
            }
        }
    }

    //Método encargado de leer Decimal.
    public static double leerDecimal(
            String mensaje) {

        while (true) {

            try {

                System.out.print(mensaje);

                return Double.parseDouble(
                        scanner.nextLine());

            } catch (Exception e) {

                System.out.println(
                        "Ingrese un valor válido.");
            }
        }
    }

    //Método encargado de confirmar.
    public static boolean confirmar(
            String mensaje) {

        System.out.print(
                mensaje + " (S/N): ");

        String valor =
                scanner.nextLine();

        return valor.equalsIgnoreCase("S");
    }

    //Método encargado de pausar.
    public static void pausar() {

        System.out.println(
                "\nPresione ENTER para continuar...");

        scanner.nextLine();
    }

    //Método encargado de limpiar Pantalla.
    public static void limpiarPantalla() {

        for (int i = 0; i < 30; i++) {

            System.out.println();
        }
    }
}