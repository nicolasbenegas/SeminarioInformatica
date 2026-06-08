package clinicgest.config;

import clinicgest.model.*;
import clinicgest.service.EspecialidadService;
import clinicgest.service.PacienteService;
import clinicgest.service.ProfesionalSaludService;
import clinicgest.service.UsuarioService;

//Clase para datos de uso provisorio antes de implementar Base de Datos MySQL
public class DatosIniciales {

    public static void cargar() {

        try {

            cargarUsuarios();

            cargarEspecialidades();

            cargarProfesionales();

            cargarPacientes();

        } catch (Exception e) {

            System.out.println(
                    "Error cargando datos iniciales: "
                            + e.getMessage());
        }
    }

    private static void cargarUsuarios()
            throws Exception {

        UsuarioService service =
                new UsuarioService();

        Administrador admin =
                new Administrador();

        admin.setUsuario("admin");
        admin.setClave("admin123");

        service.registrarUsuario(admin);

        Recepcionista recep =
                new Recepcionista();

        recep.setUsuario("recep");
        recep.setClave("recep123");

        service.registrarUsuario(recep);

        ProfesionalSalud medico =
                new ProfesionalSalud();

        medico.setUsuario("medico");
        medico.setClave("medico123");

        service.registrarUsuario(medico);
    }

    private static void cargarEspecialidades()
            throws Exception {

        EspecialidadService service =
                new EspecialidadService();

        String[] nombres = {
                "Clínica Médica",
                "Pediatría",
                "Cardiología",
                "Traumatología"
        };

        for (String nombre : nombres) {

            Especialidad e =
                    new Especialidad();

            e.setNombre(nombre);

            service.registrarEspecialidad(e);
        }
    }

    private static void cargarProfesionales()
            throws Exception {

        ProfesionalSaludService service =
                new ProfesionalSaludService();

        ProfesionalSalud p1 =
                new ProfesionalSalud();

        p1.setNombre("Juan");
        p1.setApellido("Pérez");
        p1.setMatricula("MP1001");

        service.registrar(p1);

        ProfesionalSalud p2 =
                new ProfesionalSalud();

        p2.setNombre("María");
        p2.setApellido("Gómez");
        p2.setMatricula("MP1002");

        service.registrar(p2);
    }

    private static void cargarPacientes()
            throws Exception {

        PacienteService service =
                new PacienteService();

        Paciente p1 =
                new Paciente();

        p1.setDni("35698741");
        p1.setNombre("Carlos");
        p1.setApellido("González");
        p1.setSexo("Masculino");
        p1.setEmail("carlos@gmail.com");
        p1.setContacto("385456789");
        p1.setLocalidad(
                "Santiago del Estero");

        service.registrarPaciente(
                p1);


        Paciente p2 =
                new Paciente();

        p2.setDni("40214587");
        p2.setNombre("María");
        p2.setApellido("López");
        p2.setSexo("Femenino");
        p2.setEmail("maria@gmail.com");
        p2.setContacto("385555222");
        p2.setLocalidad(
                "La Banda");

        service.registrarPaciente(
                p2);


        Paciente p3 =
                new Paciente();

        p3.setDni("41852369");
        p3.setNombre("José");
        p3.setApellido("Fernández");
        p3.setSexo("Masculino");
        p3.setEmail("jose@gmail.com");
        p3.setContacto("385777888");
        p3.setLocalidad(
                "Termas");

        service.registrarPaciente(
                p3);
    }
}