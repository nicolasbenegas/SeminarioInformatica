package clinicgest.dao;

import clinicgest.model.UsuarioSistema;

/**
 * Interfaz "UsuarioDAO"
 * Acceso a datos - Interfaz
 * Capa -> DAO
 */
public interface UsuarioDAO
        extends GenericDAO<UsuarioSistema> {

	void inhabilitar(int id);
	
    UsuarioSistema buscarPorUsuario(
            String usuario);
}