package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.connection.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {
    
    private static int status = 0;
    private static Connection connection = null;
    private static PreparedStatement personaStmt = null;
    private static PreparedStatement clienteStmt = null;
    private static ResultSet resultSet = null;
    
    //Abre: agregarCliente
    public static int agregarCliente(Cliente cliente){
        
        try {
            //Crea la conexión
            Conexion conexion = new Conexion();
            connection = conexion.crearConexion();
            
            //Insert de Persona
            String personaQuery="""
                                INSERT INTO Persona (numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo, password)
                                VALUES (?, ?, ?, ?, ?, ?, ?);
                                """;
            
            personaStmt = connection.prepareStatement(personaQuery, PreparedStatement.RETURN_GENERATED_KEYS);
            
            personaStmt.setString(1, cliente.getNumeroDocumento());
            personaStmt.setString(2, cliente.getTipoDocumento().name());//.name() convierte enum a String
            personaStmt.setString(3, cliente.getNombres());
            personaStmt.setString(4, cliente.getApellidos());
            personaStmt.setString(5, cliente.getCelular());
            personaStmt.setString(6, cliente.getCorreo());
            personaStmt.setString(7, cliente.getPassword());
            
            personaStmt.executeUpdate();
            
            //Obtener personaID generado
            resultSet = personaStmt.getGeneratedKeys();//Aquí se obtiene personaID
            int personaID = 0;
            if (resultSet.next()) {
                personaID = resultSet.getInt(1);
            }
            
            //Insert de Cliente
            String query =  """
                            INSERT INTO Cliente (personaID, tipoCliente, direccion, fechaNacimiento, estadoCivil, autorizacionDeDatos)
                            VALUES (?, ?, ?, ?, ?, ?);
                            """;
            
            clienteStmt = connection.prepareStatement(query);
            
            clienteStmt.setInt(1, personaID);//personaID antes obtenido.
            clienteStmt.setString(2, cliente.getTipoCliente().name());//.name() convierte enum a String
            clienteStmt.setString(3, cliente.getDireccion());
            clienteStmt.setDate(4, (Date) cliente.getFechaNacimiento());//Cast de util.Date a sql.Date
            clienteStmt.setString(5, cliente.getEstadoCivil().name());//.name() convierte enum a String
            clienteStmt.setBoolean(6, cliente.isAutorizacionDeDatos());
            
            status = clienteStmt.executeUpdate();
            
            System.out.print("REGISTRO GUARDADO DE FORMA EXITOSA...");
        } catch (SQLException e) {
            System.out.println("ERROR AL REGISTRAR LA ACTIVIDAD...");
            e.printStackTrace();
        } finally {
            //Cerrar recursos
            try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (personaStmt != null) personaStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (clienteStmt != null) clienteStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        
        return status;
    }
    //Cierra: agregarCliente
    
    //Abre: iniciarSesion
    public static Cliente iniciarSesion(String correo, String password){
        
        Cliente cliente = null;
            
            try {
                
                Conexion conexion = new Conexion();
                connection = conexion.crearConexion();
                
                String query =  """
                                SELECT *
                                FROM Persona p
                                INNER JOIN Cliente c
                                ON p.personaID = c.personaID
                                WHERE correo = ? AND password = ?;
                                """;
                
                personaStmt = (PreparedStatement)connection.prepareStatement(query);
                personaStmt.setString(1, correo);
                personaStmt.setString(2, password);
                
                resultSet = personaStmt.executeQuery();
                
                if(resultSet.next()) {
                    cliente = new Cliente();
                    cliente.setCorreo(resultSet.getString("correo"));
                    cliente.setPassword(resultSet.getString("contraseña"));
                }
                
                System.out.print("CLIENTE LOGEADO DE FORMA EXITOSA...");
            } catch (SQLException e) {
                System.out.println("ERROR AL LOGEAR CLIENTE...");
                e.printStackTrace();
            } finally {
                //Cerrar recursos
                try { if (resultSet != null) resultSet.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (personaStmt != null) personaStmt.close(); } catch (SQLException e) { e.printStackTrace(); }
                try { if (connection != null) connection.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        return cliente;
    }
    //Cierra: iniciarSesion
    
}
//Cierra: class
