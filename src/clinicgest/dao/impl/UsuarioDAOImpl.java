package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.UsuarioDAO;
import clinicgest.model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**

Clase "UsuarioDAOImpl"
Acceso a datos - Implementación

Capa -> DAO
*/
public class UsuarioDAOImpl
implements UsuarioDAO {

@Override
public void guardar(
UsuarioSistema usuario) {

 String sqlUsuario =
         "INSERT INTO usuario " +
         "(dni,nombre,apellido,sexo,calle,numero_calle,barrio,localidad,email,contacto) " +
         "VALUES (?,?,?,?,?,?,?,?,?,?)";

 String sqlSistema =
         "INSERT INTO usuario_sistema " +
         "(id,usuario,clave,activo,rol) " +
         "VALUES (?,?,?,?,?)";

 try (Connection cn =
              ConexionBD.obtenerConexion()) {

     cn.setAutoCommit(false);

     PreparedStatement psUsuario =
             cn.prepareStatement(
                     sqlUsuario,
                     Statement.RETURN_GENERATED_KEYS);

     psUsuario.setString(1, usuario.getDni());
     psUsuario.setString(2, usuario.getNombre());
     psUsuario.setString(3, usuario.getApellido());
     psUsuario.setString(4, usuario.getSexo());
     psUsuario.setString(5, usuario.getCalle());
     psUsuario.setInt(6, usuario.getNumeroCalle());
     psUsuario.setString(7, usuario.getBarrio());
     psUsuario.setString(8, usuario.getLocalidad());
     psUsuario.setString(9, usuario.getEmail());
     psUsuario.setString(10, usuario.getContacto());

     psUsuario.executeUpdate();

     ResultSet rs =
             psUsuario.getGeneratedKeys();

     if (!rs.next()) {

         throw new SQLException(
                 "No se pudo obtener ID");
     }

     int id = rs.getInt(1);

     PreparedStatement psSistema =
             cn.prepareStatement(
                     sqlSistema);

     psSistema.setInt(1, id);
     psSistema.setString(
             2,
             usuario.getUsuario());

     psSistema.setString(
             3,
             usuario.getClave());

     psSistema.setBoolean(
             4,
             usuario.isActivo());

     psSistema.setString(
             5,
             usuario.getRol().name());

     psSistema.executeUpdate();
	 
	 if (usuario instanceof ProfesionalSalud) {

    ProfesionalSalud profesional =
            (ProfesionalSalud) usuario;

    PreparedStatement psProfesional =
            cn.prepareStatement(
                    "INSERT INTO profesional_salud " +
                    "(id,legajo,fecha_ingreso,nro_matricula,especialidad_id) " +
                    "VALUES (?,?,?,?,?)");

    psProfesional.setInt(
            1,
            id);

    psProfesional.setString(
            2,
            "LEG-" + id);

    psProfesional.setDate(
            3,
            new Date(
                    System.currentTimeMillis()));

    psProfesional.setString(
            4,
            profesional.getMatricula());

    psProfesional.setInt(
            5,
            profesional.getEspecialidad()
                    .getId());

    psProfesional.executeUpdate();
	}

     cn.commit();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public void actualizar(
UsuarioSistema usuario) {

 String sql =
         "UPDATE usuario_sistema " +
         "SET usuario=?,clave=?,activo=? " +
         "WHERE id=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setString(
             1,
             usuario.getUsuario());

     ps.setString(
             2,
             usuario.getClave());

     ps.setBoolean(
             3,
             usuario.isActivo());

     ps.setInt(
             4,
             usuario.getId());

     ps.executeUpdate();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}


@Override
public void inhabilitar(int id) {

    String sql =
            "UPDATE usuario_sistema " +
            "SET activo = false " +
            "WHERE id = ?";

    try (Connection cn =
                 ConexionBD.obtenerConexion();
         PreparedStatement ps =
                 cn.prepareStatement(sql)) {

        ps.setInt(1, id);

        int filas =
                ps.executeUpdate();

        if (filas > 0) {

            System.out.println(
                    "\nUsuario inhabilitado correctamente.");

        } else {

            System.out.println(
                    "\nNo existe un usuario con ese ID.");
        }

    } catch (Exception ex) {

        ex.printStackTrace();
    }
}

@Override
public void eliminar(int id) {

    inhabilitar(id);

}

@Override
public UsuarioSistema buscarPorId(
int id) {

 String sql =
        "SELECT " +
        "u.*, " +
        "us.*, " +
        "ps.nro_matricula, " +
        "ps.especialidad_id, " +
        "e.nombre AS nombre_especialidad, " +
        "e.descripcion AS descripcion_especialidad " +
        "FROM usuario u " +
        "INNER JOIN usuario_sistema us " +
        "ON u.id=us.id " +
        "LEFT JOIN profesional_salud ps " +
        "ON u.id=ps.id " +
        "LEFT JOIN especialidad e " +
        "ON ps.especialidad_id=e.id " +
		"WHERE us.id=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setInt(1, id);

     ResultSet rs =
             ps.executeQuery();

     if (rs.next()) {

         return construirUsuario(
                 rs);
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return null;

}

@Override
public UsuarioSistema buscarPorUsuario(
String usuario) {

 String sql =
        "SELECT " +
        "u.*, " +
        "us.*, " +
        "ps.nro_matricula, " +
        "ps.especialidad_id, " +
        "e.nombre AS nombre_especialidad, " +
        "e.descripcion AS descripcion_especialidad " +
        "FROM usuario u " +
        "INNER JOIN usuario_sistema us " +
        "ON u.id=us.id " +
        "LEFT JOIN profesional_salud ps " +
        "ON u.id=ps.id " +
        "LEFT JOIN especialidad e " +
        "ON ps.especialidad_id=e.id " +
        "WHERE us.usuario=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setString(1, usuario);

     ResultSet rs =
             ps.executeQuery();

     if (rs.next()) {

         return construirUsuario(
                 rs);
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return null;

}

@Override
public List
listarTodos() {

 List<UsuarioSistema> lista =
         new ArrayList<>();

 String sql =
        "SELECT " +
        "u.*, " +
        "us.*, " +
        "ps.nro_matricula, " +
        "ps.especialidad_id, " +
        "e.nombre AS nombre_especialidad, " +
        "e.descripcion AS descripcion_especialidad " +
        "FROM usuario u " +
        "INNER JOIN usuario_sistema us " +
        "ON u.id=us.id " +
        "LEFT JOIN profesional_salud ps " +
        "ON u.id=ps.id " +
        "LEFT JOIN especialidad e " +
        "ON ps.especialidad_id=e.id ";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ResultSet rs =
             ps.executeQuery();

     while (rs.next()) {

         lista.add(
                 construirUsuario(
                         rs));
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return lista;

}

private UsuarioSistema
construirUsuario(
        ResultSet rs)
        throws SQLException {

    RolUsuario rol =
            RolUsuario.valueOf(
                    rs.getString("rol"));

    UsuarioSistema usuario;

    switch (rol) {

        case ADMINISTRADOR:

            usuario =
                    new Administrador();

            break;

        case RECEPCIONISTA:

            usuario =
                    new Recepcionista();

            break;

        default:

            ProfesionalSalud profesional =
        new ProfesionalSalud();

profesional.setMatricula(
        rs.getString(
                "nro_matricula"));

if (rs.getObject("especialidad_id") != null) {

    Especialidad especialidad =
            new Especialidad();

    especialidad.setId(
            rs.getInt(
                    "especialidad_id"));

    especialidad.setNombre(
            rs.getString(
                    "nombre_especialidad"));

    especialidad.setDescripcion(
            rs.getString(
                    "descripcion_especialidad"));

    profesional.setEspecialidad(
            especialidad);
}

usuario = profesional;

            break;
    }

    usuario.setId(
            rs.getInt("id"));

    usuario.setDni(
            rs.getString("dni"));

    usuario.setNombre(
            rs.getString("nombre"));

    usuario.setApellido(
            rs.getString("apellido"));

    usuario.setSexo(
            rs.getString("sexo"));

    usuario.setCalle(
            rs.getString("calle"));

    usuario.setNumeroCalle(
            rs.getInt(
                    "numero_calle"));

    usuario.setBarrio(
            rs.getString("barrio"));

    usuario.setLocalidad(
            rs.getString("localidad"));

    usuario.setEmail(
            rs.getString("email"));

    usuario.setContacto(
            rs.getString("contacto"));

    usuario.setUsuario(
            rs.getString("usuario"));

    usuario.setClave(
            rs.getString("clave"));

    usuario.setActivo(
            rs.getBoolean("activo"));

    usuario.setRol(rol);

    return usuario;
}
}