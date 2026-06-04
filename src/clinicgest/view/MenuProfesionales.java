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
                    "1 - Registrar");

            System.out.println(
                    "2 - Listar");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:
                    registrar();
                    break;

                case 2:
                    listar();
                    break;
            }

        } while (opcion != 0);
    }

	//Registrar Profesional.
    private void registrar() {

        try {

            ProfesionalSalud profesional =
                    view.cargarProfesional();

            controller.registrar(
                    profesional);

            System.out.println(
                    "Profesional registrado.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

	//Listar Profesionales
    private void listar() {

        controller.listar()
                .forEach(System.out::println);

        ConsolaUtils.pausar();
    }
}