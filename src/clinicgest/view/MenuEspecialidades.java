package clinicgest.view;

import clinicgest.controller.EspecialidadController;
import clinicgest.exception.ValidacionException;
import clinicgest.model.Especialidad;

/**
 * Clase "MenuEspecialidades"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class MenuEspecialidades {

    //Atributos
    private final EspecialidadController controller;
    private final EspecialidadView view;

	//Métodos

    //Método encargado de Menú Especialidades.
    public MenuEspecialidades() {

        controller =
                new EspecialidadController();

        view =
                new EspecialidadView();
    }

    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== ESPECIALIDADES =====");

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

	//Registrar especialidad
    private void registrar() {

        try {

            Especialidad especialidad =
                    view.cargarEspecialidad();

            controller
                    .registrarEspecialidad(
                            especialidad);

            System.out.println(
                    "Especialidad registrada.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

	//Listar especialidades
    private void listar() {

        controller
                .listarEspecialidades()
                .forEach(System.out::println);

        ConsolaUtils.pausar();
    }
}