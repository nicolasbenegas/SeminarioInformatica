package clinicgest.config;

import clinicgest.model.*;
import clinicgest.service.EspecialidadService;
import clinicgest.service.ProfesionalSaludService;
import clinicgest.service.UsuarioService;

//Clase para datos de uso provisorio antes de implementar Base de Datos MySQL
public class DatosIniciales {

    public static void cargar() {

        try {

            cargarUsuarios();

            cargarEspecialidades();

            cargarProfesionales();

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
}