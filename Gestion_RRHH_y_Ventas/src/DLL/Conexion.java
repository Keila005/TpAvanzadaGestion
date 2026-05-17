package DLL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    private static String URL = "jdbc:mysql://localhost:3306/gestion";
    private static String USER = "root";
    private static String PASSWORD = "";
    private static Connection connect = null;
    private static Conexion instance = null;
    
    private Conexion() {
        try {
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Se conectó a la base de datos");
        } catch (SQLException e) {
            System.out.println("No se conectó a la base de datos");
            e.printStackTrace();
        }
    }
    
    public static Conexion getInstance() {
        if (instance == null) {
            instance = new Conexion();
        }
        return instance;
    }
    
    public Connection getConnection() {
        return connect;
    }
}