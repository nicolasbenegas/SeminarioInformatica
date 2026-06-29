package clinicgest.view;

import clinicgest.controller.ReporteController;
import clinicgest.model.Reporte;

/**
 * Clase "MenuReportes"
 * Capa de presentación - Interfaces e interacción con usuarios.
 * Capa -> View.
 */
public class MenuReportes {

    //Atributos
    private final ReporteController controller;

    public MenuReportes() {

        controller =
                new ReporteController();
    }

    public void mostrar() {

        int opcion;

        do {

            System.out.println(
                    "\n===== REPORTES =====");

            System.out.println(
                    "1 - Reporte de pacientes");

            System.out.println(
                    "2 - Reporte de turnos");

            System.out.println(
                    "3 - Reporte de consultas");

            System.out.println(
                    "0 - Volver");

            opcion =
                    ConsolaUtils.leerEntero(
                            "Opción: ");

            switch (opcion) {

                case 1:

                    generarReportePacientes();
                    break;

                case 2:

                    generarReporteTurnos();
                    break;

                case 3:

                    generarReporteConsultas();
                    break;
            }

        } while (opcion != 0);
    }

    private void generarReportePacientes() {

        Reporte reporte =
                controller
                        .generarReportePacientes();

        System.out.println(
                "\n" +
                reporte.getContenido());

        ConsolaUtils.pausar();
    }

    private void generarReporteTurnos() {

        Reporte reporte =
                controller
                        .generarReporteTurnos();

        System.out.println(
                "\n" +
                reporte.getContenido());

        ConsolaUtils.pausar();
    }

    private void generarReporteConsultas() {

        Reporte reporte =
                controller
                        .generarReporteConsultas();

        System.out.println(
                "\n" +
                reporte.getContenido());

        ConsolaUtils.pausar();
    }
}