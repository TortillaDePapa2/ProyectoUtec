package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD conexionBD;
    private String url = "jdbc:postgresql://localhost:5432/ProyectoUtec";
    private String user = "postgres";
    private String password = "benja";
    private Connection conexion;
    private ConexionBD()  throws SQLException {
        try {
            this.conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexion establecida.");
        }catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static ConexionBD getConexionBD() throws SQLException {
        if (conexionBD == null) {
            conexionBD = new ConexionBD();
        }
        return conexionBD;
    }
}
