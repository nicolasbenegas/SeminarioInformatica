package clinicgest.view;

import clinicgest.controller.ProfesionalController;
import clinicgest.exception.ValidacionException;
import clinicgest.model.ProfesionalSalud;

/**
 * Clase "MenuProfesionales"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuProfesionales {

    private final ProfesionalController controller;
    private final ProfesionalView view;

	//Métodos
	
    //Método encargado de Menú Profesionales.
    public MenuProfesionales() {

        controller =
                new ProfesionalController();

        view =
                new ProfesionalView();
    }

    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== PROFESIONALES =====");

            System.out.println(
                    "1 - Listar profesionales");

            System.out.println(
                    "2 - Buscar por matrícula");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:
                    listar();
                    break;

                case 2:
                    buscar();
                    break;
            }

        } while (opcion != 0);
    }


	//Listar Profesionales
    private void listar() {

        controller.listar()
                .forEach(System.out::println);

        ConsolaUtils.pausar();
    }
	
	//Buscar Profesionales
	private void buscar() {

    String matricula =
            ConsolaUtils.leerTexto(
                    "Matrícula: ");

    ProfesionalSalud profesional =
            controller.buscarPorMatricula(
                    matricula);

    if (profesional != null) {

        System.out.println(profesional);

    } else {

        System.out.println(
                "\nProfesional no encontrado.");
    }

    ConsolaUtils.pausar();
}
}