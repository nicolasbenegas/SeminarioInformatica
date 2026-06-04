package clinicgest.dao.impl;

import clinicgest.dao.ReporteDAO;
import clinicgest.model.Reporte;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "ReporteDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class ReporteDAOImpl
        implements ReporteDAO {

    private static final List<Reporte>
            reportes =
            new ArrayList<>();

    @Override
    public void guardar(
            Reporte reporte) {

        reportes.add(reporte);
    }

    @Override
    public void actualizar(
            Reporte reporte) {

    }

    @Override
    public void eliminar(
            int id) {

        reportes.removeIf(
                r -> r.getId() == id);
    }

    @Override
    public Reporte buscarPorId(
            int id) {

        return reportes.stream()
                .filter(
                        r -> r.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Reporte>
    listarTodos() {

        return reportes;
    }
}