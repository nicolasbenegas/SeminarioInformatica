package clinicgest.dao.impl;

import clinicgest.dao.UsuarioDAO;
import clinicgest.model.UsuarioSistema;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase "UsuarioDAOImpl"
 * Acceso a datos - Implementación
 * Capa -> DAO
 */
public class UsuarioDAOImpl
        implements UsuarioDAO {

    private static final List<UsuarioSistema>
            usuarios =
            new ArrayList<>();

    @Override
    public void guardar(
            UsuarioSistema usuario) {

        usuarios.add(usuario);
    }

    @Override
     public void actualizar(
            UsuarioSistema usuario) {

    }

    @Override
    public void eliminar(
            int id) {

        usuarios.removeIf(
                u -> u.getId() == id);
    }

    @Override
      public UsuarioSistema buscarPorId(
            int id) {

        return usuarios.stream()
                .filter(
                        u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public UsuarioSistema buscarPorUsuario(
            String usuario) {

        return usuarios.stream()
                .filter(
                        u -> u.getUsuario()
                                .equalsIgnoreCase(
                                        usuario))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<UsuarioSistema>
    listarTodos() {

        return usuarios;
    }
}