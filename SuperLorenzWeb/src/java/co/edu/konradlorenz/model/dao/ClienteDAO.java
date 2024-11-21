package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.*;
import co.edu.konradlorenz.model.connection.*;
import co.edu.konradlorenz.model.enums.EstadoCivil;
import co.edu.konradlorenz.model.enums.TipoCliente;
import co.edu.konradlorenz.model.enums.TipoDocumento;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
            String query = "INSERT INTO Persona (numeroDocumento, tipoDocumento, nombres, apellidos, celular, correo, password)"
                    + "VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            personaStmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            
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
            query =  "INSERT INTO Cliente (personaID, tipoCliente, direccion, fechaNacimiento, estadoCivil, autorizacionDeDatos) VALUES (?, ?, ?, ?, ?, ?);";
            
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
    public static List<Cliente> getAllProveedores() {
    List<Cliente> clientes = new ArrayList<>();
    
    try {
        Conexion conexion = new Conexion();
        connection = conexion.crearConexion();
        
        String query = "SELECT p.numeroDocumento, p.tipoDocumento, p.nombres, p.apellidos, "
                     + "p.celular, p.correo, c.tipoCliente, c.direccion, c.fechaNacimiento, "
                     + "c.estadoCivil, c.autorizacionDeDatos FROM Cliente c "
                     + "INNER JOIN Persona p ON c.personaID = p.personaID";
        personaStmt = (PreparedStatement)connection.prepareStatement(query);
        personaStmt = connection.prepareStatement(query);
        resultSet = personaStmt.executeQuery();
        
        while (resultSet.next()) {
            Cliente cliente = new Cliente();
            cliente.setNumeroDocumento(resultSet.getString("numeroDocumento"));
            cliente.setTipoDocumento(TipoDocumento.valueOf(resultSet.getString("tipoDocumento")));
            cliente.setNombres(resultSet.getString("nombres"));
            cliente.setApellidos(resultSet.getString("apellidos"));
            cliente.setCelular(resultSet.getString("celular"));
            cliente.setCorreo(resultSet.getString("correo"));
            cliente.setTipoCliente(TipoCliente.valueOf(resultSet.getString("tipoCliente")));
            cliente.setDireccion(resultSet.getString("direccion"));
            cliente.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
            cliente.setAutorizacionDeDatos(resultSet.getBoolean("autorizacionDeDatos"));
            
            clientes.add(cliente);
        }
        
    } catch (SQLException e) {
        e.printStackTrace();
    }  
    return clientes;
}
    
}
