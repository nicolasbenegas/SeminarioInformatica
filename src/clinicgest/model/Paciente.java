package clinicgest.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "Paciente"
 * Paquete de modelo de objetos y datos.
 */
public class Paciente extends Usuario {

    //Atributos
    private HistoriaClinica historiaClinica;

    private List<Turno> turnos;

	//Constructor
    public Paciente() {

        turnos = new ArrayList<>();
    }

	//Métodos
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(
            HistoriaClinica historiaClinica) {

        this.historiaClinica =
                historiaClinica;
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

	//Sobrescribe el método heredado de la clase Padre.
	@Override
	public String toString() {

    StringBuilder sb =
            new StringBuilder();

    sb.append("\n");
    sb.append("===============================================\n");
    sb.append("                 PACIENTE\n");
    sb.append("===============================================\n");

    sb.append(String.format(
            "DNI          : %s%n",
            getDni()));

    sb.append(String.format(
            "Nombre       : %s%n",
            getNombre()));

    sb.append(String.format(
            "Apellido     : %s%n",
            getApellido()));

    sb.append(String.format(
            "Email        : %s%n",
            getEmail()));

    sb.append(String.format(
            "Contacto     : %s%n",
            getContacto()));

    sb.append(String.format(
            "Dirección    : %s %d%n",
            getCalle(),
            getNumeroCalle()));

    sb.append(String.format(
            "Barrio       : %s%n",
            getBarrio()));

    sb.append(String.format(
            "Localidad    : %s%n",
            getLocalidad()));

    sb.append("===============================================\n");

    return sb.toString();
	}
}