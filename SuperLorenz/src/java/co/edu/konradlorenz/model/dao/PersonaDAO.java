package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.connection.Conexion;
import co.edu.konradlorenz.model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonaDAO {

    public static int agregarPersona(Persona persona){

        Connection connection;
        Conexion conexion = new Conexion();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
        int status = 0;
        
        try {
            connection = conexion.crearConexion();
            
            String q = "INSERT INTO Persona (documentoID, tipoDocumento, nombre, celular)"
            + "VALUES (?,?,?,?)";
            
            preparedStatement = connection.prepareStatement(q);
            
            preparedStatement.setString(1, persona.getDocumentoID());
            preparedStatement.setString(2, persona.getTipoDocumento());
            preparedStatement.setString(3, persona.getNombre());
            preparedStatement.setString(4, persona.getCelular());
            
            status = preparedStatement.executeUpdate();
            connection.close();
            
            System.out.print("REGISTRO GUARDADO DE FORMA EXITOSA...");
        }catch (SQLException ex){
            System.out.print("ERROR AL REGISTRAR LA ACTIVIDAD...");
            System.out.print(ex.getMessage());
        }
        
        return status;
    }
    //agregarPersona
}
//class