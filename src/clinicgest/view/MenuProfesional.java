package clinicgest.view;

import clinicgest.controller.ConsultaController;
import clinicgest.model.Consulta;

import java.util.List;

/**
 * Clase "MenuProfesional"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class MenuProfesional {

    //Atributos
	private final ConsultaController consultaController;
    private final MenuConsultas menuConsultas;

	//Métodos
	
    //Método encargado de Menú Profesional.
    public MenuProfesional() {

        menuConsultas =
                new MenuConsultas();
		
		consultaController =
        new ConsultaController();
    }
	
    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== PROFESIONAL =====");

            System.out.println(
                    "1 - Consultas");

            System.out.println(
                    "2 - Historia Clínica");

            System.out.println(
                    "0 - Cerrar sesión");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:

                    menuConsultas.mostrar();
                    break;

                case 2:

					mostrarHistoriaClinica();
					break;
            }

        } while (opcion != 0);
    }
	
private void mostrarHistoriaClinica() {

    String dni =
            ConsolaUtils.leerTexto(
                    "DNI del paciente: ");

    List<Consulta> consultas =
            consultaController
                    .buscarPorDniPaciente(
                            dni);

    System.out.println(
            "\n===== HISTORIA CLÍNICA =====");

    if (consultas.isEmpty()) {

        System.out.println(
                "No existen consultas para ese paciente.");

    } else {

        for (Consulta consulta : consultas) {

            System.out.println(
                    consulta);
        }
    }

    ConsolaUtils.pausar();
}

}