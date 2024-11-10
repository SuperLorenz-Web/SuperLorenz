package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.connection.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    
    public static int agregarCliente(Cliente nuevoCliente){
        
        Cliente cliente = nuevoCliente;

        Connection connection;
        Conexion conexion = new Conexion();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        
        int status = 0;
        
        try {
            connection = conexion.crearConexion();
            
            String query;
            
            query = "INSERT INTO Persona (numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo, password)\n" +
                    "VALUES ('?', '?', '?', '?', '?', '?', '?');";
            
            preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(1, cliente.getNumeroDocumento());
            preparedStatement.setString(2, cliente.getTipoDocumento());
            preparedStatement.setString(3, cliente.getNombres());
            preparedStatement.setString(4, cliente.getApellidos());
            preparedStatement.setString(5, cliente.getCelular());
            preparedStatement.setString(6, cliente.getCorreo());
            preparedStatement.setString(7, cliente.getPassword());
            
            query = "SET @personaID = LAST_INSERT_ID();";
            
            preparedStatement = connection.prepareStatement(query);
              
            query = "INSERT INTO Cliente (personaID, tipoCliente, direccion, fechaNacimiento, estadoCivil, autorizacionDeDatos)\n" +
                    "VALUES ('@personaID', '?', '?', '?', '?', '?');";
            
            preparedStatement = connection.prepareStatement(query);
            
            preparedStatement.setString(2, cliente.getTipoCliente());//No estoy seguro si se pone el 2 o el 1, toca probar
            preparedStatement.setString(3, cliente.getDireccion());
            preparedStatement.setString(4, cliente.getFechaNacimiento());
            preparedStatement.setString(5, cliente.getEstadoCivil());
            preparedStatement.setString(6, cliente.isAutorizacionDeDatos());
            
            query = "SET @personaID = NULL;";
            
            preparedStatement = connection.prepareStatement(query);
            
            status = preparedStatement.executeUpdate();
            connection.close();
            
            System.out.print("REGISTRO GUARDADO DE FORMA EXITOSA...");
        }catch (SQLException ex){
            System.out.print("ERROR AL REGISTRAR LA ACTIVIDAD...");
            System.out.print(ex.getMessage());
        }
        
        return status;
    }
    //agregarCliente
}
//class
