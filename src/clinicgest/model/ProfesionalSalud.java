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

        return getNombreCompleto()
                + " - Matrícula: "
                + matricula;
    }
}