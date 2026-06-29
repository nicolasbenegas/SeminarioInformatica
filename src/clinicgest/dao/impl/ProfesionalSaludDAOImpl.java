package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.ProfesionalSaludDAO;
import clinicgest.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase "ProfesionalSaludDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class ProfesionalSaludDAOImpl
        implements ProfesionalSaludDAO {

    @Override
    public void guardar(
            ProfesionalSalud profesional) {

        String sqlUsuario =
                "INSERT INTO usuario " +
                        "(dni,nombre,apellido,sexo,calle,numero_calle,barrio,localidad,email,contacto) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection cn =
                     ConexionBD.obtenerConexion()) {

            cn.setAutoCommit(false);

            PreparedStatement psUsuario =
                    cn.prepareStatement(
                            sqlUsuario,
                            Statement.RETURN_GENERATED_KEYS);

            psUsuario.setString(1, profesional.getDni());
            psUsuario.setString(2, profesional.getNombre());
            psUsuario.setString(3, profesional.getApellido());
            psUsuario.setString(4, profesional.getSexo());
            psUsuario.setString(5, profesional.getCalle());
            psUsuario.setInt(6, profesional.getNumeroCalle());
            psUsuario.setString(7, profesional.getBarrio());
            psUsuario.setString(8, profesional.getLocalidad());
            psUsuario.setString(9, profesional.getEmail());
            psUsuario.setString(10, profesional.getContacto());

            psUsuario.executeUpdate();

            ResultSet rs =
                    psUsuario.getGeneratedKeys();

            if (!rs.next()) {

                throw new SQLException(
                        "No se pudo obtener ID");
            }

            int id = rs.getInt(1);

            PreparedStatement psSistema =
                    cn.prepareStatement(
                            "INSERT INTO usuario_sistema " +
                                    "(id,usuario,clave,activo,rol) " +
                                    "VALUES (?,?,?,?,?)");

            psSistema.setInt(1, id);
            psSistema.setString(
                    2,
                    profesional.getUsuario());

            psSistema.setString(
                    3,
                    profesional.getClave());

            psSistema.setBoolean(
                    4,
                    profesional.isActivo());

            psSistema.setString(
                    5,
                    RolUsuario.PROFESIONAL.name());

            psSistema.executeUpdate();

            PreparedStatement psProfesional =
                    cn.prepareStatement(
                            "INSERT INTO profesional_salud " +
                                    "(id,nro_matricula,especialidad_id) " +
                                    "VALUES (?,?,?)");

            psProfesional.setInt(
                    1,
                    id);

            psProfesional.setString(
                    2,
                    profesional.getMatricula());

            psProfesional.setInt(
                    3,
                    profesional.getEspecialidad()
                            .getId());

            psProfesional.executeUpdate();

            cn.commit();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(
            ProfesionalSalud profesional) {

        String sql =
                "UPDATE profesional_salud " +
                        "SET nro_matricula=?, especialidad_id=? " +
                        "WHERE id=?";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setString(
                    1,
                    profesional.getMatricula());

            ps.setInt(
                    2,
                    profesional.getEspecialidad()
                            .getId());

            ps.setInt(
                    3,
                    profesional.getId());

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
                             "DELETE FROM usuario WHERE id=?")) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public ProfesionalSalud buscarPorId(
            int id) {

        String sql =
                "SELECT " +
                        "u.id, " +
                        "u.dni, " +
                        "u.nombre, " +
                        "u.apellido, " +
                        "u.sexo, " +
                        "u.calle, " +
                        "u.numero_calle, " +
                        "u.barrio, " +
                        "u.localidad, " +
                        "u.email, " +
                        "u.contacto, " +

                        "us.usuario, " +
                        "us.clave, " +
                        "us.activo, " +

                        "ps.nro_matricula, " +
                        "ps.especialidad_id, " +

                        "e.id AS esp_id, " +
                        "e.nombre AS nombre_especialidad, " +
                        "e.descripcion AS descripcion_especialidad " +

                        "FROM profesional_salud ps " +
                        "INNER JOIN usuario u ON ps.id=u.id " +
                        "INNER JOIN usuario_sistema us ON ps.id=us.id " +
                        "LEFT JOIN especialidad e ON ps.especialidad_id=e.id " +
                        "WHERE ps.id=?";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return construirProfesional(
                        rs);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public ProfesionalSalud buscarPorMatricula(
            String matricula) {

        String sql =
                "SELECT " +
                        "u.id, " +
                        "u.dni, " +
                        "u.nombre, " +
                        "u.apellido, " +
                        "u.sexo, " +
                        "u.calle, " +
                        "u.numero_calle, " +
                        "u.barrio, " +
                        "u.localidad, " +
                        "u.email, " +
                        "u.contacto, " +

                        "us.usuario, " +
                        "us.clave, " +
                        "us.activo, " +

                        "ps.nro_matricula, " +
                        "ps.especialidad_id, " +

                        "e.id AS esp_id, " +
                        "e.nombre AS nombre_especialidad, " +
                        "e.descripcion AS descripcion_especialidad " +

                        "FROM profesional_salud ps " +
                        "INNER JOIN usuario u ON ps.id=u.id " +
                        "INNER JOIN usuario_sistema us ON ps.id=us.id " +
                        "LEFT JOIN especialidad e ON ps.especialidad_id=e.id " +
                        "WHERE ps.nro_matricula=?";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setString(1, matricula);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return construirProfesional(
                        rs);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ProfesionalSalud>
    listarTodos() {

        List<ProfesionalSalud> lista =
                new ArrayList<>();

        String sql =
                "SELECT " +
                        "u.id, " +
                        "u.dni, " +
                        "u.nombre, " +
                        "u.apellido, " +
                        "u.sexo, " +
                        "u.calle, " +
                        "u.numero_calle, " +
                        "u.barrio, " +
                        "u.localidad, " +
                        "u.email, " +
                        "u.contacto, " +

                        "us.usuario, " +
                        "us.clave, " +
                        "us.activo, " +

                        "ps.nro_matricula, " +
                        "ps.especialidad_id, " +

                        "e.id AS esp_id, " +
                        "e.nombre AS nombre_especialidad, " +
                        "e.descripcion AS descripcion_especialidad " +

                        "FROM profesional_salud ps " +
                        "INNER JOIN usuario u ON ps.id=u.id " +
                        "INNER JOIN usuario_sistema us ON ps.id=us.id " +
                        "LEFT JOIN especialidad e ON ps.especialidad_id=e.id " +
                        "ORDER BY u.apellido,u.nombre";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                lista.add(
                        construirProfesional(
                                rs));
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return lista;
    }

    private ProfesionalSalud construirProfesional(
            ResultSet rs)
            throws SQLException {

        ProfesionalSalud profesional =
                new ProfesionalSalud();

        //==========================
        // DATOS PERSONALES
        //==========================

        profesional.setId(
                rs.getInt("id"));

        profesional.setDni(
                rs.getString("dni"));

        profesional.setNombre(
                rs.getString("nombre"));

        profesional.setApellido(
                rs.getString("apellido"));

        profesional.setSexo(
                rs.getString("sexo"));

        profesional.setCalle(
                rs.getString("calle"));

        profesional.setNumeroCalle(
                rs.getInt("numero_calle"));

        profesional.setBarrio(
                rs.getString("barrio"));

        profesional.setLocalidad(
                rs.getString("localidad"));

        profesional.setEmail(
                rs.getString("email"));

        profesional.setContacto(
                rs.getString("contacto"));

        //==========================
        // USUARIO DEL SISTEMA
        //==========================

        profesional.setUsuario(
                rs.getString("usuario"));

        profesional.setClave(
                rs.getString("clave"));

        profesional.setActivo(
                rs.getBoolean("activo"));

        profesional.setRol(
                RolUsuario.PROFESIONAL);

        //==========================
        // DATOS PROFESIONALES
        //==========================

        profesional.setMatricula(
                rs.getString("nro_matricula"));

        Integer especialidadId =
                (Integer) rs.getObject(
                        "especialidad_id");

        if (especialidadId != null) {

            Especialidad especialidad =
                    new Especialidad();

            especialidad.setId(
                    especialidadId);

            especialidad.setNombre(
                    rs.getString(
                            "nombre_especialidad"));

            especialidad.setDescripcion(
                    rs.getString(
                            "descripcion_especialidad"));

            profesional.setEspecialidad(
                    especialidad);
        }

        return profesional;
    }
}