package clinicgest.model;

/**
 * Clase "Diagnostico"
 * Paquete de modelo de objetos y datos.
 */
public class Diagnostico {

	//Atributos
    private int id;

    private String descripcion;

    private String tratamiento;

    private String indicaciones;

    public Diagnostico() {
    }

	//Constructor
    public Diagnostico(
            String descripcion,
            String tratamiento,
            String indicaciones) {

        this.descripcion =
                descripcion;

        this.tratamiento =
                tratamiento;

        this.indicaciones =
                indicaciones;
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(
            String descripcion) {

        this.descripcion =
                descripcion;
    }


    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(
            String tratamiento) {

        this.tratamiento =
                tratamiento;
    }


    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(
            String indicaciones) {

        this.indicaciones =
                indicaciones;
    }

    public String resumenDiagnostico() {

        return descripcion +
                " - " +
                tratamiento;
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return "Diagnostico{" +
                "descripcion='" +
                descripcion + '\'' +
                '}';
    }
}