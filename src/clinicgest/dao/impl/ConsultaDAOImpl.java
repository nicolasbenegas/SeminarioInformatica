package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.ConsultaDAO;
import clinicgest.model.Consulta;
import clinicgest.model.Turno;
import clinicgest.model.Paciente;
import clinicgest.model.ProfesionalSalud;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**

Clase "ConsultaDAOImpl"
Acceso a datos - Implementación

Capa -> DAO
*/
public class ConsultaDAOImpl
implements ConsultaDAO {

@Override
public void guardar(Consulta consulta) {

    String sqlPaciente =
            "SELECT p.id, h.id AS historia_id " +
            "FROM paciente p " +
            "INNER JOIN usuario u ON u.id = p.id " +
            "INNER JOIN historia_clinica h ON h.paciente_id = p.id " +
            "WHERE u.dni = ?";

    String sqlProfesional =
            "SELECT id " +
            "FROM profesional_salud " +
            "WHERE nro_matricula = ?";

    String sqlInsert =
            "INSERT INTO consulta " +
            "(historia_clinica_id,paciente_id,profesional_id,turno_id,fecha,descripcion) " +
            "VALUES (?,?,?,?,?,?)";

    try (Connection cn = ConexionBD.obtenerConexion()) {

        //--------------------------------------------------
        // Buscar paciente
        //--------------------------------------------------

        int pacienteId;
        int historiaId;

        try (PreparedStatement ps =
                     cn.prepareStatement(sqlPaciente)) {

            ps.setString(
                    1,
                    consulta.getPaciente().getDni());

            ResultSet rs =
                    ps.executeQuery();

            if (!rs.next()) {

                System.out.println(
                        "Paciente inexistente.");

                return;
            }

            pacienteId =
                    rs.getInt("id");

            historiaId =
                    rs.getInt("historia_id");
        }

        //--------------------------------------------------
        // Buscar profesional
        //--------------------------------------------------

        int profesionalId;

        try (PreparedStatement ps =
                     cn.prepareStatement(sqlProfesional)) {

            ps.setString(
                    1,
                    consulta.getProfesional().getMatricula());

            ResultSet rs =
                    ps.executeQuery();

            if (!rs.next()) {

                System.out.println(
                        "Profesional inexistente.");

                return;
            }

            profesionalId =
                    rs.getInt("id");
        }

        //--------------------------------------------------
        // Guardar consulta
        //--------------------------------------------------

        try (PreparedStatement ps =
                     cn.prepareStatement(sqlInsert)) {

            ps.setInt(
                    1,
                    historiaId);

            ps.setInt(
                    2,
                    pacienteId);

            ps.setInt(
                    3,
                    profesionalId);

            // No asociamos un turno en esta versión
            ps.setNull(
                    4,
                    Types.INTEGER);

            ps.setTimestamp(
                    5,
                    Timestamp.valueOf(
                            consulta.getFechaHora()));

            String descripcion =
                    "Motivo: "
                            + consulta.getMotivoConsulta()
                            + "\n\nObservaciones: "
                            + consulta.getObservaciones();

            ps.setString(
                    6,
                    descripcion);

            ps.executeUpdate();

            System.out.println(
                    "Consulta registrada correctamente.");

        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

@Override
public void actualizar(Consulta consulta) {

    String sqlBuscar =
            "SELECT descripcion " +
            "FROM consulta " +
            "WHERE id=?";

    String sqlActualizar =
            "UPDATE consulta " +
            "SET descripcion=? " +
            "WHERE id=?";

    try (Connection cn =
                 ConexionBD.obtenerConexion()) {

        String descripcionActual = "";

        //-------------------------------------------------
        // Leer descripción existente
        //-------------------------------------------------

        try (PreparedStatement ps =
                     cn.prepareStatement(sqlBuscar)) {

            ps.setInt(
                    1,
                    consulta.getId());

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                descripcionActual =
                        rs.getString(
                                "descripcion");

                if (descripcionActual == null) {

                    descripcionActual = "";
                }
            }
        }

        //-------------------------------------------------
        // Agregar nueva información
        //-------------------------------------------------

        StringBuilder descripcion =
                new StringBuilder(
                        descripcionActual);

        if (consulta.getMotivoConsulta() != null
                && !consulta.getMotivoConsulta().isBlank()) {

            descripcion.append("\n\n");
            descripcion.append(
                    consulta.getMotivoConsulta());
        }

        if (consulta.getObservaciones() != null
                && !consulta.getObservaciones().isBlank()) {

            descripcion.append("\n");
            descripcion.append(
                    consulta.getObservaciones());
        }

        //-------------------------------------------------
        // Guardar
        //-------------------------------------------------

        try (PreparedStatement ps =
                     cn.prepareStatement(
                             sqlActualizar)) {

            ps.setString(
                    1,
                    descripcion.toString());

            ps.setInt(
                    2,
                    consulta.getId());

            ps.executeUpdate();
        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

@Override
public void eliminar(
int id) {

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(
                      "DELETE FROM consulta WHERE id=?")) {

     ps.setInt(1, id);

     ps.executeUpdate();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public Consulta buscarPorId(int id) {

    String sql =
            "SELECT c.*, " +
            "u.nombre AS paciente_nombre, " +
            "u.apellido AS paciente_apellido, " +
            "up.nombre AS profesional_nombre, " +
            "up.apellido AS profesional_apellido " +
            "FROM consulta c " +
            "INNER JOIN paciente p ON c.paciente_id = p.id " +
            "INNER JOIN usuario u ON p.id = u.id " +
            "INNER JOIN profesional_salud ps ON c.profesional_id = ps.id " +
            "INNER JOIN usuario up ON ps.id = up.id " +
            "WHERE c.id = ?";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setInt(1, id);

        ResultSet rs =
                ps.executeQuery();

        if (rs.next()) {

            return construirConsulta(rs);
        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }

    return null;
}

@Override
public void guardarDiagnostico(
        int consultaId,
        String descripcion) {

    String sql =
            "INSERT INTO diagnostico " +
            "(consulta_id,descripcion) " +
            "VALUES (?,?)";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setInt(
                1,
                consultaId);

        ps.setString(
                2,
                descripcion);

        ps.executeUpdate();

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

@Override
public void guardarReceta(
        int consultaId,
        String medicamentos,
        String indicaciones) {

    String sql =
            "INSERT INTO receta_medica " +
            "(consulta_id,fecha,medicamentos,indicaciones) " +
            "VALUES (?,CURRENT_DATE,?,?)";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setInt(
                1,
                consultaId);

        ps.setString(
                2,
                medicamentos);

        ps.setString(
                3,
                indicaciones);

        ps.executeUpdate();

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

@Override
public void guardarSolicitudExamen(
        int consultaId,
        String tipoExamen,
        String descripcion) {

    String sql =
            "INSERT INTO solicitud_examen " +
            "(consulta_id,fecha,tipo_examen,descripcion) " +
            "VALUES (?,NOW(),?,?)";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setInt(
                1,
                consultaId);

        ps.setString(
                2,
                tipoExamen);

        ps.setString(
                3,
                descripcion);

        ps.executeUpdate();

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

@Override
public List<Consulta> listarTodos() {

    List<Consulta> lista =
            new ArrayList<>();

    String sql =
            "SELECT c.*, " +
            "u.nombre AS paciente_nombre, " +
            "u.apellido AS paciente_apellido, " +
            "up.nombre AS profesional_nombre, " +
            "up.apellido AS profesional_apellido " +
            "FROM consulta c " +
            "INNER JOIN paciente p ON c.paciente_id = p.id " +
            "INNER JOIN usuario u ON p.id = u.id " +
            "INNER JOIN profesional_salud ps ON c.profesional_id = ps.id " +
            "INNER JOIN usuario up ON ps.id = up.id " +
            "ORDER BY c.fecha DESC";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            lista.add(
                    construirConsulta(rs));
        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }

    return lista;
}

public void agregarTexto(int idConsulta, String titulo, String texto) {

    String sql =
            "UPDATE consulta " +
            "SET descripcion = CONCAT(descripcion, ?, ?) " +
            "WHERE id = ?";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setString(
				1,
				"\n\n-----------------------------------------------\n"
				+ titulo
				+ "\n"
				+ "-----------------------------------------------\n");

        ps.setString(
                2,
                texto);

        ps.setInt(
                3,
                idConsulta);

        ps.executeUpdate();

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

private Consulta construirConsulta(ResultSet rs)
        throws SQLException {

    Consulta consulta =
            new Consulta();

    consulta.setId(
            rs.getInt("id"));

    Timestamp fecha =
            rs.getTimestamp("fecha");

    if (fecha != null) {

        consulta.setFechaHora(
                fecha.toLocalDateTime());
    }

    String descripcion =
        rs.getString("descripcion");

	String motivo = "";
	String observaciones = "";

	if (descripcion != null) {

    int posMotivo =
            descripcion.indexOf("Motivo:");

    int posObs =
            descripcion.indexOf("Observaciones:");

    if (posMotivo >= 0 && posObs >= 0) {

        motivo =
                descripcion.substring(
                        posMotivo + "Motivo:".length(),
                        posObs).trim();

        observaciones =
                descripcion.substring(
                        posObs + "Observaciones:".length())
                        .trim();

    } else {

        observaciones =
                descripcion;
    }
	}

consulta.setMotivoConsulta(
        motivo);


    Paciente paciente =
            new Paciente();

    paciente.setNombre(
            rs.getString(
                    "paciente_nombre"));

    paciente.setApellido(
            rs.getString(
                    "paciente_apellido"));

    consulta.setPaciente(
            paciente);

    ProfesionalSalud profesional =
            new ProfesionalSalud();

    profesional.setNombre(
            rs.getString(
                    "profesional_nombre"));

    profesional.setApellido(
            rs.getString(
                    "profesional_apellido"));

    consulta.setProfesional(
            profesional);

	//--------------------------------------------------
// Cargar diagnósticos
//--------------------------------------------------

try (Connection cn = ConexionBD.obtenerConexion();
     PreparedStatement ps = cn.prepareStatement(
             "SELECT descripcion FROM diagnostico WHERE consulta_id=?")) {

    ps.setInt(1, consulta.getId());

    ResultSet rsDiag = ps.executeQuery();

    while (rsDiag.next()) {

        observaciones +=
                "\n\n-----------------------------------------------\n"
                + "DIAGNÓSTICO\n"
                + "-----------------------------------------------\n"
                + rsDiag.getString("descripcion");
    }

} catch (Exception ex) {

    ex.printStackTrace();
}

//--------------------------------------------------
// Cargar receta
//--------------------------------------------------

try (Connection cn = ConexionBD.obtenerConexion();
     PreparedStatement ps = cn.prepareStatement(
             "SELECT medicamentos, indicaciones FROM receta_medica WHERE consulta_id=?")) {

    ps.setInt(1, consulta.getId());

    ResultSet rsReceta = ps.executeQuery();

    if (rsReceta.next()) {

        observaciones +=
                "\n\n-----------------------------------------------\n"
                + "RECETA MÉDICA\n"
                + "-----------------------------------------------\n"
                + "Medicamentos: "
                + rsReceta.getString("medicamentos")
                + "\nIndicaciones: "
                + rsReceta.getString("indicaciones");
    }

} catch (Exception ex) {

    ex.printStackTrace();
}

//--------------------------------------------------
// Cargar exámenes
//--------------------------------------------------

try (Connection cn = ConexionBD.obtenerConexion();
     PreparedStatement ps = cn.prepareStatement(
             "SELECT tipo_examen FROM solicitud_examen WHERE consulta_id=?")) {

    ps.setInt(1, consulta.getId());

    ResultSet rsExam = ps.executeQuery();

    while (rsExam.next()) {

        observaciones +=
                "\n\n-----------------------------------------------\n"
                + "EXAMEN SOLICITADO\n"
                + "-----------------------------------------------\n"
                + rsExam.getString("tipo_examen");
    }

} catch (Exception ex) {

    ex.printStackTrace();
}

// Actualizar observaciones con toda la información
consulta.setObservaciones(observaciones);
	
    return consulta;
}

@Override
public List<Consulta> buscarPorDniPaciente(
        String dni) {

    List<Consulta> lista =
            new ArrayList<>();

    String sql =
            "SELECT c.*, " +
            "u.nombre AS paciente_nombre, " +
            "u.apellido AS paciente_apellido, " +
            "up.nombre AS profesional_nombre, " +
            "up.apellido AS profesional_apellido " +
            "FROM consulta c " +
            "INNER JOIN paciente p ON c.paciente_id = p.id " +
            "INNER JOIN usuario u ON p.id = u.id " +
            "INNER JOIN profesional_salud ps ON c.profesional_id = ps.id " +
            "INNER JOIN usuario up ON ps.id = up.id " +
            "WHERE u.dni = ? " +
            "ORDER BY c.fecha DESC";

    try (Connection cn =
                 ConexionBD.obtenerConexion();

         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setString(
                1,
                dni);

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            lista.add(
                    construirConsulta(rs));
        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }

    return lista;
}

}