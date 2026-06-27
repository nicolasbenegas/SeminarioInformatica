package clinicgest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "ProfesionalSalud"
 * Paquete de modelo de objetos y datos.
 */
public class ProfesionalSalud extends UsuarioSistema {

    //Atributos
    private String matricula;

    private Especialidad especialidad;

    private List<Turno> turnos;

	//Constructor
    public ProfesionalSalud() {

        turnos = new ArrayList<>();

        setRol(RolUsuario.PROFESIONAL);
    }

	//Métodos
    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(
            Especialidad especialidad) {

        this.especialidad = especialidad;
    }

    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(
            List<Turno> turnos) {

        this.turnos = turnos;
    }

    public void agregarTurno(
            Turno turno) {

        turnos.add(turno);
    }

    public void quitarTurno(
            Turno turno) {

        turnos.remove(turno);
    }

    public List<Turno> obtenerAgenda() {

        return turnos;
    }

	//Sobrescribe el método heredado de la clase Padre.
	@Override
	public String toString() {

    StringBuilder sb =
            new StringBuilder();

    sb.append("\n");
    sb.append("===============================================\n");
    sb.append("              PROFESIONAL\n");
    sb.append("===============================================\n");

    sb.append(String.format(
            "ID           : %d%n",
            getId()));

    sb.append(String.format(
            "Usuario      : %s%n",
            getUsuario()));

    sb.append(String.format(
            "Nombre       : %s%n",
            getNombre()));

    sb.append(String.format(
            "Apellido     : %s%n",
            getApellido()));

    sb.append(String.format(
            "DNI          : %s%n",
            getDni()));

    sb.append(String.format(
            "Matrícula    : %s%n",
            getMatricula()));

    sb.append(String.format(
            "Especialidad : %s%n",
            getEspecialidad() != null
                    ? getEspecialidad().getNombre()
                    : "N/D"));

    sb.append(String.format(
            "Email        : %s%n",
            getEmail()));

    sb.append(String.format(
            "Contacto     : %s%n",
            getContacto()));

    sb.append(String.format(
            "Estado       : %s%n",
            isActivo()
                    ? "ACTIVO"
                    : "INACTIVO"));

    sb.append("===============================================\n");

    return sb.toString();
	}
}