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

        return "Paciente{" +
                "dni='" + getDni() + '\'' +
                ", nombre='" +
                getNombreCompleto() +
                '\'' +
                '}';
    }
}