package clinicgest.controller;

import clinicgest.exception.ValidacionException;
import clinicgest.model.UsuarioSistema;
import clinicgest.service.UsuarioService;

import java.util.List;

/**
 * Clase "UsuarioController"
 * Control y coordinación
 * Capa -> Controller
 */
public class UsuarioController {

	//Atributos
    private final UsuarioService service;

 	//Métodos
    public UsuarioController() {

        service = new UsuarioService();
    }

    public void registrarUsuario(
            UsuarioSistema usuario)
            throws ValidacionException {

        service.registrarUsuario(usuario);
    }

    public void modificarUsuario(
            UsuarioSistema usuario)
            throws ValidacionException {

        service.modificarUsuario(usuario);
    }

	public void inhabilitarUsuario(int id){

    service.inhabilitarUsuario(id);

	}
	
    public void eliminarUsuario(int id) {

    inhabilitarUsuario(id);

	}

    public List<UsuarioSistema>
    listarUsuarios() {

        return service.listarUsuarios();
    }
}