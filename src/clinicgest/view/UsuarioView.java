package clinicgest.view;

import clinicgest.model.Administrador;
import clinicgest.model.ProfesionalSalud;
import clinicgest.model.Recepcionista;
import clinicgest.model.RolUsuario;
import clinicgest.model.UsuarioSistema;

import clinicgest.dao.EspecialidadDAO;
import clinicgest.dao.impl.EspecialidadDAOImpl;
import clinicgest.model.Especialidad;

import java.util.List;

/**
 * Clase "UsuarioView"
 * Capa de Presentación - Interfaces e Interacción con usuarios.
 * Capa -> View.
 */
public class UsuarioView {

    //Métodos
    public UsuarioSistema cargarUsuario() {

        System.out.println(
                "\nRol:");

        System.out.println(
                "1 - Administrador");

        System.out.println(
                "2 - Recepcionista");

        System.out.println(
                "3 - Profesional");

        int opcion =
                ConsolaUtils.leerEntero(
                        "Opción: ");

        UsuarioSistema usuario;

        switch (opcion) {

            case 1:

                usuario =
                        new Administrador();

                break;

            case 2:

                usuario =
                        new Recepcionista();

                break;

            case 3:

                usuario =
                        new ProfesionalSalud();

                break;

            default:

                usuario =
                        new UsuarioSistema();

                break;
        }

        usuario.setDni(
                ConsolaUtils.leerTexto(
                        "DNI: "));

        usuario.setNombre(
                ConsolaUtils.leerTexto(
                        "Nombre: "));

        usuario.setApellido(
                ConsolaUtils.leerTexto(
                        "Apellido: "));

        usuario.setSexo(
                ConsolaUtils.leerTexto(
                        "Sexo: "));

        usuario.setCalle(
                ConsolaUtils.leerTexto(
                        "Calle: "));

        usuario.setNumeroCalle(
                ConsolaUtils.leerEntero(
                        "Número: "));

        usuario.setBarrio(
                ConsolaUtils.leerTexto(
                        "Barrio: "));

        usuario.setLocalidad(
                ConsolaUtils.leerTexto(
                        "Localidad: "));

        usuario.setEmail(
                ConsolaUtils.leerTexto(
                        "Email: "));

        usuario.setContacto(
                ConsolaUtils.leerTexto(
                        "Contacto: "));

        usuario.setUsuario(
                ConsolaUtils.leerTexto(
                        "Usuario: "));

        usuario.setClave(
                ConsolaUtils.leerTexto(
                        "Clave: "));

        if (usuario instanceof ProfesionalSalud) {

    ProfesionalSalud profesional =
            (ProfesionalSalud) usuario;

    profesional.setMatricula(
            ConsolaUtils.leerTexto(
                    "Matrícula: "));

    EspecialidadDAO especialidadDAO =
            new EspecialidadDAOImpl();

    List<Especialidad> especialidades =
            especialidadDAO.listarTodos();

    if (especialidades.isEmpty()) {

        System.out.println(
                "\nNo existen especialidades registradas.");

    } else {

        System.out.println(
                "\nEspecialidades disponibles:");

        for (Especialidad especialidad :
                especialidades) {

            System.out.println(
				"[" + especialidad.getId() + "] "
					+ especialidad.getNombre()
					+ " - "
					+ especialidad.getDescripcion());
        }

        int idEspecialidad =
                ConsolaUtils.leerEntero(
                        "Seleccione ID de especialidad: ");

        Especialidad seleccionada = null;

        for (Especialidad especialidad :
                especialidades) {

            if (especialidad.getId()
                    == idEspecialidad) {

                seleccionada =
                        especialidad;

                break;
            }
        }

        if (seleccionada != null) {

            profesional.setEspecialidad(
                    seleccionada);

        } else {

            System.out.println(
                    "Especialidad inválida.");
        }
		}
	}

        return usuario;
    }
}