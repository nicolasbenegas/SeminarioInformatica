package clinicgest.service;

import clinicgest.dao.UsuarioDAO;
import clinicgest.dao.impl.UsuarioDAOImpl;
import clinicgest.exception.LoginException;
import clinicgest.model.UsuarioSistema;

/**
 * Clase "LoginService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class LoginService {

	//Atributos
    private final UsuarioDAO dao;

	//Métodos
    public LoginService() {

        dao = new UsuarioDAOImpl();
    }

    public UsuarioSistema login(
        String usuario,
        String clave)
        throws LoginException {

    UsuarioSistema encontrado =
            dao.buscarPorUsuario(
                    usuario);

    if (encontrado == null) {

        throw new LoginException(
                "Usuario inexistente");
    }

    if (!encontrado.isActivo()) {

        throw new LoginException(
                "El usuario se encuentra inhabilitado. Comuníquese con el administrador del sistema.");
    }

    if (!encontrado.getClave()
            .equals(clave)) {

        throw new LoginException(
                "Clave incorrecta");
    }

    return encontrado;
	}
}