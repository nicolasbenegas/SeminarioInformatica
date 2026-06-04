package clinicgest.model;

/**
 * Clase "Usuario"
 * Paquete de modelo de objetos y datos.
 */
public class Usuario {

    //Atributos
    private int id;

    private String dni;

    private String nombre;
    private String apellido;

    private String sexo;

    private String calle;
    private int numeroCalle;

    private String barrio;
    private String localidad;

    private String email;
    private String contacto;

	//Constructor
    public Usuario() {
    }

    public Usuario(int id,
                   String dni,
                   String nombre,
                   String apellido) {

        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

	//Métodos
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }


    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }


    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }


    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }


    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getNombreCompleto() {

        return nombre + " " + apellido;
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return "Usuario{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }
}