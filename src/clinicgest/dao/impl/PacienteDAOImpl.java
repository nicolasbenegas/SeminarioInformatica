package clinicgest.dao.impl;

import clinicgest.config.ConexionBD;
import clinicgest.dao.PacienteDAO;
import clinicgest.model.HistoriaClinica;
import clinicgest.model.Paciente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**

Clase "PacienteDAOImpl"
Acceso a datos - Implementación

Capa -> DAO
*/
public class PacienteDAOImpl
implements PacienteDAO {

@Override
public void guardar(
Paciente paciente) {

 String sqlUsuario =
         "INSERT INTO usuario " +
         "(dni,nombre,apellido,sexo,calle,numero_calle,barrio,localidad,email,contacto) " +
         "VALUES (?,?,?,?,?,?,?,?,?,?)";

 try (Connection cn =
              ConexionBD.obtenerConexion()) {

     cn.setAutoCommit(false);

     PreparedStatement psUsuario =
             cn.prepareStatement(
                     sqlUsuario,
                     Statement.RETURN_GENERATED_KEYS);

     psUsuario.setString(1, paciente.getDni());
     psUsuario.setString(2, paciente.getNombre());
     psUsuario.setString(3, paciente.getApellido());
     psUsuario.setString(4, paciente.getSexo());
     psUsuario.setString(5, paciente.getCalle());
     psUsuario.setInt(6, paciente.getNumeroCalle());
     psUsuario.setString(7, paciente.getBarrio());
     psUsuario.setString(8, paciente.getLocalidad());
     psUsuario.setString(9, paciente.getEmail());
     psUsuario.setString(10, paciente.getContacto());

     psUsuario.executeUpdate();

     ResultSet rs =
             psUsuario.getGeneratedKeys();

     if (!rs.next()) {

         throw new SQLException(
                 "No se pudo obtener ID");
     }

     int id = rs.getInt(1);

     PreparedStatement psPaciente =
             cn.prepareStatement(
                     "INSERT INTO paciente(id) VALUES(?)");

     psPaciente.setInt(1, id);
     psPaciente.executeUpdate();

     PreparedStatement psHistoria =
        cn.prepareStatement(
                "INSERT INTO historia_clinica(paciente_id) VALUES(?)");

	 psHistoria.setInt(1, id);

	 psHistoria.executeUpdate();

     if (paciente.getHistoriaClinica() != null
             && paciente.getHistoriaClinica()
             .getFechaCreacion() != null) {

         psHistoria.setDate(
                 2,
                 Date.valueOf(
                         paciente.getHistoriaClinica()
                                 .getFechaCreacion()));

     } else {

         psHistoria.setDate(
                 2,
                 new Date(
                         System.currentTimeMillis()));
     }

     psHistoria.executeUpdate();

     cn.commit();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public void actualizar(
Paciente paciente) {

 String sql =
         "UPDATE usuario SET " +
         "dni=?,nombre=?,apellido=?,sexo=?,calle=?,numero_calle=?,barrio=?,localidad=?,email=?,contacto=? " +
         "WHERE id=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setString(1, paciente.getDni());
     ps.setString(2, paciente.getNombre());
     ps.setString(3, paciente.getApellido());
     ps.setString(4, paciente.getSexo());
     ps.setString(5, paciente.getCalle());
     ps.setInt(6, paciente.getNumeroCalle());
     ps.setString(7, paciente.getBarrio());
     ps.setString(8, paciente.getLocalidad());
     ps.setString(9, paciente.getEmail());
     ps.setString(10, paciente.getContacto());
     ps.setInt(11, paciente.getId());

     ps.executeUpdate();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public void eliminar(
int id) {

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(
                      "DELETE FROM usuario WHERE id=?")) {

     ps.setInt(1, id);

     ps.executeUpdate();

 } catch (Exception ex) {

     ex.printStackTrace();
 }

}

@Override
public Paciente buscarPorId(
int id) {

 String sql =
         "SELECT u.*,h.id AS historia_clinica_id,h.fecha_creacion " +
         "FROM usuario u " +
         "INNER JOIN paciente p ON u.id=p.id " +
         "LEFT JOIN historia_clinica h ON p.id=h.paciente_id " +
         "WHERE u.id=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setInt(1, id);

     ResultSet rs =
             ps.executeQuery();

     if (rs.next()) {

         return construirPaciente(rs);
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return null;

}

@Override
public Paciente buscarPorDni(
String dni) {

 String sql =
         "SELECT u.*,h.id AS historia_clinica_id,h.fecha_creacion " +
         "FROM usuario u " +
         "INNER JOIN paciente p ON u.id=p.id " +
         "LEFT JOIN historia_clinica h ON p.id=h.paciente_id " +
         "WHERE u.dni=?";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ps.setString(1, dni);

     ResultSet rs =
             ps.executeQuery();

     if (rs.next()) {

         return construirPaciente(rs);
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return null;

}

@Override
public List
listarTodos() {

 List<Paciente> lista =
         new ArrayList<>();

 String sql =
         "SELECT u.*,h.id AS historia_clinica_id,h.fecha_creacion " +
         "FROM usuario u " +
         "INNER JOIN paciente p ON u.id=p.id " +
         "LEFT JOIN historia_clinica h ON p.id=h.paciente_id";

 try (Connection cn =
              ConexionBD.obtenerConexion();
      PreparedStatement ps =
              cn.prepareStatement(sql)) {

     ResultSet rs =
             ps.executeQuery();

     while (rs.next()) {

         lista.add(
                 construirPaciente(rs));
     }

 } catch (Exception ex) {

     ex.printStackTrace();
 }

 return lista;

}

private Paciente construirPaciente(
ResultSet rs)
throws SQLException {

 Paciente paciente =
         new Paciente();

 paciente.setId(
         rs.getInt("id"));

 paciente.setDni(
         rs.getString("dni"));

 paciente.setNombre(
         rs.getString("nombre"));

 paciente.setApellido(
         rs.getString("apellido"));

 paciente.setSexo(
         rs.getString("sexo"));

 paciente.setCalle(
         rs.getString("calle"));

 paciente.setNumeroCalle(
         rs.getInt("numero_calle"));

 paciente.setBarrio(
         rs.getString("barrio"));

 paciente.setLocalidad(
         rs.getString("localidad"));

 paciente.setEmail(
         rs.getString("email"));

 paciente.setContacto(
         rs.getString("contacto"));

 Date fecha =
         rs.getDate(
                 "fecha_creacion");

 if (fecha != null) {

     HistoriaClinica hc =
             new HistoriaClinica();

     hc.setFechaCreacion(
             fecha.toLocalDate());

     paciente.setHistoriaClinica(
             hc);
 }

 return paciente;

}
}