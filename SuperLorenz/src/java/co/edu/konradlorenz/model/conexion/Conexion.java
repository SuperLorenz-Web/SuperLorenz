package co.edu.konradlorenz.model.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {
    
    public static String user = "root";
    public static String password = "root";
    public static String server = "localhost:3306";
    public static String BD = "tienda";
    
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

