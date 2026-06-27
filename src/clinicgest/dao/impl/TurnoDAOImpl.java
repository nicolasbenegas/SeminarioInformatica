package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.TurnoDAO;
import clinicgest.model.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**

Clase "TurnoDAOImpl"
Acceso a datos - Implementación

Capa -> DAO
*/
public class TurnoDAOImpl
implements TurnoDAO {

@Override
public void guardar(
Turno turno) {

 String sql =
         "INSERT INTO turno " +
         "(paciente_id,profesional_id,fecha_hora,estado) " +
         "VALUES (?,?,?,?)";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setInt(
             1,
             turno.getPaciente()
                     .getId());

     ps.setInt(
             2,
             turno.getProfesional()
                     .getId());

     Timestamp fechaHora =
             Timestamp.valueOf(
                     turno.getFecha()
                             .atTime(
                                     turno.getHora()));

     ps.setTimestamp(
             3,
             fechaHora);

     ps.setString(
             4,
             turno.getEstado()
                     .name());

     ps.executeUpdate();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public void actualizar(
Turno turno) {

 String sql =
         "UPDATE turno " +
         "SET estado=? " +
         "WHERE id=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setString(
             1,
             turno.getEstado()
                     .name());

     ps.setInt(
             2,
             turno.getId());

     ps.executeUpdate();

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
                      "DELETE FROM turno WHERE id=?")) {

     ps.setInt(1, id);

     ps.executeUpdate();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public Turno buscarPorId(
int id) {

 String sql =
         "SELECT * FROM turno " +
         "WHERE id=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setInt(1, id);

     ResultSet rs =
             ps.executeQuery();

     if (rs.next()) {

         return construirTurno(rs);
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return null;

}

@Override
public List
buscarPorFecha(
LocalDate fecha) {

 List<Turno> lista =
         new ArrayList<>();

 String sql =
         "SELECT * FROM turno " +
         "WHERE DATE(fecha_hora)=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setDate(
             1,
             Date.valueOf(fecha));

     ResultSet rs =
             ps.executeQuery();

     while (rs.next()) {

         lista.add(
                 construirTurno(rs));
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return lista;

}

@Override
public List<Turno> listarTodos() {

    List<Turno> lista =
            new ArrayList<>();

    String sql =
            "SELECT " +
            "t.*, " +

            "up.nombre AS paciente_nombre, " +
            "up.apellido AS paciente_apellido, " +
			"up.dni AS paciente_dni, " +

            "upr.nombre AS profesional_nombre, " +
            "upr.apellido AS profesional_apellido, " +

            "ps.nro_matricula, " +

            "e.id AS especialidad_id, " +
            "e.nombre AS especialidad_nombre " +

            "FROM turno t " +

            "INNER JOIN paciente p " +
            "ON t.paciente_id = p.id " +

            "INNER JOIN usuario up " +
            "ON p.id = up.id " +

            "INNER JOIN profesional_salud ps " +
            "ON t.profesional_id = ps.id " +

            "INNER JOIN usuario upr " +
            "ON ps.id = upr.id " +

            "LEFT JOIN especialidad e " +
            "ON ps.especialidad_id = e.id " +

            "ORDER BY t.fecha_hora";

    try (Connection cn =
                 ConexionBD.obtenerConexion();
         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ResultSet rs =
                ps.executeQuery();

        while (rs.next()) {

            lista.add(
                    construirTurno(rs));
        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }

    return lista;
}

private Turno construirTurno(
        ResultSet rs)
        throws SQLException {

    Turno turno =
            new Turno();

    turno.setId(
            rs.getInt("id"));

    Timestamp fechaHora =
            rs.getTimestamp(
                    "fecha_hora");

    if (fechaHora != null) {

        turno.setFecha(
                fechaHora
                        .toLocalDateTime()
                        .toLocalDate());

        turno.setHora(
                fechaHora
                        .toLocalDateTime()
                        .toLocalTime());
    }

    turno.setEstado(
            EstadoTurno.valueOf(
                    rs.getString(
                            "estado")));

    //==========================
    // PACIENTE
    //==========================

    Paciente paciente =
            new Paciente();

    paciente.setId(
            rs.getInt(
                    "paciente_id"));

    paciente.setNombre(
            rs.getString(
                    "paciente_nombre"));

    paciente.setApellido(
            rs.getString(
                    "paciente_apellido"));
	
	paciente.setDni(
        rs.getString(
                "paciente_dni"));

    turno.setPaciente(
            paciente);

    //==========================
    // PROFESIONAL
    //==========================

    ProfesionalSalud profesional =
            new ProfesionalSalud();

    profesional.setId(
            rs.getInt(
                    "profesional_id"));

    profesional.setNombre(
            rs.getString(
                    "profesional_nombre"));

    profesional.setApellido(
            rs.getString(
                    "profesional_apellido"));

    profesional.setMatricula(
            rs.getString(
                    "nro_matricula"));

    //==========================
    // ESPECIALIDAD
    //==========================

    if (rs.getObject(
            "especialidad_id") != null) {

        Especialidad especialidad =
                new Especialidad();

        especialidad.setId(
                rs.getInt(
                        "especialidad_id"));

        especialidad.setNombre(
                rs.getString(
                        "especialidad_nombre"));

        profesional.setEspecialidad(
                especialidad);
    }

    turno.setProfesional(
            profesional);

    return turno;
}
}