package clinicgest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "Administrador"
 * Paquete de modelo de objetos y datos.
 */
public class Administrador
        extends UsuarioSistema {

	//Atributos
    private List<Reporte> reportes;

	//Constructor
    public Administrador() {

        reportes = new ArrayList<>();

        setRol(
                RolUsuario.ADMINISTRADOR);
    }

	//Métodos
    public List<Reporte> getReportes() {
        return reportes;
    }

    public void setReportes(
            List<Reporte> reportes) {

        this.reportes = reportes;
    }

    public void agregarReporte(
            Reporte reporte) {

        reportes.add(reporte);
    }

    public void generarReporte(
            Reporte reporte) {

        reportes.add(reporte);
    }
}