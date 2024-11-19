package co.edu.konradlorenz.model.dao;

import co.edu.konradlorenz.model.connection.Conexion;
import co.edu.konradlorenz.model.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PersonaDAO {
    private final Conexion conexionBD = new Conexion();

    // Método para validar las credenciales del usuario
    public boolean validarCredenciales(String numeroDocumento, String passwordUsuario) {
        boolean credencialesValidas = false;
        try (Connection con = conexionBD.crearConexion()) {
            if (con != null) {
                String sql = "SELECT * FROM Persona WHERE numeroDocumento = ? AND password = ?";
                try (PreparedStatement ps = con.prepareStatement(sql)) {
                    ps.setString(1, numeroDocumento);
                    ps.setString(2, passwordUsuario);

                    try (ResultSet rs = ps.executeQuery()) {
                        credencialesValidas = rs.next();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return credencialesValidas;
    }

    // Método para obtener el tipo de usuario (Cliente, Proveedor, Empleado)
    public String obtenerTipoUsuario(String numeroDocumento) {
        String tipoUsuario = null;

        try (Connection con = conexionBD.crearConexion()) {
            if (con != null) {
                // Comprobar si el número de documento es de un cliente
                String sqlCliente = "SELECT * FROM Cliente WHERE personaID = (SELECT personaID FROM Persona WHERE numeroDocumento = ?)";
                try (PreparedStatement psCliente = con.prepareStatement(sqlCliente)) {
                    psCliente.setString(1, numeroDocumento);

                    try (ResultSet rsCliente = psCliente.executeQuery()) {
                        if (rsCliente.next()) {
                            tipoUsuario = "CLIENTE";
                        }
                    }
                }

                // Comprobar si el número de documento es de un proveedor
                if (tipoUsuario == null) {
                    String sqlProveedor = "SELECT * FROM Proveedor WHERE personaID = (SELECT personaID FROM Persona WHERE numeroDocumento = ?)";
                    try (PreparedStatement psProveedor = con.prepareStatement(sqlProveedor)) {
                        psProveedor.setString(1, numeroDocumento);

                        try (ResultSet rsProveedor = psProveedor.executeQuery()) {
                            if (rsProveedor.next()) {
                                tipoUsuario = "PROVEEDOR";
                            }
                        }
                    }
                }

                // Comprobar si el número de documento es de un empleado
                if (tipoUsuario == null) {
                    String sqlEmpleado = "SELECT * FROM Empleado WHERE personaID = (SELECT personaID FROM Persona WHERE numeroDocumento = ?)";
                    try (PreparedStatement psEmpleado = con.prepareStatement(sqlEmpleado)) {
                        psEmpleado.setString(1, numeroDocumento);

                        try (ResultSet rsEmpleado = psEmpleado.executeQuery()) {
                            if (rsEmpleado.next()) {
                                tipoUsuario = "EMPLEADO";
                            }
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tipoUsuario;
    }
}

/*

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
*/