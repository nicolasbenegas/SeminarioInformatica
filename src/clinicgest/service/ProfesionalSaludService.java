package clinicgest.service;

import clinicgest.exception.ValidacionException;
import clinicgest.model.ProfesionalSalud;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "ProfesionalSaludService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class ProfesionalSaludService {

	//Atributos
    private static final List<ProfesionalSalud>
            profesionales =
            new ArrayList<>();

	//Métodos
    public void registrar(
            ProfesionalSalud profesional)
            throws ValidacionException {

        if (profesional == null) {

            throw new ValidacionException(
                    "Profesional inválido");
        }

        if (profesional.getMatricula() == null
                || profesional.getMatricula().isBlank()) {

            throw new ValidacionException(
                    "Debe ingresar matrícula");
        }

        profesionales.add(profesional);
    }

    public List<ProfesionalSalud> listar() {

        return profesionales;
    }

    public ProfesionalSalud buscarPorMatricula(
            String matricula) {

        for (ProfesionalSalud profesional :
                profesionales) {

            if (profesional.getMatricula()
                    .equalsIgnoreCase(matricula)) {

                return profesional;
            }
        }

        return null;
    }
}