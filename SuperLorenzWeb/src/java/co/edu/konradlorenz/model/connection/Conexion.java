package co.edu.konradlorenz.model.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Configuración de la base de datos
    public static String usuario = "root";
    public static String clave = ""; // Contraseña por defecto
    public static String servidor = "localhost:3306";
    public static String BD = "SuperLorenzWeb";

    // Método para crear la conexión
    public Connection crearConexion() {
        Connection con = null;
        try {
            // Cargar el driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // URL para la conexión
            String URL = "jdbc:mysql://" + servidor + "/" + BD + "?useSSL=false&serverTimezone=UTC";
            
            // Establecer la conexión
            con = DriverManager.getConnection(URL, usuario, clave);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error: No se encontró la clase para el driver de MySQL");
        } catch (SQLException e) {
            System.out.println("Error: No se pudo establecer conexión con la base de datos");
        }
        return con;
    }
}

/*
public class Conexion {
    
    public static String user = "root";
    public static String password = "G01fukl*";
    public static String server = "localhost:3306";
    public static String BD = "SuperLorenz";
    
    public Connection crearConexion() {
        
        Connection connection = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL="jdbc:mysql://"+server+"/"+BD;
            connection=DriverManager.getConnection(URL, user,password);
        } catch(java.lang.ClassNotFoundException ex) {
            System.out.println("classnotfound");
        } catch(SQLException e) {
            System.out.println("error de enlace canal");
        }
        
        return connection;
    }
    //crearConexion

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    //createStatement
    
}
//class
*/
