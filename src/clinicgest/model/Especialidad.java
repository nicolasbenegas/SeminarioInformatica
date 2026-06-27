package clinicgest.model;

/**
 * Clase "Especialidad"
 * Paquete de modelo de objetos y datos.
 */
public class Especialidad {

    //Atributos
    private int id;

    private String nombre;

    private String descripcion;

	//Constructores
    public Especialidad() {
    }

    public Especialidad(
            int id,
            String nombre,
            String descripcion) {

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(
            String descripcion) {

        this.descripcion = descripcion;
    }

	//Sobrescribe el método heredado de la clase Padre.
	@Override
	public String toString() {

    StringBuilder sb =
            new StringBuilder();

    sb.append("\n");
    sb.append("===============================================\n");
    sb.append("             ESPECIALIDAD\n");
    sb.append("===============================================\n");

    sb.append(String.format(
            "ID           : %d%n",
            id));

    sb.append(String.format(
            "Nombre       : %s%n",
            nombre));

    sb.append(String.format(
            "Descripción  : %s%n",
            descripcion != null
                    ? descripcion
                    : "-"));

    sb.append("===============================================\n");

    return sb.toString();
	}
}