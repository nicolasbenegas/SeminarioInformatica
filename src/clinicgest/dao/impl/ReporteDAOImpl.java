package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.ReporteDAO;
import clinicgest.model.Reporte;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase "ReporteDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class ReporteDAOImpl
        implements ReporteDAO {

    @Override
    public void guardar(
            Reporte reporte) {

        String sql =
                "INSERT INTO reporte " +
                        "(administrador_id,tipo,fecha_generacion,contenido) " +
                        "VALUES (?,?,?,?)";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setInt(
                    1,
                    reporte.getAdministradorId());

            ps.setString(
                    2,
                    reporte.getTipo());

            ps.setDate(
                    3,
                    Date.valueOf(
                            reporte.getFechaGeneracion()));

            ps.setString(
                    4,
                    reporte.getContenido());

            ps.executeUpdate();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public void actualizar(
            Reporte reporte) {

        String sql =
                "UPDATE reporte " +
                        "SET administrador_id=?, " +
                        "tipo=?, " +
                        "fecha_generacion=?, " +
                        "contenido=? " +
                        "WHERE id=?";

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(sql)) {

            ps.setInt(
                    1,
                    reporte.getAdministradorId());

            ps.setString(
                    2,
                    reporte.getTipo());

            ps.setDate(
                    3,
                    Date.valueOf(
                            reporte.getFechaGeneracion()));

            ps.setString(
                    4,
                    reporte.getContenido());

            ps.setInt(
                    5,
                    reporte.getId());

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
                             "DELETE FROM reporte WHERE id=?")) {

            ps.setInt(1, id);

            ps.executeUpdate();

        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    @Override
    public Reporte buscarPorId(
            int id) {

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(
                             "SELECT * FROM reporte WHERE id=?")) {

            ps.setInt(1, id);

            ResultSet rs =
                    ps.executeQuery();

            if (rs.next()) {

                return construirReporte(rs);
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Reporte>
    listarTodos() {

        List<Reporte> lista =
                new ArrayList<>();

        try (Connection cn =
                     ConexionBD.obtenerConexion();
             PreparedStatement ps =
                     cn.prepareStatement(
                             "SELECT * FROM reporte ORDER BY fecha_generacion DESC")) {

            ResultSet rs =
                    ps.executeQuery();

            while (rs.next()) {

                lista.add(
                        construirReporte(rs));
            }

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        return lista;
    }

    private Reporte construirReporte(
            ResultSet rs)
            throws SQLException {

        Reporte reporte =
                new Reporte();

        reporte.setId(
                rs.getInt("id"));

        reporte.setAdministradorId(
                rs.getInt(
                        "administrador_id"));

        reporte.setTipo(
                rs.getString("tipo"));

        Date fecha =
                rs.getDate(
                        "fecha_generacion");

        if (fecha != null) {

            reporte.setFechaGeneracion(
                    fecha.toLocalDate());
        }

        reporte.setContenido(
                rs.getString(
                        "contenido"));

        return reporte;
    }
}