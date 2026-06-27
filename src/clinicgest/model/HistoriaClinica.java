package clinicgest.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase "HistoriaClinica"
 * Paquete de modelo de objetos y datos.
 */
public class HistoriaClinica {

    //Atributos
    private int id;

    private LocalDate fechaCreacion;

    private List<Consulta> consultas;

	//Constructor
    public HistoriaClinica() {

        consultas = new ArrayList<>();
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(
            LocalDate fechaCreacion) {

        this.fechaCreacion =
                fechaCreacion;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(
            List<Consulta> consultas) {

        this.consultas = consultas;
    }

    public void agregarConsulta(
            Consulta consulta) {

        consultas.add(consulta);
    }

    public Consulta buscarConsulta(
            int idConsulta) {

        for (Consulta consulta :
                consultas) {

            if (consulta.getId()
                    == idConsulta) {

                return consulta;
            }
        }

        return null;
    }

    public void mostrarHistorial() {

        System.out.println(
                "\n===== HISTORIA CLÍNICA =====");

        for (Consulta consulta :
                consultas) {

            System.out.println(
                    consulta);
        }
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return "HistoriaClinica{" +
                "id=" + id +
                ", consultas=" +
                consultas.size() +
                '}';
    }
}