package clinicgest.service;

import clinicgest.dao.UsuarioDAO;
import clinicgest.dao.impl.UsuarioDAOImpl;
import clinicgest.exception.ValidacionException;
import clinicgest.model.UsuarioSistema;

import java.util.List;

/**
 * Clase "UsuarioService"
 * Reglas del Negocio - Validaciones
 * Capa -> Service
 */
public class UsuarioService {

	//Atributos
    private final UsuarioDAO dao;

	//Métodos
    public UsuarioService() {

        dao = new UsuarioDAOImpl();
    }

    public void registrarUsuario(
            UsuarioSistema usuario)
            throws ValidacionException {

        validar(usuario);

        dao.guardar(usuario);
    }

    public void modificarUsuario(
            UsuarioSistema usuario)
            throws ValidacionException {

        validar(usuario);

        dao.actualizar(usuario);
    }

    public void eliminarUsuario(
            int id) {

        dao.eliminar(id);
    }

    public List<UsuarioSistema>
    listarUsuarios() {

        return dao.listarTodos();
    }

    private void validar(
            UsuarioSistema usuario)
            throws ValidacionException {

        if (usuario == null) {

            throw new ValidacionException(
                    "Usuario nulo");
        }

        if (usuario.getUsuario() == null
                || usuario.getUsuario()
                .isBlank()) {

            throw new ValidacionException(
                    "Debe ingresar usuario");
        }
    }
}