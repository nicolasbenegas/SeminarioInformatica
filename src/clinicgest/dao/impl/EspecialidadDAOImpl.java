package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.EspecialidadDAO;
import clinicgest.model.Especialidad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase "EspecialidadDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class EspecialidadDAOImpl
        implements EspecialidadDAO {

    @Override
    public void guardar(
            Especialidad especialidad) {

        String sql =
                "INSERT INTO especialidad " +
                        "(nombre,descripcion) " +
                        "VALUES (?,?)";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setString(
                    1,
                    especialidad.getNombre());

            ps.setString(
                    2,
                    especialidad.getDescripcion());

            ps.executeUpdate();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    @Override
    public void actualizar(
            Especialidad especialidad) {

        String sql =
                "UPDATE especialidad " +
                        "SET nombre=?, descripcion=? " +
                        "WHERE id=?";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setString(
                    1,
                    especialidad.getNombre());

            ps.setString(
                    2,
                    especialidad.getDescripcion());

            ps.setInt(
                    3,
                    especialidad.getId());

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
                             "DELETE FROM especialidad WHERE id=?")) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception ex) {

            ex.printStackTrace();
        }

    }

    @Override
    public Especialidad buscarPorId(
            int id) {

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(
                             "SELECT * FROM especialidad WHERE id=?")) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return construirEspecialidad(
                        rs);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return null;

    }

    @Override
    public List
    listarTodos() {

        List<Especialidad> lista =
                new ArrayList<>();

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(
                             "SELECT * FROM especialidad ORDER BY id")) {

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                lista.add(
                        construirEspecialidad(
                                rs));
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return lista;

    }

    private Especialidad
    construirEspecialidad(
            ResultSet rs)
            throws SQLException {

        Especialidad especialidad =
                new Especialidad();

        especialidad.setId(
                rs.getInt("id"));

        especialidad.setNombre(
                rs.getString("nombre"));

        especialidad.setDescripcion(
                rs.getString("descripcion"));

        return especialidad;

    }
}