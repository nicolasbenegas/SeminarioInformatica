package clinicgest.controller;

import clinicgest.exception.LoginException;
import clinicgest.model.UsuarioSistema;
import clinicgest.service.LoginService;

/**
 * Clase "LoginController"
 * Control y coordinación
 * Capa -> Controller
 */
public class LoginController {

	//Atributos
    private final LoginService service;

	//Métodos
    public LoginController() {

        service = new LoginService();
    }

    public UsuarioSistema login(
            String usuario,
            String clave)
            throws LoginException {

        return service.login(
                usuario,
                clave);
    }
}