package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.connection.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    
    public static int agregarCliente(Cliente cliente){

        int status = 0;
        Connection connection = null;
        PreparedStatement personaStmt = null;
        PreparedStatement clienteStmt = null;
        ResultSet generatedKeys = null;
        
        //ResultSet resultSet; 
        
        try {
            //Crea la conexión
            Conexion conexion = new Conexion();
            connection = conexion.crearConexion();
            
            //Insert de Persona
            String personaQuery="INSERT INTO Persona (numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo, password)\n" +
                                "VALUES (?, ?, ?, ?, ?, ?, ?);";
            
            personaStmt = connection.prepareStatement(personaQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            
            personaStmt.setString(1, cliente.getNumeroDocumento());
            personaStmt.setString(2, cliente.getTipoDocumento());
            personaStmt.setString(3, cliente.getNombres());
            personaStmt.setString(4, cliente.getApellidos());
            personaStmt.setString(5, cliente.getCelular());
            personaStmt.setString(6, cliente.getCorreo());
            personaStmt.setString(7, cliente.getPassword());
            
            personaStmt.executeUpdate();
            
            //Obtener personaID generado
            generatedKeys = personaStmt.getGeneratedKeys();//Aquí se obtiene personaID
            int personaID = 0;
            if (generatedKeys.next()) {
                personaID = generatedKeys.getInt(1);
            }
            
            //Insert de Cliente
            String clienteQuery="INSERT INTO Cliente (personaID, tipoCliente, direccion, fechaNacimiento, estadoCivil, autorizacionDeDatos)\n" +
                                "VALUES (?, ?, ?, ?, ?, ?);";
            
            clienteStmt = connection.prepareStatement(clienteQuery);
            
            clienteStmt.setInt(1, personaID);//personaID antes obtenido.
            clienteStmt.setString(2, cliente.getTipoCliente());
            clienteStmt.setString(3, cliente.getDireccion());
            clienteStmt.setDate(4, (Date) cliente.getFechaNacimiento());//Cast de util.Date a sql.Date
            clienteStmt.setString(5, cliente.getEstadoCivil());
            clienteStmt.setBoolean(6, cliente.isAutorizacionDeDatos());
            
            status = clienteStmt.executeUpdate();
            
            System.out.print("REGISTRO GUARDADO DE FORMA EXITOSA...");
        } catch (SQLException ex) {
            System.out.println("ERROR AL REGISTRAR LA ACTIVIDAD...");
            ex.printStackTrace();
        } finally {
            //Cerrar recursos
            try { if (generatedKeys != null) generatedKeys.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (personaStmt != null) personaStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (clienteStmt != null) clienteStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        
        return status;
    }
    //agregarCliente
}
//class
