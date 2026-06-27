package clinicgest.dao;

import java.util.List;

/**
 * Interfaz "GenericDAO"
 * Acceso a datos - Interfaz
 * Capa -> DAO
 */
public interface GenericDAO<T> {

    void guardar(T entidad);

    void actualizar(T entidad);

    void eliminar(int id);

    T buscarPorId(int id);

    List<T> listarTodos();
}