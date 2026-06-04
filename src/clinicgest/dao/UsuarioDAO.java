package clinicgest.dao;

import clinicgest.model.UsuarioSistema;

/**
 * Interfaz "UsuarioDAO"
 * Acceso a datos - Interfaz
 * Capa -> DAO
 */
public interface UsuarioDAO
        extends GenericDAO<UsuarioSistema> {

    UsuarioSistema buscarPorUsuario(
            String usuario);
}