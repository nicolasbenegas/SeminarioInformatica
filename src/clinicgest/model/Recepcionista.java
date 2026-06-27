package clinicgest.model;

/**
 * Clase "Recepcionista"
 * Paquete de modelo de objetos y datos.
 */
public class Recepcionista
        extends UsuarioSistema {

	//Constructor
    public Recepcionista() {

        setRol(
                RolUsuario.RECEPCIONISTA);
    }

	//Métodos
    public void registrarPaciente() {

        System.out.println(
                "Paciente registrado");
    }

    public void asignarTurno() {

        System.out.println(
                "Turno asignado");
    }

    public void cancelarTurno() {

        System.out.println(
                "Turno cancelado");
    }
}