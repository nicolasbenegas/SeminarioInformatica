package clinicgest.model;

import java.time.LocalDate;

/**
 * Clase "RecetaMedica"
 * Paquete de modelo de objetos y datos.
 */
public class RecetaMedica {

    //Atributos
    private int id;

    private LocalDate fecha;

    private String medicamentos;

    private String indicaciones;

	//Constructor
    public RecetaMedica() {

        fecha = LocalDate.now();
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(
            LocalDate fecha) {

        this.fecha = fecha;
    }


    public String getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(
            String medicamentos) {

        this.medicamentos =
                medicamentos;
    }


    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(
            String indicaciones) {

        this.indicaciones =
                indicaciones;
    }

    public String generarTextoReceta() {

        return "Medicamentos: "
                + medicamentos
                + "\nIndicaciones: "
                + indicaciones;
    }

    public void imprimir() {

        System.out.println(
                generarTextoReceta());
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return generarTextoReceta();
    }
}