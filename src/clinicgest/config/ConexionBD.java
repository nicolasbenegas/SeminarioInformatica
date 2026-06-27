package clinicgest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que administra la conexión
 * entre Java y MySQL mediante JDBC.
 */
public class ConexionBD {

    private static final String URL =
            "jdbc:mysql://localhost:3306/clinicgest"
            + "?useSSL=false"
            + "&allowPublicKeyRetrieval=true"
            + "&serverTimezone=America/Argentina/Cordoba";

    private static final String USUARIO =
            "root";

    private static final String CLAVE =
            "123456";

    public static Connection obtenerConexion()
            throws SQLException {

        return DriverManager.getConnection(
                URL,
                USUARIO,
                CLAVE
        );
    }
}