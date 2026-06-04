package clinicgest.view;

import clinicgest.controller.ConsultaController;
import clinicgest.exception.ValidacionException;
import clinicgest.model.Consulta;
import clinicgest.model.Diagnostico;
import clinicgest.model.RecetaMedica;
import clinicgest.model.SolicitudExamen;

/**
 * Clase "MenuConsultas"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class MenuConsultas {

    private final ConsultaController controller;

    private final ConsultaView consultaView;

    private final DiagnosticoView diagnosticoView;

    private final RecetaView recetaView;

    private final SolicitudExamenView examenView;

	//Métodos

    //Método encargado de Menú Consultas.
    public MenuConsultas() {

        controller =
                new ConsultaController();

        consultaView =
                new ConsultaView();

        diagnosticoView =
                new DiagnosticoView();

        recetaView =
                new RecetaView();

        examenView =
                new SolicitudExamenView();
    }

    //Método encargado de mostrar Opciones.
    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== CONSULTAS =====");

            System.out.println(
                    "1 - Registrar consulta");

            System.out.println(
                    "2 - Agregar diagnóstico");

            System.out.println(
                    "3 - Generar receta");

            System.out.println(
                    "4 - Solicitar examen");

            System.out.println(
                    "5 - Listar consultas");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:
                    registrarConsulta();
                    break;

                case 2:
                    agregarDiagnostico();
                    break;

                case 3:
                    generarReceta();
                    break;

                case 4:
                    solicitarExamen();
                    break;

                case 5:
                    listarConsultas();
                    break;
            }

        } while (opcion != 0);
    }

    private Consulta buscarConsulta() {

        int id =
                ConsolaUtils.leerEntero(
                        "ID consulta: ");

        return controller
                .buscarPorId(id);
    }

    private void registrarConsulta() {

        try {

            Consulta consulta =
                    consultaView
                            .cargarConsulta();

            controller
                    .registrarConsulta(
                            consulta);

            System.out.println(
                    "Consulta registrada.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void agregarDiagnostico() {

        try {

            Consulta consulta =
                    buscarConsulta();

            if (consulta == null) {

                System.out.println(
                        "Consulta inexistente");

                return;
            }

            Diagnostico diagnostico =
                    diagnosticoView
                            .cargarDiagnostico();

            controller
                    .agregarDiagnostico(
                            consulta,
                            diagnostico);

            System.out.println(
                    "Diagnóstico agregado.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void generarReceta() {

        try {

            Consulta consulta =
                    buscarConsulta();

            if (consulta == null) {

                System.out.println(
                        "Consulta inexistente");

                return;
            }

            RecetaMedica receta =
                    recetaView
                            .cargarReceta();

            controller
                    .generarReceta(
                            consulta,
                            receta);

            System.out.println(
                    "Receta generada.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void solicitarExamen() {

        try {

            Consulta consulta =
                    buscarConsulta();

            if (consulta == null) {

                System.out.println(
                        "Consulta inexistente");

                return;
            }

            SolicitudExamen examen =
                    examenView
                            .cargarExamen();

            controller
                    .solicitarExamen(
                            consulta,
                            examen);

            System.out.println(
                    "Examen solicitado.");

        } catch (ValidacionException e) {

            System.out.println(
                    e.getMessage());
        }

        ConsolaUtils.pausar();
    }

    private void listarConsultas() {

        controller
                .listarConsultas()
                .forEach(System.out::println);

        ConsolaUtils.pausar();
    }
}