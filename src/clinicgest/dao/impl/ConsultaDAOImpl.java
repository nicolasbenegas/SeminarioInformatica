package clinicgest.dao.impl;

import clinicgest.dao.ConsultaDAO;
import clinicgest.model.Consulta;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "ConsultaDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class ConsultaDAOImpl
        implements ConsultaDAO {

    private static final List<Consulta>
            consultas =
            new ArrayList<>();

    @Override
    public void guardar(
            Consulta consulta) {

        consultas.add(consulta);
    }

    @Override
    public void actualizar(
            Consulta consulta) {

    }

    @Override
    public void eliminar(
            int id) {

        consultas.removeIf(
                c -> c.getId() == id);
    }

    @Override
    public Consulta buscarPorId(
            int id) {

        return consultas.stream()
                .filter(
                        c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Consulta>
    listarTodos() {

        return consultas;
    }
}