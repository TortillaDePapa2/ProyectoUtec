package Proyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static ConexionBD conexionBD;
    private String url = "jdbc:postgresql://localhost:5432/ProyectoUtec"; // necesitan tener docker dado que la url se esta redirigiendo a un contenedor de docker
    private String user = "postgres"; // este es el usuario postgresql el cual es el dueño de la BD
    private String password = "benja"; //aqui va la password que ustedes tienen para su postgresql
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
