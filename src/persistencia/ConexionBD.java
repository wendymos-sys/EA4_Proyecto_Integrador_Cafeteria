
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD {

    private static final String URL =
        "jdbc:sqlite:datos/cafeteria.db";

    public static String probarConexion() {

        try {
            // Cargar el controlador JDBC
            Class.forName("org.sqlite.JDBC");

            // Abrir la conexion y realizar una consulta
            try (
                Connection conexion =
                    DriverManager.getConnection(URL);

                Statement sentencia =
                    conexion.createStatement();

                ResultSet resultado =
                    sentencia.executeQuery("SELECT 1")
            ) {

                if (resultado.next()) {
                    return "CONEXION EXITOSA CON SQLITE\n"
                         + "Base de datos: datos/cafeteria.db";
                }

                return "Conexion establecida sin resultados.";

            }

        } catch (ClassNotFoundException e) {

            return "ERROR: No se encontro el driver JDBC.\n"
                 + "Detalle: " + e.getMessage();

        } catch (SQLException e) {

            return "ERROR: No fue posible conectar con SQLite.\n"
                 + "Detalle: " + e.getMessage();
        }
    }
}
