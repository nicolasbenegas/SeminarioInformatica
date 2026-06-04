package clinicgest.model;

/**
 * Clase "UsuarioSistema"
 * Paquete de modelo de objetos y datos.
 */
public class UsuarioSistema extends Usuario {

    //Atributos
    private String usuario;

    private String clave;

    private boolean activo;

    private RolUsuario rol;

	//Constructor
    public UsuarioSistema() {

        activo = true;
    }

	//Métodos
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public RolUsuario getRol() {
        return rol;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }

    public void activar() {

        activo = true;
    }

    public void desactivar() {

        activo = false;
    }

    public boolean autenticar(
            String usuario,
            String clave) {

        return this.usuario.equals(usuario)
                && this.clave.equals(clave);
    }

    public void cambiarClave(
            String nuevaClave) {

        this.clave = nuevaClave;
    }

	//Sobrescribe el método heredado de la clase Padre.
    @Override
    public String toString() {

        return getNombreCompleto() +
                " [" + rol + "]";
    }
}