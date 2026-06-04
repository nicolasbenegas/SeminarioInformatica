package clinicgest.model;

import java.time.LocalDate;

/**
 * Clase "Reporte"
 * Paquete de modelo de objetos y datos.
 */
public class Reporte {

    //Atributos
    private int id;

    private String tipo;

    private LocalDate fechaGeneracion;

    private String contenido;

	//Constructor
    public Reporte() {

        fechaGeneracion =
                LocalDate.now();
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(
            String tipo) {

        this.tipo = tipo;
    }


    public LocalDate getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(
            LocalDate fechaGeneracion) {

        this.fechaGeneracion =
                fechaGeneracion;
    }


    public String getContenido() {
        return contenido;
    }

    public void setContenido(
            String contenido) {

        this.contenido =
                contenido;
    }

    public void generarContenido(
            String contenido) {

        this.contenido =
                contenido;
    }

    public void imprimir() {

        System.out.println(
                "\n===== REPORTE =====");

        System.out.println(
                contenido);
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return "Reporte{" +
                "tipo='" + tipo + '\'' +
                ", fecha=" +
                fechaGeneracion +
                '}';
    }
}